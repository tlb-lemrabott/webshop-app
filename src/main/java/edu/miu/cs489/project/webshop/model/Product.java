package edu.miu.cs489.project.webshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    private String name;
    private String owner;
    private String originCountry;
    private double price;
    private int availableQuantity;
    private String description;
    @ManyToOne()
    @JoinColumn(name = "category_fk")
    private Category category;
    @OneToMany(mappedBy = "product")
    private List<Review> reviews;
    @OneToMany(mappedBy = "product")
    private List<CartItem> cartItems;
    @OneToMany(mappedBy = "product")
    private List<OrderLine> orderLines;

    public Product(Integer productId, String name, String owner, String originCountry, double price, int availableQuantity, String description) {
        this.productId = productId;
        this.name = name;
        this.owner = owner;
        this.originCountry = originCountry;
        this.price = price;
        this.availableQuantity = availableQuantity;
        this.description = description;
    }




}
