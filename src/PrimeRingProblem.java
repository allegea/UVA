/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.BitSet;

/**
 *
 * @author Alejandro E. Garces
 */
public class PrimeRingProblem {

    /**
     * @param args the command line arguments
     */
    public static int n;
    public static boolean[] visited;
    public static int[] numbers;
    public static BitSet criba = new BitSet();
    public static int now = 0;
    public static StringBuilder output = new StringBuilder();
    public static void permutar(int[] values, int k){
        
        if(k==n){
            if(!criba.get(values[k-1]+values[0])){
                
                output.append("\n").append(values[0]);
                for(int i=1;i<k;i++)
                    output.append(" ").append(values[i]);
            }
            return;
        }
        
        for(int i=0;i<n;i++){
            if(visited[i])continue;
            if(criba.get(values[k-1]+numbers[i]))
            continue;
            
            visited[i]=true;
            values[k]=numbers[i];
            permutar(values,k+1);
            visited[i]=false;
            
        }
        
    }
    
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         criba.set(0);
         for(int i=2;i*i<=32;i++)
             if(!criba.get(i))
                 for(int j=2*i;j<=32;j+=i)
                     criba.set(j);

         
           String line;
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
           boolean count=false;
            while ((line = in.readLine()) != null) 
            {
                if(count){
                   output.append("\n");
                }
                now++;
                output.append("Case ").append(now).append(":");
                count=true;
                
                n = Integer.parseInt(line);
                numbers = new int[n];
                visited = new boolean[n];
                
                for(int i=1;i<=n;i++)
                numbers[i-1]=i;
                
                int[] aux = new int[n];
                aux[0]=1;
                visited[0]=true;
                permutar(aux,1);
                
                System.out.println(output);
                output = new StringBuilder();
            }
            
            

        in.close();
        System.exit(0);
        
    }
}
