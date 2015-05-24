package org.dieschnittstelle.jee.esa.basics;

import org.w3c.dom.Element;

public interface IStockItemBuilder {

	public IStockItem buildStockItemFromElement(Element el);
	
}
