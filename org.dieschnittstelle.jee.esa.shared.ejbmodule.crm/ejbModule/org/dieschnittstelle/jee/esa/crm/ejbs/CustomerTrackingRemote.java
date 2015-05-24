package org.dieschnittstelle.jee.esa.crm.ejbs;

import java.util.List;

import javax.ejb.Remote;

import org.dieschnittstelle.jee.esa.crm.entities.CustomerTransaction;

@Remote
public interface CustomerTrackingRemote {

	public void createTransaction(CustomerTransaction transaction);

	public List<CustomerTransaction> readAllTransactions();

}
