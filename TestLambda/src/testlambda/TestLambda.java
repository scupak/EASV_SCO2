/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testlambda;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author spangsberg
 */
public class TestLambda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        
        list.add("Harry Potter");
        list.add("Terminator 2");
        list.add("Terminator 1");
        list.add("Godfather 1-3");
        list.add("The Matrix");
        
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        
        System.out.println("------------------");
        
        list.forEach((movie) -> System.out.println(movie));
                
        
        
    }
    
}
