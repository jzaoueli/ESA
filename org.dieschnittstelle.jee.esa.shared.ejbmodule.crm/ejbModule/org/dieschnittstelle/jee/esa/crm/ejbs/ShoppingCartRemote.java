package org.dieschnittstelle.jee.esa.crm.ejbs;

import java.util.List;

import org.dieschnittstelle.jee.esa.crm.entities.CrmProductBundle;

import javax.ejb.Remote;

@Remote
public interface ShoppingCartRemote {

	public void addProductBundle(CrmProductBundle product);
	
	public List<CrmProductBundle> getProductBundles();
	
}
