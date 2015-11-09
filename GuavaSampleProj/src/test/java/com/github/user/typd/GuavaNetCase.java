package com.github.user.typd;

import com.google.common.net.InternetDomainName;

public class GuavaNetCase extends BaseCase {

    public void testNet() {
        print(InternetDomainName.from("google").parent());
    }
}
