package com.example.greencommute.service.impl;

import com.example.greencommute.entity.Skill;
import com.example.greencommute.respository.SkillRepository;
import com.example.greencommute.service.SkillService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillServiceImpl implements SkillService {
    private final SkillRepository skillRepository;
    public SkillServiceImpl(SkillRepository skillRepository){
        this.skillRepository=skillRepository;
    }

    @Override
    public List<Skill> findAllSkills() {
        return skillRepository.findAll();
    }

    @Override
    public Optional<Skill> findSkillById(int theSkillId) {
        return skillRepository.findById(theSkillId);
    }

    @Override
    public void deleteSkillById(int theSkillId) {
        skillRepository.deleteById(theSkillId);
    }

    @Override
    public Skill saveSkill(Skill theSkill){
        return skillRepository.save(theSkill);
    }
}
