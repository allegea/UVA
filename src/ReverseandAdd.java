/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;


import java.util.*;

/**
 *
 * @author allegea
 */
public class ReverseandAdd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) /*throws IOException*/{
        try{
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

         int cases = Integer.parseInt(in.readLine());
           int act = 0;
            while(act++<cases)
            {
                int iter = 1;
                
                long number = Long.parseLong(in.readLine());
                while(true)
                {
                    long number2 = number;
                    long number1=0;

                    while(number2!=0)
                    {
                        number1=number1*10+number2%10;
                        number2/=10;
                    }
                    
                    number+=number1;
                    if(palindrome(number))break;
                    iter++;
                    
                
                }
                System.out.println(iter+" "+number);
            }
        }
        catch(IOException e)
        {
            System.exit(0);
        }

        
        System.exit(0);


    }
    
    static boolean palindrome(long number)
    {
        char[] num = String.valueOf(number).toCharArray();
        
        for(int i=0;i<num.length/2;i++)
        {
            if(num[i]!=num[num.length-1-i])return false;
        }
        return true;
        
    }
}
