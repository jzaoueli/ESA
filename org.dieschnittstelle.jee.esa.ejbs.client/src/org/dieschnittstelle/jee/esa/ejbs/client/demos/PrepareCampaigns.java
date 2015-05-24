package org.dieschnittstelle.jee.esa.ejbs.client.demos;

import org.dieschnittstelle.jee.esa.ejbs.client.TotalUsecase;

public class PrepareCampaigns {

	public static void main(String[] args) {
		
		TotalUsecase uc;
		try {
			uc = new TotalUsecase();
			uc.prepareCampaigns();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
