package rest.com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import rest.com.example.model.Product;
import rest.com.example.repository.ProductRepository;

@Service
@Transactional
public class ProductService {// implements IProductService

	@Autowired
	private ProductRepository productRepository;

	// @Override
	public List<Product> listAll() {
		return productRepository.findAll();
	}

	// Insert or add product
	public void save(Product product) {
		productRepository.save(product);
	}
	
	//get by id 
	public Product get(Integer id) {
		return productRepository.findById(id).get();
	}
	//delete by id
	public void delete(Integer id) {
		productRepository.deleteById(id);
    }
	
	public double getTotalPrice() {
		return productRepository.findAllNative();
	}
}