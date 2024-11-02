package com.ticketing.dto;

import com.ticketing.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String firstName;
    private String lastName;
    private String userName;
    private String phone;
    private String passWord;
    private Gender gender;
    private RoleDTO role;

}
