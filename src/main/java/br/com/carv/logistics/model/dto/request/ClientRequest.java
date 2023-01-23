package br.com.carv.logistics.model.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ClientRequest {

    @NotBlank @Size(max = 100, min = 5, message = "The name field must have a minimum of {max} characters and a maximum of {min}")
    private String name;
    @NotBlank @Size(max = 50, message = "The name field must have a minimum of {max} characters.")
    @Email
    private String email;
    @NotBlank @Size(max = 20, message = "The name field must have a minimum of {max} characters.")
    private String telephone;

    public ClientRequest() {
    }

    public ClientRequest(String name, String email, String telephone) {
        this.name = name;
        this.email = email;
        this.telephone = telephone;
    }

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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
