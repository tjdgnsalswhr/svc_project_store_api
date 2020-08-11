package com.example.demo.store.core.port_infra.persistent;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.store.core.entity.Store;

public interface StoreRepository extends JpaRepository<Store, String> 
{
	public List<Store> findByStorecode(String storecode);
	public Optional<Store> findByOwnerid(String owid);

}
