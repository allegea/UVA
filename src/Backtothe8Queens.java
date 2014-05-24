/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Alejandro E. Garces
 */

public class  Backtothe8Queens{

	static boolean[][] occuped = new boolean[8][8];
	static int answer;
	static boolean[] occupedRow = new boolean[8];
        static int[] OriPos;
        static int used;
        static int[][] valid = new int[92][8];
        static int[] currPos = new int[8];
        static boolean[][] leftD = new boolean[8][8];
        static boolean[][] RightD = new boolean[8][8];
	
	static boolean canLeft(int x, int y)
	{
		int min = Math.min(x, y);
		int i = x-min;
		int j = y-min;
		for(;i<8 && j<8;)
			if(occuped[i++][j++])return false;

		return true;
	}
	
	static boolean canRight(int x, int y)
	{
            
		int min = Math.min(x, 7-y);
		int i = x-min;
		int j = y+min;
		for(;i<8 && j>=0;)
			if(occuped[i++][j--])return false;
		return true;
	}
	
        static boolean canDiag(int x, int y){
            
            int minl = Math.min(x, 7-y);
            int il = x-minl;
            int jl = y+minl;
            
            int minR = Math.min(x, y);
            int iR = x-minR;
            int jR = y-minR;
            if(leftD[il][jl] || RightD[iR][jR])return false;
            leftD[il][jl] = true;
            RightD[iR][jR] = true;
            return true;
            
        }
        
        static boolean unmark(int x, int y){
            
            int minl = Math.min(x, 7-y);
            int il = x-minl;
            int jl = y+minl;
            
            int minR = Math.min(x, y);
            int iR = x-minR;
            int jR = y-minR;
            leftD[il][jl] = false;
            RightD[iR][jR] = false;
            return true;
            
        }
	static void BT(int col)
	{
		if(col == 8)
		{
			//System.out.println(answer+" - "+acum);
			//answer = Math.min(acum, answer);
                        for(int i=0;i<8;i++)
                            valid[used][i] = currPos[i];
                        used++;
			return;
		}
		
		for(int i=0;i<8;i++)
		{
			if( !occupedRow[i] && canDiag(i, col)/*&& canLeft(i, col) && canRight(i, col)*/)
			{
				occupedRow[i] = true;
				occuped[i][col] = true;
                                currPos[col] = i;
				BT(col+1);
				occupedRow[i] = false;
                                currPos[col] = -1;
				occuped[i][col] = false;
                                unmark(i, col);
			}
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
                //Scanner in = new Scanner((System.in));
		//int n = Integer.parseInt(in.readLine());
               // int n = in.nextInt();
		String[] read;
                String line = "";
                int curr = 1;
                BT(0);
                //for(int i=0;i<used;i++)
                  //  System.out.println(i+" - "+Arrays.toString(valid[i]));
		while( (line = in.readLine()) != null && line.length()>0)
		{
			answer = Integer.MAX_VALUE;
                       // used = 0;
                        read = line.split("[ ]+");
                        OriPos = new int[8];
			for(int i=0;i<8;i++)
				OriPos[i] = Integer.parseInt(read[i])-1;
                       
                      // System.out.println(Arrays.toString(OriPos));
			//BT(0, 0);
                        int min = Integer.MAX_VALUE;
                        for(int i=0;i<used;i++)
                        {   
                            int count = 0;
                            for(int j=0;j<8;j++)
                            if(valid[i][j] != OriPos[j])
                                count++;
                            
                            min = Math.min(min, count);
                            
                        }
			System.out.println("Case "+curr+": "+min);
                        //System.out.println(used);
                        curr++;
		
		}
		
		in.close();
		System.exit(0);
	}
}
