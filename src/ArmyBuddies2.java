/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @author Alejandro E. Garces
 */
public class ArmyBuddies2 { 

    public static void main(String[] args) throws IOException{
	
	//Scanner in = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer r;
        StringBuilder output = new StringBuilder();
        int[] right = new int[200000];
        int[] left =  new int[200000];
        int u, v, n, m, prev, next;
	while(true)
	{
                r = new StringTokenizer(in.readLine());
                n = Integer.parseInt(r.nextToken());
                m = Integer.parseInt(r.nextToken());
		/*int n = in.nextInt();
		int m = in.nextInt();*/
		if(n == 0 && m == 0)break;
               
               // right = new int[n+2];
                //left = new int[n+2];
                for(int i=1;i<=n;i++)
                {
                    left[i] = i-1;
                    right[i] = i+1;
                }
                
                for(int i=0;i<m;i++)
                {
                    r = new StringTokenizer(in.readLine());
                    u = Integer.parseInt(r.nextToken());
                    v = Integer.parseInt(r.nextToken());
                    /*int u = in.nextInt();
                    int v = in.nextInt();*/

                    prev = left[u];
                    next = right[v];
                    /*if(prev == 0)
                    {
                        if(next == n+1)System.out.println("* *");
                        else System.out.println("* "+next);
                    }else{
                        if(next == n+1)System.out.println(prev+" *");
                        else System.out.println(prev+" "+next);
                    }*/
                    if(prev == 0)
                    {
                        if(next == n+1)output.append("* *").append("\n");
                        else output.append("* ").append(next).append("\n");
                    }else{
                        if(next == n+1)output.append(prev).append(" *").append("\n");
                        else output.append(prev).append(" ").append(next).append("\n");
                    }
                    /*String p  = "";
                    String ne = "";
                    if(prev == 0) p = "*";
                    else p = ""+prev;
                    if(next == n+1) ne = "*";
                    else ne = ""+next;*/
                   // System.out.println(p+" "+ne);
                   // output.append(p).append(" ").append(ne).append("\n");
                    
                    left[right[v]] = left[u];
                    right[left[u]] = right[v];
                    

                }
                output.append("-").append("\n");
                //System.out.println("-");
		
	}
        System.out.println(output);
	in.close();
	System.exit(0);
	}

}
/*
 #include<stdio.h>


int main()
{

    int right[200000], left[200000];
    int n, m, u, v, prev, next;
    while(true)
    {
        scanf("%d %d", &n,&m);
        if(n == 0 && m == 0)break;
        for(int i=1;i<=n;i++)
        {
            left[i] = i-1;
            right[i] = i+1;
        }

        for(int i=0;i<m;i++)
        {
             scanf("%d %d", &u,&v);
             prev = left[u];
             next = right[v];
             if(prev == 0)
                    {
                        if(next == n+1)printf("* *\n");
                        else printf("* %d\n", next);
                    }else{
                        if(next == n+1)printf("%d *\n", prev);
                        else printf("%d %d\n", prev, next);
                    }
             left[right[v]] = left[u];
             right[left[u]]= right[v];
        }

        printf("-\n");

    }
    return 0;
}

 */