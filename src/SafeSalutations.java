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
public class  SafeSalutations {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = 12;
		long[] catalan = new long[N+1];
		catalan[0] = 1;
                long tes = 4294967295l;
		for(int i=1;i<=N;i++)
		{
			catalan[i] = (2*(2*i-1)*catalan[i-1])/(i+1);
                        System.out.println(catalan[i]);
                        System.out.println((catalan[i]>=tes));
                                
		}

                boolean first = true;
                String line = "";
		while( (line = in.readLine()) != null)
		{
                    if(!first)System.out.println();
			System.out.println(catalan[Integer.parseInt(line)]);
                        first = false;
                        
                    in.readLine();
		}
		
		in.close();
		System.exit(0);
	}
}