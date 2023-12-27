package by.market.foodstuffs.models.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name")
    private String productName;

    @ManyToOne
    @JoinTable(
            name="categories_products",
            joinColumns =  { @JoinColumn( name="product_id", referencedColumnName = "product_id")},
            inverseJoinColumns = { @JoinColumn( name="category_id", referencedColumnName = "category_id") }
    )
    private Category category;

    @Column(name = "description")
    private String description;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "notes")
    private String notes;

    @Column(name = "special_notes")
    private String specialNotes;
}
