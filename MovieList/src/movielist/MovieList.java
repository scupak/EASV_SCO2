/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movielist;

import java.util.Iterator;

/**
 *
 * @author spangsberg
 */
public class MovieList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MovieManager mm = new MovieManager();
        
        Movie m1 = new Movie("The Simpsons Movie");
        Movie m2 = new Movie("Terminator 2");
        
        mm.addMovies(m1, m2);
        
//        System.out.println(mm);
//        
//        for (int i = 0; i < mm.getMovies().size() - 1; i++) {
//            System.out.println(mm.getMovies().get(i));
//        }
//        
        Iterator it = mm.getMovies().iterator();
        
        while (it.hasNext()) {
            Movie m = (Movie) it.next();
            
            System.out.println(m);
        }           
        
    }
    
}
