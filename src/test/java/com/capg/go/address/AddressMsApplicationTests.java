package com.capg.go.address;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.assertj.core.api.AssertFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.Times;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.capg.go.address.Dao.IAddressDao;
import com.capg.go.address.model.Address;
//import com.capg.go.address.model.AddressType;
import com.capg.go.address.service.IAddressService;

@SpringBootTest
//@TestInstance(Lifecycle.PER_CLASS)
@RunWith(SpringRunner.class)
class AddressMsApplicationTests {

	 @Autowired
 IAddressService addressService;

 @MockBean
 private IAddressDao addressDao;


@Test
 public void testGetAllAddress() {
	 Address address1=new Address();
	  address1.setAddressId("6785");
		address1.setUserId("77");
		address1.setFullName("xyz");
		address1.setBuildingNo("123-9");
		address1.setCity("hyderabad");
		address1.setState("telangana");
    	address1.setPincode(5055);

		
		Address address3=new Address();
		  address3.setAddressId("8765");
			address3.setUserId("88");
			address3.setFullName("mno");
			address3.setBuildingNo("76-7");
			address3.setCity("hyderabad");
			address3.setState("telangana");
	    	address3.setPincode(2022);

	 List<Address> addressList=new ArrayList<>();
	 addressList.add(address1);
	 addressList.add(address3);
	 Mockito.when(addressDao.findAll()).thenReturn(addressList);
		assertThat(addressService.getAll()).isEqualTo(addressList);
		assertEquals(addressList.size(),2);
 }
 @Test
	public void testaddAddress() {
	 
		Address address2=new Address();
		address2.setAddressId("1234");
		address2.setUserId("123");
		address2.setFullName("abcd bgcg");
		address2.setBuildingNo("12-9");
		address2.setCity("hyderabad");
		address2.setState("telangana");
      	address2.setPincode(123);

		Mockito.when(addressDao.save(address2)).thenReturn(address2);
		assertThat(addressService.addAddress(address2)).isEqualTo(address2);
	}
 @Test
	public void deleteByAddressIdTest() {
	 Address address=new Address();
		address.setAddressId("1234");
		address.setUserId("123");
		address.setFullName("abcd bgcg");
		address.setBuildingNo("12-9");
		address.setCity("hyderabad");
		address.setState("telangana");
   	    address.setPincode(123);

		Mockito.when(addressDao.existsById(address.getAddressId())).thenReturn(false);
        assertFalse(addressDao.existsById(address.getAddressId()));
 }
 
// @Test
// void testupdate() {
//	 Address address=new Address("24413","123","abcd bgcg","12-9","hyderabad","telangana",123);
//	 Mockito.when(addressDao.saveAndFlush(address)).thenReturn(address);
//		assertThat(addressService.updateAddress("24413", address)).isEqualTo(address);
// }
// @Test
// void testgetAddressById() {
//	 Address address=new Address("12345","123","abcd bgcg","12-9","hyderabad","telangana",123,"123456789",
//             "345678",AddressType.HOME); 
//	 Mockito.when(addressService.findAddressById("12345")).thenReturn(address);
//		assertThat(addressService.findAddressById("12345")).isEqualTo(address);
// }
// @Test
// void getAddressByIdTest() {
//	 Optional<Address> address=Optional.empty(); 
//	 Mockito.when(addressDao.findById("1234")).thenReturn(address);
//		assertThat(addressDao.findById("1234")).isEqualTo(address);
// }
// @Test
// void testUpdateAddress() {
//		
//		Address address= new Address();
//		//address.setShippingAddress("Rd number:7,street number 26,madhapur");
//		address.setAddressId("123,abcd,12,hyd,tel,12,12324567,234567,home");
//
//		Mockito.when(addressService.updateAddress(null, address)).thenReturn(address);
//		assertThat(addressService.updateAddress(null, address)).isEqualTo(address);
//	}
	
//	@Test
//	public void testDeleteOrder() {
//		
//		addressService.deleteAddress("1101");
//		verify(addressService,times(1)).deleteAddress(1101);
//	}
 
// @Test
//	public void deleteAddressTest() {
//	 Address address=new Address("1234","123","abcd bgcg","12-9","hyderabad","telangana",123,"123456789",
//			                     "345678",null);
//	 addressService.deleteAddress("1234");
//	 verify(addressRepo, Times(1)
//	 
// }
 
// @BeforeAll
// public void setUp() {
//	 List<String> option=new ArrayList();
//	 option.add("String");
//	 option.add("String");
//	 option.add("String");
//	 option.add("String");
//	 option.add("String");
//	 option.add("String");
//	 option.add("Long");
//	 option.add("String");
//	 option.add("String");
//	 option.add("Enum");
//	 address=new Address();
//	 address.setAddressOptions(option);
// }
// @Test
// void testDeleteAddress() {
//	 addressService.addAddress(address);
//	 assertEquals(true,addressService.deleteAddress("25738"));
// }
// @Test
// void testfindAddressById() {
//	 assertEquals(address,addressService.findAddressById(123));
// }
// @Test
//	public void addAddressTest() {
//	 
//Address address=mock(Address.class);
//addressService.addAddress(address);
//verify(addressRepo).save(address);
//}
//
//@Test
//public void getAllAddressTest() {
//	 addressService.getAll();
//	 verify(addressRepo).findAll();
//}
//@Test
//	public void testGettAll() {
//		when(addressRepo.findAll()).thenReturn(Stream.
//				of(new Address(),new Address(176,"airli","mode",88)).
//				collect(Collectors.toList()));
//		assertEquals(addressService.getAll().Address(), addressService.getAll().getFlightList());
//	
//	}

}
