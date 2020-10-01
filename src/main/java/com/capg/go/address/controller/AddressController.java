/***************************************************************
 -File Name             : AddressController.java
 -Author                : Geetha
 -Created/Modified Date : 22/09/2020
 -Description           : Controller For Address
 
*******************************************************************/
package com.capg.go.address.controller;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.go.address.model.Address;
import com.capg.go.address.service.IAddressService;



@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/address") 
public class AddressController {

	/*
	 * http://localhost:9088/address/add POSTMAN (Post : body{ "addressId": "257381","userId":"251",
	 *"fullName":"Geetha Banoth","buildingNo":"67-6","city":"hyd","state":"telangana", "pincode":1234,
	 *"phoneNo":"23456789","otherPhoneNo":"2345678567","addressType":"HOME"}) Don't insert
	 * addressId, Id is :@GeneratedValue(strategy =GenerationType.SEQUENCE)
	 */

		@Autowired
		IAddressService addressService;

		/******************************************
	    - Method Name      : addAddress
	    - Input Parameters : Address Object
	    - End Point Url    : /add
	    -Request Method Type: PostMapping
	    - Author           : Geetha
	    - Creation Date    : 22-09-2020
	    - Description      : Inserting the address information entered by user into  the database.
	     ******************************************/

		@PostMapping("/add")
		public Address addAddress( @RequestBody Address address) {
			address.setAddressId(getAddressId()+"");
			return addressService.addAddress(address);
		}
		/******************************************
	    - Method Name      : deleteAddress
	    - Input Parameters : addressId
	    - Return type      : boolean
	    - End Point Url    : /deleteById/{flightNumber}
	    -Request Method Type: DeleteMapping
	    - Author           : Geetha
	    - Creation Date    : 22-09-2020
	    - Description      : delete Address based on Id.
	     ******************************************/
			
		@DeleteMapping("/deleteById/{addressbyId}")
		public ResponseEntity<Object> deleteAddress( @PathVariable("addressbyId") String addressId) {
			addressService.deleteAddress(addressId);
			return new ResponseEntity<>("Deleted Successfull",HttpStatus.OK);
		}
		/******************************************
	    - Method Name      : updateAddress
	    - Input Parameters : address
	    - Return type      : newAddress
	    - End Point Url    : /modify/{addressId}
	    -Request Method Type: PutMapping
	    - Author           : Geetha
	    - Creation Date    : 22-09-2020
	    - Description      : Modify Address Management.
	     ******************************************/
		@PutMapping("/update/{addressId}")
		public ResponseEntity<Object> updateAddress(@PathVariable("addressId") String addressId, @RequestBody Address address)
		{
			addressService.updateAddress(addressId,address);
			return new ResponseEntity<>("AddressDetails Updated",HttpStatus.OK);
		}
		

		/******************************************
	    - Method Name      : findAddressById
	    - Input Parameters : addressId
	    - Return type      : address
	    - End Point Url    : getAddressById/{addressId}
	    -Request Method Type: GettMapping
	    - Author           : Geetha
	    - Creation Date    : 22-09-2020
	    - Description      : Viewing address based on addressId.
	     ******************************************/
		
		@GetMapping("/getaddressById/{addressId}")
		public ResponseEntity<Address> findAddressById(@PathVariable String addressId) {

			Address address = addressService.findAddressById(addressId);

			return new ResponseEntity<Address>(address, HttpStatus.OK);
		}
		/******************************************
	    - Method Name      :  getAll
	    - Input Parameters :  None
	    - Return type      :  list
	    - End Point Url    :  /all
	    -Request Method Type: GettMapping
	    - Author           :  Geetha
	    - Creation Date    :  22-09-2020
	    - Description      :  Viewing Address List.
	     ******************************************/
		@GetMapping("/all")
		public ResponseEntity<List<Address>> getAll()
		{
			List<Address> list = addressService.getAll();
			ResponseEntity<List<Address>>  rt = new ResponseEntity<List<Address>>(list,HttpStatus.OK);
			return rt;
				}
		
		
		
		public int getAddressId() {
		    Random r = new Random( System.currentTimeMillis() );
		    return 10000 + r.nextInt(20000);
		}
		@ExceptionHandler(Exception.class)
		public String inValid(Exception e) {
			return e.getMessage();
		}
		


}
