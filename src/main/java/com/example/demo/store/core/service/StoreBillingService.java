package com.example.demo.store.core.service;

import java.util.Optional;



import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.store.core.application.object.command.StoreRequestDTO;
import com.example.demo.store.core.entity.Store;
import com.example.demo.store.core.port_infra.persistent.StoreRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class StoreBillingService {
	

	private final StoreRepository storeRepository;
	private final ModelMapper modelMapper;
	
	public void updateEarnings(String storeid, int money)
	{
		Optional<Store> optionalStore = storeRepository.findBySid(storeid);
		Store store = optionalStore.get();
		
		StoreRequestDTO storeRequestDTO = modelMapper.map(optionalStore.get(), StoreRequestDTO.class);
		int plus = storeRequestDTO.getEarnings() + money;
		storeRequestDTO.setEarnings(plus);
		
		store.update(storeRequestDTO);
		
	}
	
	

}
