package br.com.roanbrasil.rest;

import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * 
 * @author roanbrasil
 *
 */
public class Server {

	private static HttpServer server;

	/**
	 * 
	 * @return HttpServer
	 */
	public static HttpServer initializeServer() {
		ResourceConfig config = new ResourceConfig()
				.packages("br.com.roanbrasil.rest");
		URI uri = URI.create("http://localhost:8080");
		server = GrizzlyHttpServerFactory.createHttpServer(uri, config);

		return server;
	}
}
