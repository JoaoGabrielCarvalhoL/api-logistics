package br.com.carv.logistics.model;

import jakarta.persistence.*;

@Embeddable
public class Addressee {

    @Column(name = "addressee_name")
    private String name;
    @Column(name = "addressee_public_place")
    private String publicPlace;
    @Column(name = "addressee_house_number")
    private String houseNumber;
    @Column(name = "addressee_complement")
    private String complement;
    @Column(name = "addressee_district")
    private String district;

    public Addressee() {
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
