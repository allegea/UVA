/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @author Alejandro E. Garces
 */
public class Ones {

    public static void main(String[] args) throws IOException{
                Scanner in = new Scanner(System.in);
		String line = "";
                while(in.hasNext())
		{
			int fact = Integer.parseInt(in.next());
			int x = 1;
			int ones = 0;
			int w = 0;
			do{
				x= ((x%fact)*(10%fact))%fact;
				w= (w%fact + x%fact)%fact;
				ones++;
			}while(w%fact!=0);
			
			System.out.println(ones);
		}
		in.close();
		System.exit(0);
	}
}
