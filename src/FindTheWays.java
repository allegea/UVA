/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 *
 * @author Alejandro E. Garces
 */
public class FindTheWays {


        static int logNF(int n, int k)
	{
              BigInteger facN = BigInteger.ONE;
              BigInteger facK = BigInteger.ONE;
              
              if(k > n-k) k = n-k;
              
              for(int i=n; i>n-k;i--)
              facN = facN.multiply(new BigInteger(String.valueOf(i)));
              
              for(int i=2; i<=k;i++)
              facK = facK.multiply(new BigInteger(String.valueOf(i)));
              
              return facN.divide(facK).toString().length();
                
              
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));


                String line = "";
                while(( line = in.readLine()) != null)
                {
                    String[] read = line.split("[ ]+");
                    int u = Integer.parseInt(read[0]);
                    int v = Integer.parseInt(read[1]);

                    System.out.println(logNF(u, v));
                }
		
		
		in.close();
		System.exit(0);
	}
	

}
