package com.lab4.demo.hotel;

import com.lab4.demo.hotel.model.Hotel;
import com.lab4.demo.hotel.model.dto.HotelDTO;
import com.lab4.demo.hotel.model.dto.SuggestionInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.lab4.demo.UrlMapping.HOTELS;

@RestController
@RequestMapping(HOTELS)
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @GetMapping
    public List<HotelDTO> allGroups() {
        return hotelService.findAll();
    }

    @PostMapping("/recommend")
    public List<Hotel> makeSuggestion(@RequestBody SuggestionInfo info){
        return hotelService.suggest(info);
    }
}
