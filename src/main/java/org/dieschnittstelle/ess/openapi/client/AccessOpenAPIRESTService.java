package org.dieschnittstelle.ess.openapi.client;

// TODO: entfernen Sie die auskommentierten Codezeilen. Falls Ihre imports automatisch aktualisiert
//  werden, dann entfernen Sie erst die Kommentare aus der Implementierung der Klasse und kommentieren
//  Sie die imports erst danach ein.

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.logging.log4j.Logger;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.dieschnittstelle.ess.openapi.client.api.DefaultApi;
import org.dieschnittstelle.ess.openapi.client.model.MyDataItemComposite;
import org.dieschnittstelle.ess.openapi.client.model.MyDataItemPart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
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

		// TODO: provide the url where your api is available
		DefaultApi serviceProxy = JAXRSClientFactory.create("http://localhost:7075/", DefaultApi.class, providers);
		
		// TODO: access the api using the proxy object. Note that for attributes with primitive types default values might need to be set

		// TODO: the following code is based on the sample api.yaml provided with the project. remove it with our own one.
		MyDataItemComposite composite = new MyDataItemComposite();
		composite.setId(0L);
		composite.setName("composite");
		MyDataItemPart part1 = new MyDataItemPart();
		part1.setName("part1");
		part1.setId(0L);
		MyDataItemPart part2 = new MyDataItemPart();
		part2.setName("part2");
		part2.setId(0L);
		composite.setParts(new HashSet<>(Arrays.asList(part1,part2)));

		System.out.println("created: " + toSinglelineString(serviceProxy.createMyDataItemComposite(composite)));
		System.out.println("read: " + toSinglelineString(serviceProxy.readAllMyDataItemComposites()));
	}

	public static String toSinglelineString(Object obj) {
		String trimmed = String.valueOf(obj).replaceAll("\n","");
		while (trimmed.indexOf("  ") != -1) {
			trimmed = trimmed.replaceAll("  "," ");
		}
		return trimmed;
	}

}
