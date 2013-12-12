package com.saloonsuite.data.entity;

import com.saloonsuite.util.CustomerServiceConstants;

public class CustomerServices extends DataObject{

	
	private String _customerId;
	private String _serviceId;
	private String _serviceName;
	private Integer _up;
	private Integer _down;
	
	
	public CustomerServices() {
		
	}
	public CustomerServices(String customerId,String serviceId,String serviceName,Integer up,Integer down) {
		this._customerId = customerId;
		this._serviceId = serviceId;
		this._serviceName = serviceName;
		this._up = up;
		this._down = down;
		
	}
	public String getCustomerId() {
		return _customerId;
	}
	public void setCustomerId(String customerId) {
		_customerId = customerId;
	}
	public String getServiceId() {
		return _serviceId;
	}
	public void setServiceId(String serviceId) {
		_serviceId = serviceId;
	}
	public String getServiceName() {
		return _serviceName;
	}
	public void setServiceName(String serviceName) {
		_serviceName = serviceName;
	}
	public Integer getUp() {
		return _up;
	}
	public void setUp(Integer up) {
		_up = up;
	}
	public Integer getDown() {
		return _down;
	}
	public void setDown(Integer down) {
		_down = down;
	}
	@Override
	public String getQueryString() {
		return CustomerServiceConstants.SELECT_ALL_CUSTOMERSERVICE;
	}

}
