package com.example.demo.controller;

import com.example.demo.entity.Supplier;
import com.example.demo.service.SupplierService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SupplierController {
	
	private final SupplierService supplierService;
	
	@Autowired
	public SupplierController(SupplierService supplierService) {
		
		this.supplierService = supplierService;
	}
	
	@PostMapping(value = "/store-supplier", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier){
		
		supplierService.createSupplier(supplier);
        return ResponseEntity.ok(supplier);
	}
	
    @GetMapping("/supplier-list")
    public ResponseEntity<List<Supplier>> getSupplier() {
        List<Supplier> supplier = supplierService.getAllSupplier();
        return ResponseEntity.ok(supplier);
    }
    
    @PutMapping(value = "/supplier/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Supplier> updateSupplier(@PathVariable Integer id, @RequestBody Supplier updateSupplier) {
        boolean isUpdated = supplierService.updateSupplier(id, updateSupplier);
        if (isUpdated) {
            Supplier updatedSupplier = supplierService.getSupplierById(id);
            if (updatedSupplier != null) {
                return ResponseEntity.ok(updatedSupplier);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/supplier-delete/{id}")
    public ResponseEntity<String> deleteSupplier(@PathVariable Integer id) {
        boolean isDeleted = supplierService.deleteSupplier(id);
        if (isDeleted) {
            return ResponseEntity.ok("Supplier deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
