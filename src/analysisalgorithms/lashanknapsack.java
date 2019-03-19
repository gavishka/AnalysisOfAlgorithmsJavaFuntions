/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analysisalgorithms;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;




/**
 *
 * @author gavis
 */
public class lashanknapsack {
    public static void main(String[] args) {
    int Items;
        int Capacity; 
        
        //getting the inputs
        Scanner f = new Scanner(System.in);
        System.out.println("Tell me the how many items :");
        Items = f.nextInt();
        System.out.println("Tell me the Capacity of the Bag :");
        Capacity = f.nextInt();
        
        int[][] myArray = new int[Items][3];
        System.out.println("Tell me the value and the weight respectively : " );
        for (int i =0; i<Items; i++)
        {
            myArray[i][0] = i+1;
            myArray[i][1] = f.nextInt();
            myArray[i][2] = f.nextInt();
    
        }
        int subsets = (int) Math.pow(2, Items);

        int[][] subArray = new int[subsets][3];
        
        int subArrayIndex =0;
        
        for( int j=0; j<Items ; j++)
        {
            int itemNum = myArray[j][0];
            
            subArray[subArrayIndex][0] = itemNum;
            subArray[subArrayIndex][1] = myArray[j][1];
            subArray[subArrayIndex][2] = myArray[j][2];
            subArrayIndex++;
            
            for( int y=0; y<j ; y++)
            {
                String s;
                int a = subArray[y][0];
                s = Integer.toString(a) + Integer.toString(itemNum) ;
                subArray[subArrayIndex][0] = Integer.parseInt(s);
                subArray[subArrayIndex][1] = myArray[j][1] + subArray[y][1];
                subArray[subArrayIndex][2] = myArray[j][1] + subArray[y][1];
                subArrayIndex++;
            } 
            
        }
        
        System.out.println("The subsets are -----");
        for (int q =0 ;q < subsets; q++)
        {
            System.out.println(subArray[q][0]);
        }
        
        System.out.println("Best items to pick -----");
        
        int bestIndex=-1;
        int CurrentValue=0;
        for(int h=0; h<subsets; h++)
        {
            if(subArray[h][2]<=Capacity)
            {
                if(CurrentValue<subArray[h][1])
                {
                    CurrentValue = subArray[h][1];
                    bestIndex = h;
                }
            }
            
        }
        if (bestIndex ==-1)
        {
            System.err.println("There is no capacity for any item");
        }
        else
        {
        System.out.println("Item number" + subArray[bestIndex][0]+" Value is " +subArray[bestIndex][1]+ " Weight is : "+subArray[bestIndex][2]);
        }
    }
}
