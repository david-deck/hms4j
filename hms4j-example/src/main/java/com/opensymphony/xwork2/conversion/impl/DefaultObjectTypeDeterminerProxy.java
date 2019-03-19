package com.opensymphony.xwork2.conversion.impl;

import com.opensymphony.xwork2.conversion.ObjectTypeDeterminer;
import com.opensymphony.xwork2.inject.Inject;
import com.opensymphony.xwork2.util.reflection.ReflectionProvider;

/**
 * <p>Mantis 13485</p>
 * <p>Cette classe permet d'éviter l'erreur 'DefaultObjectTypeDeterminer is not an interface' qui se produit de façon aléatoire lors du démarrage des schedulers Web.<p>
 * <p>Elle doit être déclarée dans le fichier struts.properties :</p>
 * <p><b>struts.objectTypeDeterminer = com.opensymphony.xwork2.conversion.impl.DefaultObjectTypeDeterminerProxy<b></p>
 * @author david.deck
 *
 */
public class DefaultObjectTypeDeterminerProxy implements ObjectTypeDeterminer {

	private ObjectTypeDeterminer delegate;
	private ReflectionProvider reflectionProvider;
	private XWorkConverter xworkConverter;

	@Inject
	public void setReflectionProvider(ReflectionProvider reflectionProvider) {
		this.reflectionProvider = reflectionProvider;
	}

	@Inject
	public void setXworkConverter(XWorkConverter xworkConverter) {
		this.xworkConverter = xworkConverter;
	}

	ObjectTypeDeterminer delegate() {

		if (delegate == null) {

			delegate = new DefaultObjectTypeDeterminer(xworkConverter, reflectionProvider);
		}

		return delegate;
	}

	@Override
	public Class getKeyClass(Class parentClass, String property) {
		return delegate().getKeyClass(parentClass, property);
	}

	@Override
	public Class getElementClass(Class parentClass, String property, Object key) {
		return delegate().getElementClass(parentClass, property, key);
	}

	@Override
	public String getKeyProperty(Class parentClass, String property) {
		return delegate().getKeyProperty(parentClass, property);
	}

	@Override
	public boolean shouldCreateIfNew(Class parentClass, String property, Object target, String keyProperty,	boolean isIndexAccessed) {
		return delegate().shouldCreateIfNew(parentClass, property, target, keyProperty, isIndexAccessed);
	}

}
