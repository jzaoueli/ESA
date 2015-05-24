package esa.uebungen.add2.junit;

//TODO: you might need to replace these imports by imports of the generated web service classes in case the latter are placed in a different package
import java.util.ArrayList;
import java.util.List;

import org.dieschnittstelle.jee.esa.erp.ejbs.crud.AbstractProduct;
import org.dieschnittstelle.jee.esa.erp.ejbs.crud.IndividualisedProductItem;
import org.dieschnittstelle.jee.esa.erp.ejbs.crud.Campaign;
import org.dieschnittstelle.jee.esa.erp.ejbs.crud.ProductBundle;
import org.dieschnittstelle.jee.esa.erp.ejbs.crud.ProductType;

/**
 * lorem this class specifies a couple of entities for the domain objects that
 * are used by the client classes
 */
public class Constants {

	/*
	 * constants for the objects that are dealt with in the different accessors
	 * to the beans
	 */
	public static IndividualisedProductItem PRODUCT_1;

	public static IndividualisedProductItem PRODUCT_2;

	// instantiate the constants
	static {

		PRODUCT_1 = new IndividualisedProductItem();
		PRODUCT_1.setName("Schrippe");
		PRODUCT_1.setProductType(ProductType.ROLL);
		PRODUCT_1.setExpirationAfterStocked(720);

		PRODUCT_2 = new IndividualisedProductItem();
		PRODUCT_2.setName("Kirschplunder");
		PRODUCT_2.setProductType(ProductType.PASTRY);
		PRODUCT_2.setExpirationAfterStocked(1080);
	}

	// this method resets all ids that might have been assigned to the objects
	// referred to the constants after successful server-side creation
	// note that in order for this to work, ids must have int type and must not
	// be defaulted to any value different from 0 (e.g. -1)
	public static void resetEntities() {
		PRODUCT_1.setId(0);
		PRODUCT_2.setId(0);
	}

}
