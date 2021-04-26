package com.tz.tz_web.controllers;
import com.tz.tz_web.Models.flying;
import com.tz.tz_web.Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tz.tz_web.repo.flying_repository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController
{
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);
    @Autowired
    private flying_repository flying_repository;
    @GetMapping("/")
    public String main(Model model)
    {
        Parser parser=new Parser();
        Iterable<flying> flying= flying_repository.findAll();
        model.addAttribute("title", "Web-Service");
        model.addAttribute("parse",parser);
        model.addAttribute("flying",flying);
        return "main";
    }

    @RequestMapping("/bd")
    @Cacheable(value="cache",key="#keyword")
    public String bd(Model model, @Param("keyword") String keyword)/*по request включаем param keyword*/
    {
        long starttime=System.currentTimeMillis();
        Iterable<flying> flying= flying_repository.search(keyword);/*search создан в репозитории*/
        logger.info(keyword);
        model.addAttribute("flying",flying);
        System.out.println("time:".concat(Long.toString(System.currentTimeMillis()-starttime)).concat("ms"));
        return "main";
    }


}
