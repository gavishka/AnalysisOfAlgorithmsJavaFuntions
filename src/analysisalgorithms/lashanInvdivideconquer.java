/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analysisalgorithms;

import java.util.Scanner;

/**
 *
 * @author gavis
 */
public class lashanInvdivideconquer {
 

    
    static int count=0;
    public static void main(String[] args) {
        // TODO code application logic here
        
        int sizeArray = 10;
        
        Scanner c = new Scanner(System.in);
        
        System.out.println("Default Array Size is 10..");

        
        System.out.println("Enter the Array elements : ");
        
        int[] myArray = new int[sizeArray];
        
        for( int i=0; i<sizeArray; i++)
        {
            myArray[i] = c.nextInt();
        }
        
        divide(myArray, sizeArray);
        
        System.out.println("number of inversions is " + count);
                
    }
    
    public static void divide(int[] myArray, int size)
    {
        
        if(size>1)
        {        
            //System.out.println(size);
            int newSize= (size/2);
            int reminder= (size%2);
            int[] b = new int[newSize];
            int[] c = new int[newSize];
            
            for(int j=0;j<newSize; j++)
            {
                b[j] = myArray[j];
                c[j] = myArray[j+newSize+reminder];
            }
            divide(b, newSize);
            divide(c, newSize);
            count(myArray, b, c);
        }
        
        
    }
    public static void count(int[] myArray, int[] b, int[] c)
    {
        int i=0;
        int j=0;
        int k=0;
        
        while (i<b.length && j<c.length)
        {
            if(b[i]<c[i])
            {
                i++;
            }
            else
            {
                count++;
                j++;
            }
            k++;
        }
         
    }
    

  
}
