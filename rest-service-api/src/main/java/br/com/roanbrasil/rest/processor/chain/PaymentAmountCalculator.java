package br.com.roanbrasil.rest.processor.chain;

import br.com.roanbrasil.rest.model.PaymentTotalAmount;
import br.com.roanbrasil.rest.model.Product;
import br.com.roanbrasil.rest.model.ShoppingCart;

/**
 * 
 * @author roanbrasil
 *
 */
public class PaymentAmountCalculator {
	/**
	 * 
	 * @param shoppingCart
	 * @return PaymentTotalAmount
	 */
	public PaymentTotalAmount calculateQuantityAndTotalAmount(ShoppingCart shoppingCart){
		PaymentTotalAmount paymentTotalAmount = new PaymentTotalAmount();
		long quantityAmount = 0;
		double sum = 0;
		for (Product product : shoppingCart.getProducts()) {
			quantityAmount += product.getQuantity();
			sum += product.getPrice();
		}
		paymentTotalAmount.setTotalAmount(sum);
		paymentTotalAmount.setTotalQuantity(quantityAmount);
		
		return paymentTotalAmount;
	}

}
