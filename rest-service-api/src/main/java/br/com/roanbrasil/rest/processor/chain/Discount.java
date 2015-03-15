package br.com.roanbrasil.rest.processor.chain;

import br.com.roanbrasil.rest.model.PaymentTotalAmount;
import br.com.roanbrasil.rest.model.ShoppingCart;

/**
 * Abstract class follow de Design Pattern Chain of Responsability,
 * because you can have to avoid to many If's cases to get next condition.
 * @author roanbrasil
 *
 */
public interface Discount {
	
	/**
	 * 
	 * @param shoppingCart
	 * @return double
	 */
	public abstract PaymentTotalAmount discountCalculate(ShoppingCart shoppingCart);
	
	public void setNextDiscount(Discount nextDiscount);
}
