package com.saloonsuite.dao;

import static com.saloonsuite.dao.connection.ConnectionFactory.getConnection;
import static com.saloonsuite.util.CustomerAddressConstants.ADDRESS_1_COL;
import static com.saloonsuite.util.CustomerAddressConstants.ADDRESS_2_COL;
import static com.saloonsuite.util.CustomerAddressConstants.CITY_COL;
import static com.saloonsuite.util.CustomerAddressConstants.CUSTOMER_ID_COL;
import static com.saloonsuite.util.CustomerAddressConstants.SELECT_ALL_CUSTOMERADDRESS;
import static com.saloonsuite.util.CustomerAddressConstants.SELECT_BY_CUSTOMER_ID;
import static com.saloonsuite.util.CustomerAddressConstants.STATE_COL;
import static com.saloonsuite.util.CustomerAddressConstants.ZIPCODE_COL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.saloonsuite.data.entity.CustomerAddress;
import com.saloonsuite.data.entity.DataObject;
import com.saloonsuite.util.validator.BaseValidator;


public class CustomerAddressDAOImpl extends AbstractDAO implements CustomerAddressDAO  {

	Logger log = Logger.getLogger(CustomerAddressDAOImpl.class);
	@Override
	public boolean create() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean exists() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DataObject get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerAddress> getAll() {

		ResultSet resultSet = null;
		Statement stmt = null;
		log.info("Searching all customer address records from database");
		try {
			log.debug("Customer Address Get All Query is  : " + SELECT_ALL_CUSTOMERADDRESS);
			stmt = getConnection().createStatement();
			resultSet = stmt.executeQuery(SELECT_ALL_CUSTOMERADDRESS);
			List<CustomerAddress> lstRecords = new ArrayList<CustomerAddress>();
			if(resultSet.next()) {
				do{
					CustomerAddress obj = new CustomerAddress();
					obj.setCustomerId(resultSet.getString(CUSTOMER_ID_COL));
					obj.setAddress1(resultSet.getString(ADDRESS_1_COL));
					obj.setAddress2(resultSet.getString(ADDRESS_2_COL));
					obj.setCity(resultSet.getString(CITY_COL));
					obj.setState(resultSet.getString(STATE_COL));
					obj.setZipCode(resultSet.getString(ZIPCODE_COL));
					lstRecords.add(obj);
				}while(resultSet.next());
				log.debug("Customer Address List from DB :" + lstRecords);
				return lstRecords;
				
			} else {
				log.debug("No Record Found while searching customer address!" );
			}

		} catch (SQLException e) {
			log.error("Error while trying to fetch the data for Customer Address Info Records.");
			e.printStackTrace();
		} finally {
			close(resultSet);
			close(stmt);
		}
		
		return null;
	
	}

	@Override
	public boolean save() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveOrUpdate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CustomerAddress getByCustomerId(String customerId) {

		PreparedStatement pStmt = null;
		ResultSet resultSet = null;
		log.info("Searching customer address records from database with CustomerId : " + customerId);
		if (BaseValidator.isNullOrBlank(customerId)) {
			log.error("Invalid customerId provided for Searching records.Search request completed, returning null");
			return null;
		}
		try {
			log.debug("Customer Address Get Query is  : " + SELECT_BY_CUSTOMER_ID);
			pStmt = getConnection().prepareStatement(SELECT_BY_CUSTOMER_ID);
			pStmt.setString(1, customerId);
			resultSet = pStmt.executeQuery();
			if(resultSet.next()) {
					CustomerAddress obj = new CustomerAddress();
					obj.setCustomerId(resultSet.getString(CUSTOMER_ID_COL));
					obj.setAddress1(resultSet.getString(ADDRESS_1_COL));
					obj.setAddress2(resultSet.getString(ADDRESS_2_COL));
					obj.setCity(resultSet.getString(CITY_COL));
					obj.setState(resultSet.getString(STATE_COL));
					obj.setZipCode(resultSet.getString(ZIPCODE_COL));
				log.debug("Customer Address Found :" + obj);
				return obj;
				
			} else {
				log.debug("No Record Found while searching customer address!" );
			}
			resultSet.close();
		} catch (SQLException e) {
			log.error("Error while trying to fetch the data for Customer Address Info Records.");
			e.printStackTrace();
		} finally {
			close(resultSet);
			close(pStmt);
		}
		
		return null;
		
	}
}
