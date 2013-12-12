package com.saloonsuite.data.entity;
import static com.saloonsuite.util.CustomerAddressConstants.SELECT_ALL_CUSTOMERADDRESS;
public class CustomerAddress extends DataObject {

	private String _customerId ;
	private String _address1;
	private String _address2;
	private String _city;
	private String _state;
	private String _zipCode;
	
	
	public CustomerAddress() {
		
	}
	
	public CustomerAddress(String customerId,String address1,String address2,String city,String state,String zipCode) {
		this._customerId = customerId;
		this._address1 = address1;
		this._address2 = address2;
		this._city = city;
		this._state = state;
		this._zipCode = zipCode;
	}
	
	
	public String getCustomerId() {
		return _customerId;
	}

	public void setCustomerId(String customerId) {
		_customerId = customerId;
	}

	public String getAddress1() {
		return _address1;
	}

	public void setAddress1(String address1) {
		_address1 = address1;
	}

	public String getAddress2() {
		return _address2;
	}

	public void setAddress2(String address2) {
		_address2 = address2;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getState() {
		return _state;
	}

	public void setState(String state) {
		_state = state;
	}

	public String getZipCode() {
		return _zipCode;
	}

	public void setZipCode(String zipCode) {
		_zipCode = zipCode;
	}

	@Override
	public String getQueryString() {
		return SELECT_ALL_CUSTOMERADDRESS;
	}
	
	public String toString() {
		return 
		"Address1 : " + _address1 + "," + 
		"Address2 : " + _address2 + "," +
		"City : " + _city +"," +
		"State : " + _state +"," +
		"Zip Code : " + _zipCode;
	}
	
	public String displayString() {
		return 
		_address1 + "<br>" + 
		 _address2 + ", " + _city +"<br>" 
		+ _state +", " + _zipCode;
	}

}
