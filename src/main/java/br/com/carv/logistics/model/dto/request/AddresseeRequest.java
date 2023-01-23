package br.com.carv.logistics.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AddresseeRequest {

    @NotBlank @Size(max = 100, min = 5, message = "The field must have a minimum of {min} characters and a maximum of {max}")
    private String name;
    @NotBlank @Size(max = 100, min = 5, message = "The field must have a minimum of {min} characters and a maximum of {max}")
    private String publicPlace;
    @NotBlank @Size(max = 100, min = 1, message = "The field must have a minimum of {min} characters and a maximum of {max}")
    private String houseNumber;
    @NotBlank @Size(max = 100, min = 1, message = "The field must have a minimum of {min} characters and a maximum of {max}")
    private String complement;
    @NotBlank @Size(max = 100, min = 5, message = "The field must have a minimum of {min} characters and a maximum of {max}")
    private String district;

    public AddresseeRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublicPlace() {
        return publicPlace;
    }

    public void setPublicPlace(String publicPlace) {
        this.publicPlace = publicPlace;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

}
