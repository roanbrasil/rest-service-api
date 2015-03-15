package br.com.roanbrasil.rest.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import br.com.roanbrasil.rest.model.Product;
import br.com.roanbrasil.rest.model.ShoppingCart;

/**
 * 
 * @author roanbrasil
 * @version 1.0
 * @since 2015-03-14
 *
 */
public class ShoppingCartDAO {

	private static Map<Long, ShoppingCart> map = new HashMap<Long, ShoppingCart>();
	private static AtomicLong counter = new AtomicLong(1);

	/**
	 * Future implementation to use Persistence on database (thinking about MongoDB to my studies)
	 */
	static {
		Product videogame = new Product(1, "PS4", 4000, 1);
		Product sport = new Product(2, "Sport Game", 199, 3);
		ShoppingCart shoppingCart = new ShoppingCart().add(videogame)
				.add(sport).deliveryLocation("1991 De Vaca Way", "Livermore")
				.setId(1l);
		map.put(1l, shoppingCart);
	}

   /**
    * 
    * @param shoppingCart
    */
	public void add(ShoppingCart shoppingCart) {
		long id = counter.incrementAndGet();
		shoppingCart.setId(id);
		map.put(id, shoppingCart);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public ShoppingCart remove(long id) {
		return map.remove(id);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public ShoppingCart search(Long id) {
		return map.get(id);
	}
}
