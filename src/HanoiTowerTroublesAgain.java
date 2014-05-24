/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;



/**
 *
 * @author allegea
 */
public class HanoiTowerTroublesAgain {

   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         long[] numbers = new long[50];
         numbers[0]=1;
         numbers[1]=3;
         int add = 4;
         int cant = 0;
         for(int i=2;i<50;i++)
         {
             numbers[i]=numbers[i-1]+add;
             cant++;
             if(cant%2==0)
             {
                 cant=0;
                 add+=2;
             }
         }
         
           String line;
           
           line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;
            while (act++<cases) 
            {
                System.out.println(numbers[Integer.parseInt((in.readLine()))-1]);
            }

            
        in.close();
        System.exit(0);
        
    }
}
