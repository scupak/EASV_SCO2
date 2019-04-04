package simplesearching;

import java.util.List;

/**
 *
 * @author spangsberg
 */
public class Searcher {
    private SearchStrategy strategy;

    public Searcher(SearchStrategy strategy) {
        this.strategy = strategy;
    }
    
    public int executeSearch(List<ComputerGame> objects, ComputerGame wanted) {
        return strategy.doSearch(objects, wanted);
    }
}
