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
public class HomeworkChecker {

	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		int count = 0;
		while((line = in.readLine()) != null && line.length()>0)
		{
                        int indexE = line.indexOf("=");
                        int index = line.indexOf("+");
                        boolean sum = true;
                        if(index < 0)
                        {
                            index = line.indexOf("-");
                            sum = false;
                        }
                        
                        int a = Integer.parseInt(line.substring(0, index));
                        int b = Integer.parseInt(line.substring(index+1, indexE));
			
                        if(sum) a+=b;
                        else a-=b;
			
			if(String.valueOf(a).equals(line.substring(indexE+1, line.length())))count++;
                        
                        //System.out.println(count);
                                
			
		}
		System.out.println(count);
		in.close();
		System.exit(0);
	}
}