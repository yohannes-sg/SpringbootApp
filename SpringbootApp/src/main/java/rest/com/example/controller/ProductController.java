package rest.com.example.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rest.com.example.model.Product;
import rest.com.example.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping("/products")
	public List<Product> getProduct() {
		return productService.listAll();
	}
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> get(@PathVariable Integer id) {
	    try {
	        Product product = productService.get(id);
	        return new ResponseEntity<Product>(product, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	    }      
	}
		
	@PostMapping("/product")
	public void add(@RequestBody Product product) {
		productService.save(product);
	}
	
	@DeleteMapping("/product/{id}")
	public void delete(@PathVariable Integer id) {
		productService.delete(id);
	}
	@GetMapping("/totalPrice")
	public double getTotalProduct() {
		return productService.getTotalPrice();
	}
}