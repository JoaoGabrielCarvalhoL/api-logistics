package br.com.carv.logistics.model;

import br.com.carv.logistics.model.enumeration.DeliveryStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_delivery")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Delivery {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private BigDecimal rate;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate orderDate;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate completionDate;
    @ManyToOne
    private Client client;
    @Embedded
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Addressee addressee;
    @Enumerated(EnumType.STRING)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private DeliveryStatus deliveryStatus;

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Occurrence> occurrences;

    public Delivery() {
        this.occurrences = new ArrayList<>();
    }
    public Delivery(BigDecimal rate, LocalDate orderDate, LocalDate completionDate, Client client, Addressee addressee, DeliveryStatus deliveryStatus) {
        this.rate = rate;
        this.orderDate = orderDate;
        this.completionDate = completionDate;
        this.client = client;
        this.addressee = addressee;
        this.deliveryStatus = deliveryStatus;
        this.occurrences = new ArrayList<>();
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

    public LocalDate getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(LocalDate completionDate) {
        this.completionDate = completionDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Addressee getAddressee() {
        return addressee;
    }

    public void setAddressee(Addressee addressee) {
        this.addressee = addressee;
    }

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public List<Occurrence> getOccurrences() {
        return occurrences;
    }

    public void setOccurrences(List<Occurrence> occurrences) {
        this.occurrences = occurrences;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delivery delivery = (Delivery) o;
        return Objects.equals(id, delivery.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Occurrence addOccurrence(String description) {
        Occurrence occurrence = new Occurrence(description, LocalDate.now(), this);
        this.getOccurrences().add(occurrence);
        return occurrence;
    }
}
