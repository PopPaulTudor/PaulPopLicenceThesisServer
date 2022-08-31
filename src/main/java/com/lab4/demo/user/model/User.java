package com.lab4.demo.user.model;

import lombok.*;
import org.springframework.data.annotation.TypeAlias;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.*;

@Entity
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Table(name = "user", schema = "postgres")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 20)
    private String username;

    @Email
    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 120)
    private String password;

    @Column(nullable = false, length = 12)
    private String number;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @Builder.Default
    private Set<Role> roles = new HashSet<>();

    @Column(nullable = false, length = 100)
    @Builder.Default
    private String description = "";


}
