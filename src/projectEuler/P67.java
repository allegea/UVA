/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uva.projectEuler;
import java.io.*;
import java.util.StringTokenizer;



/**
 *
 * @author allegea
 */
public class P67 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
         BufferedReader in   = new BufferedReader(new FileReader("triangulo.txt"));
        
         //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
           String line;
           StringBuilder out = new StringBuilder();
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
           int[][] numeros = new int[100][100];
           int curr = 0;
           int tamm = 100;
            while (curr<tamm) 
            {
               StringTokenizer leer = new StringTokenizer(in.readLine());
               int i=0;
               for(i = 0;leer.hasMoreTokens();i++){
                   numeros[curr][i]=Integer.parseInt(leer.nextToken());
                   //System.out.print(numeros[curr][i]+"\t");
               }
               curr++;
                //System.out.println("  -  "+i);
            }
            
            
            int[][] sum = new int[tamm+1][tamm+1];
            for(int i=0;i<tamm;i++)
                sum[i][tamm-1]=numeros[i][tamm-1];
            
            
           
            for(int j=tamm-1;j>=0;j--){
                for(int i=0;i<=j;i++){
                    int a,b,c;
                    a=b=c=0;
                    {
                       // if(i-1>=0)a=sum[j+1][i-1];
                        b=sum[j+1][i+1];
                        c=sum[j+1][i];
                    }
                    sum[j][i] = numeros[j][i]+Math.max(a, Math.max(b, c));
                }
            }
            
            
            for(int i=0;i<tamm;i++){
                for(int j=0;j<=i;j++){
                    System.out.print(sum[i][j]+"\t");
                }
                System.out.println();
                
            }
                
            
            

            
            
        in.close();
        System.exit(0);
        
    }
}
