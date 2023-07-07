package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Supplier;
import com.example.demo.repository.SupplierRepository;

@Service
public class SupplierService {
	
	private final SupplierRepository supplierRepository;

	public SupplierService(SupplierRepository supplierRepository) {
		this.supplierRepository = supplierRepository;
	}

	public void createSupplier(Supplier supplier) {
		supplierRepository.save(supplier);
	}
}
