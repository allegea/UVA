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
public class  TheDepartmentOfRedundancyDepartment {


	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
		StringTokenizer st;
		StringBuilder output = new StringBuilder();
                
		while( (line = in.readLine()) != null)
		{
			
                    st = new StringTokenizer(line);
                    while(st.hasMoreTokens())
                    {
                            int x = Integer.parseInt(st.nextToken());
                            int fre = 1;
                            if(!freq.containsKey(x))
                                    numbers.add(x);
                            else fre += freq.get(x);

                            freq.put(x, fre);
                    }
	
		}
                for(int x:numbers)
				output.append(x).append(" ").append(freq.get(x)).append("\n");
			System.out.print(output);
		in.close();
		System.exit(0);
	}

}
