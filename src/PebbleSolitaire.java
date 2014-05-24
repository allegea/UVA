/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Alejandro E. Garces
 */
public class PebbleSolitaire{

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		int now = 0;
		int answer;
		Queue<Integer> games;
		HashSet<Integer> visited;
		while(now++<n)
		{
			char[] szboard = in.readLine().toCharArray();
			int board = 0;
			answer = 12;
			for(int i = 11;i>=0;i--)
				if(szboard[i] == 'o')
					board|=(1<<i);
			
			games = new LinkedList<Integer>();
			visited = new HashSet<Integer>();
			games.offer(board);
                        //System.out.println(board+" - "+Integer.toBinaryString(board));
			int newBoard = 0;
			int oneS = 0, twoS = 0, curr = 0;
			while(!games.isEmpty())
			{
				boolean newGames = false;
				newBoard = games.poll();
				
				for(int i=11;i>=2;i--)
				{
					oneS = newBoard&(1<<(i-1));
					twoS = newBoard&(1<<(i-2));
					curr = newBoard&(1<<i);
					/*System.out.println("****");
                                        System.out.println(newBoard+" - "+Integer.toBinaryString(newBoard));
                                        System.out.println(oneS+" - "+Integer.toBinaryString(oneS));
                                        System.out.println(twoS+" - "+Integer.toBinaryString(twoS));
                                        System.out.println(curr+" - "+Integer.toBinaryString(curr)+" - "+i);*/
					if(curr != 0 && oneS != 0 && twoS ==0)
					{
						int auxBoard = newBoard^curr;
						auxBoard^=oneS;
						auxBoard|=(1<<(i-2));
                                                //System.out.println(auxBoard+" - "+Integer.toBinaryString(auxBoard));
						if(visited.add(auxBoard))
							games.offer(auxBoard);
					}
				}
				
				for(int i=0;i<=9;i++)
				{
					oneS = newBoard&(1<<(i+1));
					twoS = newBoard&(1<<(i+2));
					curr = newBoard&(1<<i);
					/*System.out.println("****");
                                        System.out.println(newBoard+" - "+Integer.toBinaryString(newBoard));
                                        System.out.println(oneS+" - "+Integer.toBinaryString(oneS));
                                        System.out.println(twoS+" - "+Integer.toBinaryString(twoS));
                                        System.out.println(curr+" - "+Integer.toBinaryString(curr)+" - "+i);*/
					if(curr != 0 && oneS != 0 && twoS ==0)
					{
						int auxBoard = newBoard^curr;
						auxBoard^=oneS;
						auxBoard|=(1<<(i+2));
                                                 //System.out.println(auxBoard+" - "+Integer.toBinaryString(auxBoard));
						if(visited.add(auxBoard))
							games.offer(auxBoard);
					}
				}
				
				if(!newGames)
				answer = Math.min(answer,Integer.bitCount(newBoard));
			}
			
			System.out.println(answer);
			
		}
                in.close();
        System.exit(0);
	}
}
