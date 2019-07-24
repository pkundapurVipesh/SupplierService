package com.vippar.service.model;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="customer" )
public interface CustromerService {
    @RequestMapping("/customer/findById/{id}")
    public  Customer findByID(@PathVariable("id") Long id); 
    	
    

}
