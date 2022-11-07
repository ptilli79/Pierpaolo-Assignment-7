package com.coderscampus.assignment7;
@SuppressWarnings("unchecked")
public class CustomArrayList<T> implements CustomList<T> {
	//Object[] items = new Object[10];
		
    private Object[] customArray; // my custom array    
    private int nextIndex; // index which shall point to next index position where element is to be added
    private int initialSize; // initial size of the list
 
    /**
     * Constructor to initialize a custom array list
     */
    public CustomArrayList(){
        this.nextIndex = 0;
        this.initialSize = 10;
        this.customArray = new Object[initialSize];     
    }
	
    // helper method to grow the array dynamically
    /**
     * 
     * @return reference to a new array with increased size
     */
    private Object[] growArray() {
    	//As instructed by the assignment, the new generated array should be the double of the previous one when nextIndex >= customArray.length
    	initialSize=initialSize*2;
        Object [] copiedArray = new Object[initialSize];
        for (int i=0;i<customArray.length;i++){
            copiedArray[i]=customArray[i];          
        }
        customArray = copiedArray;
        return customArray;
    }
 
    /**
     * 
     * @param object - the element being added
     * @param list - reference to the list
     */
 
    // method to add elements to the end of Custom Array List
	@Override
	public boolean add(T item) {
		// TODO Auto-generated method stub
        if(nextIndex>=customArray.length){
            // call the growArray method to copy existing contents
            customArray=growArray(); 
        }
        customArray[nextIndex]=item;
        nextIndex++;
		return false;
	}
	
	@Override
	public boolean add(int index, T item) throws IndexOutOfBoundsException{
		// TODO Auto-generated method stub
		int count = 0;
		  for (Object obj : customArray) {
		    if ( obj != null ) count++;
		  }
	    if ((index < 0 || index >= this.customArray.length || index >= count) && index!=0) {
	        // FYI, this would be thrown anyway; not sure if you need to do it
	        throw new IndexOutOfBoundsException();
	    }
	    if(nextIndex>=customArray.length-1){
            // call the growArray method to copy existing contents
            customArray=growArray(); 
        }
	    Object[] temp = new Object[this.customArray.length];
	    int j;
	    for(int i = 0 ; i < this.customArray.length; i++){
	        if (i == index) {
	        	j=index;
	            while(j < this.customArray.length){
	            	temp[j] = this.customArray[j];	
	            	j++;
	            }
	            customArray[index]=item;
	            for(j=index+1 ; j < this.customArray.length; j++){
	            	this.customArray[j]=temp[j-1];
	            }  
	            nextIndex++;
	            break;
	        }
	    }
	    
	    return true;
	}
	
	
	
	// method to get the actual size of Custom Array List
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		//return customArray.length;
		int count = 0;
		  for (Object obj : customArray) {
		    if ( obj != null ) count++;
		  }
		  return count;
		
	}
	
	// method to get elements from Custom Array List
	@Override
	public T get(int index) throws IndexOutOfBoundsException{
		if (index < 0 || index >= this.customArray.length) {
	        // FYI, this would be thrown anyway; not sure if you need to do it
	        throw new IndexOutOfBoundsException();
	    }
		if (this.customArray.length<=0) return null;
		else {
		return (T)customArray[index];
		}
	}
	
	public T remove(int index) throws IndexOutOfBoundsException {
		int count = 0;
		  for (Object obj : customArray) {
		    if ( obj != null ) count++;
		  }
	    if (index < 0 || index >= this.customArray.length || index>=count) {
	        throw new IndexOutOfBoundsException();
	    }
	    Object removed = this.customArray[index];
	    Object[] temp = new Object[this.customArray.length];
	    for(int i = 0, j = 0; i < this.customArray.length; i++){
	        if (i != index) {
	            temp[j++] = this.customArray[i];
	        }
	    }
	    temp[(temp.length)-1]=null;
	    this.customArray = temp; 
		nextIndex--;
		// TODO Auto-generated method stub
		return (T)removed;
	}
	
	
}
