package com.saloonsuite.dao;

import com.saloonsuite.dao.base.BaseDAO;
import com.saloonsuite.data.entity.CustomerAddress;

public interface CustomerAddressDAO extends BaseDAO {

	public CustomerAddress getByCustomerId(String customerId);
}
