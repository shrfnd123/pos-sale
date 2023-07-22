package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	private final ProductRepository productrepo;
	
	private ProductService(ProductRepository productrepo) {
		
		this.productrepo = productrepo;
	}
	
	public void createProduct(Product product) {
		
		productrepo.save(product);
		
	}
	
	public List<Product> getAllProduct() {
		
        return productrepo.findAll();
	}
	
	public boolean updateProduct(Integer id, Product updateProduct) {
		
	    Optional<Product> existingProduct = productrepo.findById(id);
	    
	    if (existingProduct.isPresent()) {
	    	Product product = existingProduct.get();
	    	product.setgenericName(updateProduct.getgenericName());
	        productrepo.save(product);
	        return true;
	    } else {
	        return false;
	    }
}

	public Product getSProductById(Integer id) {
		
	    return productrepo.findById(id).orElse(null);
	    
	}
	
	public boolean deleteProduct(Integer id) {
		
        if (productrepo.existsById(id)) {
        	
        	productrepo.deleteById(id);
            return true;
            
        } else {
        	
            return false;
        }
    }
	
	public Product findProductByCategoryId(Integer categoryId) {
		
        return productrepo.findByCategoryId(categoryId);
        
    }
	
	public Product findProductBySupplierId(Integer supplierId) {
		
		return productrepo.findByCategoryId(supplierId);
				
	}

}
