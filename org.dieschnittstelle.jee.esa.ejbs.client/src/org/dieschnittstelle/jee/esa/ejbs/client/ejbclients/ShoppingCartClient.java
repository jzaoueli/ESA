package org.dieschnittstelle.jee.esa.ejbs.client.ejbclients;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.dieschnittstelle.jee.esa.crm.ejbs.ShoppingCartRemote;
import org.dieschnittstelle.jee.esa.crm.entities.CrmProductBundle;
import org.dieschnittstelle.jee.esa.ejbs.client.Constants;

public class ShoppingCartClient implements ShoppingCartRemote {

	private ShoppingCartRemote proxy;

	public ShoppingCartClient() throws Exception {
		Context context = new InitialContext();
		this.proxy = (ShoppingCartRemote) context
				.lookup(Constants.SHOPPING_CART_BEAN);
	}

	@Override
	public void addProductBundle(CrmProductBundle product) {
		proxy.addProductBundle(product);
	}

	@Override
	public List<CrmProductBundle> getProductBundles() {
		return proxy.getProductBundles();
	}

}
