/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author Alejandro E. Garces
 */
public class Recurrences {

    public static long[][] multiply(long[][] a, long[][] b, int mod){
        
        int n=a[0].length;
        long[][] answer = new long[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++)
                    answer[i][j]+=(a[i][k]*b[k][j])%mod;
                answer[i][j]%=mod;
            }
        
        return answer;
    }
    
    public static long[][] fastExpo(long[][] x,int n, int mod){
        
        int size = x[0].length;
        long[][] identidy = new long[size][size];
        for(int i=0;i<size;i++)
            identidy[i][i]=1;
        
        while(n!=0)
        {
            if((n&1)!=0)identidy=multiply(identidy,x,mod);
            x=multiply(x,x,mod);
            n>>=1;
        }
        
       // System.out.println("*"+Arrays.deepToString(identidy));
        
        return identidy;
    }
    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            while (true) 
            {
                String[] read = in.readLine().split("[ ]+");
                int d = Integer.parseInt(read[0]);
                int n = Integer.parseInt(read[1]);
                int m = Integer.parseInt(read[2]);
                
                if(d==0 && n==0 && m==0)
                    break;
                long[] ad = new long[d];
                long[] fd = new long[d]; 
                long[][] matrix = new long[d][d];
                
                StringTokenizer x = new StringTokenizer(in.readLine());
                StringTokenizer y = new StringTokenizer(in.readLine());
                
                for(int i=0;i<d-1;i++)
                {
                    ad[i]=Integer.parseInt(x.nextToken());
                    fd[i]=Integer.parseInt(y.nextToken());
                    matrix[d-1][d-1-i]=ad[i]%m;
                    matrix[i][i+1]=1;
                }

                    ad[d-1]=Integer.parseInt(x.nextToken());
                    fd[d-1]=Integer.parseInt(y.nextToken());
                    matrix[d-1][0]=ad[d-1]%m;
                    
                   // System.out.println(Arrays.deepToString(matrix));
                
                if(n<=d)
                {
                    System.out.println(fd[n-1]%m);
                }else{
                    
                    matrix = fastExpo(matrix, n-d, m);
                    long sum=0;
                    for(int i=0;i<d;i++)
                    {
                        sum+=(matrix[d-1][i]*fd[i])%m;
                    }
                    System.out.println(sum%m);
                   /* long sum=0;
                    for(int i=0;i<n-d;i++)
                    {
                        sum=fd[0]*ad[d-1];
                        for(int j=0;j<d-1;j++){
                            fd[j]=fd[j+1];
                            sum+=fd[j]*ad[d-2-j];
                        }
                        fd[d-1]=sum%m;
                       // System.out.println(Arrays.toString(fd));
                    }
                    System.out.println(fd[d-1]%m);*/
                }
                in.readLine();
                
            }

        in.close();
        System.exit(0);
        
    }
}
