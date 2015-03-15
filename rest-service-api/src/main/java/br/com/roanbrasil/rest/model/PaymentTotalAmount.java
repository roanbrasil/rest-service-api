package br.com.roanbrasil.rest.model;

import java.text.DecimalFormat;

/**
 * 
 * @author roanbrasil
 *
 */
public class PaymentTotalAmount extends BasicModel {

	private double totalAmount;

	private double discountAmount;

	private long totalQuantity;

	/**
	 * @return the totalAmount
	 */
	public double getTotalAmount() {
		return totalAmount;
	}

	/**
	 * @param totalAmount
	 *            the totalAmount to set
	 */
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * @return the discountAmount
	 */
	public double getDiscountAmount() {
		return discountAmount;
	}

	/**
	 * @param discountAmount
	 *            the discountAmount to set
	 */
	public void setDiscountAmount(double discountAmount) {
		DecimalFormat df = new DecimalFormat("#.##");
		this.discountAmount = Double.parseDouble(df.format(discountAmount));
	}

	/**
	 * @return the totalQuantity
	 */
	public long getTotalQuantity() {
		return totalQuantity;
	}

	/**
	 * @param totalQuantity
	 *            the totalQuantity to set
	 */
	public void setTotalQuantity(long totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
}
