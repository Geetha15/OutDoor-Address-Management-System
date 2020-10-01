package com.capg.go.address.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="great_out_table1")
public class Address {

    @Id
	@Column(name="address_id")
	private String addressId;
	
	@Column(name="user_id",length=3)
	private String userId;
	
	@Column(name="fullname",length=15)
	private String fullName;
	
	@Column(name="Building_No",length=50)
	private String buildingNo;
	
	@Column(name="city",length=15)
	private String city;
	
	@Column(name="state",length=15)
	private String state;
	
	@Column(name="pincode",length=15)
	private long pincode;

	
	public Address() {
		super();
	}

public Address(String addressId, String userId, String fullName, String buildingNo, String city, String state,
		long pincode) {
	super();
	this.addressId = addressId;
	this.userId = userId;
	this.fullName = fullName;
	this.buildingNo = buildingNo;
	this.city = city;
	this.state = state;
	this.pincode = pincode;
}

public String getAddressId() {
	return addressId;
}

public void setAddressId(String addressId) {
	this.addressId = addressId;
}

public String getUserId() {
	return userId;
}

public void setUserId(String userId) {
	this.userId = userId;
}

public String getFullName() {
	return fullName;
}

public void setFullName(String fullName) {
	this.fullName = fullName;
}

public String getBuildingNo() {
	return buildingNo;
}

public void setBuildingNo(String buildingNo) {
	this.buildingNo = buildingNo;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public long getPincode() {
	return pincode;
}

public void setPincode(long pincode) {
	this.pincode = pincode;
}




	
}









/////////////////////////////////////////////////////////////////////////////
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;
//
//
//@Entity
//@Table(name="great_out")
//public class Address {
//	@Id
//	@GeneratedValue(generator="mygen",strategy=GenerationType.SEQUENCE)
//	@SequenceGenerator(name="mygen",sequenceName="Addss_seq",allocationSize=1)
//	@Column(name="address_id")
//	private int addressId;
////	@Column(name="adoor",length=15)
//	@Column(name="user_id",length=15)
//	private String userId;
//	
//	@Column(name="Building_No",length=15)
//	private String buildingNo;
//	
//	@Column(name="city",length=15)
//	private String city;
//	
//
//	@Column(name="state",length=15)
//	private String state;
//	
//	@Column(name="pincode",length=15)
//	private long pincode;
//	
//	@Column(name="phone_no",length=15)
//	private String phoneNo;
//	
//	@Column(name="other_phone_no")
//	private String otherPhoneNo;
//	@Column(name="fullname",nullable=false)
//	private String fullName;
//	@Column(name="address_line",nullable=false)
//	private String addressLine;
//	@Enumerated(EnumType.STRING)
//	@Column(name="address_type",nullable=false)
//	private AddressType addressType;
//
//	public Address() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public Address(int addressId, String userId, String buildingNo, String city, String state, long pincode,
//			String phoneNo) {
//		super();
//		this.addressId = addressId;
//		this.userId = userId;
//		this.buildingNo = buildingNo;
//		this.city = city;
//		this.state = state;
//		this.pincode = pincode;
//		this.phoneNo = phoneNo;
//	}
//
//	public int getAddressId() {
//		return addressId;
//	}
//
//	public void setAddressId(int addressId) {
//		this.addressId = addressId;
//	}
//
//	public String getUserId() {
//		return userId;
//	}
//
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}
//
//	public String getBuildingNo() {
//		return buildingNo;
//	}
//
//	public void setBuildingNo(String buildingNo) {
//		this.buildingNo = buildingNo;
//	}
//
//	public String getCity() {
//		return city;
//	}
//
//	public void setCity(String city) {
//		this.city = city;
//	}
//
//	public String getState() {
//		return state;
//	}
//
//	public void setState(String state) {
//		this.state = state;
//	}
//
//	public long getPincode() {
//		return pincode;
//	}
//
//	public void setPincode(long pincode) {
//		this.pincode = pincode;
//	}
//
//	public String getPhoneNo() {
//		return phoneNo;
//	}
//
//	public void setPhoneNo(String phoneNo) {
//		this.phoneNo = phoneNo;
//	}
//	
//
//	
//	
//	
//}
