package org.dieschnittstelle.jee.esa.crm.ejbs;

import java.util.List;
import javax.ejb.Local;

import org.dieschnittstelle.jee.esa.crm.entities.CrmProductBundle;

@Local
public interface ShoppingCartLocal {

	public void addProductBundle(CrmProductBundle product);
	
	public List<CrmProductBundle> getProductBundles();

}
