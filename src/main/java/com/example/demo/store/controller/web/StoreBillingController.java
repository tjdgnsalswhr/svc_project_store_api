package com.example.demo.store.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.store.core.service.StoreBillingService;

import io.swagger.annotations.ApiOperation;

@RestController
public class StoreBillingController {
	
	@Autowired
	StoreBillingService storeBillingService;

	@ApiOperation(value = "가게 수입 증가", httpMethod="PUT", notes="가게 수익 증가 API.")
	@PutMapping(value="/store/info/earnings/{storeid}/{money}")
	public ResponseEntity<Object> updateStoreEarnings(@PathVariable String storeid, @PathVariable int money)
	{
		storeBillingService.updateEarnings(storeid, money);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
