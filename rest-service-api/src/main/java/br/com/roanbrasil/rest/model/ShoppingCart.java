package br.com.roanbrasil.rest.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.roanbrasil.rest.dao.ShoppingCartDAO;
import br.com.roanbrasil.rest.processor.chain.CalculatorTotalAmountAndDiscount;

/**
 * This Shopping Cart Model, here you can add products, delivery in some
 * address...
 * 
 * @author roanbrasil
 * @version 1.0
 * @since 2015-03-14
 *
 */
public class ShoppingCart extends BasicModel{

	private List<Product> products = new ArrayList<>();
	private String street;
	private String neighbourhood;
	private String city;
	private long id;

	/**
	 * 
	 * @param product
	 * @return {@link ShoppingCart} - ShoppingCart
	 */
	public ShoppingCart add(Product product) {
		products.add(product);
		return this;
	}

	/**
	 * Set all the delivery Location
	 * 
	 * @param street
	 * @param city
	 * @return {@link ShoppingCart} - ShoppingCart
	 */
	public ShoppingCart deliveryLocation(String street, String city) {
		this.street = street;
		this.city = city;
		return this;
	}

	/**
	 * remove Product from ShoppingCart
	 * 
	 * @param id
	 */
	public void remove(long id) {
		for (Iterator<Product> iterator = products.iterator(); iterator
				.hasNext();) {
			Product product = iterator.next();
			// remove if the product has the same id
			if (product.getId() == id) {
				iterator.remove();
			}
		}
	}

	/**
	 * Change a Product for Another one
	 * 
	 * @param product
	 */
	public void change(Product product) {
		remove(product.getId());
		add(product);
	}

	/**
	 * Change a number of Products in Shopping Cart
	 * 
	 * @param product
	 */
	public void changeNumberOfProducts(Product product) {
		for (Iterator<Product> iterator = products.iterator(); iterator
				.hasNext();) {
			Product p = iterator.next();
			// if the product id are the same the quantity should be as well
			if (p.getId() == product.getId()) {
				p.setQuantity(product.getQuantity());
				return;
			}
		}
	}

	/**
	 * 
	 * @param id
	 * @return double
	 */
	public PaymentTotalAmount getTotalAmountAndDiscount(long id) {
		ShoppingCart shoppingCart = new ShoppingCartDAO().search(id);
		CalculatorTotalAmountAndDiscount calculator = new CalculatorTotalAmountAndDiscount();
		PaymentTotalAmount paymentTotalAmount = calculator
				.calculateDiscountAmount(shoppingCart);

		return paymentTotalAmount;

	}

	/**
	 * 
	 * @return List<Product>
	 */
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * 
	 * @param products
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	/**
	 * 
	 * @return String
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * 
	 * @param street
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the neighbourhood
	 */
	public String getNeighbourhood() {
		return neighbourhood;
	}

	/**
	 * @param neighbourhood
	 *            the neighbourhood to set
	 */
	public void setNeighbourhood(String neighbourhood) {
		this.neighbourhood = neighbourhood;
	}

	/**
	 * 
	 * @return String
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 
	 * @return long
	 */
	public long getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	public ShoppingCart setId(long id) {
		this.id = id;
		return this;
	}
}
