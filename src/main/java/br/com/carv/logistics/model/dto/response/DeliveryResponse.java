package br.com.carv.logistics.model.dto.response;

import br.com.carv.logistics.model.enumeration.DeliveryStatus;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeliveryResponse {

    private Long id;
    private BigDecimal rate;
    private LocalDate orderDate;
    private ClientResponse client;
    private AddresseeResponse addressee;
    private DeliveryStatus deliveryStatus;
    private LocalDate completionDate;

    public DeliveryResponse() {
    }
    public DeliveryResponse(BigDecimal rate, LocalDate orderDate, ClientResponse client, AddresseeResponse addressee, DeliveryStatus deliveryStatus, LocalDate completionDate) {
        this.rate = rate;
        this.orderDate = orderDate;
        this.client = client;
        this.addressee = addressee;
        this.deliveryStatus = deliveryStatus;
        this.completionDate = completionDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public ClientResponse getClient() {
        return client;
    }

    public void setClient(ClientResponse client) {
        this.client = client;
    }

    public AddresseeResponse getAddressee() {
        return addressee;
    }

    public void setAddressee(AddresseeResponse addressee) {
        this.addressee = addressee;
    }

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public LocalDate getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(LocalDate completionDate) {
        this.completionDate = completionDate;
    }
}
