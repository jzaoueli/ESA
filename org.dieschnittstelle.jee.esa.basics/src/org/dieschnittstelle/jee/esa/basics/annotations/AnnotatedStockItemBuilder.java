package org.dieschnittstelle.jee.esa.basics.annotations;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.log4j.Logger;
import org.dieschnittstelle.jee.esa.basics.IStockItem;
import org.dieschnittstelle.jee.esa.basics.IStockItemBuilder;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class AnnotatedStockItemBuilder implements IStockItemBuilder {

	// the logger
	protected static Logger logger = Logger
			.getLogger(AnnotatedStockItemBuilder.class);

	private static XPath xpathEvaluator;

	static {
		XPathFactory factory = XPathFactory.newInstance();
		xpathEvaluator = factory.newXPath();
	}

	@Override
	public IStockItem buildStockItemFromElement(Element el) {
		try {

			/*
			 * this demonstrates a different way to access the nodes within an
			 * element
			 */
			// first we obtain the class name element using
			// getElementsByTagName()
			NodeList classnameEls = el.getElementsByTagName("class");
			// we read out the textual content from the element
			String classname = classnameEls.item(0).getTextContent();
			logger.debug("will create consumable of class: " + classname);

			// then we read out the name and units information elements from the
			// root element (using the Java XPath API)
			String brandname = xpathEvaluator.evaluate("./brandname/text()", el);
			String units = xpathEvaluator.evaluate("./units/text()", el);
			logger.debug("read out brandname and units from element: " + brandname + ", "
					+ units);

			// try to obtain the class given the classname and create an
			// instance of it
			Class<?> klass = Class.forName(classname);
			Object instance = klass.newInstance();

			logger.debug("created an instance of class "
					+ klass
					+ ": "
					+ instance
					+ ". Now create a wrapper that implements the IConsumable interface");

			IStockItem instanceProxy = createProxyForInstance(instance);

			logger.debug("created instance proxy: " + instanceProxy);

			// now try to invoke the acquire method on the proxy
			instanceProxy.initialise(Integer.parseInt(units),brandname);

			// and pass back the instance
			return instanceProxy;
		} catch (ClassNotFoundException e) {
			logger.error("got ClassNotFoundException: " + e, e);
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			logger.error("got InstantiationException: " + e, e);
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			logger.error("got IllegalAccessException: " + e, e);
			throw new RuntimeException(e);
		} catch (XPathExpressionException e) {
			logger.error("got XPathExpressionException: " + e, e);
			throw new RuntimeException(e);
		}

	}

	/**
	 * create a proxy that implements the IConsumable interface - here, we create a static proxy
	 * @param instance
	 * @return
	 */
	protected IStockItem createProxyForInstance(Object instance) {
		return new StockItemProxyImpl(instance);
	}
}
