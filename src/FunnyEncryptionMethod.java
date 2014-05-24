/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import java.util.*;

/**
 *
 * @author Alejandro E. Garces
 */
public class FunnyEncryptionMethod{

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		
		while(n-- > 0)
		{
			
			String line = in.readLine().trim();
			int x = Integer.parseInt(line);
			int y = Integer.parseInt(line, 16);
			System.out.println(Integer.bitCount(x) + " " + Integer.bitCount(y));
				
		}
		in.close();
		System.exit(0);
	}

}

