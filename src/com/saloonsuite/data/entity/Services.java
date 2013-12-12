package com.saloonsuite.data.entity;

import com.saloonsuite.util.ServicesConstants;

public class Services extends DataObject {

	
	private String _serviceId;
	private String _serviceName;
	public Services(){
		
	}
	
	public Services(String serviceId,String serviceName) {
		this._serviceId = serviceId;
		this._serviceName = serviceName;
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


	public void setServiceName(String sericeName) {
		_serviceName = sericeName;
	}


	@Override
	public String getQueryString() {
		return ServicesConstants.SELECT_ALL_SERVICES;
	}

}
