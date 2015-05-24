package org.dieschnittstelle.jee.esa.crm.ejbs;

import java.util.List;

import javax.ejb.Local;

import org.dieschnittstelle.jee.esa.crm.entities.AbstractTouchpoint;

@Local
public interface TouchpointAccessLocal {

	public AbstractTouchpoint createTouchpoint(AbstractTouchpoint touchpoint);

	public List<AbstractTouchpoint> readAllTouchpoints();
	
}
