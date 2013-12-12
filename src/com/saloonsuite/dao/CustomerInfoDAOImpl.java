package com.saloonsuite.dao;

import static com.saloonsuite.dao.connection.ConnectionFactory.getConnection;
import static com.saloonsuite.util.CustomerAddressConstants.SELECT_ALL_CUSTOMERADDRESS;
import static com.saloonsuite.util.CustomerInfoConstants.CUSTOMER_ID_COL;
import static com.saloonsuite.util.CustomerInfoConstants.CUSTOMER_TITLE_COL;
import static com.saloonsuite.util.CustomerInfoConstants.DOWNRATING_COL;
import static com.saloonsuite.util.CustomerInfoConstants.EMAIL_COL;
import static com.saloonsuite.util.CustomerInfoConstants.IMG_NAME_COL;
import static com.saloonsuite.util.CustomerInfoConstants.SELECT_ALL_CUSTOMERINFO;
import static com.saloonsuite.util.CustomerInfoConstants.UPRATING_COL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import com.saloonsuite.data.entity.CustomerInfo;
import com.saloonsuite.data.entity.CustomerServices;
import com.saloonsuite.data.entity.DataObject;
import com.saloonsuite.util.validator.BaseValidator;

public class CustomerInfoDAOImpl extends AbstractDAO implements CustomerInfoDAO {

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
	public List<CustomerInfo> getAll(String strNames,String strServices,String strPlaces) {
		
		log.info("Getting All Customer Information with : name:" + strNames + ", Services :" + strServices + ", Places : " + strPlaces);
		
		List<CustomerInfo> lstCustomers = getAll();
		StringTokenizer strTokens = null;
		List<String> lstTokens = new ArrayList<String>();
		if ( !BaseValidator.isNullOrBlank(strServices)) {
			strTokens = new StringTokenizer(strServices, ",");
			while(strTokens.hasMoreTokens()) {
				lstTokens.add(strTokens.nextToken());
			}
		}
		
		Iterator<CustomerInfo> iteCustomers = lstCustomers.iterator();
		while(iteCustomers.hasNext()) {
			
			CustomerInfo c = iteCustomers.next();
			
			if ( !BaseValidator.isNullOrBlank(strNames))
				if ( c.getTitle().indexOf(strNames) == -1)
					iteCustomers.remove();
			
			if ( strTokens != null) {
				List<CustomerServices> lstServices = c.getServices();
				boolean provideService = false;
				for(String str : lstTokens) {
					for(CustomerServices s : lstServices) {
						if(s.getServiceName().indexOf(str) != -1) {
							//this customer does provide this service , move to next
							provideService = true;
						}
					}
				if ( !provideService )
					iteCustomers.remove();
				}
				
			}
			
			if (!BaseValidator.isNullOrBlank(strPlaces)) {
				if(c.getAddress().getCity().indexOf(strPlaces) == -1)
					iteCustomers.remove();
			}
			
		}
		log.info("Filtered Customer List : " + lstCustomers);
		return lstCustomers;
	}
	@Override
	public List<CustomerInfo> getAll() {

		ResultSet rSet = null;
		Statement stmt = null;
		log.info("Searching all customer info records from database");
		try {
			stmt = getConnection().createStatement();
			log.debug("Customer Info Get All Query is  : " + SELECT_ALL_CUSTOMERINFO);
			rSet = stmt.executeQuery(SELECT_ALL_CUSTOMERINFO);
			List<CustomerInfo> lstRecords = new ArrayList<CustomerInfo>();
			if(rSet.next()) {
				do{
					CustomerInfo obj = new CustomerInfo();
					obj.setCustomerId(rSet.getString(CUSTOMER_ID_COL));
					obj.setImageName(rSet.getString(IMG_NAME_COL));
					obj.setDowns(rSet.getInt(DOWNRATING_COL));
					obj.setUps(rSet.getInt(UPRATING_COL));
					obj.setEmail(rSet.getString(EMAIL_COL));
					obj.setTitle(rSet.getString(CUSTOMER_TITLE_COL));
					obj.setAddress(new CustomerAddressDAOImpl().getByCustomerId(obj.getCustomerId()));
					obj.setServices(new CustomerServiceDAOImpl().getByCustomerId(obj.getCustomerId()));
					
					lstRecords.add(obj);
					
				}while(rSet.next());
				log.debug("Customer Info List from DB :" + lstRecords);
				return lstRecords;
				
			} else {
				log.debug("No Record Found while searching customer info!" );
			}

		} catch (SQLException e) {
			log.error("Error while trying to fetch the data for Customer Info Records.");
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
