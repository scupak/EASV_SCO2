package simplesearching;

import java.util.List;

/**
 *
 * @author spangsberg
 */
public class SequentialSearch implements SearchStrategy {

    /*
    Using "bounded type parameters" with <T extends Comparable<T>>
    doSearch() only accept types that either implements the Comparable interface 
    or extends a class that implements the Comparable interface
    */
    @Override
    public <T extends Comparable<T>> int doSearch(List<T> objects, T wanted) {        
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i).equals(wanted))
                return i;
        }        
        return -1;
    }   
    
    //Non-generic sequential search (tied to specific type ComputerGame)
//    @Override
//    public int doSearch(List<ComputerGame> objects, ComputerGame wanted) {        
//        for (int i = 0; i < objects.size(); i++) {
//            if (objects.get(i).equals(wanted))
//                return i;
//        }        
//        return -1;
//    }    
}
