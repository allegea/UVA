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
class EasyProblemFromRujiaLiu{

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		StringTokenizer r;
		HashMap<Integer, ArrayList<Integer>> map;
		ArrayList<Integer> pos;
		int kth = 0;
                StringBuilder output = new StringBuilder();
		while((line = in.readLine()) != null && line.length() > 0)
		{
			r = new StringTokenizer(line);
			int n = Integer.parseInt(r.nextToken());
			int m = Integer.parseInt(r.nextToken());
			map = new HashMap<Integer, ArrayList<Integer>>();
			r = new StringTokenizer(in.readLine());
			for(int i=0;i<n;i++)
			{
				int num = Integer.parseInt(r.nextToken());
				if(map.containsKey(num))
					map.get(num).add(i+1);
				else {
					pos = new ArrayList<Integer>();
					pos.add(i+1);
					map.put(num, pos);
				}
			}
			//System.out.println(map);
			for(int i=0;i<m;i++)
			{
				r = new StringTokenizer(in.readLine());
				int k = Integer.parseInt(r.nextToken());
				int v = Integer.parseInt(r.nextToken());
				kth = 0;
				if(map.containsKey(v) && map.get(v).size() >= k)
				kth = map.get(v).get(k-1);
				
				System.out.println(kth);
                                output.append(kth).append("\n");
                                
			}
		}
                //System.out.println("****************");
                System.out.println(output);
		in.close();
		System.exit(0);
	
	}

}

/**********
 #include<stdio.h>
#include<vector>
using namespace std;
vector<int> kth[1000001];
int N = 1000001;
int main()
{
    int n, m, x, y;
    while(scanf("%d%d",&n,&m) == 2)
    {
        for(int i=0;i<N; kth[i++].clear());
        for(int i=0;i<n;i++)
        {
            scanf("%d",&x);
            kth[x].push_back(i+1);
        }

        for(int i=0;i<m;i++)
        {
            int answer = 0;
            scanf("%d%d",&x,&y);
            if(kth[y].size() >= x)
            answer = kth[y][x-1];
            printf("%d\n",answer);
        }

    }
    return 0;
}
 */