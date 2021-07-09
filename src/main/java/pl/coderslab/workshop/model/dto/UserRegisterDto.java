package pl.coderslab.workshop.model.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class UserRegisterDto {

   @NotBlank
   @Length(min = 3 , max = 50)
    private String userName;
   @NotBlank
   @Length(min = 6, max = 50)
    private String password;
    @NotBlank
    @Length(min = 6, max = 50, message = "Błędne hasło")
    private String rePassword;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;

    private String role;

    @Pattern(regexp = "^\\d{9}$", message = "Niepoprawny numer telefonu")
    private String phoneNumber;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Past(message = "Data musi być z przeszłości")
    private LocalDate dateOfBirth;

    private String strDateOfBirth;

//    public LocalDate setCorrectDate(String date){
//        String[] splitData=date.split(".");
//        int[] correctDate={Integer.parseInt(splitData[0]),Integer.parseInt(splitData[1]),Integer.parseInt(splitData[2])};
//       return LocalDate.of(correctDate[0],correctDate[1],correctDate[2]);
//    }


}
