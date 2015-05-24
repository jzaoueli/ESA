package org.dieschnittstelle.jee.esa.ejbs.client.demos;

import org.dieschnittstelle.jee.esa.ejbs.client.TotalUsecase;

public class CreateTouchpoints {

	public static void main(String[] args) {
		try {
			TotalUsecase uc = new TotalUsecase();
			uc.createTouchpoints();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
