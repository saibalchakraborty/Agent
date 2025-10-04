package com.demo.agent.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String emailId;
    private String phoneNumber;
}
