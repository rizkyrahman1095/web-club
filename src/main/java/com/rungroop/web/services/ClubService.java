package com.rungroop.web.services;

import com.rungroop.web.dto.ClubDto;
import com.rungroop.web.models.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClub();
     Club saveClub(ClubDto clubdto);
    ClubDto findClubById(Long clubId);

     void updateClub(ClubDto club);
}
