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
public class SymmetricMatrix {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         

         //System.out.println(Long.parseLong("12",10));
         
           String line;
           line = in.readLine();
           int cases = Integer.parseInt(line);
           int now = 0;
           
            while (now++<cases) 
            {
                
                StringTokenizer read = new StringTokenizer(in.readLine());
                read.nextToken();
                read.nextToken();
                int n = Integer.parseInt(read.nextToken());
                long[][] matrix = new long[n][n];
                
                boolean answer = true;
                
                for(int i=0;i<n;i++){
                    read = new StringTokenizer(in.readLine());
                    for(int j=0;j<n;j++)
                    {   matrix[i][j]= Long.parseLong(read.nextToken());
                        if(matrix[i][j]<0)answer=false;
                    }
                }
                
                
                
                for(int i=0;i<n && answer;i++)
                    for(int j=0;j<n/2 && answer;j++)
                        if(matrix[i][j] != matrix[n-i-1][n-j-1]){
                            answer=false;
                            System.out.println(matrix[n-i-1][n-j-1]+" - "+matrix[i][j]);
                        }
                
                if(answer)
                    System.out.println("Test #"+now+": Symmetric.");
                else System.out.println("Test #"+now+": Non-symmetric.");
                
                

            }
            
            

        in.close();
        System.exit(0);
        
    }
}
