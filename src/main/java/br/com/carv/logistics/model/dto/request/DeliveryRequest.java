package br.com.carv.logistics.model.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class DeliveryRequest {

    @NotNull
    private BigDecimal rate;
    @Valid
    private AddresseeRequest addressee;
    public DeliveryRequest() {
    }
    public DeliveryRequest(BigDecimal rate, AddresseeRequest addressee) {
        this.rate = rate;
        this.addressee = addressee;
    }
    public BigDecimal getRate() {
        return rate;
    }
    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
    public AddresseeRequest getAddressee() {
        return addressee;
    }
    public void setAddressee(AddresseeRequest addressee) {
        this.addressee = addressee;
    }

}
