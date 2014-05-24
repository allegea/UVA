/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Alejandro E. Garces
 */
public class Argentina{
	static String[] names;
	static int[] attack;
	static int[] deffend;
	
	public static class Team implements Comparable{
	int sumAttack;
	int sumDeffend;
	int[] posAtta;
	int[] posDeff;
	Team(int sumA, int sumDe, int[] posA, int[] posD)
	{
		sumAttack = sumA;
		sumDeffend = sumDe;
		posAtta = Arrays.copyOf(posA, 5);
		posDeff = Arrays.copyOf(posD, 5);
	}
        
        @Override
        public int compareTo(Object o)
	{
		if(sumAttack> ((Team)o).sumAttack)return 1;
		if(sumAttack< ((Team)o).sumAttack)return -1;
		if(sumDeffend> ((Team)o).sumDeffend)return 1;
		if(sumDeffend< ((Team)o).sumDeffend)return -1;
		String[] namesA = new String[5];
		String[] namesB = new String[5];
		for(int i=0;i<5;i++)
		{
			namesA[i] = names[posAtta[i]];
			namesB[i] = names[((Team)o).posAtta[i]];
		}
		Arrays.sort(namesA);
		Arrays.sort(namesB);
		for(int i=0;i<5;i++)
		{	int comp = namesA[i].compareTo(namesB[i]);
			if(comp!=0)return -comp;
		}
                return 0;
	}
	
        @Override
	public String toString()
	{
		String[] namesA = new String[5];
		String[] namesD = new String[5];
		for(int i=0;i<5;i++)
		{
			namesA[i] = names[posAtta[i]];
			namesD[i] = names[posDeff[i]];
		}
		Arrays.sort(namesA);
		Arrays.sort(namesD);
		String A = "(";
		String B = "(";
		for(int i=0;i<4;i++)
		{
			A+=namesA[i]+", ";
			B+=namesD[i]+", ";
		}
		A+=' '+namesA[4]+')';
		B+=' '+namesD[4]+')';
		return A+"\n"+B/*+"\n"+sumAttack+" - "+sumDeffend+"\n"*/;
	}


	}
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int m = 0;
		ArrayList<Team> teams;
		int[] auxA;
		int[] auxD;
		int iA = 0, iD = 0, suA = 0, suD = 0;
		while(m++<n)
		{
			names = new String[10];
			attack = new int[10];
			deffend = new int[10];
			teams = new ArrayList<Team>();
			
			for(int i=0;i<10;i++)
			{
				String[] read = in.readLine().split("[ ]+");
				names[i] = read[0];
				attack[i] = Integer.parseInt(read[1]);
				deffend[i] = Integer.parseInt(read[2]);
			}
			
			for(int i=0;i<(1<<10);i++)
			{
				if(Integer.bitCount(i)!=5)continue;
				iA = 0; iD = 0; suA = 0; suD = 0;
				auxA = new int[5];
				auxD = new int[5];
				for(int j=0;j<10;j++)
				{
					if(((1<<j)&i)!=0)
					{
						auxA[iA++] = j;
						suA+= attack[j];
					}
					else 
					{	
						auxD[iD++] = j;
						suD+=deffend[j];
					}
				}
				teams.add(new Team(suA, suD, auxA, auxD));
			}
			Collections.sort(teams);
                        //System.out.println(teams);
			System.out.println("Case "+m+":\n"+teams.get(teams.size()-1).toString());
		}
		in.close();
		System.exit(0);
	}
}