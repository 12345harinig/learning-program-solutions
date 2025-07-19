package com.cognizant.spring_learn.dao;

import com.cognizant.spring_learn.model.Skill;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;

public class SkillDao {
    private static List<Skill> SKILL_LIST;

    static {
        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("skill.xml");
            SKILL_LIST = (List<Skill>) context.getBean("skillList");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Skill> getAllSkills() {
        return SKILL_LIST;
    }
}
