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
public class knapsack {
    
    
    public static void main(String[] args) {
        int items;
       
        int capacityLimit;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("How many Items? :");
        items = sc.nextInt();
        System.out.println("What is the Capacity of the Bag? :");
        capacityLimit = sc.nextInt();
        
        int[] weights = new int[3];
        int[] values = new int[3];
        System.out.println("What are the weights of each item? : " );
        for (int i =0; i<items; i++)
        {
            weights[i] = sc.nextInt();
        }
        
        System.out.println("What are the values of each item? : " );
        for (int i =0; i<items; i++)
        {
            values[i] = sc.nextInt();
        }
        System.out.print("\n");
        
        ArrayList<Integer> TotalWeightlist=new ArrayList<Integer>();
        ArrayList<Integer> TotalValueslist=new ArrayList<Integer>();
        
        TotalWeightlist.add(0);
        for(int i=0;i<4;i++){
            for(int j=0;j<i;j++){
                int u=TotalWeightlist.get(j)+weights[i-1];
                TotalWeightlist.add(u);
            }
        }
        
        
        int a=weights[0]+weights[1]+weights[2];
        TotalWeightlist.add(a);
        
        System.out.print("Total weights of each subset: ");
        for(int i=0;i<8;i++){
            System.out.print(TotalWeightlist.get(i)+", ");
        }
        System.out.println();
        
        TotalValueslist.add(0);
        for(int i=0;i<4;i++){
            for(int j=0;j<i;j++){
                int u=TotalValueslist.get(j)+values[i-1];
                TotalValueslist.add(u);
            }
        }
        
        
        int b=values[0]+values[1]+values[2];
        TotalValueslist.add(b);
        
        System.out.print("Total values of each subset: ");
        for(int i=0;i<8;i++){
           System.out.print(TotalValueslist.get(i)+", ");
        }
        System.out.print("\n\n");
        

        for(int i=0;i<TotalWeightlist.size();i++){
            if(TotalWeightlist.get(i)>capacityLimit){
                TotalWeightlist.remove(i);
                TotalValueslist.remove(i);
            }
        }
        
        int maxValue=0;
        for(int i=0;i<5;i++){
            if(TotalValueslist.get(i)>maxValue){
                maxValue=TotalValueslist.get(i);
           
            }
        }
        
        System.out.println("The largest value that fits into the knapsack: "+maxValue);
        
    }
}
