
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
