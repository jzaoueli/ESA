package org.dieschnittstelle.jee.esa.entities;

import java.io.Serializable;

public interface GenericCRUDEntity extends Serializable {
	
	/*
	 * obtain an id
	 */
	public int getId();
	
	public void setId(int id);
	
}