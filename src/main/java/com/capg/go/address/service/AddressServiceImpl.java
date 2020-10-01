/***************************************************************
 -Author                         : Geetha
 -Created/Modified Date          : 21/09/2020
 -Description                    : AddressServiceImpl implements IAddressService
 						               for Great OutDoor Documentation.
 						           
*******************************************************************/

package com.capg.go.address.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capg.go.address.Dao.IAddressDao;
import com.capg.go.address.exception.AddressAlreadyExistException;
import com.capg.go.address.exception.AddressNotFoundException;
import com.capg.go.address.model.Address;


@Service
public class AddressServiceImpl implements IAddressService {

	@Autowired(required = true)
	IAddressDao addressDao;

	/*************************************************************************
	 -FunctionName                     : addAddress
	 -Input Parameters                 : Address address
	 -Return Type                      : flight
	 -Throws				           : AddressAlreadyExistException
	 -Author				           : Geetha
	 -Creation Date			           : 22/09/2020
	 -Description			           : Adding Address to database
	***************************************************************************/
	@Override  
	      public Address addAddress (Address address) {
		  System.out.println(address);
		  if(addressDao.existsById(address.getAddressId())) {
			 throw new AddressAlreadyExistException("address Already Exits");
		     }
		      return addressDao.save(address);
	       }

	 /*************************************************************************
	 -FunctionName                      : deleteAddress
	 -Input Parameters                  : addressId
	 -Return Type                       : Void
	 -Throws				            : AddressNotFoundException
	 -Author				            : Geetha
	 -Creation Date			            : 22/09/2020
	 -Description			            : delete Address based on AddressId
	***************************************************************************/
	@Override
	public void deleteAddress(String addressId){
		
		if(!(addressDao.findById(addressId).isPresent())) {
			throw new AddressNotFoundException("addressid with "+addressId+" is NOT FOUND");
		}
			addressDao.deleteById(addressId);
			
	
	}



	 /*************************************************************************
	 -FunctionName                       : updateAddress
	 -Input Parameters                   : addressId, userId, fullName, buildingNo, city, state, pincode, phoneNo,
	                                       otherPhoneNo, AddressType addressType
	 -Return Type                        : address
	 -Throws				             : AddressNotFoundException
	 -Author				             : Geetha 
	 -Creation Date			             : 22/09/2020
	 -Description			             : Modify Address 
	***************************************************************************/
	@Override
	public Address updateAddress(String addressId,Address address) {
		Address newAddress = addressDao.getOne(addressId);
		if( !(addressDao.existsById(addressId)))
		{ 
			throw new AddressNotFoundException("address with Number : " +addressId+" Not Found");
			}	
		newAddress.setUserId(address.getUserId());
		newAddress.setFullName(address.getFullName());
		newAddress.setBuildingNo(address.getBuildingNo());
		newAddress.setCity(address.getCity());
		newAddress.setState(address.getState());
		newAddress.setPincode(address.getPincode());
		addressDao.save(newAddress);
		return address;	
	}


	 /*************************************************************************
	 -FunctionName                       : findAddressById
	 -Input Parameters                   : addressId
	 -Return Type                        : addressIdr
	 -Throws			               	 : AddressNotFoundException
	 -Author				             : Geetha
	 -Creation Date			             : 22/09/2020
	 -Description			             : Viewing Address based on AddressId
	***************************************************************************/
	
	@Override
	public Address findAddressById(String addressId) {
		if (!addressDao.existsById(addressId)) {
				throw new AddressNotFoundException(" Address not found");
			}
			return addressDao.findById(addressId).get();
	}

	  /*************************************************************************
		 -FunctionName                    : getAll
		 -Input Parameters                : None
		 -Return Type                     : address
		 -Throws				          : None
		 -Author				          : Geetha 
		 -Creation Date			          : 22/09/2020
		 -Description			          : Viewing Address List
		***************************************************************************/
	@Override
	public List<Address> getAll() {
		return addressDao.findAll();
	}



}









