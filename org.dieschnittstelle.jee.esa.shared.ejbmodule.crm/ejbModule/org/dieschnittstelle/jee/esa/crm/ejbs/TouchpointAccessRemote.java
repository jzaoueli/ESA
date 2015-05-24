package org.dieschnittstelle.jee.esa.crm.ejbs;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
//import javax.ejb.Remote;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.dieschnittstelle.jee.esa.crm.entities.AbstractTouchpoint;

@Remote
@WebService
@Path("/touchpoints")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public interface TouchpointAccessRemote {

	@POST
	public AbstractTouchpoint createTouchpoint(AbstractTouchpoint touchpoint);

	@GET
	public List<AbstractTouchpoint> readAllTouchpoints();

}
