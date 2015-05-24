package org.dieschnittstelle.jee.esa.ejbs.client.demos;

import static org.dieschnittstelle.jee.esa.ejbs.client.Constants.PRODUCT_1;
import static org.dieschnittstelle.jee.esa.ejbs.client.Constants.PRODUCT_2;
import static org.dieschnittstelle.jee.esa.ejbs.client.Constants.TOUCHPOINT_1;
import static org.dieschnittstelle.jee.esa.ejbs.client.Constants.TOUCHPOINT_2;

import org.apache.log4j.Logger;
import org.dieschnittstelle.jee.esa.shared.lib.Util;
import org.dieschnittstelle.jee.esa.ejbs.client.ejbclients.ProductCRUDClient;
import org.dieschnittstelle.jee.esa.ejbs.client.ejbclients.StockSystemClient;
import org.dieschnittstelle.jee.esa.ejbs.client.ejbclients.TouchpointAccessClient;

public class ShowStockSystem {

	protected static Logger logger = Logger.getLogger(ShowStockSystem.class);

	public static void main(String[] args) {
		try {
			(new ShowStockSystem()).runAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// declare the attributes that will be instantiated with the ejb clients
	private ProductCRUDClient productCRUD;
	private StockSystemClient stockSystemClient;
	private TouchpointAccessClient touchpointCRUD;
	
	public ShowStockSystem() throws Exception {
		instantiateClients();
	}
	
	public void runAll() {

		try {
			createProducts();
			createTouchpoints();
			createStock();
			showStock();
		} catch (Exception e) {
			logger.error("got exception: " + e, e);
		}
	}

	private void showStock() {
		show("poss for prod1: " + stockSystemClient.getPointsOfSale(PRODUCT_1));
		show("poss for prod2: " + stockSystemClient.getPointsOfSale(PRODUCT_2));
		show("total units prod1: " + stockSystemClient.getTotalUnitsOnStock(PRODUCT_1));
		show("total units prod2: " + stockSystemClient.getTotalUnitsOnStock(PRODUCT_2));
	}

	public void instantiateClients() throws Exception {
		// instantiate the clients
		productCRUD = new ProductCRUDClient();
		stockSystemClient = new StockSystemClient();
		touchpointCRUD = new TouchpointAccessClient();
		
		System.out.println("\n***************** instantiated clients\n");
	}

	public void createProducts() {
		// create products
		productCRUD.createProduct(PRODUCT_1);
		Util.step();
		productCRUD.createProduct(PRODUCT_2);
		//productCRUD.createProduct(CAMPAIGN_1);
		//productCRUD.createProduct(CAMPAIGN_2);
		
		show("created products: " + PRODUCT_1 + ", " + PRODUCT_2);
		show("all products: " + productCRUD.readAllProducts());
		
		Util.step();

		System.out.println("\n***************** created products\n");
	}

	public void createTouchpoints() {
		// create touchpoints
		touchpointCRUD.createTouchpoint(TOUCHPOINT_1);
		touchpointCRUD.createTouchpoint(TOUCHPOINT_2);

		System.out.println("\n***************** created touchpoints\n");
	}
	
	public void createStock() {
		// create stock
		stockSystemClient.addToStock(PRODUCT_1,
				TOUCHPOINT_1.getErpPointOfSaleId(), 100);
		stockSystemClient.addToStock(PRODUCT_1,
				TOUCHPOINT_2.getErpPointOfSaleId(), 90);
		stockSystemClient.addToStock(PRODUCT_2,
				TOUCHPOINT_1.getErpPointOfSaleId(), 80);
//		stockSystemClient.addToStock(PRODUCT_2,
//				TOUCHPOINT_2.getErpPointOfSaleId(), 100);

		System.out.println("\n***************** created stock\n");
	}

	public static void show(Object content) {
		System.err.println(content + "\n");
	}

}
