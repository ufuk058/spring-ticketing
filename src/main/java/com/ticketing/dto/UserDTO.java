package com.ticketing.dto;

import com.ticketing.enums.Gender;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @NotBlank   //Not blank mean this field cant be null ot blank
    @Size(max=15,min=2)
    private String firstName;

    @NotBlank   //Not blank mean this field cant be null ot blank
    @Size(max=15,min=2)
    private String lastName;

    @NotBlank
    @Email   //this validation is o check if input email has a correct email format
    private String userName;

    @NotBlank
    @Pattern(regexp ="^\\d{10}$" )
    private String phone;

    @NotBlank
    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,}")
    /* "^\\d{10}$"  --> includes 10 digits
    *(?=.*\d)  ---> includes digits
    * (?=.*[a-z])  --> includes lowercase
    * (?=.*[A-Z]) ---> includes lowercase
    * .{4,} ---> includes at least 4 characters
    * */
    private String passWord;

    @NotNull
    private Gender gender;
    @NotNull
    private RoleDTO role;

}
