package com.rungroop.web.controller;

import com.rungroop.web.dto.ClubDto;
import com.rungroop.web.models.Club;
import com.rungroop.web.services.ClubService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;
@Slf4j
@Controller
@RequestMapping("/clubs")
public class ClubController {
    private ClubService clubService;

    @Autowired
    public ClubController(ClubService clubService) {
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

    @GetMapping("/new")
    public String creatClubForm(Model model) {
        Club club = new Club();
        model.addAttribute("club", club);
        return "/clubs-create";
    }

    @PostMapping("/new")
    public String saveClub(@Valid @ModelAttribute("club") ClubDto clubDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("club", clubDto);
            log.info("ada eror disini");
            return "/clubs-create";

        }
        clubService.saveClub(clubDto);
        return "redirect:/clubs";
    }
//    @PostMapping("/new")
//    public String saveClub(@Valid @ModelAttribute("club") Club club) {
//        clubService.saveClub(club)
//
//    }

    @GetMapping("/{clubId}/edit")
    public String editClub(@PathVariable("clubId") Long clubId, Model model) {
        ClubDto club = clubService.findClubById(clubId);
        model.addAttribute("club", club);
        return "/clubs-edit";
    }

    @PostMapping("/{clubId}/edit")
    public String updateClub(@PathVariable("clubId") Long clubId, @Valid @ModelAttribute("club")
    ClubDto club, BindingResult result) {
        if (result.hasErrors()) {
            return "/clubs-edit";
        }
        club.setId(clubId);
        clubService.updateClub(club);
        return "redirect:/clubs";
    }

}
