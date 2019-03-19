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
public class AnalysisAlgorithms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
        int count;
        Scanner sc = new Scanner(System.in);
        System.out.println("How many elements in the array? :");
        count = sc.nextInt();
        
        int[] array=new int[count];
        
        System.out.print("\n");
        System.out.println("What are the elements in the array? :");
        for(int i=0;i<count;i++){
            array[i]=sc.nextInt();
        }
        
        System.out.print("\n");
        
        int inv=0;
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i]>array[j]){
                    inv++;
                }
            }
        }
        System.out.println("Total inversions: "+inv);
    }
    
}
