package com.example.greencommute.service.impl;

import com.example.greencommute.entity.Skill;
import com.example.greencommute.respository.SkillRepository;
import com.example.greencommute.service.SkillService;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;


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
    void findAll() {
        Skill skill1=new Skill(1,"spring");
        Skill skill2=new Skill(1,"spring");

        List<Skill> skillsList=new ArrayList<>();
        skillsList.add(skill1);
        skillsList.add(skill2);

        Mockito.when(skillRepository.findAll()).thenReturn(skillsList);
        Assertions.assertEquals(skillsList, skillService.findAllSkills());
        Mockito.verify(skillRepository).findAll();

    }

    @Test
    void findSkill() {
        Optional<Skill> skill=Optional.of(new Skill(1,"spring"));

        Mockito.when(skillRepository.findById(1)).thenReturn(skill);
        Assertions.assertEquals(skill, skillService.findSkillById(1));
        Mockito.verify(skillRepository).findById(1);

    }

    @Test
    void deleteSkill() {
        Skill skill1=new Skill(1,"spring");

        doNothing().when(skillRepository).deleteById(1);
        skillRepository.deleteById(1);
        Mockito.verify(skillRepository).deleteById(1);

    }

    @Test
    void saveSkill() {
        Skill skill=new Skill(1,"spring");

        Mockito.when(skillRepository.save(skill)).thenReturn(skill);
        Assertions.assertEquals(skill, skillService.saveSkill(skill));
        Mockito.verify(skillRepository).save(skill);

    }
}