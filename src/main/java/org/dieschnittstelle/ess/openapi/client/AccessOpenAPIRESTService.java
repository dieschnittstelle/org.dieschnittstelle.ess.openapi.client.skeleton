package org.dieschnittstelle.ess.openapi.client;

// TODO: entfernen Sie die auskommentierten Codezeilen. Falls Ihre imports automatisch aktualisiert
//  werden, dann entfernen Sie erst die Kommentare aus der Implementierung der Klasse und kommentieren
//  Sie die imports erst danach ein.

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.logging.log4j.Logger;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.dieschnittstelle.ess.openapi.client.api.DefaultApi;

import java.util.ArrayList;
import java.util.List;

public class AccessOpenAPIRESTService {

	protected static Logger logger = org.apache.logging.log4j.LogManager
			.getLogger(AccessOpenAPIRESTService.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// create the service proxy, using a jackson provider instance that is configured not
		// to fail on unknown properties (most importantly, the @class property)
		JacksonJsonProvider provider = new JacksonJsonProvider();
		provider.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);

		List providers = new ArrayList();
		providers.add(provider);

		// TODO: provide the url for the api
		DefaultApi serviceProxy = JAXRSClientFactory.create("url-of-api-to-be-accessed", DefaultApi.class, providers);
		
		// TODO: access the api using the proxy object
	}

	public static String toSinglelineString(Object obj) {
		String trimmed = String.valueOf(obj).replaceAll("\n","");
		while (trimmed.indexOf("  ") != -1) {
			trimmed = trimmed.replaceAll("  "," ");
		}
		return trimmed;
	}

}
