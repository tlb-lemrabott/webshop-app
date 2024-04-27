package edu.miu.cs489.project.webshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer oderId;
    private LocalDateTime shippingDate;
    @ManyToOne
    @JoinColumn(name = "shipping_address_fk")
    private Address shippingAddress;
    @OneToMany(mappedBy = "order")
    private List<OrderLine> orderLines;




}
