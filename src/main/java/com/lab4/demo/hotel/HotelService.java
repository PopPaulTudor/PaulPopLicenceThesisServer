package com.lab4.demo.hotel;

import com.lab4.demo.ai.AiService;
import com.lab4.demo.hotel.model.dto.HotelDTO;
import com.lab4.demo.hotel.model.Hotel;
import com.lab4.demo.hotel.model.dto.SuggestionInfo;
import com.lab4.demo.user.UserRepository;
import com.lab4.demo.user.UserService;
import com.lab4.demo.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HotelService {
    private final HotelRepository hotelRepository;

    private final UserService userService;
    private final HotelMapper hotelMapper;

    private final AiService aiService;


    private Hotel findById(Long id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Group not found: " + id));
    }

    public List<HotelDTO> findAll() {
        return hotelRepository.findAll().stream()
                .map(hotelMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<Hotel> suggest(SuggestionInfo info){
        User user = userService.getUser(info.getEmail());
        Hotel[] hotels = aiService.recommend(Double.parseDouble(info.getLatitude()), Double.parseDouble(info.getLongitude()), user.getDescription());
        return Arrays.asList(hotels);
    }
}
