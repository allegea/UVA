/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;

/**
 *
 * @author allegea
 */
public class Base_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));

       System.out.println(1l<<101);
       
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         goto a;
           String line;
           StringBuilder out = new StringBuilder();
           line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;
            while (act++<cases) 
            {
               long number = Long.parseLong(in.readLine());
               out.append("Case #").append(act).append(": ").append(negativeB(number, -2)).append("\n"); 
                
            }

            System.out.print(out);
        in.close();
        System.exit(0);
        a:
        
    }
    
    static String negativeB(long x, int b)
    {
        StringBuilder out = new StringBuilder();
        if(x==0){
            return "0";
        }
        while(x!=0)
        {
            long y;
            if(x==-1)y=-b-1;
            else y = Math.abs(x%b);
                out.append(y);
                x=(x-y)/b;
        }
        
        return out.reverse().toString();
    }
}
