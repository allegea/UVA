/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.BitSet;

/**
 *
 * @author Alejandro E. Garces
 */
public class TraingSwaping {
    
    public static int countMerge(int A[], int lf, int mid, int rg){
        
        int count=0;
        int j=lf,h=mid;
        for(int i=lf;i<=rg;i++){
            
            if(j==mid)
            
            if(A[j]<A[h]){
                A[i]=A[j++];
            }else{
                A[i]=A[h++];
                count+=mid-j;
            }
            
        }
        
        
        return count;
    }

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         
           String line;
           line = in.readLine();
           int cases = Integer.parseInt(line);
            while (cases-->0) 
            {
               int n= Integer.parseInt(in.readLine());
               String[] read = in.readLine().split("[ ]+");
               int[] train = new int[n];
               for(int i=0;i<n;i++)
                   train[i]=Integer.parseInt(read[i]);
               
               int count=0;
               for(int i=0;i<n-1;i++){
                   for(int j=i+1;j<n;j++)
                       if(train[i]>train[j])
                           count++;
               }
               
               System.out.println("Optimal train swapping takes "+count+" swaps.");
                
                
            }

        in.close();
        System.exit(0);
        
    }
}
