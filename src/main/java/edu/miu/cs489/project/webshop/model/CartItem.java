package edu.miu.cs489.project.webshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "cart_items")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartItemId;
    private int quantity;
    @ManyToOne()
    @JoinColumn(name = "product_fk")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "cart_fk")
    private ShoppingCart shoppingCart;





}
