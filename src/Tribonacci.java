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
public class Tribonacci {

    
    public static long[][] multiply(long[][] a, long[][] b, int mod)
    {
        int n= a[0].length;
        long[][] answer = new long[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                    answer[i][j]+=((a[i][k]%mod)*(b[k][j]%mod))%mod;
                answer[i][j]%=mod;
            }
        }
        return answer;
    }
    
    public static long fastExp(long[][] base, long expo, int m)
    {
        int n= base[0].length;
        long[][] identidy =  new long[n][n];
        for(int i=0;i<n;i++)
            identidy[i][i]=1;
        
        while(expo!=0)
        {
            if((expo&1)!=0)identidy=multiply(identidy,base,m);
            base=multiply(base,base,m);
            expo>>=1;
        }
       // System.out.println(Arrays.deepToString(identidy));
        return identidy[1][1];
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         int mod = 1000000009;
         
         long[][] start = {{0,1,0},{0,0,1},{1,1,1}};
         long[][] aux;
         
            while (true) 
            {
               long n = Long.parseLong(in.readLine());
               if(n==0)break;
               
               aux = start;
               System.out.println(fastExp(aux, n,mod));
                
                
            }

        in.close();
        System.exit(0);
        
    }
}
