/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.Arrays;



/**
 *
 * @author allegea
 */
public class Permutar {

    static int n;
    static int[] elementos;
    static boolean[] visitados;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        n=8;
        elementos = new int[n];
        visitados = new boolean[n];
        for(int i=0;i<n;i++)
            elementos[i]=i;
        
        int[] aux = new int[n];
        permutar(aux,0);
        
    }
    
    static void permutar(int[] toperm,int k){
        //if(k==n)
            System.out.println(Arrays.toString(toperm));
       // else
        {
            
            for(int i=0;i<n;i++){
                if(visitados[i])continue;
                visitados[i]=true;
                toperm[k]=elementos[i];
                permutar(toperm,k+1);
                visitados[i]=false;
            }
        }
        
    }
}
