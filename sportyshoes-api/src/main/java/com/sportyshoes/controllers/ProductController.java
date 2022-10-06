package com.sportyshoes.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.models.Product;
import com.sportyshoes.services.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping("")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/search")
	public List<Product> searchByProductName(@RequestParam String productName) {
		return productService.getByProductName(productName);
	}

	@GetMapping("/search/{id}")
	public Product searchByProductId(@PathVariable Integer id) {
		return productService.getByProductId(id);
	}
	
	@PostMapping("/add")
	public Map<String, String> addProduct(@RequestParam MultiValueMap<String, String> newProductDetails) {
		Map<String, String> productAddedResponse = new HashMap<String, String>();
		Boolean productAdded = productService.addProduct(
				newProductDetails.getFirst("name"),
				Double.parseDouble(newProductDetails.getFirst("msrp")),
				Integer.parseInt(newProductDetails.getFirst("quantity")), 
				newProductDetails.getFirst("vendor"));
		if(productAdded) {
			productAddedResponse.put("status", "true");
			productAddedResponse.put("message", "Product Added successfully");
		} else {
			productAddedResponse.put("status", "false");
			productAddedResponse.put("message", "Invalid inputs");
		}
		return productAddedResponse;
	}


	@PatchMapping("/{productId}/update/name")
	public Map<String, String> updateProductName(@PathVariable Integer productId, @RequestParam String productName) {
		Map<String, String> productUpdatedResponse = new HashMap<String, String>();
		Boolean productUpdated = productService.updateProductName(productId, productName);
		if(productUpdated) {
			productUpdatedResponse.put("status", "true");
			productUpdatedResponse.put("message", "Product Updated successfully");
		} else {
			productUpdatedResponse.put("status", "false");
			productUpdatedResponse.put("message", "Invalid inputs");
		}
		return productUpdatedResponse;
	}

	@PatchMapping("/{productId}/update/msrp")
	public Map<String, String> updateProductPrice(@PathVariable Integer productId, @RequestParam Double msrp) {
		Map<String, String> productUpdatedResponse = new HashMap<String, String>();
		Boolean productUpdated = productService.updateProductMsrp(productId, msrp);
		if(productUpdated) {
			productUpdatedResponse.put("status", "true");
			productUpdatedResponse.put("message", "Product Updated successfully");
		} else {
			productUpdatedResponse.put("status", "false");
			productUpdatedResponse.put("message", "Invalid inputs");
		}
		return productUpdatedResponse;
	}

	@PatchMapping("/{productId}/update/quantity")
	public Map<String, String> updateProductQuantity(@PathVariable Integer productId, @RequestParam Integer quantity) {
		Map<String, String> productUpdatedResponse = new HashMap<String, String>();
		Boolean productUpdated = productService.updateProductQuantity(productId, quantity);
		if(productUpdated) {
			productUpdatedResponse.put("status", "true");
			productUpdatedResponse.put("message", "Product Updated successfully");
		} else {
			productUpdatedResponse.put("status", "false");
			productUpdatedResponse.put("message", "Invalid inputs");
		}
		return productUpdatedResponse;
	}

	@PatchMapping("/{productId}/update/vendor")
	public Map<String, String> updateProductVendor(@PathVariable Integer productId, @RequestParam String vendor) {
		Map<String, String> productUpdatedResponse = new HashMap<String, String>();
		Boolean productUpdated = productService.updateProductVendor(productId, vendor);
		if(productUpdated) {
			productUpdatedResponse.put("status", "true");
			productUpdatedResponse.put("message", "Product Updated successfully");
		} else {
			productUpdatedResponse.put("status", "false");
			productUpdatedResponse.put("message", "Invalid inputs");
		}
		return productUpdatedResponse;
	}

	@DeleteMapping("/{id}/delete")
	public Map<String, String> deleteProduct(@PathVariable Integer id) {
		Map<String, String> productDeletedResponse = new HashMap<String, String>();
		Boolean productDeleted = productService.deleteProductById(id);
		if(productDeleted) {
			productDeletedResponse.put("status", "true");
			productDeletedResponse.put("message", "Product deleted successfully");
		} else {
			productDeletedResponse.put("status", "false");
			productDeletedResponse.put("message", "Invalid inputs");
		}
		return productDeletedResponse;
	}

}
