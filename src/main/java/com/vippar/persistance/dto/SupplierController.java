package com.vippar.persistance.dto;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vippar.persistance.repository.SupplierRepository;
import com.vippar.service.model.CustromerService;
@RestController
@RequestMapping("/supplier")
public class SupplierController {
	@Autowired
	SupplierRepository supplierRepository;
	 @Autowired
	 CustromerService custromerService;

	@PostMapping("/")
	public void createSupplier(@RequestBody Supplier supplier) {
		supplierRepository.save(supplier);
		
	}
	
	@GetMapping("/{id}")
	public Supplier getSupplier(@PathVariable long  id) {
		 Supplier supplier=new Supplier();
				 
         Optional<Supplier> optional = this.supplierRepository.findById(id);
         if (optional.isPresent()) {
        	 supplier= optional.get();
        	 supplier.setCustomer(custromerService.findByID(supplier.getCustomerId()));
         }
         return supplier;

		
	}
}
