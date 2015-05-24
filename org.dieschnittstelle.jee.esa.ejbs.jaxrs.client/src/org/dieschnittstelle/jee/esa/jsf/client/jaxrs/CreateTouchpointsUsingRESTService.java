package org.dieschnittstelle.jee.esa.jsf.client.jaxrs;

import org.apache.log4j.Logger;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.dieschnittstelle.jee.esa.crm.entities.Address;
import org.dieschnittstelle.jee.esa.crm.entities.StationaryTouchpoint;
import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.client.core.executors.ApacheHttpClient4Executor;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

public class CreateTouchpointsUsingRESTService {

	protected static Logger logger = Logger
			.getLogger(CreateTouchpointsUsingRESTService.class);

	public static void main(String[] args) {

		/*
		 * register jackson as reader and writer for json
		 */
		RegisterBuiltin.register(ResteasyProviderFactory.getInstance());
		// the MessageBodyReader must be added explicitly to the provider
		// factory. Here, we use the jackson implementation
		ResteasyProviderFactory.getInstance().addMessageBodyReader(
				JacksonJaxbJsonProvider.class);
		ResteasyProviderFactory.getInstance().addMessageBodyWriter(
				JacksonJaxbJsonProvider.class);

		/*
		 * create a client for the web service passing the interface
		 * 
		 * notice that our java interface is located in a different package and
		 * uses different names compared to the server-side jax-rs annotated
		 * interface, but generated the correct http requests to access the
		 * latter's methods.
		 * 
		 * due to the fact that the interfaces' method signatures use abstract
		 * classes, the classes of the objects being passed between client and
		 * service must be identically named on the client side. Note, however,
		 * that the transient attributes that are used on the server side are
		 * not declared on the client's classes
		 */
		TouchpointAccessRESTService serviceClient = ProxyFactory
				.create(TouchpointAccessRESTService.class,
						"http://localhost:8080/org.dieschnittstelle.jee.esa.ejbs.jaxrs/rest",
						new ApacheHttpClient4Executor());
		logger.info("created client: " + serviceClient);

		// create the touchpoint
		Address addr1 = new Address();
		addr1.setId(-1);
		addr1.setStreet("Muellerstrasse");
		addr1.setHouseNr("147");
		addr1.setZipCode("13353");
		addr1.setCity("Berlin");
		StationaryTouchpoint tp = new StationaryTouchpoint();
		tp.setId(-1);
		tp.setName("Rathaus Wedding");
		tp.setLocation(addr1);

		// invoke the creation method
		tp = (StationaryTouchpoint) serviceClient.createNewTouchpoint(tp);

		logger.info("created touchpoint: " + tp);

		// create the touchpoint
		Address addr2 = new Address();
		addr2.setId(-1);
		addr2.setStreet("Luxemburger Strasse");
		addr2.setHouseNr("10");
		addr2.setZipCode("13353");
		addr2.setCity("Berlin");
		StationaryTouchpoint tp2 = new StationaryTouchpoint();
		tp2.setId(-1);
		tp2.setName("BHT Mensa");
		tp2.setLocation(addr1);

		tp2 = (StationaryTouchpoint) serviceClient.createNewTouchpoint(tp2);

		logger.info("created touchpoint: " + tp2);
		
		System.err.println("CreateTouchpointsUsingRESTService: done.\n");
	}

}
