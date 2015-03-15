/**
 * 
 */
package br.com.roanbrasil.rest.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import br.com.roanbrasil.rest.resources.GreetingResource;
import br.com.roanbrasil.rest.resources.ShoppingCartResource;

/**
 * @author roanbrasil
 *
 */
@ApplicationPath("resources")
public class ShoppingCartApplication extends  Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> rootResources = new HashSet<Class<?>>();
		rootResources.add(GreetingResource.class);
		rootResources.add(ShoppingCartResource.class);
		return rootResources;
	}
}
