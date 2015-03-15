/**
 * 
 */
package br.com.roanbrasil.rest.processor.chain;

import br.com.roanbrasil.rest.model.PaymentTotalAmount;
import br.com.roanbrasil.rest.model.ShoppingCart;

/**
 * @author roanbrasil
 *
 */
public class NoDiscount implements Discount {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.roanbrasil.rest.processor.chain.Discount#discountCalculate(br.
	 * com.roanbrasil.rest.model.ShoppingCart)
	 */
	@Override
	public PaymentTotalAmount discountCalculate(ShoppingCart shoppingCart) {
		// no discount amount to calculate
		PaymentTotalAmount paymentTotalAmount = new PaymentTotalAmount();
		paymentTotalAmount.setDiscountAmount(0.0);
		return paymentTotalAmount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.roanbrasil.rest.processor.chain.Discount#setNextDiscount(br.com
	 * .roanbrasil.rest.processor.chain.Discount)
	 */
	@Override
	public void setNextDiscount(Discount nextDiscount) {
		//no Next and no Discount for this option
	}

}
