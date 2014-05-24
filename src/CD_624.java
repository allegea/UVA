/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author Alejandro E. Garces
 */

public class CD_624 {

	static long output;
	static long answer;
	static boolean[] visited;
	static long maxDuration;
	static int[] durations;
	static int n;
        static HashMap<Long, Long> map;
	
	static void backtracking(long dura, long tracks, int j)
	{
                //System.out.println(dura+" - "+Long.toBinaryString(tracks)+" - "+j);
		if(dura > maxDuration)return;
		if(answer < dura)
		{
			answer = dura;
			output = tracks;
                        //Collections.copy(tracks, current);
		}
		for(int i=j;i<n;i++)
                {
			if(!visited[i])
			{
				visited[i] = true;
				backtracking(dura + durations[i], tracks|(1<<i), i+1);
				visited[i] = false;
			}
                }
	
	}
        
        static long DP(long dura, long tracks, int j)
	{
                //System.out.println(dura+" - "+Long.toBinaryString(tracks)+" - "+j);
                
		if(dura > maxDuration)return - 1;
		if(answer < dura)
		{
			answer = dura;
			output = tracks;
                        return answer;
                        //Collections.copy(tracks, current);
		}
                
                long max = -1;
		for(int i=j;i<n;i++)
			if(!visited[i])
			{
				visited[i] = true;
				max = Math.max(DP(dura + durations[i], tracks|(1<<i), i+1), max);
				visited[i] = false;
			}
                map.put(dura, max);
                return max;
	
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		while((line = in.readLine()) != null && line.length() > 0)
		{
			String[] read = line.split("[ ]+");
			maxDuration = Integer.parseInt(read[0]);
			n = Integer.parseInt(read[1]);
			visited = new boolean[n];
			durations = new int[n];
                        answer = 0;
                        output = 0;
                        map = new HashMap<Long, Long>();
                        StringBuilder salida = new StringBuilder();
			for(int i=0;i<n;i++)
			durations[i] = Integer.parseInt(read[i+2]);
			backtracking(0, 0, 0);
                        //System.out.println(Arrays.toString(durations));
                        //System.out.println(Long.toBinaryString(output));
                        int aux = 1;
                        for(int i=0;i<n;i++){
                            if(((aux)&output)!=0)
                                salida.append(durations[i]).append(" ");
                            aux<<=1;
                        }
                       // System.out.println(tracks);
			salida.append("sum:").append(answer);
			System.out.println(salida);
		}
		in.close();
		System.exit(0);
	}
}