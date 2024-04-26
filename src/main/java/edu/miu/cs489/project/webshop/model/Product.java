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
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "products_categories",
            joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "productId")},
            inverseJoinColumns = {@JoinColumn(name = "category_id", referencedColumnName = "categoryId")}
    )
    private List<Category> category;
    @OneToMany
    private List<Review> reviews;
    @OneToMany
    private List<CartItem> cartItems;
    @OneToMany
    private List<OrderLine> orderLines;

}
