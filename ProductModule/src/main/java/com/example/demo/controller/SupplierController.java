package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Supplier;
import com.example.demo.service.SupplierService;

import jakarta.validation.Valid;

@RestController
public class SupplierController {
	
	private final SupplierService supplierService;
	
	@Autowired
	public SupplierController(SupplierService supplierService) {
		
		this.supplierService = supplierService;
	}
	
	@PostMapping(value = "/store-supplier", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Supplier> createSupplier(@Valid @RequestBody Supplier supplier){
		
		supplierService.createSupplier(supplier);
        return ResponseEntity.ok(supplier);
	}

}
