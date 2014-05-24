/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Alejandro E. Garces
 */
public class StrategicDefenseInitiative {

    public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
               // Scanner in = new Scanner(System.in);
		String line = "";
		ArrayList<Integer> numbers;
                boolean first = true;
                int m = Integer.parseInt(in.readLine());
                in.readLine();
		while( m-->0)
                {
                       // in.readLine();
                        if(!first) System.out.println();
                        first = false;
                        numbers = new ArrayList<Integer>();
                        while( (line = in.readLine() )!= null && line.length() > 0)
			numbers.add(Integer.parseInt(line));
                        
                    int n = numbers.size();
                    int[] states = new int[n];
                    int[] prev = new int[n];
                    Arrays.fill(prev, -1);
                   // System.out.println(numbers);
                    if(numbers.size() == 0){
                        System.out.println("Max hits: 0");
                        continue;
                    }
                    int maxG = -1;
                    int posM = -1;
                    for(int i=0;i<n;i++)
                    {
                            int max = 0;
                            for(int j=0;j<i;j++)
                                    if(numbers.get(j)<numbers.get(i))
                                    {
                                            //prev[i] = j;
                                            if(max < states[j])
                                            {
                                                max = states[j];
                                                prev[i] = j;
                                            }
                                    }

                            states[i] = max + 1;
                            if(states[i] > maxG)
                            {
                                    maxG = states[i];
                                    posM = i;
                            }

                    }
		
                   /* System.out.println(Arrays.toString(states));
                    System.out.println(Arrays.toString(prev));
                    System.out.println(posM+" - "+maxG);*/

                    
                    //String output = "\n"+numbers.get(posM);
                    System.out.println("Max hits: "+maxG);
                    Stack<Integer> answer = new Stack<Integer>();
                    answer.push(numbers.get(posM));
                    int to = posM;
                    while( prev[to] != -1)
                    {
                       // output = "\n"+numbers.get(prev[to])+output;
                        answer.push(numbers.get(prev[to]));
                        to = prev[to];
                    }
                    while(!answer.isEmpty())
                    System.out.println(answer.pop());
                    //in.readLine();
                }
		
		
		in.close();
		System.exit(0);
	
	}

}
