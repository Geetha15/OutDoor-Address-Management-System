package com.capg.go.address.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.go.address.model.Address;

@Repository
public interface IAddressDao extends JpaRepository<Address, String>{


}
