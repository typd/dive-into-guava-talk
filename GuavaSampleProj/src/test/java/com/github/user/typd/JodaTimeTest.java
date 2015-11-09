package com.github.user.typd;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.util.Date;

public class JodaTimeTest extends BaseCase {

    public void testJodaTime() {
        print(DateTime.now());
        print(DateTime.now(DateTimeZone.UTC));

        print(DateTime.now().minusHours(24));

        Date javaDate = DateTime.now().toDate();
        DateTime jodaDate = new DateTime(javaDate);
        print(javaDate);
        print(jodaDate);

        DateTime d1 = DateTime.now();
        DateTime d2 = d1.minusDays(1);
        print(d1.isAfter(d2));

    }
}
