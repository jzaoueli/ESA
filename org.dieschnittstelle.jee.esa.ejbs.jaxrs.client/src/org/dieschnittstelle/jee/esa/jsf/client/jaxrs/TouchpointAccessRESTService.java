package org.dieschnittstelle.jee.esa.jsf.client.jaxrs;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.dieschnittstelle.jee.esa.crm.entities.AbstractTouchpoint;

@Path("/touchpoints")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public interface TouchpointAccessRESTService {

	@POST
	public AbstractTouchpoint createNewTouchpoint(AbstractTouchpoint touchpoint);

	@GET
	public List<AbstractTouchpoint> getAllTouchpoints();

}
