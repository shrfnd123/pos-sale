package com.example.demo.service;

import com.example.demo.entity.Supplier;
import com.example.demo.repository.SupplierRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {
	
	private final SupplierRepository supplierRepository;

	public SupplierService(SupplierRepository supplierRepository) {
		this.supplierRepository = supplierRepository;
	}

	public void createSupplier(Supplier supplier) {
		supplierRepository.save(supplier);
	}
	
	public List<Supplier> getAllSupplier() {
			
	        return supplierRepository.findAll();
	}
	
	public boolean updateSupplier(Integer id, Supplier updateSupplier) {
			
		    Optional<Supplier> existingSupplier = supplierRepository.findById(id);
		    
		    if (existingSupplier.isPresent()) {
		        Supplier supplier = existingSupplier.get();
		        // Update the category fields with the values from updatedCategory
		        supplier.setName(updateSupplier.getName());
		        // ...
	
		        supplierRepository.save(supplier);
		        return true;
		    } else {
		        return false;
		    }
	}
	
	public Supplier getSupplierById(Integer id) {
		
        return supplierRepository.findById(id).orElse(null);
	}
	
	public boolean deleteSupplier(Integer id) {
		
        Optional<Supplier> supplierOptional = supplierRepository.findById(id);
        
        if (supplierOptional.isPresent()) {
        	supplierRepository.deleteById(id);
            return true;
        }
        return false;
}
}
