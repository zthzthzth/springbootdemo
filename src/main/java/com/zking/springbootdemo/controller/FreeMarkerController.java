package com.zking.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Administrator
 * @create 2019-12-1722:25
 */
@Controller
public class FreeMarkerController {

    @RequestMapping("/")
    public String index(Model model) {
        System.out.println("----------- index -----------");
        return "index";
    }


    @RequestMapping("/commonGrammar")
    public String commonGrammar(Model model) {
        System.out.println("----------- common grammar ----------");

        Map map = new LinkedHashMap<>();
        for (int i = 0; i < 5; i++) {
            map.put("key" + i, "value" + i);
        }
        model.addAttribute("list", Arrays.asList("string1", "string2", "string3", "string4", "string5", "string6"));
        model.addAttribute("map", map);
        model.addAttribute("name", "   htTps://wWw.zHyD.mE   ");
        model.addAttribute("htmlText", "<span style=\"color: red;font-size: 16px;\">html内容</span>");
        model.addAttribute("num", 123.012);
        model.addAttribute("null", null);
        model.addAttribute("dateObj", new Date());
        model.addAttribute("bol", true);

        return "commonGrammar";
    }

}
