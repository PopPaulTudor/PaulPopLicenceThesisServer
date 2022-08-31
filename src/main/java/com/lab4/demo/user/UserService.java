package com.lab4.demo.user;

import com.lab4.demo.ai.AiService;
import com.lab4.demo.label.Label;
import com.lab4.demo.label.LabelRepository;
import com.lab4.demo.user.dto.UserListDTO;
import com.lab4.demo.user.dto.UserMinimalDTO;
import com.lab4.demo.user.dto.UserPhotoDTO;
import com.lab4.demo.user.mapper.UserMapper;
import com.lab4.demo.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final LabelRepository labelRepository;

    private final AiService aiService;
    private final UserMapper userMapper;

    public List<UserMinimalDTO> allUsersMinimal() {
        return userRepository.findAll()
                .stream().map(userMapper::userMinimalFromEmail)
                .collect(toList());
    }

    public List<UserListDTO> allUsersForList() {
        return userRepository.findAll()
                .stream().map(userMapper::userListDtoFromUser)
                .collect(toList());
    }

    public User getUser(String email) {
        Optional<User> optionalUser = userRepository.findByUsername(email);
        return optionalUser.orElseGet(() -> User.builder().build());
    }

    public String uploadPhotosForUser(UserPhotoDTO data) {

        String labels = "";
        List<String> numberObjects = aiService.getObjectsFromImage(data.getPhotos());
        List<Label> objects = new ArrayList<>();
        for(String object: numberObjects){
            String[] probs = object.split(",", 0);
            int category = Integer.parseInt(probs[0]);
            objects.add(labelRepository.findLabelByNameNumber(category));
        }

        boolean food = false;
        boolean churchAndHistory = false;
        boolean solo = false;
        boolean adventure = true;
        boolean business = true;
        for(Label label: objects){
            if(label.getNameNumber() == 47 ||
            label.getNameNumber() == 48 ||
                    label.getNameNumber() == 46 ||
                    label.getNameNumber() == 54 ||
                    label.getNameNumber() == 59 ||
                    label.getNameNumber() ==63){
                food = true;
            }
            if(label.getNameNumber() == 10){
                churchAndHistory = true;
            }
            if(label.getNameNumber() == 1){
                solo = true;
            }
            if(label.getNameNumber() == 42 ||
            label.getNameNumber() == 37 ||
            label.getNameNumber() == 34 ||
            label.getNameNumber() == 35){
                adventure = true;
            }
            if(label.getNameNumber() == 32 ||
                    label.getNameNumber() == 33){
                business = true;
            }
        }
        if(food){
            labels=labels + "food, ";
        }
        if(churchAndHistory){
            labels =labels + "history, church ";
        }
        if(solo){
            labels=labels+"solo, ";
        }
        if(adventure){
            labels= labels+"adventure, ";
        }
        if(business){
            labels=labels+"business, ";
        }else{
            labels=labels+"leisure, ";
        }


        Optional<User> optionalUser = userRepository.findByUsername(data.getEmail());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            userRepository.delete(user);
            user.setDescription(labels);
            userRepository.save(user);
        }

        return labels;
    }

}
