/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;

/**
 *
 * @author allegea
 */
public class OddSum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
           int cases = Integer.parseInt(in.readLine());
           int[] pows = new int[51];
           for(int i=0;i<=50;i++)
               pows[i]=i*i;
           
           int act = 0;
            while (act++<cases) 
            {
               int a = Integer.parseInt(in.readLine());
               int b = Integer.parseInt(in.readLine());
               
               int inf = a>b?b:a;
               
               if(inf%2==0)inf++;
               
               /*int sum = 0;
               
               for(int p=inf;p<=b;p+=2)
                   sum+=p;
               
               System.out.println("Case "+act+": "+sum);
               */
               /*if(b%2==0)
               System.out.println("Case "+act+": "+(int)(Math.pow(b/2, 2)-Math.pow(inf/2, 2)));
               else System.out.println("Case "+act+": "+(int)(Math.pow(b/2+1, 2)-Math.pow(inf/2, 2)));*/
               
               if(b%2==0)
               System.out.println("Case "+act+": "+(pows[b/2]-pows[inf/2]));
               else System.out.println("Case "+act+": "+(pows[b/2+1]-pows[inf/2]));
               
                
            }

        in.close();
        System.exit(0);
        
    }
}
