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
class DNASequencing {

public static void main(String[] args) throws IOException{
	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		TreeSet[] subs;
		String line = "";
		boolean nofirst = false;
                boolean nofirstC = false;
		while((line = in.readLine()) != null)
		{
                        if(nofirst)System.out.println();
                        nofirst = true;
			String may = line;
			String men = in.readLine();
			if(may.length() < men.length())
			{
				line = men;
				men = may;
				may = line;
			}
			
			int m = may.length();
			int n = men.length();
			subs = new TreeSet[n+1];
			for(int i=0;i<=n;i++)subs[i] = new TreeSet<String>();
			
			for(int i=n;i>=1;i--)
				for(int j=0;j<i;j++)
				{
					String sub = men.substring(j, i);
                                        //System.out.println(sub);
					if(may.contains(sub))subs[sub.length()].add(sub);
				}
			boolean nofound = true;
			TreeSet<String> toPrint;
			for(int i=n; i >=0 && nofound;i--)
			{
				if(!subs[i].isEmpty())
				{
					nofound = false;
					toPrint = subs[i];
                                        nofirstC = false;
                                       // System.out.println(subs[i]);
					for(String x:toPrint)
                                        {
                                            if(nofirstC)System.out.println();
                                            nofirstC = true;
                                            System.out.print(x);
                                        }
                                        System.out.println();
				}
			}
			
			if(nofound)System.out.println("No common sequence.");
			//System.out.println();
			in.readLine();
		}
    }
		
}

/*
atgc
tcac

atgc
gctg

aaa
b

*/