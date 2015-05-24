package org.dieschnittstelle.jee.esa.ejbs.client.shopping;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.dieschnittstelle.jee.esa.crm.entities.AbstractTouchpoint;
import org.dieschnittstelle.jee.esa.crm.entities.Customer;
import org.dieschnittstelle.jee.esa.erp.entities.AbstractProduct;

public class ShoppingSessionFacadeClient implements ShoppingBusinessDelegate {

	protected static Logger logger = Logger
			.getLogger(ShoppingSessionFacadeClient.class);

	/*
	 * use the ShoppingSessionFacadeRemote interface
	 */

	@Override
	public void initialise() {
		/* create a jndi context */
		
		/* lookup the bean */
	}

	@Override
	public void setTouchpoint(AbstractTouchpoint touchpoint) {
	
	}

	@Override
	public void setCustomer(Customer customer) {
	
	}

	@Override
	public void addProduct(AbstractProduct product, int units) {
	
	}

	@Override
	public void purchase() {
	
	}

}
