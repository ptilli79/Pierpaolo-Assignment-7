package com.coderscampus.assignment7;
import java.util.Random;

//import java.util.ArrayList;
//import java.util.List;


public class CustomArrayListApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		//Create CustomList Type variable
		CustomList<String> customArray = new CustomArrayList<String>();
		Random random = new Random();
	
		System.out.println("Initial array size: " + customArray.getSize());

		
		//The for loop will add items  to customArray as desired
		Integer i;
		for(i =0; i<11;i++){
            customArray.add(String.valueOf(i));
        }
		//Print out the resulting customArray
		System.out.println("Resulting size when adding (without index) "+i+ " elements: "+ customArray.getSize());
		printArrayListToConsole(customArray);
		
		//Erase all items from the list, and then try to continue removing items from empty list
		for(i =0; i<10;i++){
			try {
            customArray.remove(random.nextInt(customArray.getSize()));
			}catch (IllegalArgumentException expected){
			}
			
			
        }
		
		System.out.println("Resulting size when removing "+i+" ramdom elements (by index): "+ customArray.getSize());
		printArrayListToConsole(customArray);
		
		//Add 10 ramdon items (by index) from customArray. If customArray.getSize()==0, first item will be added using add (T item);
		int aux;
		for(i =0; i<10;i++){
			if (customArray.getSize()==0) {
				customArray.add(0,String.valueOf("XXX"));
			}
			else {
			aux=random.nextInt(customArray.getSize());
			customArray.add(aux,String.valueOf(i+999));
			}
		}
		
		System.out.println("Resulting size when adding "+i+" ramdom elements (by index): "+ customArray.getSize());
		printArrayListToConsole(customArray);
	}
	
	//Print customArray
	private static void printArrayListToConsole(CustomList<String> customArray) {
		if (customArray.getSize()>0) {
			for(int i =0; i<customArray.getSize(); i++){
				System.out.println("Index " +i+" --> "+customArray.get(i));
			}
		} else {System.out.println("No items to show");}
		System.out.println("");
	}

}
	
