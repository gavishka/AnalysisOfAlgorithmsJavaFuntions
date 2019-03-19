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
public class WorkPlan_dynamic {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        System.out.println("How many weeks? ");
        int n=sc.nextInt();
        
        System.out.println("Enter low stress jobs revenues starting from week 1");
        
        int[] low=new int[n];
        int[] high=new int[n];
        
        for(int i=0;i<n;i++){
            low[i]=sc.nextInt();
        }
        System.out.println("Enter high stress jobs revenues starting from week 1");
        for(int i=0;i<n;i++){
            high[i]=sc.nextInt();
        }
        
        findplan(low,high);
    }
    
    static void findplan(int[] low, int[] high){
        int n=low.length;
        int[] values=new int[n];
        for(int i=0;i<n;i++){
            values[i]=0;
        }
        
        for(int i=0;i<n;i++){
            if(i==0){
                values[i]=Math.max(low[i], high[i]);
            }else if(i==1){
                values[i]=Math.max(values[0]+low[1],high[1]);
            }
            else{
                values[i]=Math.max(values[i-1]+low[i],values[i-2]+high[i]);
            }
        }
        System.out.print("\n");
        System.out.println("The maximum value of this plan is: "+values[n-1]);
        System.out.print("\n");
        
        char[] week={'n','n','n','n'};
        int k=n-1;
        
        while(k>=0){
            if(k==0){
                if(values[k]==low[k]){
                    week[k]='l';
                }
                else{
                    week[k]='h';
                }
            }
            else if((values[k]-values[k-1])==low[k]){
                week[k]='l';
            }
            else{
                week[k]='h';
                k--;
            }
            k--;
        }
        String todo;
        
         System.out.println("What to do each week: ");
         System.out.print("\n");
        for(int i=0;i<n;i++){
           // System.out.print(week[i]);
            
            switch(week[i]){
            
                case 'l': todo = "Low stress job";
                     break;
                case 'h': todo = "High stress job";
                     break;
                default: todo = "None";
                     break;
            }
             System.out.println("Week "+(i+1)+": "+todo);
          
        }
        System.out.println("\n");
        
        
        
    }
}
