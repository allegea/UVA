/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.Arrays;
import java.util.TreeSet;



/**
 *
 * @author allegea
 */
public class Bandwidth {

    static int n;
    static int bandwidth;
    static char[] letters;
     static char[] winner;
    static boolean[] visitados;
    static int[][] adj;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         
           String line;
          
            while (true) 
            {
               line = in.readLine();
               if(line.equals("#"))break;
               char[] read = line.toCharArray();

               TreeSet<Character> letras = new TreeSet<Character>();
               adj = new int[26][26];
               char act = read[0];
               for(int i=0;i<read.length;i++){
                   if(read[i]==';')continue;
                   if(Character.isLetter(read[i])){
                       act=read[i];
                       letras.add(act);
                       i++;
                       while(++i<read.length && Character.isLetter(read[i]))
                       {    letras.add(read[i]);
                           adj[act-65][read[i]-65]=adj[read[i]-65][act-65]=1;
                       }
                       
                       
                   }
               }
               n=letras.size();
               letters = new char[n];
               int i=0;
               for(Character c:letras){
                   letters[i++]=c;
               }
               bandwidth = 8;
               winner = new char[n];
            
               visitados = new boolean[n];
               char[] aux = new char[n];
               permutar(aux,0);
               
               for(Character c:winner)
                   System.out.print(c+" ");
               System.out.println("-> "+bandwidth);

                
            }

            
        in.close();
        System.exit(0);
        
    }
    
    static void permutar(char[] toperm,int k){
        if(k==n)
        {
            calcular(toperm);

        }
            
        else
        {
            
            for(int i=0;i<n;i++){
                if(visitados[i])continue;
                visitados[i]=true;
                toperm[k]=letters[i];
                permutar(toperm,k+1);
                visitados[i]=false;
            }
        }
        
    }
    
    static void calcular(char[] x)
    {
        int cal = 0;
        
        for(int i=0;i<x.length-1;i++){
            for(int j=i+1;j<x.length;j++){
                if(adj[x[i]-65][x[j]-65]==1){
                    cal=Math.max(cal, j-i);
                    if(cal>bandwidth)break;
                }
            }
            if(cal>bandwidth)break;
        }
        
        if(cal<bandwidth){
              
                bandwidth=cal;
               winner= Arrays.copyOf(x, n);
            }
        
    }
}
