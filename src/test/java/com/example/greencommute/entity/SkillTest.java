package com.example.greencommute.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SkillTest {

    Skill skill=new Skill(1,"React");

    @Test
    void skillEntityTest(){

        assertEquals(1,skill.getSkillId());
        assertEquals("React",skill.getSkillName());

        Skill skill1=new Skill();
        skill1.setSkillId(2);
        skill1.setSkillName("spring");

        assertEquals(2,skill1.getSkillId());
        assertEquals("spring",skill1.getSkillName());
    }

}