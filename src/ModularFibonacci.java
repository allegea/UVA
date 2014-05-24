/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Alejandro E. Garces
 */
public class ModularFibonacci {
    

    public static long[][] multiply(long[][] a, long[][] b,long m)
    {
        int n=a[0].length;
        long[][] answer =  new long[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    answer[i][j]+=(a[i][k])*(b[k][j])%m;
                }
               answer[i][j]%=m;
            }
        }
        return answer;
    }
    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

         String line="";
         long[][] start ={{0,1},{1,1}};
         long[][] identi = {{1,0},{0,1}};
         long[][] pow;
         long[][] aux;
         /*for(int i=0;i<3;i++)
         {
         start = multiply(start,pow);
         
         System.out.println(Arrays.deepToString(start));
         }*/
            while ((line=in.readLine())!=null) 
            {
                String[] read = line.split("[ ]+");
                long n=Integer.parseInt(read[0]);
                long m=Integer.parseInt(read[1]);
                m=(1<<m);
               // System.out.println(m);
                aux=identi;
                pow=start;
                
                while(n!=0){
                    if((n&1)!=0)
                        aux=multiply(aux,pow,m);
                        pow=multiply(pow,pow,m);
                        n>>=1;

                       // System.out.println(Arrays.deepToString(identi));
                }
               /* for(int i=0;i<n;i++)
                {
                    aux = multiply(aux,pow,m);
                }*/
                //System.out.println(Arrays.deepToString(aux));
              System.out.println(aux[0][1]);
                
            }

        in.close();
        System.exit(0);
        
    }
}
