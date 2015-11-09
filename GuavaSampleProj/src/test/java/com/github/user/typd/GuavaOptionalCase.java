package com.github.user.typd;

import com.google.common.base.Optional;
import com.google.common.net.InternetDomainName;

public class GuavaOptionalCase extends BaseCase {

    public void testOptionalBasic() {
        Object param = null;
        if (param == null)
            param = null;
        param = Optional.fromNullable(param).or(3);
        print(param);
    }

    public void testOptionalMethodReturn() {
        String result = null;

        // Optional<T> is a way of replacing a nullable T reference with a non-null value. An Optional may either contain a non-null T reference (in which case we say the reference is "present"), or it may contain nothing (in which case we say the reference is "absent"). It is never said to "contain null."

        // old way
        result = mayReturnNull();
        // what if use forget to do this
        if (result == null)
            result = "default";
        print(result);


        // with optional
        Optional<String> mayBeNull = null;
        {
            // can't use whatIWant directly, have to do call .get
            mayBeNull = mayReturnNullWithOptional(null);
            if (mayBeNull.isPresent())
                result = mayBeNull.get(); // throw exception if it's null
            else
                result = "default";
            print(result);
        }

        {
            // make it shorter
            mayBeNull = mayReturnNullWithOptional(null);
            result = mayBeNull.or("default");
            print(result);
        }

        {
            // even shorter
            result = mayReturnNullWithOptional(null).or("default");
            print(result);

            result = mayReturnNullWithOptional(null).orNull();
            print(result);
        }
    }

    public void testAboutNullInCollection(){
        // If you're trying to use null values in a Set or as a key in a Map -- don't;
        // it's clearer (less surprising) if you explicitly special-case null during lookup operations.
        // If you want to use null as a value in a Map -- leave out that entry; keep a separate Set of non-null keys (or null keys). It's very easy to mix up the cases where a Map contains an entry for a key, with value null, and the case where the Map has no entry for a key. It's much better just to keep such keys separate, and to think about what it means to your application when the value associated with a key is null.
    }


    public void testNet() {
        print(InternetDomainName.from("www.google.com").parts().toString());
    }

    private String mayReturnNull() {
        return null;
    }

    private Optional<String> mayReturnNullWithOptional(String x) {
        return Optional.fromNullable(x);
    }
}
