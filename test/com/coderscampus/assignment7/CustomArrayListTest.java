package com.coderscampus.assignment7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomArrayListTest {
	// Test-Driven Development Methodology
	// Step 1 - Write a failing test
	// Step 2 - Write the business logic to make the test pass  
	// Step 3 - Refactor your code

	@Test
	void should_add_100_items_to_list () {
		// Arrange
		CustomList<Integer> sut = new CustomArrayList<>();
		
		// Act
		for (int i=1; i<=100; i++) {
			sut.add(i);
		}
		
		// Assert
		for (int i=0; i<99; i++) {
			assertEquals(i+1, sut.get(i));
		}
		assertEquals(100, sut.getSize());
	}
	
	@Test
	void should_remove_one_item_from_list_based_on_index () {
		// Arrange
		CustomList<Integer> sut = new CustomArrayList<>();
		
		// Act
		for (int i=1; i<=10; i++) {
			sut.add(i);
		}
		int initialSize = sut.getSize();
		sut.remove(8);
		
		
		// Assert
		assertEquals(1, initialSize-sut.getSize());

	}
	
	@Test
	void should_return_index_out_of_bounds_when_removing_by_wrong_idex () {
		// Arrange
		CustomList<Integer> sut = new CustomArrayList<>();
		String tmp=null;
		int initialSize=sut.getSize();
		
		// Act
		//Remove item out of index
	    try {
	    	sut.remove(-1);
	    } catch (IndexOutOfBoundsException expected) {
	        // just ignore it and let the test pass
	    	//throw new IndexOutOfBoundsException();
	    	tmp="Index out of bounds.";
	    }
		
		// Assert
	    assertEquals(0, sut.getSize()-initialSize);
	    assertEquals("Index out of bounds.", tmp);

	}
	
	@Test
	void should_return_index_out_of_bounds_when_removing_any_item_from_empty_list () {
		// Arrange
		CustomList<Integer> sut = new CustomArrayList<>();
		String tmp=null;
		
		// Act
		
		//Remove item out of index
		try {
		sut.remove(0);
		}catch (IndexOutOfBoundsException expected) {
			tmp="Index out of bounds.";
			
		}	
		
		// Assert
		assertEquals("Index out of bounds.", tmp);
		assertEquals(0, sut.getSize());
	}
	
	@Test
	void should_return_index_out_of_bounds_when_adding_item_by_invalid_index () {
		// Arrange
		CustomList<Integer> sut = new CustomArrayList<>();
		String tmp=null;
		
		// Act
		for (int i=0; i<10; i++) {
			sut.add(i);
		}
		
		int initialSize = sut.getSize();
		
		try {
			sut.add(10,999);
		}catch (IndexOutOfBoundsException expected) {
			tmp="Index out of bounds.";	
		}
		
		// Assert
		assertEquals(0, sut.getSize()-initialSize);
		assertEquals("Index out of bounds.", tmp);
	}
	
	
	@Test
	void should_return_index_out_of_bounds_when_getting_by_invalid_index () {
		// Arrange
		CustomList<Integer> sut = new CustomArrayList<>();
		String tmp1=null;
		String tmp2=null;
		
		// Act
		for (int i=0; i<10; i++) {
			sut.add(i);
		}
		
		try {
			sut.get(10);
		}catch (IndexOutOfBoundsException expected) {
			tmp1="Index out of bounds.";	
		}
		
		try {
			sut.get(-1);
		}catch (IndexOutOfBoundsException expected) {
			tmp2="Index out of bounds.";	
		}
		
		// Assert
		assertEquals("Index out of bounds.", tmp1);
		assertEquals("Index out of bounds.", tmp2);
	}
	
	@Test
	void should_add_one_item_by_index_to_an_ampty_list () {
		// Arrange
		CustomList<Integer> sut = new CustomArrayList<>();
		
		//Act
		sut.add(0,999);
		
		//Assert
		assertEquals(999, sut.get(0));
		assertEquals(1, sut.getSize());
	}
	
	@Test
	void should_add_one_item_based_on_index_at_the_last_position_available () {
		// Arrange
		CustomList<Integer> sut = new CustomArrayList<>();
		
		// Act
		for (int i=1; i<=10; i++) {
			sut.add(i);
		}

		int initialSize = sut.getSize();
		
		sut.add(9,999);
	
		// Assert
		assertEquals(999, sut.get(9));
		assertEquals(1, sut.getSize()-initialSize);
		assertEquals(10, sut.get(sut.getSize()-1));
	}
	
	
	

}
