/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package analysisalgorithms;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author gavis
 */
public class LongestCommonSbSqnce {
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter string X :");
        String x=sc.next();
        
        System.out.println("Enter string Y :");
        String y=sc.next();
        System.out.print("\n");
        
        int m=x.length();
        int n=y.length();
        
        findLCS(x,y,m,n);
    }
    
    static void findLCS(String X, String Y, int m, int n){
        int[][] table=new int[m+1][n+1];
        
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0||j==0){
                    table[i][j]=0;
                }
                else if(X.charAt(i-1)==Y.charAt(j-1)){
                    table[i][j]=table[i-1][j-1]+1;
                }
                else{
                    table[i][j]=Math.max(table[i-1][j], table[i][j-1]);
                }
            }
        }
        
        System.out.println("The length of the longest common subsequence is "+table[m][n]);
        System.out.print("\n");
        
        int lengthSb=table[m][n];
        int copylengthSb=lengthSb;
        
        char[] lcs=new char[lengthSb];
        
        int i=m;
        int j=n;
        
        while(i>0 && j>0){
            if(X.charAt(i-1)==Y.charAt(j-1)){
                lcs[lengthSb-1]=X.charAt(i-1);
                i--;
                j--;
                lengthSb--;
            }
            else if(table[i-1][j]>=table[i][j-1]){
                i--;
            }
            else{
                j--;
            }
        }
        
        System.out.println("Longest common subsequence in strings "+X+" and "+Y+" is:");
        
        for(int g=0;g<copylengthSb;g++){
            System.out.print(lcs[g]);
        }
        System.out.print("\n");
        
    } 
}
