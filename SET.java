import java.util.NoSuchElementException;

/**
 * This class represents a simple set implementation with multipule functions.
 * 
 * @author Evan Phillips
 * @version 1.0
 * @since 2/6/24
 */

/**.
 * A simple set implementation
 *
 * @param <T> The type of elements in the set.
 */
public class SET<T> {
	
	private Object[] set;
	private int size = 0;
   private static final int MAX_SIZE = 10000;
	
	/**
	 * Constructs an empty set.
	 */
	public SET() {
		this.set = new Object[0];
	}
	
	/**
	 * Performs the union operation with another set.
	 *
    * Note: This method uses the unchecked cast (T) to handle generics,
    * which may cause a compiler warning due to type erasing. The warning can 
    * be suppressed using @SuppressWarnings("unchecked").
	 * @param newSet The set to union with.
	 * @return A new set representing the union.
	 */
   @SuppressWarnings("unchecked")
	public SET<T> union(SET<T> newSet) {
		SET<T> returnedSet = new SET();
		Object[] arr = newSet.returnArr();
		for (int i = 0; i < arr.length; i++) {
			returnedSet.add((T) arr[i]);
		}
		for (int i = 0; i < size; i++) {
			returnedSet.add((T) set[i]);
		}
		return returnedSet;
	}
	
	/**
	 * Performs the intersection operation with another set.
	 *
    * Note: This method uses the unchecked cast (T) to handle generics,
    * which may cause a compiler warning due to type erasing. The warning can 
    * be suppressed using @SuppressWarnings("unchecked").
	 * @param newSet The set to intersect with.
	 * @return A new set representing the intersection.
	 */
   @SuppressWarnings("unchecked")
	public SET<T> intersection(SET<T> newSet) {
		SET<T> returnedSet = new SET();
		SET<T> holdingSet = new SET();
		Object[] arr = newSet.returnArr();
		for (int i = 0; i < arr.length; i++) {
			holdingSet.add((T) arr[i]);
		}
		for (int i = 0; i < size; i++) {
			if (holdingSet.contains((T) set[i])) {
            returnedSet.add((T) set[i]);
         }
		}
		return returnedSet;
	}
   
   /**
    * Returns the complement of this set with respect to the universe set.
    * 
    * Note: This method uses the unchecked cast (T) to handle generics,
    * which may cause a compiler warning due to type erasing. The warning can 
    * be suppressed using @SuppressWarnings("unchecked").
    * @param universe The universe set from which to calculate the complement.
    * @return The complement of this set with respect to the universe set.
    */
   @SuppressWarnings("unchecked")
	public SET<T> complement(SET<T> universe) {
		SET<T> universeCopy = new SET<T>(); 
 		for (Object elem : universe.returnArr()) {
			universeCopy.add((T) elem);
		}
		for (int i = 0; i < size; i++) {
			universeCopy.delete((T) set[i]);
		}
		return universeCopy;
	}

	/**
	 * Deletes an element from the set.
	 *
	 * @param data The element to delete.
    * @throws NoSuchElementException if the element is not present in this set.
	 */
	public void delete(T data) throws NoSuchElementException {
		if (!this.contains(data)) { 
      	throw new NoSuchElementException("Element is not found in SET.");
		}
      Object[] newSet = new Object[set.length - 1];
		int count = 0;
		for (int i = 0; i < set.length; i++) {
	      if (!data.equals(set[i])) {
			   newSet[count] = set[i];
				count++;
			}
		}	
		set = newSet;
		size--;
	}
	
	/**
	 * Returns the cardinality of the set.
	 *
	 * @return The number of elements in the set.
	 */
	public int cardinality() {
		return size;
	}
	
	/**
	 * Adds an element to the set.
	 *
	 * @param elem The element to add.
	 */
	public void add(T elem) {
		Object[] newSet = new Object[set.length + 1];
		boolean add = true;
		for (int i = 0; i < this.set.length; i++) {
			if (elem.equals(set[i])) {
				add = false;
         }
			newSet[i] = this.set[i];
		}
      if (size >= MAX_SIZE) {
         add = false;
      }
		newSet[this.set.length] = elem;
		if (add) {
			set = newSet;
			size++;
		}
	}
	
	/**
	 * Checks if the set is empty.
	 *
	 * @return True if the set is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * Checks if the set is a subset of another set.
	 *
    * Note: This method uses the unchecked cast (T) to handle generics,
    * which may cause a compiler warning due to type erasing. The warning can
    * be suppressed using @SuppressWarnings("unchecked").
	 * @param comparedSet The set to compare with.
	 * @return True if the set is a subset, false otherwise.
	 */
   @SuppressWarnings("unchecked")
	public boolean isSubset(SET<T> comparedSet) {
		boolean subSet = true;
		if (comparedSet.cardinality() <= size) { 
         subSet = false;
      }
		for (int i = 0; i < set.length; i++) {
			if (!comparedSet.contains((T) set[i])) {
            subSet = false;
         }
		}
		return subSet;
	}

	/**
	 * Checks if the set contains a specific element.
	 *
	 * @param elem The element to check for.
	 * @return True if the set contains the element, false otherwise.
	 */
	public boolean contains(T elem) {
		boolean contains = false;
		int position = 0;
		while (!contains && position < size) {
			if (set[position].equals(elem)) {
            contains = true;
         }
			position++;
		}
		return contains;
	}
	
	/**
	 * Returns a string representation of the set.
	 *
	 * @return A string representing the set.
	 */
	public String toString() {
		if (set.length == 0) {
         return "[]";
      }
		String output = "[";
		for (int i = 0; i < set.length - 1; i++) { 
			output += "" + set[i] + ",";
      }
		output += "" + set[set.length - 1] + "]";
		return output;
	}
	
	/**
	 * Returns the internal array representation of the set.
	 *
	 * @return The array representation of the set.
	 */
	public Object[] returnArr() {
		return set;
	}
	
	/**
	 * Main method for testing the SET class.
	 *
	 * @param args Command line arguments.
	 */
	public static void main(String[] args) {
      SET<String> setthingy = new SET<String>();
		setthingy.add("a");
		setthingy.add("b");
		setthingy.add("c");
		setthingy.add("d");
		setthingy.add("e");
		System.out.println("set is: " + setthingy);
		System.out.println("size size is: " + setthingy.cardinality());
		//setthingy.delete("f");
		System.out.println("set is: " + setthingy);
		System.out.println("size size is: " + setthingy.cardinality());
		setthingy.delete("a");
		System.out.println("set is: " + setthingy);
		System.out.println("size size is: " + setthingy.cardinality());
		setthingy.delete("e");
		System.out.println("set is: " + setthingy);
		System.out.println("size size is: " + setthingy.cardinality());
		setthingy.delete("c");
		System.out.println("set is: " + setthingy);
		System.out.println("size size is: " + setthingy.cardinality());
		System.out.println("is the set empty? " + setthingy.isEmpty());
		setthingy.delete("d");
		System.out.println("set is: " + setthingy);
		System.out.println("size size is: " + setthingy.cardinality());
		setthingy.delete("b");
		System.out.println("set is: " + setthingy);
		System.out.println("size size is: " + setthingy.cardinality());
		//setthingy.delete("c");
		System.out.println("set is: " + setthingy);
		System.out.println("size size is: " + setthingy.cardinality());
		System.out.println("is the set empty? " + setthingy.isEmpty());
   }
}