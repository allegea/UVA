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
public class ThrowingCardsAwayII {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
        
       
            while (true) 
            {
               int n= Integer.parseInt(in.readLine());
               if(n==0)break;
               int i=1;
               while((1<<i)<n)i++;
               if((1<<i)>n)i--;
               n-=(1<<i);
               if(n==0)System.out.println((1<<i));
               else System.out.println(n*2);
               
               /*sfmunera
                * int ans = 2 * (N - Integer.highestOneBit(N));
                if (ans == 0)
                ans = N;
                */
               /////////////////////////////////
               ////////////////////////////////
               
               /* Mio iterativo
                * ArrayList<Integer> x = new ArrayList<Integer>();
               for(int i=n;i>0;i--)
                   x.add(i);
               
               while(x.size()!=1){
                   
                   x.remove(x.size()-1);
                   System.out.println(x+" s"+x.size());
                   int aux = x.remove(x.size()-1);
                  //if(x.size()==1){
                   //    System.out.println(aux);
                  //     break;
                  // }
                   x.add(0, aux);
                   System.out.println(x+" --");
               }
                System.out.println(x.get(0));*/
            }

        in.close();
        System.exit(0);
        
    }
}
