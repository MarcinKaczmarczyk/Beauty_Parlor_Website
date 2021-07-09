package pl.coderslab.workshop.model.dto;

public class EmployeeFullNameDto {

   private String name;

   private String surname;


    public EmployeeFullNameDto(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getFullName(){
        return name+" "+surname;
    }
}
