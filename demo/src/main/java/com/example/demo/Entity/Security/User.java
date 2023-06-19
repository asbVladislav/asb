package com.example.demo.Entity.Security;

import lombok.*;

import javax.persistence.*;

@Entity
@Table( name="User")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {


    @Id
    private String login;

    private String password;



    @Enumerated(value = EnumType.STRING)
    private Role role;

}
