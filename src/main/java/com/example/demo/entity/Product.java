package com.example.demo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
public class Product {

	 @Id
	    @GeneratedValue
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name="CATEGORY_ID", nullable=false)
	    private Category category;

	    @ManyToOne
	    @JoinColumn(name="SUPPLIER_ID", nullable=false)
	    private Supplier supplier;

	    @Column
	    private String genericName;

	    @Column
	    private String brand;

	    @Column(nullable = false, unique = true)
	    private String name;

	    @Column(nullable = false)
	    private String code; //item code or barcode

	    @Column(nullable = false)
	    private String description;

	    @Column(nullable = false)
	    private String barCode;

	    @Column(nullable = false)
	    private BigDecimal buyingPrice;

	    @Column(nullable = false)
	    private BigDecimal sellingPrice;

	    private UnitOfMeasure unitOfMeasure;

	    @Column
	    private Instant expiryDate;

	    @Column
	    private Instant purchaseDate;

	    @Column
	    private Instant quantity;

	    @Column
	    private boolean excludeFromSales;

	    @Column
	    private String status;

	    @Column
	    private String rack;
	    
	    public String getgenericName() {
	    	
	    	return genericName;
	    }
	    
	    public void  setgenericName(String genericName) {
	    	
	    	this.genericName = genericName;
	    }
}
