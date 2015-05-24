package org.dieschnittstelle.jee.esa.jsf.model;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.dieschnittstelle.jee.esa.crm.ejbs.ShoppingCartLocal;
import org.dieschnittstelle.jee.esa.crm.ejbs.ShoppingCartRemote;
import org.dieschnittstelle.jee.esa.crm.entities.CrmProductBundle;
import org.jboss.logging.Logger;

/**
 * this class works as a presentation-side proxy of the shopping cart EJB business component
 * 
 * due to the usage of the local EJB interface, all changes of product bundles are immediately propagated to the ejb
 */
@ManagedBean(name = "shoppingCartModel")
@SessionScoped
public class ShoppingCartModel {
	
	protected static Logger logger = Logger.getLogger(ShoppingCartModel.class);

	/*
	 * show by-reference vs. by-value semantics of local vs. remote!
	 */
	@EJB(lookup="java:global/org.dieschnittstelle.jee.esa.ejbs/org.dieschnittstelle.jee.esa.shared.ejbmodule.crm/ShoppingCartStateful!org.dieschnittstelle.jee.esa.crm.ejbs.ShoppingCartLocal")
	private ShoppingCartLocal shoppingCart;
	
//	using the remote interface the call-by-value behaviour is very obvious...
//	@EJB(lookup="java:global/org.dieschnittstelle.jee.esa.ejbs/org.dieschnittstelle.jee.esa.shared.ejbmodule.crm/ShoppingCartStateful!org.dieschnittstelle.jee.esa.crm.ejbs.ShoppingCartRemote")
//	private ShoppingCartRemote shoppingCart;
	
	public List<CrmProductBundle> getProductBundles() {
		return shoppingCart.getProductBundles();
	}
	
	/**
	 * add a product
	 * 
	 * @param bundle
	 * @return
	 */
	public void addProduct(CrmProductBundle bundle) {
		logger.info("addProduct()");
		shoppingCart.addProductBundle(bundle);
	}
	
	/*
	 * additional methods for accessing information from the cart
	 */
	
	public int getNumOfProductsInCart() {
		logger.info("countProductsInCart()");
		int totalCount = 0;
		for (CrmProductBundle productBundle : shoppingCart.getProductBundles()) {
			totalCount += productBundle.getUnits();
		}

		return totalCount;
	}

	public int getPriceOfProductsInCart() {
		logger.info("countProductsInCart()");
		int totalPrice = 0;
		for (CrmProductBundle productBundle : shoppingCart.getProductBundles()) {
			totalPrice += productBundle.getUnits()
					* productBundle.getProductObj().getPrice();
		}

		return totalPrice;
	}

}
