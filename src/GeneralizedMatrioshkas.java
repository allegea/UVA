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

class GeneralizedMatrioshkas{

	static int INF = Integer.MAX_VALUE/2;
	static boolean answer(int[] num)
	{
		int n = num.length;
		if(-num[0] != num[n-1])return false;
		if(-num[0] <= check(num, 1, n-2))return false;
		return true;
		
	}

	static int check(int[] num, int l, int r)
	{
                System.out.println(l+" - "+r);
		if(l>=r)return 0;
		int posA = INF;
		int posB = INF;
		int posR = r;
		int posL = l;
		int fl = num[l];
                if(fl > 0)return INF;
		while(posR > l)
		{
			if(num[posR] == -fl)
			{
				posA = posR;
				break;
			}
			posR--;
		}
		while(posL < r)
		{
			if(num[posL] == -fl)
			{
				posB = posL;
				break;
			}
			posL++;
		}
		int fromL, fromR, fromL1, fromR1;
		fromL = fromR = fromL1 = fromR1 = INF;
                System.out.println(-fl+" * "+l+" - "+r+" - "+posA+" - "+posB);
		if(posA != INF)	{
                    fromL = check(num, l+1, posA-1);
                    fromL1 = check(num, posA+1, r);
                }
		if(posB != INF && posB != posA) {
                    fromR = check(num, l+1, posB-1);
                    fromR1 = check(num, posB+1, r);
                }
		
                System.out.println(-fl+" - "+l+" - "+r+" - "+posA+" - "+posB+" - "+fromL+" - "+fromL1+" - "+fromR+" - "+fromR1);
		//if(fromL < -fl || fromR < -fl)return Math.min(fromL1, fromR1)+-fl;
                if(fromL < -fl) return fromL1-fl;
                if(fromR < -fl) return fromR1-fl;
                //if(posB <= posA)return Math.min(fromL1, fromR1)+-fl;
		return INF;
	}
        
        static boolean checkStack(int[] num)
        {
            Stack<Integer> s = new Stack<Integer>();
            for(int i=0;i<num.length;i++)
            {
                if(num[i] > 0)
                {    if(s.isEmpty())return false;
                     int sum = 0;
                     boolean found = false;
                     while(!s.isEmpty())
                     {
                         if(-s.peek() == num[i])
                         {
                             s.pop();
                             //System.out.println(sum+" - "+num[i]+" - "+i);
                             if(sum < num[i]){
                                 s.push(num[i]);
                                 found = true;
                             }
                             break;
                         }
                         sum+=(Math.abs(s.pop()));
                     }
                     if(!found)return false;
                }else s.push(num[i]);
                //System.out.println(i+" - "+s);
            }
            
            //if(!s.isEmpty())return false;
            if(s.size() <= 1)return true;
            return false;
            
            
        }
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String read;
		while((read = in.readLine())!= null && read.length() > 0)
		{
			StringTokenizer tokens = new StringTokenizer(read);
			int[] numbers = new int[tokens.countTokens()];
			int pos = 0;
			while(tokens.hasMoreTokens())
			numbers[pos++] = Integer.parseInt(tokens.nextToken());
			
			System.out.println(checkStack(numbers)?":-) Matrioshka!":":-( Try again.");
		}
		in.close();
		System.exit(0);
	}
}