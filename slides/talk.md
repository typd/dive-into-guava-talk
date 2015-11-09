
# Optional<T>

Replace a nullable T reference with a non-null value
- present: a non-null T reference
- absent:  nothing

Why? Explicitly check and get it out. Force to handle absent case

    String result = null;

    // old way
    result = getSomethingMayReturnNull();
    if (result == null) // may easily forget
        result = "default";
    print(result.toString());

    // with Optional
    Optional<String> opt = tryToGet();
    if (opt.isPresent())
        result = opt.get(); // .get() throw exception if not present
    else
        result = "default";
    print(result.toString());

    // Shorter
    result = tryToGet().or("default");
    print(result.toString());

# Use cases

In Guava

    // com.google.common.base.Enums.java
    public static <T extends Enum<T>> Optional<T> getIfPresent(Class<T> enumClass, String value)

    // com.google.common.collect.BinaryTreeTraverser.java
    public abstract Optional<T> rightChild(T root);

    // com.google.common.io.File.java
    public Optional<Long> sizeIfKnown()

    // com.google.common.net.MediaType.java
    public Optional<Charset> charset()

Whenever "try to get" something, no guaranteed result, e.g.

    public Optional<IP> tryToResolveDomain(String domain)


# Optional<T> manual

    // Template class

    // static creation
    Optional<String> strOpt = Optional.absent();
    strOpt = Optional.fromNullable(null);
    strOpt = Optional.of("string");

    // check and get
    boolean isPresent = strOpt.isPresent();
    String str = strOpt.get();

    // injection
    str = strOpt.or("default");
    str = strOpt.orNull();

Look deeper?


# Source code of Optional

https://github.com/google/guava/blob/master/guava/src/com/google/common/base/Optional.java
https://github.com/google/guava/blob/master/guava/src/com/google/common/base/Absent.java
https://github.com/google/guava/blob/master/guava/src/com/google/common/base/Present.java

    abstract class Optional<T>
        static Optional<T> absent(){ /* */ }
        static Optional<T> of();
        static Optional<T> fromNullable();

        abstract boolean isPresent();
        abstract T get();
        abstract T or(T var1);
        abstract T orNull();

    final class Absent extends Optional<T>
        // singleton
        // Null pattern

    final class Present extends Optional<T>
        // hold a member

Highlights
- final class
- private Constructor
- early params check
- Null pattern


# About "null pattern"

Providing a substitutable alternative that offers "do nothing behavior".
Avoid unpleasent null checks

    @Autowired
    MetricsClient client; // null for non-prod envs
    if (client != null)
        client.send();

Or 

    @Autowired
    MetricsClient client; // inject a DumbMetricsClient (extends MetricsClient) for non-prod envs
    client.send();
    
<img>



# Guava Joiner

    Joiner.on("|").skipNulls().join("1", null, "3"); // "1|3"
    Joiner.on("|").useForNull("*").join("1", null, "3"); // "1|*|3"

Joiner instances are always immutable. The joiner configuration methods will always return a new Joiner, which you must use to get the desired semantics. This makes any Joiner thread safe, and usable as a static final constant.


# Source code of Joiner

https://github.com/google/guava/blob/master/guava/src/com/google/common/base/Joiner.java

    class Joiner
        public static Joiner on()
        private Joiner(Joiner prototype)

        public Joiner useForNull(final String nullText)
        public Joiner skipNulls()
        
        CharSequence toString(Object part) // a default impl, to be override

Highlights
- private Constructor
- Immutable instance, thread safe
- Decorator pattern


# Other goods

Guava
- Strings
- Cache
- Collections

JodaTime
