package com.saloonsuite.dao;

import static com.saloonsuite.dao.connection.ConnectionFactory.getConnection;
import static com.saloonsuite.util.ServicesConstants.SELECT_ALL_SERVICES;
import static com.saloonsuite.util.ServicesConstants.SERVICE_ID_COL;
import static com.saloonsuite.util.ServicesConstants.SERVICE_NAME_COL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.saloonsuite.data.entity.DataObject;
import com.saloonsuite.data.entity.Services;

public class ServicesDAOImpl extends AbstractDAO implements SerivcesDAO{
	Logger log = Logger.getLogger(ServicesDAOImpl.class);
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
	public List<Services> getAll() {


		Statement stmt = null;
		ResultSet rSet = null;
		log.info("Searching all services from database");
		try {
			log.debug("Service Get All Query is  : " + SELECT_ALL_SERVICES);
			stmt = getConnection().createStatement();
			rSet = stmt.executeQuery(SELECT_ALL_SERVICES);
			List<Services> lstRecords = new ArrayList<Services>();
			if(rSet.next()) {
				do{
					Services obj = new Services(rSet.getString(SERVICE_ID_COL),rSet.getString(SERVICE_NAME_COL));
					lstRecords.add(obj);
				}while(rSet.next());
				
				log.debug("Service List from DB :" + lstRecords);
				return lstRecords;
				
			} else {
				log.debug("No Record Found while searching services!" );
			}

		} catch (SQLException e) {
			log.error("Error while trying to fetch the data for Service Info Records.");
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
