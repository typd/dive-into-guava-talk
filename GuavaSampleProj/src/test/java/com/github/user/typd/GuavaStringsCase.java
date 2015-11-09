package com.github.user.typd;

import com.google.common.base.Strings;

public class GuavaStringsCase extends BaseCase {

    public void testStrings() {
        print(Strings.isNullOrEmpty(""));
        print(Strings.isNullOrEmpty(null));
        print(Strings.isNullOrEmpty("string"));

        print(Strings.emptyToNull(""));

        print(Strings.repeat("a", 10));
    }
}
