package com.lab4.demo;


import com.lab4.demo.label.Label;
import com.lab4.demo.label.LabelRepository;
import com.lab4.demo.reservation.ReservationRepository;
import com.lab4.demo.review.ReviewRepository;
import com.lab4.demo.security.AuthService;
import com.lab4.demo.security.dto.SignupRequest;
import com.lab4.demo.user.RoleRepository;
import com.lab4.demo.user.UserRepository;
import com.lab4.demo.user.model.ERole;
import com.lab4.demo.user.model.Role;
import com.lab4.demo.hotel.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class Bootstrapper implements ApplicationListener<ApplicationReadyEvent> {

    private final RoleRepository roleRepository;

    private final UserRepository userRepository;

    private final AuthService authService;

    private final ReservationRepository reservationRepository;

    private final ReviewRepository reviewRepository;

    private final HotelRepository hotelRepository;

    private final LabelRepository labelRepository;


    @Value("${app.bootstrap}")
    private Boolean bootstrap;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        if (bootstrap) {
//            userRepository.deleteAll();
//            roleRepository.deleteAll();
//            reservationRepository.deleteAll();
//            hotelRepository.deleteAll();
//            reviewRepository.deleteAll();
//            labelRepository.deleteAll();

           addLabels();
            for (ERole value : ERole.values()) {
                roleRepository.save(
                        Role.builder()
                                .name(value)
                                .build()
                );
            }
            authService.register(SignupRequest.builder()
                    .email("email@gmail.com")
                    .username("username")
                    .password("password")
                    .number("+40755476663")
                    .build());

            authService.register(SignupRequest.builder()
                    .email("email2@email.com")
                    .username("username2")
                    .password("password")
                    .number("+40755476663")
                    .build());

        }
    }

    private void addLabels(){
        labelRepository.save(Label.builder().name("person").nameNumber(1).build());
        labelRepository.save(Label.builder().name("bicycle").nameNumber(2).build());
        labelRepository.save(Label.builder().name("car").nameNumber(3).build());
        labelRepository.save(Label.builder().name("motorcycle").nameNumber(4).build());
        labelRepository.save(Label.builder().name("airplane").nameNumber(5).build());
        labelRepository.save(Label.builder().name("bus").nameNumber(6).build());
        labelRepository.save(Label.builder().name("train").nameNumber(7).build());
        labelRepository.save(Label.builder().name("traffic light").nameNumber(10).build());
        labelRepository.save(Label.builder().name("cat").nameNumber(17).build());
        labelRepository.save(Label.builder().name("dog").nameNumber(18).build());
        labelRepository.save(Label.builder().name("cow").nameNumber(21).build());
        labelRepository.save(Label.builder().name("backpack").nameNumber(27).build());
        labelRepository.save(Label.builder().name("tie").nameNumber(32).build());
        labelRepository.save(Label.builder().name("suitcase").nameNumber(33).build());
        labelRepository.save(Label.builder().name("frisbee").nameNumber(34).build());
        labelRepository.save(Label.builder().name("skis").nameNumber(35).build());
        labelRepository.save(Label.builder().name("sportsball").nameNumber(37).build());
        labelRepository.save(Label.builder().name("surfball").nameNumber(42).build());
        labelRepository.save(Label.builder().name("wineglass").nameNumber(46).build());
        labelRepository.save(Label.builder().name("cup").nameNumber(47).build());
        labelRepository.save(Label.builder().name("fork").nameNumber(48).build());
        labelRepository.save(Label.builder().name("sandwich").nameNumber(54).build());
        labelRepository.save(Label.builder().name("pizza").nameNumber(59).build());
        labelRepository.save(Label.builder().name("donut").nameNumber(60).build());
        labelRepository.save(Label.builder().name("coach").nameNumber(63).build());
        labelRepository.save(Label.builder().name("laptop").nameNumber(73).build());
        labelRepository.save(Label.builder().name("book").nameNumber(84).build());
    }


}
