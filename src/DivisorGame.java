/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
a
/**
 *
 * @author allegea
 */
public class DivisorGame {

    static int[] mayor = new int[1000000];
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        
        numbers();
        BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        // BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
           int cases = Integer.parseInt(in.readLine());
           int act = 0;
            while (act++<cases) 
            {
               int number = Integer.parseInt(in.readLine());
               System.out.println(mayor[number-1]);
                
                
            }

        in.close();
        System.exit(0);
        
    }
    
    static void numbers()
    {
        mayor[0]=1;
        
        int current = 1;
        int div_cur=1;
        for(int i=2;i<=1000000;i++)
        {
            int x=i;
            int div=1;
            
            for(int p=2;p*p<=x;p++)
            {
                int cu=0;
                while(x%p==0)
                {
                    x/=p;
                    cu++;
                }
                div*=cu+1;
            }
            
            if(x>1)div*=2;
            
            if(div>=div_cur)
            {
                current=i;
                div_cur=div;
            }
            
            mayor[i-1]=current;

            //System.out.println(i+" - "+mayor[i-1]+" - "+div);
        }
        
    }
}
