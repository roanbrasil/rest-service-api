/**
 * 
 */
package br.com.roanbrasil.rest.resources;

import java.net.URI;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.roanbrasil.rest.dao.ShoppingCartDAO;
import br.com.roanbrasil.rest.model.Product;
import br.com.roanbrasil.rest.model.ShoppingCart;

import com.thoughtworks.xstream.XStream;

/**
 * @author roanbrasil
 *
 */
@Singleton
@Path("shoppingcart")
public class ShoppingCartResource {

	/**
	 * interface that search a shoppingCart by Id
	 * 
	 * @param id
	 * @return String - XML
	 */
	@GET
	@Path("search/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public String search(@PathParam("id") long id) {
		ShoppingCart shoppingCart = new ShoppingCartDAO().search(id);
		return shoppingCart.toXML();
	}

	/**
	 * Add Products in a new ShoppingCart
	 * 
	 * @param content
	 * @return Response
	 */
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response add(String content) {
		ShoppingCart shoppingCart = (ShoppingCart) new XStream()
				.fromXML(content);
		new ShoppingCartDAO().add(shoppingCart);

		URI uri = URI.create("/shoppingcart/search/" + shoppingCart.getId());
		return Response.created(uri).build();
	}

	/**
	 * Interface to remove product from a ShoppingCart List
	 * 
	 * @return String
	 */
	@Path("{id}/products/{productId}")
	@DELETE
	public Response removeProduct(@PathParam("id") long id,
			@PathParam("productId") long productId) {
		ShoppingCart shoppingCart = new ShoppingCartDAO().search(id);
		shoppingCart.remove(productId);
		return Response.ok().build();
	}

	/**
	 * s
	 * 
	 * @param id
	 * @param productId
	 * @return
	 */
	@Path("{id}/products/{productId}")
	@PUT
	public Response changeQuantity(String content, @PathParam("id") long id,
			@PathParam("productId") long productId) {
		ShoppingCart shoppingCart = new ShoppingCartDAO().search(id);
		Product product = (Product) new XStream().fromXML(content);
		shoppingCart.change(product);
		return Response.ok().build();
	}
}
