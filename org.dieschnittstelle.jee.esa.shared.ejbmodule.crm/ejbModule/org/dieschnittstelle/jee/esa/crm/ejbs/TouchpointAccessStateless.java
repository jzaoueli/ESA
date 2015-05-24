package org.dieschnittstelle.jee.esa.crm.ejbs;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.dieschnittstelle.jee.esa.crm.ejbs.crud.TouchpointCRUDLocal;
import org.dieschnittstelle.jee.esa.crm.entities.AbstractTouchpoint;
import org.dieschnittstelle.jee.esa.crm.entities.CrmProductBundle;
import org.dieschnittstelle.jee.esa.erp.ejbs.crud.PointOfSaleCRUDLocal;
import org.dieschnittstelle.jee.esa.erp.entities.PointOfSale;
import org.jboss.logging.Logger;

@Stateless
@WebService(targetNamespace = "http://dieschnittstelle.org/jee/esa/jaxws", serviceName = "TouchpointAccessWebService", endpointInterface = "org.dieschnittstelle.jee.esa.crm.ejbs.TouchpointAccessRemote")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public class TouchpointAccessStateless implements
		TouchpointAccessRemote, TouchpointAccessLocal {

	protected static Logger logger = Logger
			.getLogger(TouchpointAccessStateless.class);

	@EJB
	private TouchpointCRUDLocal touchpointCRUD;

	@EJB
	private PointOfSaleCRUDLocal posCRUD;

	@Override
	public AbstractTouchpoint createTouchpoint(
			AbstractTouchpoint touchpoint) {
		logger.info("createTouchpoint(): " + touchpoint);
		
		logProductBundleKlass();

		// we first create the posCRUD
		PointOfSale pos = posCRUD.createPointOfSale(new PointOfSale());
		logger.info("createTouchpoint(): created pointOfSale: "
				+ pos);

		// we pass the id to the touchpoint
		touchpoint.setErpPointOfSaleId(pos.getId());

		// then we persist the touchpoint
		touchpoint = touchpointCRUD.createTouchpoint(touchpoint);
		logger.info("createTouchpoint(): created touchpoint: "
				+ touchpoint);

		// return it
		return touchpoint;
	}
	
	// for testing class loading
	private void logProductBundleKlass() {
		StringBuffer log = new StringBuffer();
		log.append(CrmProductBundle.class + "\n");
		ClassLoader cl = CrmProductBundle.class.getClassLoader();
		do {
			log.append("\t"+ cl + "\n");
			cl = cl.getParent();
		}
		while (cl != null);
		
		logger.info("class loader hierarchy of CrmProductBundle is: \n" + log);	
	}

	@Override
	public List<AbstractTouchpoint> readAllTouchpoints() {
		return touchpointCRUD.readAllTouchpoints();
	}

}
