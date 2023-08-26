package com.rungroop.web.controller;

import com.rungroop.web.dto.ClubDto;
import com.rungroop.web.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {

    private ClubService clubService;

    @Autowired
    public IndexController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("")
    public String listClub(Model model) {
        String log = "RunClub";
        List<ClubDto> clubs = clubService.findAllClub();
        model.addAttribute("logs", log);
        model.addAttribute("clubs", clubs);
        return "/index";
    }

}
