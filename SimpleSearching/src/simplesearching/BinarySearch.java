package simplesearching;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author spangsberg
 */
public class BinarySearch implements SearchStrategy {

    @Override
    public <T extends Comparable<T>> int doSearch(List<T> objects, T wanted) {
        //custom implementation
        //return binarySearch(objects, 0, objects.size()-1, wanted);
        
        //Java built-in binary search algorithm
        return Collections.binarySearch(objects, wanted);
    }

    
    // Returns index of x if it is present in arr[l.. 
    // r], else return -1 
    private <T extends Comparable<T>> int binarySearch(List<T> objects, int l, int r, T wanted) 
    { 
        if (r >= l) { 
            int mid = l + (r - l) / 2; 
  
            // If the element is present at the 
            // middle itself 
            if (objects.get(mid).equals(wanted)) 
                return mid; 
  
            // If element is smaller than mid, then 
            // it can only be present in left subarray 
            if (objects.get(mid).compareTo(wanted) > 0) 
                return binarySearch(objects, l, mid - 1, wanted); 
  
            // Else the element can only be present 
            // in right subarray 
            return binarySearch(objects, mid + 1, r, wanted); 
        } 
  
        // We reach here when element is not present 
        // in array 
        return -1; 
    } 
}
