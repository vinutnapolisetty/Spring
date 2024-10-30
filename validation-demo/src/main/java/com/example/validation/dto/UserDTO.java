// package com.example.validation.dto;

// import jakarta.validation.constraints.NotNull;
// import jakarta.validation.constraints.Pattern;
// import lombok.Data;
// import org.hibernate.validator.constraints.Length;

// @Data
// public class UserDTO {
//     @NotNull(message = "{user.name.required}")
//     @Length(min = "${validation.user.name.min}", max = "${validation.user.name.max}", 
//             message = "{user.name.length}")
//     private String name;

//     @Pattern(regexp = "${validation.user.email.pattern}", 
//              message = "{user.email.invalid}")
//     private String email;

//     @Length(min = "${validation.user.password.min}", 
//             message = "{user.password.length}")
//     @Pattern(regexp = "${validation.user.password.pattern}", 
//              message = "{user.password.pattern}")
//     private String password;
// }
package com.example.validation.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {
    
    // Constants for min and max values
    private static final int NAME_MIN_LENGTH = 2; 
    private static final int NAME_MAX_LENGTH = 50; 
    private static final int PASSWORD_MIN_LENGTH = 8; 

    @NotNull(message = "{user.name.required}")
    @Size(min = NAME_MIN_LENGTH, max = NAME_MAX_LENGTH, 
          message = "{user.name.length}")
    private String name;

    @NotNull(message = "{user.email.required}")
    @Email(message = "{user.email.invalid}")
    private String email;

    @NotNull(message = "{user.password.required}")
    @Size(min = PASSWORD_MIN_LENGTH, message = "{user.password.length}")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$", 
    message = "{user.password.pattern}")
    private String password;
}
