package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.model.Skill;
import com.cognizant.spring_learn.service.SkillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SkillController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SkillController.class);
    private final SkillService skillService = new SkillService();

    @GetMapping("/skills")
    public List<Skill> getAllSkills() {
        LOGGER.info("START");
        List<Skill> list = skillService.getAllSkills();
        LOGGER.debug("Skills: {}", list);
        LOGGER.info("END");
        return list;
    }
}
