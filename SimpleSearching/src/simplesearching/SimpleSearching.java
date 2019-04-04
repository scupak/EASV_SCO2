package simplesearching;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author spangsberg
 */
public class SimpleSearching {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ComputerGame wow = new ComputerGame("WOW", "MMORPG");
        ComputerGame csgo = new ComputerGame("CS:GO", "FPS");
        ComputerGame doom = new ComputerGame("DOOM", "FPS");
        
        List<ComputerGame> games = new ArrayList<>();
        games.add(wow);
        games.add(csgo);
        games.add(doom);
        
        ComputerGame wanted = new ComputerGame("Commander Keen","2D");
        
        //Performance measurement
        int size = 20_000_000;
        List<ComputerGame> objects = new ArrayList<>();
        System.out.println("Loading objects into list...");
        
        for (int i = 0; i < size; i++) {
            objects.add(new ComputerGame("Title" + i, "Genre" + i));            
        }
        objects.add(wanted);
        
        System.out.println("Done loading...");
        
        //create a new Searcher object with a search strategy of SequentialSearch
        Searcher s = new Searcher(new SequentialSearch());
        
        
        long start = System.currentTimeMillis();
        int result = s.executeSearch(objects, wanted);
        System.out.println("Time elapsed: " + (System.currentTimeMillis()-start) + " ms");        
        System.out.println("Search result (Sequential Search):" + result);
        
        //change strategy to Binary Search
        s = new Searcher(new BinarySearch());
        Collections.sort(objects); //sort needed for binary search - O(log N)
        start = System.currentTimeMillis();
        result = s.executeSearch(objects, wanted);
        System.out.println("Time elapsed: " + (System.currentTimeMillis()-start) + " ms");
        System.out.println("Search result (Binary Search):" + result);
        
    }
}
