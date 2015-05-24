package org.dieschnittstelle.jee.esa.basics;


import java.lang.reflect.Modifier;
import java.lang.reflect.Field;

import org.dieschnittstelle.jee.esa.basics.annotations.AnnotatedStockItemBuilder;
import org.dieschnittstelle.jee.esa.basics.annotations.StockItemProxyImpl;

import static org.dieschnittstelle.jee.esa.shared.lib.Util.*;

//import com.sun.org.apache.bcel.internal.classfile.Field;


public class ShowAnnotations {

	public static void main(String[] args) {
		// we initialise the collection
		StockItemCollection collection = new StockItemCollection(
				"stockitems_annotations.xml", new AnnotatedStockItemBuilder());
		// we load the contents into the collection
		collection.load();

		for (IStockItem consumable : collection.getStockItems()) {
			
			showAttributes(((StockItemProxyImpl)consumable).getProxiedObject());
		}

		// we initialise a consumer
		Consumer consumer = new Consumer();
		// ... and let them consume
		consumer.doShopping(collection.getStockItems());
	}

	/*
	 * UE BAS2 
	 */
	private static void showAttributes(Object consumable) {
		
		Class<?> klass = consumable.getClass();
			
		String myString = "{";
		
		//add name of the class
		
		myString += klass.getSimpleName();
		
		//add attributes of the object
		//iterate over the declared fileds of klass 

		for (Field field : klass.getDeclaredFields())
				{	Field myfild = field;
					myfild.setAccessible(true);
					Class<?> fieldType = myfild.getType();
					
					Object fieldValue = null;
					
					try {
							if (fieldType.equals(String.class)){
							
								fieldValue = myfild.get(consumable);
								myString += " " + field.getName() + ":" + fieldValue +" ";
							}
							else if (fieldType.equals(Integer.TYPE)){
								fieldValue = myfild.getInt(consumable);
								myString += " " + field.getName() + ":" + fieldValue;
								myString += ",";
							} 

					} catch (IllegalArgumentException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IllegalAccessException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					}
		
				myString += "}";
		
		System.err.println(myString);
		
//		+++++++++++++++++++++++++++++++++++++++++
//		Field field = Klass.getDeclaredFields();
//		show (field);
//		if(Modifier.isPrivate(field.getModifiers()));		
//		**System.err.println(Klass.getDeclaredMethods());**
//		+++++++++++++++++++++++++++++++++++++++++
		
	}

}
