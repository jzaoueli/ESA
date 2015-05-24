package org.dieschnittstelle.jee.esa.crm.ejbs;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.jboss.resteasy.logging.Logger;

@ApplicationPath("/rest")
public class CrmRESTApplication extends Application {

	protected static Logger logger = Logger.getLogger(CrmRESTApplication.class);
	
	public CrmRESTApplication() {
		logger.info("<constructor>");
	}
	
}
