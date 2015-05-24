package org.dieschnittstelle.jee.esa.basics.annotations;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.dieschnittstelle.jee.esa.basics.IStockItem;

public class StockItemProxyImpl implements IStockItem {

	protected static Logger logger = Logger
			.getLogger(StockItemProxyImpl.class);

	private Object proxiedObject;

	/*
	 * the methods that are the targets for the interface methods
	 */
	private Method acquireMethod;
	private Method purchaseMethod;
	private Method getBrandnameMethod;
	private Method getUnitsMethod;

	/**
	 * in the constructor we set the object to be proxied and extract the target
	 * methods for each interface method from its class
	 * 
	 * @param proxiedObject
	 */
	public StockItemProxyImpl(Object proxiedObject) {
		this.proxiedObject = proxiedObject;

		try {
			// the following code is mainly taken from ConsumableInvocationHandler

			// for checking presence of annotations we can either use
			// isAnnotationPresent() or getAnnotation(), where the latter
			// requires checking non null on the return value
			for (Method m : proxiedObject.getClass().getDeclaredMethods()) {
				if (purchaseMethod == null
						&& m.isAnnotationPresent(Purchase.class)) {
					purchaseMethod = m;
				} else if (acquireMethod == null
						&& m.getAnnotation(Initialise.class) != null) {
					acquireMethod = m;
				} else if (getBrandnameMethod == null
						&& m.isAnnotationPresent(Brandname.class)) {
					getBrandnameMethod = m;
				} else if (getUnitsMethod == null
						&& m.isAnnotationPresent(Units.class)) {
					getUnitsMethod = m;
				}
			}

			// it might be possible that the @Units or @Brandname annotation is
			// declared on the attributes rather than on the methods, in this
			// case iterate over the fields
			if (getBrandnameMethod == null || getUnitsMethod == null) {
				for (Field f : proxiedObject.getClass().getDeclaredFields()) {
					/*
					 * if the annotation is declared on one of the fields, we
					 * require a conventionalised getter for that field -
					 * alternatively our mapping could distinguish between
					 * method invocations and field access (see the class
					 * ShowClasspathScan for how to read out the value of a
					 * field)
					 */
					if (getBrandnameMethod == null
							&& f.isAnnotationPresent(Brandname.class)) {
						getBrandnameMethod = proxiedObject.getClass()
								.getDeclaredMethod(
										"get"
												+ f.getName().substring(0, 1)
														.toUpperCase()
												+ f.getName().substring(1));
					} else if (getUnitsMethod == null
							&& f.isAnnotationPresent(Units.class)) {
						getUnitsMethod = proxiedObject.getClass()
								.getDeclaredMethod(
										"get"
												+ f.getName().substring(0, 1)
														.toUpperCase()
												+ f.getName().substring(1));
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	public Object getProxiedObject() {
		return proxiedObject;
	}

	public void setProxiedObject(Object proxiedObject) {
		this.proxiedObject = proxiedObject;
	}

	@Override
	public void initialise(int units, String brandname) {
		try {
			this.acquireMethod.invoke(this.proxiedObject, units, brandname);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	@Override
	public void purchase(int units) {
		try {
			this.purchaseMethod.invoke(this.proxiedObject,units);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	@Override
	public int getUnits() {
		try {
			return (Integer) this.getUnitsMethod.invoke(this.proxiedObject);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	@Override
	public String getBrandname() {
		try {
			return (String) this.getBrandnameMethod.invoke(this.proxiedObject);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}
	
	/*
	 * also handle toString and equals
	 */
	@Override
	public String toString() {
		return "{Proxy " + this.proxiedObject.toString() + "}";
	}
	
	@Override
	public boolean equals(Object other) {
		if (other.getClass() != this.getClass()) {
			return false;
		}
		Object otherProxiedObject = ((StockItemProxyImpl)other).getProxiedObject();
		
		return this.proxiedObject.equals(otherProxiedObject);
	}

}
