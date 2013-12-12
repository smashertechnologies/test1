package com.saloonsuite.dao;

import static com.saloonsuite.dao.connection.ConnectionFactory.getConnection;
import static com.saloonsuite.util.CustomerServiceConstants.CUSTOMER_ID_COL;
import static com.saloonsuite.util.CustomerServiceConstants.DOWNRATING_COL;
import static com.saloonsuite.util.CustomerServiceConstants.SELECT_ALL_CUSTOMERSERVICE;
import static com.saloonsuite.util.CustomerServiceConstants.SELECT_BY_CUSTOMER_ID;
import static com.saloonsuite.util.CustomerServiceConstants.SERVICE_ID_COL;
import static com.saloonsuite.util.CustomerServiceConstants.SERVICE_NAME_COL;
import static com.saloonsuite.util.CustomerServiceConstants.UPRATING_COL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.saloonsuite.data.entity.CustomerServices;
import com.saloonsuite.data.entity.DataObject;
import com.saloonsuite.util.validator.BaseValidator;

public class CustomerServiceDAOImpl extends AbstractDAO implements CustomerServiceDAO {

	@Override
	public List<CustomerServices> getByCustomerId(String customerId) {

		
		if ( BaseValidator.isNullOrBlank(customerId)) {
			log.error("Invalid CustomerId found for searching customer service :  " + customerId+", Search Completed. Returning null.");
			return null;
		}
		PreparedStatement pStmt = null;
		ResultSet rSet = null;
		log.info("Searching all customer service records from database by CustomerId with CustomerId : "+ customerId);
		try {
			log.debug("Customer Service select Query : " + SELECT_BY_CUSTOMER_ID);
			pStmt = getConnection().prepareStatement(SELECT_BY_CUSTOMER_ID);
			pStmt.setString(1, customerId);
			
			rSet = pStmt.executeQuery();
			List<CustomerServices> lstRecords = new ArrayList<CustomerServices>();
			if(rSet.next()) {
				do{
					CustomerServices obj = new CustomerServices();
					obj.setCustomerId(rSet.getString(CUSTOMER_ID_COL));
					obj.setServiceId(rSet.getString(SERVICE_ID_COL));
					obj.setServiceName(rSet.getString(SERVICE_NAME_COL));
					obj.setUp(rSet.getInt(UPRATING_COL));
					obj.setDown(rSet.getInt(DOWNRATING_COL));
					
					lstRecords.add(obj);
					
				}while(rSet.next());
				
				log.debug("Customer Service List from DB :" + lstRecords);
				return lstRecords;
				
			} else {
				log.debug("No Record Found while searching customer address!" );
			}

		} catch (SQLException e) {
			log.error("Error while trying to fetch the data for Customer Service Info Records.");
			e.printStackTrace();
		} finally {
			close(rSet);
			close(pStmt);
		}
		return null;
	}

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
	public List<CustomerServices> getAll() {


		log.info("Searching all customer service records from database");
		Statement stmt = null;
		ResultSet rSet = null;
		try {
			log.debug("Customer Service Get All Query is  : " + SELECT_ALL_CUSTOMERSERVICE);
			rSet = getConnection().createStatement().executeQuery(SELECT_ALL_CUSTOMERSERVICE);
			List<CustomerServices> lstRecords = new ArrayList<CustomerServices>();
			if(rSet.next()) {
				do{
					CustomerServices obj = new CustomerServices();
					obj.setCustomerId(rSet.getString(CUSTOMER_ID_COL));
					obj.setServiceId(rSet.getString(SERVICE_ID_COL));
					obj.setServiceName(rSet.getString(SERVICE_NAME_COL));
					obj.setUp(rSet.getInt(UPRATING_COL));
					obj.setDown(rSet.getInt(DOWNRATING_COL));
					
					lstRecords.add(obj);
					
				}while(rSet.next());

				log.debug("Customer Service List from DB :" + lstRecords);
				return lstRecords;
				
			} else {
				log.debug("No Record Found while searching customer service!" );
			}

		} catch (SQLException e) {
			System.err.println("Error while trying to fetch the data for Customer Service Info Records.");
			e.printStackTrace();
		} finally {
			close(rSet);
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

}
