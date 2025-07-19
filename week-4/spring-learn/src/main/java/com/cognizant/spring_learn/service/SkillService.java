package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.dao.SkillDao;
import com.cognizant.spring_learn.model.Skill;
import java.util.List;

public class SkillService {
    public List<Skill> getAllSkills() {
        return new SkillDao().getAllSkills();
    }
}
