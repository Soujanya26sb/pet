package com.Group3tatastrive.VetPawtner.Entity;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Products")  // matching your table name
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    private String productName;

    private Double price;

    // other fields, constructors, getters, setters
}

