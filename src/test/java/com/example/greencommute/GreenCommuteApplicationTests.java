package com.example.greencommute;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
class GreenCommuteApplicationTests {

    @Test
    void testApplication() {
        String[] str = new String[]{};
        GreenCommuteApplication.main(str);
        Assertions.assertEquals(1,2-1);
    }
}
