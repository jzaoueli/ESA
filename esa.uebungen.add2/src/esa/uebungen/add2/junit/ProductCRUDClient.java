package esa.uebungen.add2.junit;

import java.util.List;


// TODO: you might need to replace these imports by imports of the generated web service classes in case the latter are placed in a different package
import org.dieschnittstelle.jee.esa.erp.ejbs.crud.ProductCRUDRemote;
import org.dieschnittstelle.jee.esa.erp.ejbs.crud.AbstractProduct;
import org.dieschnittstelle.jee.esa.erp.ejbs.crud.ProductCRUDStatelessService;

public class ProductCRUDClient implements ProductCRUDRemote {

	private ProductCRUDRemote proxy;

	public ProductCRUDClient() throws Exception {
		// TODO: instantiate the proxy using the generated web service classes
		proxy = null;
	}

	public AbstractProduct createProduct(AbstractProduct prod) {
		AbstractProduct created = proxy.createProduct(prod);
		// as a side-effect we set the id of the created product on the argument before returning
		prod.setId(created.getId());
		return created;
	}

	public List<AbstractProduct> readAllProducts() {
		return proxy.readAllProducts();
	}

	public AbstractProduct updateProduct(AbstractProduct update) {
		return proxy.updateProduct(update);
	}

	public AbstractProduct readProduct(int productID) {
		return proxy.readProduct(productID);
	}

	public boolean deleteProduct(int productID) {
		return proxy.deleteProduct(productID);
	}

}
