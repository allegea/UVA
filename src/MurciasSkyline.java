/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author Alejandro E. Garces
 */
public class MurciasSkyline{
	 public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] LIS;
		int[] LDS;
		int[] height;
                int[] widths;
                int[] sumWI;
                int[] sumWD;
		int answerI;
                int answerD;
                int curr = 1;
		while(n-->0)
		{
			int m = Integer.parseInt(in.readLine());
			LIS = new int[m];
			LDS = new int[m];
			height = new int[m];
                        widths = new int[m];
                        sumWI = new int[m];
                        sumWD = new int[m];
                        
			answerI = 0;
                        answerD = 0;
                        String[] read = in.readLine().split("[ ]+");
			for(int i=0;i<m;i++)
				height[i] = Integer.parseInt(read[i]);
                        read = in.readLine().split("[ ]+");
			for(int i=0;i<m;i++)
				widths[i] = Integer.parseInt(read[i]);
				
			for(int i=0; i<m;i++)
			{
				int maxI = 0;
				int maxD = 0;
                                int maxSI = 0;
                                int maxSD = 0;
				for(int j=0;j<i;j++)
				{	if(height[j]<height[i]){
					maxI = Math.max(maxI, LIS[j]);
                                        maxSI = Math.max(maxSI, sumWI[j]);
                                        }
					if(height[j]>height[i]){
					maxD = Math.max(maxD, LDS[j]);
                                        maxSD = Math.max(maxSD, sumWD[j]);
                                        }
				}
				LIS[i] = maxI+1;
				LDS[i] = maxD+1;
                                sumWI[i] = maxSI+widths[i]; 
                                sumWD[i] = maxSD+widths[i];
				//answer = Math.max(answer, LIS[i]+LDS[i]-1);
                                answerI = Math.max(sumWI[i], answerI);
                                answerD = Math.max(sumWD[i], answerD);
			
			}
			/*System.out.println(Arrays.toString(LIS));
			System.out.println(Arrays.toString(LDS));
                        System.out.println(Arrays.toString(sumWI));
                        System.out.println(Arrays.toString(sumWD));*/
                        if(answerI >= answerD)
                            System.out.println("Case "+curr+". Increasing ("+answerI+"). Decreasing ("+answerD+").");
                        else System.out.println("Case "+curr+". Decreasing ("+answerD+"). Increasing ("+answerI+").");
                        curr++;
			//System.out.println(answer);
		}
		in.close();
		System.exit(0);
	}

}