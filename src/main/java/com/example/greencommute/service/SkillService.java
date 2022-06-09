package com.example.greencommute.service;

import com.example.greencommute.entity.Skill;
import com.example.greencommute.entity.User;

import java.util.List;
import java.util.Optional;

public interface SkillService {

    List<Skill> findAll();

    Optional<Skill> findSkill(int theSkillId);

    void deleteSkill(int theSkillId);

    Skill saveSkill(Skill theSkill);

}
