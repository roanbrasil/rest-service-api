/**
 * 
 */
package br.com.roanbrasil.rest.model;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

/**
 * @author roanbrasil
 *
 */
public class BasicModel {
	
	public BasicModel(){
		super();
	}
	/**
	 * 
	 * @return String
	 */
	public String toXML() {
		return new XStream().toXML(this);
	}

	/**
	 * 
	 * @return String
	 */
	public String toJson() {
		return new Gson().toJson(this);
	}

}
