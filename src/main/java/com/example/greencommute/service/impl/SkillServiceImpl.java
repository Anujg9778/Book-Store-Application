package com.example.greencommute.service.impl;

import com.example.greencommute.entity.Skill;
import com.example.greencommute.respository.SkillRepository;
import com.example.greencommute.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    SkillRepository skillRepository;

    @Override
    @Transactional
    public List<Skill> findAll() {
        return skillRepository.findAll();
    }

    @Override
    public Optional<Skill> findSkill(int theSkillId) {
        return skillRepository.findById(theSkillId);
    }

    @Override
    public void deleteSkill(int theSkillId) {
        skillRepository.deleteById(theSkillId);
    }

    @Override
    public Skill saveSkill(Skill theSkill){
        return skillRepository.save(theSkill);
    }
}
