import java.util.*;

public class BinarySearchLibrary {
	
	public static <T>
	    int firstIndexSlow(List<T> list, 
	    		           T target, Comparator<T> comp) {
		int index = Collections.binarySearch(list, target,comp);
		
		if (index < 0) return index;
		
		while (0 <= index && comp.compare(list.get(index),target) == 0) {
			index -= 1;
		}
		return index+1;
	}
	
	/**
	 * Uses binary search to find the index of the first object in parameter
	 * list -- the first object o such that comp.compare(o,target) == 0.
	 * 
	 * This method should not call comparator.compare() more than 1+log n times
	 * @param list is the list of objects being searched
	 * @param target is the object being searched for
	 * @param comp is how comparisons are made
	 * @return index i such that comp.compare(list.get(i),target) == 0
	 * and there is no index < i such that this is true. Return -1
	 * if there is no such object in list.
	 */
	
	public static <T>
    	int firstIndex(List<T> list, 
	               	T target, Comparator<T> comp) {
		if (list.size() == 0) {
			return -1; //if the size is 0, then the target isn't in the list
		}
		int low = -1;
		int high = list.size()-1; //set the bounds, low open, high closed
		while (low + 1 != high) {
			int mid = (low + high) / 2; //create the mid index number within the current high and low
			T midval = list.get(mid); 
			int cmp = comp.compare(midval, target);
			if (cmp < 0)
	            low = mid; //if the target comes later in the alphabet than midval
	        else {
	        	high = mid; //if midval comes later in the alphabet than the target
	        }
		}
		T lastval = list.get(high);
		int cmp = comp.compare(lastval, target); //one last comparison to find the first index if there
		if (cmp == 0) {
			return high; 
		}
		return -1;
	}

	/**
	 * Uses binary search to find the index of the last object in parameter
	 * list -- the first object o such that comp.compare(o,target) == 0.
	 * 
	 * This method should not call comparator.compare() more than 1+log n times
	 * @param list is the list of objects being searched
	 * @param target is the object being searched for
	 * @param comp is how comparisons are made
	 * @return index i such that comp.compare(list.get(i),target) == 0
	 * and there is no index > i such that this is true. Return -1
	 * if there is no such object in list.
	 */
	public static <T>
	int lastIndex(List<T> list, 
               	  T target, Comparator<T> comp) {
		if (list.size() == 0) {
			return -1; //if the size is 0, then the target isn't in the list
		}
		int low = 0;
		int high = list.size(); //set the bounds, low closed, high open
		while (low + 1 != high) {
			int mid = (low + high) / 2; //create the mid index number within the current high and low
			T midval = list.get(mid);
			int cmp = comp.compare(midval, target);
			if (cmp <= 0)
	            low = mid; //if the target comes later in the alphabet than midval
	        else {
	        	high = mid; //if midval comes later in the alphabet than the target
	        }
		}
		T lastval = list.get(low);
		int cmp = comp.compare(lastval, target); //one last comparison to find the last index if there
		if (cmp == 0) {
			return low;
		}
		return -1;
	}
	
}
