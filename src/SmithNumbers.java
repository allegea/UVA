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
public class SmithNumbers {

    public static int sumDigitis(int x)
    {
        int ans = 0;
        while(x!=0)
        {
            ans+=x%10;
            x/=10;
        }
        return ans;
    }
    
    public static boolean isPrime(int x)
    {
        if(x==1)return true;
        if(x==2)return true;
        if(x%2==0)return false;
        for(int i=3;i*i<=x;i+=2)
            if(x%i==0)return false;
        return true;
    }
    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        /*int[] prime = new int[3402];
        Arrays.fill(prime, 2);
        
        int top = 1;
    for(int i = 3; i*i <= 1e9; i += 2){
        int judge = 1;
        for(int j = 2; j*j <= i; j++)
            if(i%j == 0)    judge = 0;
        if(judge!=0)   
        {
            prime[top++] = i;
           // System.out.println(i);
        }
    }*/

        
           int n=Integer.parseInt(in.readLine());
           for(int k=0;k<n;k++)
           {
               int num = Integer.parseInt(in.readLine());
              //int aux = num+1;
               int aux = num;
               int sumD = sumDigitis(num);
              // System.out.println(num+" -> "+sumD);
              // int answ = -1;
               boolean found = false;
               while(!found)
               {
                   int m = (++aux);
                   if(isPrime(aux))continue;
                   sumD = sumDigitis(aux);
                   //System.out.print(aux+" -> "+sumD + " - ");
                   int sum=0;
                    for(int i=2;i*i<=m;i++)
                    {

                        while(m%i==0)
                        {
                            m/=i;
                            sum+=sumDigitis(i);
                            //System.out.print(" *"+i);

                        }
                    }
                    if(m>1){
                        sum+=sumDigitis(m);
                        //System.out.print(" *"+m);
                    }
                    
                   // System.out.println("\n"+aux+" -> "+sum);
                    if(sumD==sum)
                        found=true;
               }
               System.out.println(aux);
           }
           
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/

        in.close();
        System.exit(0);
        
    }
}
