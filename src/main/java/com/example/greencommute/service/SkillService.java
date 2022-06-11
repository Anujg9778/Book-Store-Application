package com.example.greencommute.service;

import com.example.greencommute.entity.Skill;

import java.util.List;
import java.util.Optional;

public interface SkillService {

    List<Skill> findAllSkills();

    Optional<Skill> findSkillById(int theSkillId);

    void deleteSkillById(int theSkillId);

    Skill saveSkill(Skill theSkill);

}
