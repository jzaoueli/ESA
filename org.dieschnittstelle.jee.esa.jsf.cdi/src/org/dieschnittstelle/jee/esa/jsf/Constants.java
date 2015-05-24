package org.dieschnittstelle.jee.esa.jsf;

import org.dieschnittstelle.jee.esa.crm.entities.Address;
import org.dieschnittstelle.jee.esa.crm.entities.Customer;
import org.dieschnittstelle.jee.esa.crm.entities.Gender;
import org.dieschnittstelle.jee.esa.crm.entities.MobileTouchpoint;
import org.dieschnittstelle.jee.esa.crm.entities.StationaryTouchpoint;
import org.dieschnittstelle.jee.esa.erp.entities.Campaign;
import org.dieschnittstelle.jee.esa.erp.entities.IndividualisedProductItem;
import org.dieschnittstelle.jee.esa.erp.entities.ProductBundle;
import org.dieschnittstelle.jee.esa.erp.entities.ProductType;

/**
 * this class specifies a couple of entities for the domain objects that are used by the client classes
 */
public class Constants {
	
	/*
	 * the bean identifiers 
	 */
	public static final String SHOPPING_CART_BEAN = "ejb:org.dieschnittstelle.jee.esa.jsf/org.dieschnittstelle.jee.esa.jsf.ejbmodule/shoppingCart!org.dieschnittstelle.jee.esa.crm.ejbs.ShoppingCartRemote?stateful";
	public static final String CAMPAIGN_TRACKING_BEAN = "ejb:org.dieschnittstelle.jee.esa.jsf/org.dieschnittstelle.jee.esa.jsf.ejbmodule/CampaignTrackingSingleton!org.dieschnittstelle.jee.esa.crm.ejbs.CampaignTrackingRemote"; 
	public static final String CUSTOMER_TRACKING_BEAN = "ejb:org.dieschnittstelle.jee.esa.jsf/org.dieschnittstelle.jee.esa.jsf.ejbmodule/customerTrackingSystem!org.dieschnittstelle.jee.esa.crm.ejbs.CustomerTrackingRemote"; 
	public static final String CUSTOMER_CRUD_BEAN = "ejb:org.dieschnittstelle.jee.esa.jsf/org.dieschnittstelle.jee.esa.jsf.ejbmodule/CustomerCRUDStateless!org.dieschnittstelle.jee.esa.crm.ejbs.crud.CustomerCRUDRemote"; 
	public static final String TOUCHPOINT_CRUD_BEAN = "ejb:org.dieschnittstelle.jee.esa.jsf/org.dieschnittstelle.jee.esa.jsf.ejbmodule/TouchpointCRUDStateless!org.dieschnittstelle.jee.esa.crm.ejbs.crud.TouchpointCRUDRemote"; 
	public static final String TRANSACTIONS_CRUD_BEAN = "ejb:org.dieschnittstelle.jee.esa.jsf/org.dieschnittstelle.jee.esa.jsf.ejbmodule/CustomerTransactionCRUDStateless!org.dieschnittstelle.jee.esa.crm.ejbs.crud.CustomerTransactionCRUDRemote"; 
	public static final String POS_CRUD_BEAN = "ejb:org.dieschnittstelle.jee.esa.jsf/org.dieschnittstelle.jee.esa.jsf.ejbmodule/PointOfSaleCRUDStateless!org.dieschnittstelle.jee.esa.erp.ejbs.crud.PointOfSaleCRUDRemote"; 
	
	/*
	 * constants for the objects that are dealt with in the different accessors to the beans
	 */

	public static StationaryTouchpoint TOUCHPOINT_1;

	public static StationaryTouchpoint TOUCHPOINT_2;

	public static MobileTouchpoint TOUCHPOINT_3;

	public static IndividualisedProductItem PRODUCT_1;

	public static IndividualisedProductItem PRODUCT_2;
	
	public static Campaign CAMPAIGN_1;

	public static Campaign CAMPAIGN_2;
	
	public static Customer CUSTOMER_1;

	public static Customer CUSTOMER_2;
	
	// instantiate the constants
	static {
		
		Address addr1 = new Address("Luxemburger Strasse", "10", "13353", "Berlin");
		TOUCHPOINT_1 = new StationaryTouchpoint(-1, "BHT Mensa", addr1);
		
		Address addr2 = new Address("Leopoldplatz", "1", "13353", "Berlin");
		TOUCHPOINT_2 = new StationaryTouchpoint(-1, "U Leopoldplatz", addr2);
		
		TOUCHPOINT_3 = new MobileTouchpoint("01778896571");

		PRODUCT_1 = new IndividualisedProductItem("Schrippe",	ProductType.ROLL, 720);
		PRODUCT_1.setId(1);
		PRODUCT_1.setPrice(39);

		PRODUCT_2 = new IndividualisedProductItem("Kirschplunder",ProductType.PASTRY, 1080);
		PRODUCT_2.setId(2);
		PRODUCT_2.setPrice(109);

		CAMPAIGN_1 = new Campaign();
		CAMPAIGN_1.setId(3);
		CAMPAIGN_1.addBundle(new ProductBundle(PRODUCT_1, 5));
		
		CAMPAIGN_2 = new Campaign();
		CAMPAIGN_2.setId(4);
		CAMPAIGN_2.addBundle(new ProductBundle(PRODUCT_2, 2));

		CUSTOMER_1 = new Customer("Anna", "Musterfrau", Gender.W);
		CUSTOMER_1.setAddress(new Address("Kopernikusstrasse","11","10245","Berlin"));

		CUSTOMER_2 = new Customer("Benedikt", "Mustermann", Gender.M);
		CUSTOMER_2.setAddress(new Address("Corinthstrasse","44","10245","Berlin"));
	}
	
}
