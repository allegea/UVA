/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author Alejandro E. Garces
 */
public class DNASorting {
    
    public static int invertion(String x){

        int n=0;
        char[] charX = x.toCharArray();
        for(int i=0;i<x.length();i++){
            for(int j=i+1;j<x.length();j++)
                if(charX[i]>charX[j])n++;
        }
        return n;
    }
    
    public static int merge(char[] x, int lef, int midd, int rigt){
        
        int inv = 0;
        char[] aux = new char[x.length];
        
        for(int h=lef;h<=rigt;h++)
            aux[h]=x[h];
        //System.arraycopy(x, lef, aux, lef, rigt-lef+1);
        int i=lef,j=midd+1;
        //System.out.println(aux);
 
        for(int h=lef;h<=rigt;h++)
        {
            if(i>midd) {x[h]=aux[j++];}
            else if(j>rigt) {   x[h]=aux[i++];}
            else if(aux[i]<=aux[j]) {x[h]=aux[i++];}
            else {
                x[h]=aux[j++];
                inv+=midd-i+1;
            }
           // System.out.println(x);
        }
        
        //System.out.print(x);
       //System.out.println(" - "+lef+" - "+midd+" - "+rigt);
        
        //System.arraycopy(aux, lef, x, lef, rigt-lef);
        
        return inv;
        
    }
     public static int invertion2(char[] x, int lef, int rigt){
         
         if(lef>=rigt)
             return 0;
         
         int mid = lef+(rigt-lef)/2;
         int count = 0;
         count+=invertion2(x,lef,mid);
         count+=invertion2(x,mid+1,rigt);
         return count+merge(x,lef,mid,rigt);
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
           int act = 0;
           boolean first = true;
            while (act++<cases) 
            {
               in.readLine();
               
               SortedMap<Integer, ArrayList<Integer>> sets = new TreeMap<Integer, ArrayList<Integer>>();
               
               if(!first)
                   System.out.println();
               first = false;
               String[] input = in.readLine().split("[ ]+");
               ArrayList<Integer> setStrings = new ArrayList<Integer>();
               int n= Integer.parseInt(input[0]);
               int m= Integer.parseInt(input[1]);
               String[] read = new String[m];
               for(int i=0;i<m;i++){
                   read[i] = in.readLine();
                   //int inv = invertion(read[i]);
                   int inv = invertion2(read[i].toCharArray(),0,read[i].length()-1);
                  // System.out.println(inv);
                  // System.out.println(invertion(read[i]));
                   if(sets.containsKey(inv)){
                       sets.get(inv).add(i);
                   }else{
                       setStrings = new ArrayList<Integer>();
                       setStrings.add(i);
                       sets.put(inv, setStrings);
                   }
               }
               Entry<Integer, ArrayList<Integer>> aux;
               Set<Integer> keys = sets.keySet();
               for(int i:keys){
                   setStrings = sets.get(i);
                   for(int j=0;j<setStrings.size();j++)
                       System.out.println(read[setStrings.get(j)]);
               }
              // System.out.println(sets);
               
                
                
            }

        in.close();
        System.exit(0);
        
    }
}
