/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analysisalgorithms;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author gavis
 */
public class unique_transform_conquer {
    
    public static void main(String args[]){
        int size;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of integers in the sets:");
        size=sc.nextInt();
        
        System.out.println("Enter the first set: ");
        
        int[] array1 = new int[size];
        
        for( int i=0; i<size; i++)
        {
            array1[i] = sc.nextInt();
        }
        
        System.out.println("Enter the second set: ");
        
        int[] array2 = new int[size];
        
        for( int i=0; i<size; i++)
        {
            array2[i] = sc.nextInt();
        }
        Arrays.sort(array1);
        Arrays.sort(array2);
        
        int count=0;
        int j=0;
        for(int i=0;i<array1.length;i++){
            if(array1[i]==array2[j]){
                count++;
            }
            j++;
        }
        System.out.println();
        if(count==array1.length){
            System.out.println("These two sets are equal.");
        }
        else{
            System.out.println("These two sets are not equal.");
        }
        System.out.println();
    }
    
}
