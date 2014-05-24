/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @author Alejandro E. Garces
 */
public class FroshWeek {

    static long merge(int[] A, int l, int mid, int r) {
        long cnt = 0;
        int n1 = mid - l + 1;
        int n2 = r - mid;

        int[] L = new int[n1 + 1]; // A[l..mid]
        int[] R = new int[n2 + 1]; // A[mid+1..r]

        for (int i = 0; i < n1; ++i) {
            L[i] = A[l + i];
        }
        for (int i = 0; i < n2; ++i) {
            R[i] = A[mid + i + 1];
        }
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        for (int k = l; k <= r; ++k) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                ++i;
            } else {
                A[k] = R[j];
                ++j;
                cnt += n1 - i; // Count inversions as remaining elements in left array
            }
        }
        return cnt;
    }
   /* static int merge(int[] array,int l, int m,int r){
        int count=0;
        
        int[] aux = new int[array.length];
        for(int i=l;i<=r;i++)
            aux[i]=array[i];
        int h=l,j=m+1;
        
        for(int i=l;i<=r;i++){
            if(h>m) array[i]=aux[j++];
            else if(j>r) array[i]=aux[h++];
            else if(aux[h]<=aux[j]) array[i]=aux[h++];
            else{
                array[i]=aux[j++];
                count+=m-h+1;
            }
        }
        
        
        return count;
    }*/
    static long sort(int[] array, int l, int r){
        
        if(l>=r)return 0;
        int m = l+(r-l)/2;
        long count = sort(array,l,m);
        count += sort(array,m+1,r);
        return count + merge(array,l,m,r);
    }
    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));

         
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

           String line;
            while ((line = in.readLine())!=null) 
            {
               int n= Integer.parseInt(line);
               int[] array = new int[n];
               for(int i=0;i<n;i++)
                   array[i]=Integer.parseInt(in.readLine());
               
               System.out.println(sort(array,0,n-1));
               //System.out.println(Arrays.toString(array));
                
            }
        in.close();
        System.exit(0);
        
    }
}
