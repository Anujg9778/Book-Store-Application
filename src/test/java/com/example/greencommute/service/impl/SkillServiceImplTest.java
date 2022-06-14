package com.example.greencommute.service.impl;

import com.example.greencommute.entity.Skill;
import com.example.greencommute.respository.SkillRepository;
import com.example.greencommute.service.SkillService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
class SkillServiceImplTest {

    @Mock
    SkillRepository skillRepository;

    private SkillService skillService;

    @BeforeEach
    void initUseCase(){
        skillService = new SkillServiceImpl(skillRepository);
    }


    @Test
    void findSkill() {
        Optional<Skill> skill=Optional.of(new Skill(1,"spring"));

        Mockito.when(skillRepository.findById(1)).thenReturn(skill);
        Assertions.assertEquals(skill, skillService.findSkillById(1));
        Mockito.verify(skillRepository).findById(1);

    }

    @Test
    void saveSkill() {
        Skill skill=new Skill(1,"spring");

        Mockito.when(skillRepository.save(skill)).thenReturn(skill);
        Assertions.assertEquals(skill, skillService.saveSkill(skill));
        Mockito.verify(skillRepository).save(skill);

    }
}