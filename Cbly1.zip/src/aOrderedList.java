/**
* <The aOrderedList class manages the array of the cars and orders them.
* SIZEINCREMENTS is a constant of how much to increase the array when it needs to increase
* Comparable[] oList is a variable to represent the ordered list which is an array of the cars
* listSize is a variable that stores whatever the current size of the ordered list is
* numObjects is a variable that indicates the number of cars in the ordered list
* curr is the index of current element accessed via iterator methods>
*
* CSC 1351 Programming Project No <1>
* 
* Section <1>
*
* @author <Cameron Bly>
* @since <March 17th, 2024>
*
*/
import java.util.Arrays;

public class aOrderedList {
    private final int SIZEINCREMENTS = 20;
    private Comparable[] oList;
    private int listSize;
    private int numObjects;
    private int curr;

    /**
    * <initializes the variables
    * initializes numObjects to 0
    * sets listSize to SIZEINCREMENTS
    * sets oList array to the new comparable listSize
    * initializes curr to 0 >
    *
    * CSC 1351 Programming Project No <1>
    * 
    * Section <1>
    *
    * @author <Cameron Bly>
    * @since <March 17th, 2024>
    *
    */
    public aOrderedList() {
        this.numObjects = 0;
        this.listSize = SIZEINCREMENTS;
        this.oList = new Comparable[listSize];
        this.curr = 0;
    }

    /**
     * <adds a new car object to the array list in the correct position to maintain the sorted order and can increase the array size>
     *
     * CSC 1351 Programming Project No <1>
     * 
     * Section <1>
     *
     * @author <Cameron Bly>
     * @since <March 17th, 2024>
     *
     */
    public void add(Comparable newObject) {
        if (numObjects == listSize) {
            listSize += SIZEINCREMENTS;
            oList = Arrays.copyOf(oList, listSize);
        	}
        
        		int index = numObjects;
        		
        		while(index > 0 && newObject.compareTo(oList[index - 1]) < 0){
        			oList[index] = oList[index - 1];
        			index--;
        		}
        		
        			oList[index] = newObject;
        			numObjects++;
    }
        
    /**
     * <deletes car from the input file and tells user when a car in the input file cannot be found in the list >
     *
     * CSC 1351 Programming Project No <1>
     * 
     * Section <1>
     *
     * @author <Cameron Bly>
     * @since <March 17th, 2024>
     *
     */
    public void deleteCar(String make, int year) {
    	
    	for(int i = 0; i < numObjects; i++) {
    		Car currentCar = (Car) oList[i];
    		
    		if(currentCar.getMake().equals(make) && currentCar.getYear() == year) {
    			removeElementAtIndex(i);
    			return;
    		}
    	}
    	
    	System.out.println("Car with make: " + make + " and year: " + year +" not found.");
    }
    
    /**
     * <removes the car from specified position in the index when deleted and shifts the other elements to fill in the gap >
     *
     * CSC 1351 Programming Project No <1>
     * 
     * Section <1>
     *
     * @author <Cameron Bly>
     * @since <March 17th, 2024>
     *
     */
    private void removeElementAtIndex(int index) {
    	for (int i = index; i < numObjects - 1; i++) {
    		oList[i] = oList[i + 1];
    	}
    	oList[--numObjects] = null;
    }
    
    /**
     * <returns the number of cars in the list>
     *
     * CSC 1351 Programming Project No <1>
     * 
     * Section <1>
     *
     * @author <Cameron Bly>
     * @since <March 17th, 2024>
     *
     */
    public int size() {
        return numObjects;
    }
    
    /**
     * <returns the car at the specified position in the list>
     *
     * CSC 1351 Programming Project No <1>
     * 
     * Section <1>
     *
     * @author <Cameron Bly>
     * @since <March 17th, 2024>
     *
     */
 public Comparable get(int index) {
    	
            return oList[index];
    }
    
 /**
  * <returns true if the array is empty and false if it is not>
  *
  * CSC 1351 Programming Project No <1>
  * 
  * Section <1>
  *
  * @author <Cameron Bly>
  * @since <March 17th, 2024>
  *
  */
 public boolean isEmpty() {
 	return numObjects == 0;
 }

 /**
  * <removes the car at the specified position in the list and moves other cars to fill in the gap>
  *
  * CSC 1351 Programming Project No <1>
  * 
  * Section <1>
  *
  * @author <Cameron Bly>
  * @since <March 17th, 2024>
  *
  */
    public void remove(int index) {
    	
    	if(index >= 0 && index < numObjects) {
    		for (int i = index; i < numObjects - 1; i++) {
    			oList[i] = oList[i + 1];
    		}
    		numObjects--;
    	}
    }

    /**
     * <resets the parameters so that the 'next' car is the first car in the array>
     *
     * CSC 1351 Programming Project No <1>
     * 
     * Section <1>
     *
     * @author <Cameron Bly>
     * @since <March 17th, 2024>
     *
     */
    public void reset() {
        curr = 0;
    }

    /**
     * <returns the next car in the list and the next increments, allowing the user to be able to move through the list>
     *
     * CSC 1351 Programming Project No <1>
     * 
     * Section <1>
     *
     * @author <Cameron Bly>
     * @since <March 17th, 2024>
     *
     */
    public Comparable next() {
        if (curr < numObjects) {
        	return oList[curr++];
        }
        
        return null;
    }

    /**
     * <checks for more cars in the list and checking if the program can continue without going beyond the end of the list>
     *
     * CSC 1351 Programming Project No <1>
     * 
     * Section <1>
     *
     * @author <Cameron Bly>
     * @since <March 17th, 2024>
     *
     */
    public boolean hadNext() {
    	return curr < numObjects;
    }
}