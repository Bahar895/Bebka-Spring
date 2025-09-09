package com.bahar.Bebka_Spring.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class StudentRequest {

    @NotBlank(message = "İsim boş olamaz")
    @Size(min = 2, max = 50, message = "İsim 2-50 karakter arasında olmalıdır")
    private String name;

    @Email(message = "Geçerli bir email adresi giriniz")
    private String email;

    @Min(value = 18, message = "Yaş en az 18 olmalıdır")
    private int age;

    // getter - setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}