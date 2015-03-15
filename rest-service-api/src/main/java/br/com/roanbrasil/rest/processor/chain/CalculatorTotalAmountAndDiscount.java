package br.com.roanbrasil.rest.processor.chain;

import br.com.roanbrasil.rest.model.PaymentTotalAmount;
import br.com.roanbrasil.rest.model.ShoppingCart;

/**
 * Implements the Design Pattern Chain of Responsability calculate of de
 * discount
 * 
 * @author roanbrasil
 *
 */
public class CalculatorTotalAmountAndDiscount {

	/**
	 * Calculate one of option of discount whether there is one
	 * @param shoppingCart
	 * @return double
	 */
	public PaymentTotalAmount calculateDiscountAmount(ShoppingCart shoppingCart) {
		Discount d1 = new DiscountForMoreThanTwoProducts();
		Discount d2 = new DiscountForMoreThanThousand();
		d1.setNextDiscount(d2);
		d2.setNextDiscount(new NoDiscount());

		return d1.discountCalculate(shoppingCart);
	}
}
