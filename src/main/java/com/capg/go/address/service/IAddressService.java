/***************************************************************
 -Author                         : Geetha
 -Created/Modified Date          : 21/09/2020
 -Description                    : IAddressService interface for 
 						           Great OutDoor Documentation.
 						           
*******************************************************************/
package com.capg.go.address.service;
import java.util.List;

import com.capg.go.address.model.Address;



public interface IAddressService {
	
	public Address addAddress(Address address);
	
	public void deleteAddress(String addressId) ;
	
    public Address updateAddress(String addressId, Address address);
	
	public Address findAddressById(String addressId);
	
	public List<Address> getAll();


}



