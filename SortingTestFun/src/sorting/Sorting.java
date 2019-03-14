/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

/**
 *
 * @author spangsberg
 */
public class Sorting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Generate some random numbers
        int[] int10000 = generateRandomNumbers(10000);
        int[] int20000 = generateRandomNumbers(20000);
        int[] int40000 = generateRandomNumbers(40000);
        int[] int80000 = generateRandomNumbers(80000);
        
        //sort the data
        bubbleSort(int10000);        
        bubbleSort(int20000);        
        bubbleSort(int40000);        
        bubbleSort(int80000);        
       
    }
    
    private static int[] generateRandomNumbers(int size) {
        int[] randomNumbers = new int[size];
        Random r = new Random();
        
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = r.nextInt(size * 10);
            //System.out.println(randomNumbers[i] + ",");
        }    
        return randomNumbers;
    }
    
    private static int[] bubbleSort(int[] numbers) {
        
        Instant start = Instant.now();
        
        //O(N)
        for (int i = 1; i < numbers.length; i++)  
        {
            //O(N^2)
            for (int j = 0; j < numbers.length - 1; j++)  
            {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j]; //create temporary space
                    
                    //swap elements
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        
        Instant finish = Instant.now();
        
        long elapsedTime = Duration.between(start, finish).toMillis();
        
        System.out.println("Finished BubbleSort on " + numbers.length + " items in " + elapsedTime + " ms");
        
        return numbers;
    }
}
