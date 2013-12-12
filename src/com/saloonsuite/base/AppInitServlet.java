package com.saloonsuite.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

public class AppInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("Log4JInitServlet is initializing log4j");
		String log4jLocation = config.getInitParameter("log4j-properties-location");

		ServletContext sc = config.getServletContext();

		if (log4jLocation == null) {
			System.err.println("*** No log4j-properties-location init param, so initializing log4j with BasicConfigurator");
			BasicConfigurator.configure();
		} else {
			String webAppPath = sc.getRealPath("/");
			String log4jProp = webAppPath + log4jLocation;
			File yoMamaYesThisSaysYoMama = new File(log4jProp);
			if (yoMamaYesThisSaysYoMama.exists()) {
				System.out.println("Initializing log4j with: " + log4jProp);
				PropertyConfigurator.configure(log4jProp);
			} else {
				System.err.println("*** " + log4jProp + " file not found, so initializing log4j with BasicConfigurator");
				BasicConfigurator.configure();
			}
		}
		
		try {
			String dbProperties = config.getInitParameter("db-properties-location");
			File f = new File(sc.getRealPath("/")+dbProperties);
			if (f.exists()) {
				System.out.println("Initializing App properties with: " + f);
				AppProperties.getProperties().load(new FileInputStream(f));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("Could not find configuration bundle for initializing application. Startup aborted.");
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Error while loading configuration bundle for initializing application. Startup aborted.");
			System.exit(0);
		}
		
		super.init(config);
	}
}
