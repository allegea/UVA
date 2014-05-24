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
public class   OneLittleTwoLittleThreeLittleEndians  {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";

		while( (line = in.readLine()) != null)
		{
			int x = Integer.parseInt(line);
			int y = 0;
			long bit = 1;
                       
			for(int i = 0; i < 4; i++)
			{
				long bitL = (bit << 8*i) - 1;
				long bitR = (bit << 8*(i + 1)) - 1;
				long mask = bitR ^ bitL;
				mask = x & mask;
				mask>>=(8 * i);
				y|= (mask<< ( 8 * (3 - i)));
			}
                        System.out.println(x + " converts to " + y);
		}
		
	}
}