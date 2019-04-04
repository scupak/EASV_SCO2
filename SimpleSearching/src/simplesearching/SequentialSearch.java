package simplesearching;

import java.util.List;

/**
 *
 * @author spangsberg
 */
public class SequentialSearch implements SearchStrategy {

    @Override
    public <T extends Comparable<T>> int doSearch(List<T> objects, T wanted) {        
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i).equals(wanted))
                return i;
        }        
        return -1;
    }    
}
