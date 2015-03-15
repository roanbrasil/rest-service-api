package br.com.roanbrasil.rest.processor.chain;

import br.com.roanbrasil.rest.model.PaymentTotalAmount;
import br.com.roanbrasil.rest.model.ShoppingCart;

/**
 * Implements the Design Pattern Chain of Responsability interface Discount
 * 
 * @author roanbrasil
 *
 */
public class DiscountForMoreThanTwoProducts implements Discount {

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
		// if quantity is more than two itens of product get discount 30% off
		if (paymentTotalAmount.getTotalQuantity() >= 2) {
			paymentTotalAmount.setDiscountAmount(paymentTotalAmount
					.getTotalAmount() * 0.7);
			return paymentTotalAmount;
		}
		return nextDiscount.discountCalculate(shoppingCart);
	}

	public void setNextDiscount(Discount nextDiscount) {
		this.nextDiscount = nextDiscount;
	}

}
