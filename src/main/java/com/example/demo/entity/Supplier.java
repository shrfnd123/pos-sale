package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.Collection;

@Entity
public class Supplier {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy="supplier", fetch = FetchType.LAZY)
    Collection<Product> products;
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
