/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;



/**
 *
 * @author allegea
 */
public class TeobaldoTrip {

    public static long[][] multiply(long[][] a, long[][] b)
    {
        int n=a[0].length;
        long[][] answer = new long[n][n];
        
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
            { for(int k=0;k<n;k++)
                    answer[i][j]+=(a[i][k]*b[k][j]);
            if(answer[i][j]!=0)
            answer[i][j]/=answer[i][j];

            }
        return answer;
    }
    public static long path(long[][] a,int s, int e, int d)
    {
        int n=a[0].length;
        long[][] identidy = new long[n][n];
        for(int i=0;i<n;i++)
            identidy[i][i]=1;
        
        while(d!=0)
        {
            if((d&1)!=0)identidy=multiply(identidy,a);
            a=multiply(a,a);
            d>>=1;
        }
        
      //System.out.println(Arrays.deepToString(identidy));
        return identidy[s-1][e-1];
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
         boolean first = false;
            while (true) 
            {
                if(first)
                in.readLine();
                
                first= true;
               String[] read = in.readLine().split("[ ]+");
               int c = Integer.parseInt(read[0]);
               int l = Integer.parseInt(read[1]);
               
               if(c==0 && l==0)break;
               
               long[][] matrix = new long[c][c];
               StringTokenizer x;
               int o=0;
               int o2=0;
               for(int i=0;i<l;i++)
               {
                   x = new StringTokenizer(in.readLine());
                   o=Integer.parseInt(x.nextToken())-1;
                   o2= Integer.parseInt(x.nextToken())-1;
                   matrix[o][o2]=matrix[o2][o]=1;
               }
                x = new StringTokenizer(in.readLine());
               //read = in.readLine().split("[ ]+");
               int s = Integer.parseInt(x.nextToken());
               int e = Integer.parseInt(x.nextToken());
               int d = Integer.parseInt(x.nextToken());

               if(path(matrix,s,e,d)!=0)
               System.out.println("Yes, Teobaldo can travel.");
               else System.out.println("No, Teobaldo can not travel.");
               
               
               
               
                
            }

            
        in.close();
        System.exit(0);
        
    }
}
