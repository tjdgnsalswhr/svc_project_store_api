package com.example.demo.store.core.service;

import java.util.List;

import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.common.error.exception.BusinessException;
import com.example.demo.store.core.application.object.command.StoreRequestDTO;
import com.example.demo.store.core.application.object.query.StoreResponseDTO;
import com.example.demo.store.core.entity.Store;
import com.example.demo.store.core.port_infra.persistent.StoreRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class StoreInfoService {
	private final StoreRepository storeRepository;
	private final ModelMapper modelMapper;
	
	public List<Store> getAllStoreList()
	{
		return storeRepository.findAll();
	}
	
	
	public StoreResponseDTO getOneStore(String id) //계속 주고 받는 것에 DTO를 쓰는 이유는 원래 객체를 망가뜨리지 않기 위해서 비슷한 것을 복제해 사용하는 것임
	{
		Optional<Store> optionalStore = storeRepository.findById(id);
		if(optionalStore.isPresent())
		{
			return modelMapper.map(optionalStore.get(), StoreResponseDTO.class);
		}
		else
			return null;
	}
	
	public void insertStore(StoreRequestDTO storeRequestDTO)
	{
		Store store = modelMapper.map(storeRequestDTO, Store.class);
		storeRepository.save(store);
	}
	
	public void updateStore(StoreRequestDTO storeRequestDTO)	
	{
		Optional<Store> optionalStore = storeRepository.findById(storeRequestDTO.getSid());
		if(!optionalStore.isPresent())
		{
			throw new BusinessException("0000","There is No Store");
		}
		Store store = optionalStore.get();
		store.update(storeRequestDTO);
		storeRepository.save(store);
	}
	
	public void deleteStore(String id)
	{
		Optional<Store> optionalStore = storeRepository.findById(id);
		if(!optionalStore.isPresent())
		{
			throw new BusinessException("0000","There is No Store");
		}
		storeRepository.delete(optionalStore.get());
	}
	
	//음식 종류별 가게 조회
	public List<Store> getTypeStore(String storecode)
	{
		return storeRepository.findByStorecode(storecode);
	}



}
