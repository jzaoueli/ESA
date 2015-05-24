package org.dieschnittstelle.jee.esa.ejbs.client.ejbclients;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.dieschnittstelle.jee.esa.crm.ejbs.CampaignTrackingRemote;
import org.dieschnittstelle.jee.esa.crm.ejbs.CustomerTrackingRemote;
import org.dieschnittstelle.jee.esa.crm.entities.CustomerTransaction;
import org.dieschnittstelle.jee.esa.ejbs.client.Constants;

public class CustomerTrackingClient implements CustomerTrackingRemote {

	private CustomerTrackingRemote proxy;
	
	public CustomerTrackingClient() throws Exception {
		Context context = new InitialContext();
		proxy = (CustomerTrackingRemote) context
				.lookup(Constants.CUSTOMER_TRACKING_BEAN);
	}
	
	@Override
	public void createTransaction(CustomerTransaction transaction) {
		proxy.createTransaction(transaction);
	}

	@Override
	public List<CustomerTransaction> readAllTransactions() {
		return proxy.readAllTransactions();
	}

}
