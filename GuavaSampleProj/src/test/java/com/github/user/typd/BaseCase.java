package com.github.user.typd;

import com.google.common.base.Optional;
import junit.framework.TestCase;

public class BaseCase extends TestCase{
    public void print(Object message) {
        System.out.println(Optional.fromNullable(message).orNull() + "");
    }
}
