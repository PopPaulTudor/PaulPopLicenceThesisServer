package com.lab4.demo.ai;

import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class UserImage{
    private String base64data;

    private String name;

}