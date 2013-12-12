package com.saloonsuite.data.entity;
import static com.saloonsuite.util.CustomerInfoConstants.SELECT_ALL_CUSTOMERINFO;

import java.util.List;
public class CustomerInfo extends DataObject {

	private String _customerId;
	private String _title;
	private List<CustomerServices> _services;
	private Integer _up;
	private Integer _downs;
	private String _imageName;
	private CustomerAddress _address;
	private String _email;
	
	
	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public CustomerAddress getAddress() {
		return _address;
	}
	

	public void setAddress(CustomerAddress customerAddress) {
		_address = customerAddress;
	}

	public CustomerInfo() {
		
	}
	public CustomerInfo(String customerId,String title,String imageName,CustomerAddress address,List<CustomerServices> services,Integer ups,Integer downs,String email) {
	
		this._customerId = customerId;
		this._title = title;
		this._imageName = imageName;
		this._address = address;
		_services = services;
		this._up = ups;
		this._downs = downs;
		this._email = email;
		
	}
	
	
	public String getCustomerId() {
		return _customerId;
	}
	
	public void setCustomerId(String customerId) {
		this._customerId = customerId;
	}
	
	public void setTitle(String title) {
		this._title = title;
	}
	public String getTitle(){
		return _title;
	}
	public String getImageName() {
		return _imageName;
	}
	public void setImageName(String imageName ){
		this._imageName  = imageName;
	}
	public Integer getUps() {
		return _up;
	}
	public void setUps(Integer up) {
		this._up = up;
	}
	public Integer getDowns(){
		return _downs;
	}
	public void setDowns(Integer down) {
		this._downs = down;
	}
	public List<CustomerServices> getServices(){
		return _services;
	}
	public void setServices(List<CustomerServices> services) {
		this._services = services;
	}
	

	@Override
	public String getQueryString() {
		return SELECT_ALL_CUSTOMERINFO;
	}
}
