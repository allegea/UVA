/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.math.BigInteger;


/**
 *
 * @author allegea
 */
public class f500Factorial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         BigInteger[] factorials = new BigInteger[1001];
         factorials[0]=factorials[1]=new BigInteger("1");
         for(int i=2;i<=1000;i++)
         {
             factorials[i]=factorials[i-1].multiply(BigInteger.valueOf(i));
             //System.out.println(factorials[i].toString());
         }
         
         
         String line;
         while((line = in.readLine())!=null)
         {

             int multi = Integer.parseInt(line);


             System.out.println(multi+"!\n"+factorials[multi]);
                  
         
         }
         

        in.close();
        System.exit(0);
        
    }
}

/*
 * String[] factorials = new String[1000];
         
         String line;
         while((line = in.readLine())!=null)
         {
             int[] base = new int[1000000];
         int digits = 2;
         base[0]=1;
         
         int multi = Integer.parseInt(line);
         int tmp = 0;
         
         for(int j=2;j<=multi;j++)
         {
             for(int i=0;i<digits;i++)
             {
                 int x = base[i]*j + tmp;
                 base[i]=x%10;
                 tmp=x/10;
             }

             while(tmp!=0)
             {
                 base[digits++]=tmp%10;
                 tmp/=10;
             }
         }
         
         System.out.println(multi+"!");
         for(int i=digits-1;i>=0;i--)
             System.out.print(base[i]);
         
         System.out.println();
         }
 */