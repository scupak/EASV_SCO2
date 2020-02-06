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
        
        testLambda1();      
          
        
        
    }
    
    
    /**
     * 
     */
    public static void testLambda1() {
        
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
    
    
    /**
     * 
     */
    public static void testLambda2() {
        new Thread(()-> {
                System.out.println("Printing from Lambda....");
                System.out.println("Test two");
                System.out.println("Test three");
            }).start();
        
//        new Thread(new Runnable() {
//            @Override
//            public void run(){
//                System.out.println("Printing from inner annonymous class....");
//            }
//        }).start();

        //new Thread(new ThreadWithCode()).start();
    }         
    
    
    
    /**
     * 
     */
    public static void testLambda3() {
        
        // lambda expression to define the calculate method 
        Square s = (int x)->x*x; 
        //Box b = new Box(); //Without Lambda - we need to create class that implements the interface
                
        // parameter passed and return type must be 
        // same as defined in the prototype 
        int result = s.calculate(5); 
        System.out.println(result); 
    }    
}

//Class that implements Functional Interface (one method to implement only) 
class ThreadWithCode implements Runnable {
    @Override
    public void run() {
        System.out.println("Printing from Runnable class....");
    }    
}



@FunctionalInterface
interface Square 
{ 
    int calculate(int x); 
} 
 

/**
 * Class that implements our Functional Interface
 * 
 * @author Søren Spangsberg
 */
class Box implements Square {

    @Override
    public int calculate(int x) {
        return x*x;
    }    
}
