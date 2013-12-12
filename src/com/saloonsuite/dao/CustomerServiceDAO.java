package com.saloonsuite.dao;

import java.util.List;

import com.saloonsuite.dao.base.BaseDAO;
import com.saloonsuite.data.entity.CustomerServices;

public interface CustomerServiceDAO extends BaseDAO {

	public List<CustomerServices> getByCustomerId(String customerId);
}
