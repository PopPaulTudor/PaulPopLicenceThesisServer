package com.lab4.demo.user;

import com.lab4.demo.user.dto.UserListDTO;
import com.lab4.demo.user.dto.UserPhotoDTO;
import com.lab4.demo.user.model.User;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.lab4.demo.UrlMapping.USERS;

@RestController
@RequestMapping(USERS)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserListDTO> allUsers() {
        return userService.allUsersForList();
    }

    @PostMapping("/upload-photos")
    public String uploadPhotos(@RequestBody UserPhotoDTO data){
        return userService.uploadPhotosForUser(data);
    }

    @PostMapping("/info")
    public User getUser(@RequestBody String email){
        email = email.substring(1, email.length() -1);
        return userService.getUser(email);
    }

}
