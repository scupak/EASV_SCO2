package simplesearching;

import java.util.List;

/**
 *
 * @author spangsberg
 */
public interface SearchStrategy  {
    //Non-generic
    //public int doSearch(List<ComputerGame> objects, ComputerGame wanted); 
    
    //Generic
    public <T extends Comparable<T>> int doSearch(List<T> objects, T wanted); 
    
}
