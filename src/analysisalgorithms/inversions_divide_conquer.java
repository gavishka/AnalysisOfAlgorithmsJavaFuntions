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
public class inversions_divide_conquer {
        static int invCount=0;
        
    public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Size of the array : ");
        int size = sc.nextInt();
        
        System.out.println("Enter the Array elements : ");
        
        int[] array = new int[size];
        
        for( int i=0; i<size; i++)
        {
            array[i] = sc.nextInt();
        }
        
        divideAndCount(array,0,array.length-1);
        
        System.out.println();
        System.out.println("Number of inversions: "+invCount);
        System.out.println();
    }
    
    static void divideAndCount(int arr[],int left,int right){
        if(left<right){
            int mid=(left+right)/2;
            
            divideAndCount(arr,left,mid);
            divideAndCount(arr,mid+1,right);
            
            countInv(arr,left,mid,right);
        }
    }
    
    static void countInv(int arr[],int left,int mid,int right){
        int leftSize=mid-left+1;
        int rightSize=right-mid;
        
        int leftArr[]=new int[leftSize];
        int rightArr[]=new int[rightSize];
        
        System.out.println("Left Array printing...");
        for(int i=0;i<leftSize;i++){
            leftArr[i]=arr[i+left];
            System.out.print(leftArr[i]+", ");
        }
        
        System.out.println();
        
        System.out.println("Right Array printing...");
        for(int j=0;j<rightSize;j++){
            rightArr[j]=arr[j+mid+1];
            System.out.print(rightArr[j]+", ");
        }
        System.out.println();
        int i=0; // leftArray Index
        int j=0; // rightArray Index
        
        while(i<leftSize && j<rightSize){
            if(leftArr[i]>rightArr[j]){
                
                j++;
                
                invCount = invCount + 1;
                
                
            }
            else{
               // i++;
               j++;
            }
            if(j==rightSize && i!=leftSize){
                    j=0;
                    i++;
            }
        }
    }
}
