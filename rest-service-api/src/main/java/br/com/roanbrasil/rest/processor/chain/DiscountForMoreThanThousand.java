/**
 * 
 */
package br.com.roanbrasil.rest.processor.chain;

import br.com.roanbrasil.rest.model.PaymentTotalAmount;
import br.com.roanbrasil.rest.model.ShoppingCart;

/**
 * Implements the Design Pattern Chain of Responsability interface Discount
 * 
 * @author roanbrasil
 *
 */
public class DiscountForMoreThanThousand implements Discount {

	private Discount nextDiscount;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.roanbrasil.rest.processor.chain.Discount#discountCalculate(br.
	 * com.roanbrasil.rest.model.ShoppingCart)
	 */
	@Override
	public PaymentTotalAmount discountCalculate(ShoppingCart shoppingCart) {
		
		PaymentAmountCalculator calculator = new PaymentAmountCalculator();
		PaymentTotalAmount paymentTotalAmount = calculator
				.calculateQuantityAndTotalAmount(shoppingCart);
		
		// if quantity is more than two itens of product get discount 10% off
		if (paymentTotalAmount.getTotalAmount() >= 1000) {
			paymentTotalAmount.setDiscountAmount(paymentTotalAmount
					.getTotalAmount() * 0.90);
			return paymentTotalAmount;
		}
		return nextDiscount.discountCalculate(shoppingCart);
	}

	public void setNextDiscount(Discount nextDiscount) {
		this.nextDiscount = nextDiscount;
	}

}
