package org.hms4j.example.jaxws.devis.service.impl;

import javax.jws.WebService;

import org.hms4j.example.jaxws.devis.DevisBean;
import org.hms4j.example.jaxws.devis.WebServiceResponse;
import org.hms4j.example.jaxws.devis.service.DevisService;

@WebService(endpointInterface = "org.hms4j.example.jaxws.devis.service.DevisService")
public class DevisServiceImpl implements DevisService {

	@Override
	public WebServiceResponse traiterDevis(DevisBean devisBean) {

		System.out.println("devisBean: " + devisBean);
		if (devisBean != null) {
			System.out.println("devisBean.codeClientFinal: " + devisBean.getCodeClientFinal());
		}

		return new WebServiceResponse();
	}

}
