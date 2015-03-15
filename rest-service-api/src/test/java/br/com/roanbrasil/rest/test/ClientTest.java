package br.com.roanbrasil.rest.test;

import static org.junit.Assert.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Assert;
import org.junit.Test;

import br.com.roanbrasil.rest.model.Product;
import br.com.roanbrasil.rest.model.ShoppingCart;

import com.thoughtworks.xstream.XStream;

/**
 * Client Test the funcions on ShoppingCartResource to URI
 * 
 * @author roanbrasil
 * @version 1.0
 * @since 2015-03-14
 *
 */
public class ClientTest {

	private Client client;

	@Test
	public void testConnectionToServer() {

		this.client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		String content = target
				.path("/rest-service-api/resources/shoppingcart/search/1")
				.request().get(String.class);
		ShoppingCart shoppingCart = (ShoppingCart) new XStream()
				.fromXML(content);
		Assert.assertEquals("1991 De Vaca Way", shoppingCart.getStreet());
	}

	/**
	 * Testing add product in a new Shopping Cart
	 */
	@Test
	public void testAddProductsInShoppingCart() {

		this.client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");

		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.add(new Product(3, "Cellphone", 450, 1));
		shoppingCart.setStreet("1259 Las Vegas Boulevard");
		shoppingCart.setCity("Las Vegas");
		String xml = shoppingCart.toXML();
		Entity<String> entity = Entity.entity(xml, MediaType.APPLICATION_XML);

		Response response = target
				.path("/rest-service-api/resources/shoppingcart").request()
				.post(entity);

		assertEquals(201, response.getStatus());
	}
}
