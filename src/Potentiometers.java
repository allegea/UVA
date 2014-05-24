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


class Potentiometers{

    	static int[] values;
	
		static int[] RMQ;

		static int n;
               static int m;
		
		static void create()
		{
                        m = values.length;
                       // n = (int)(2 * Math.pow(2.0, Math.floor((Math.log((double)m) / Math.log(2.0)) + 1)));
                        n = (int)(Math.log((double)m) / Math.log(2.0)) +2;
                        n = 1<<n;
			//System.out.println(m + " - "+n);
			RMQ = new int[n];
			buildST(1, 0, m-1);
		}
		
		static void buildST(int root, int L, int R)
		{
			if(L == R){
                            //RMQ[root] = L;
                            RMQ[root] = values[L];
                        }
			else{
				int nL = root*2;
				int nR = root*2+1;
				buildST(nL, L, (L+R)/2);
				buildST(nR,(L+R)/2+1, R);
				int pL = RMQ[nL];
				int pR = RMQ[nR];
				/*int vL = values[pL];
				int vR = values[pR];
				RMQ[root] = ((vL <= vR)?pL:pR);*/
                                RMQ[root] = pL+pR;
			}
		}
                
               static public void update(int index, int value)
                {
                     update(1, 0, m-1, index, value);
                }
                
               static private int update(int root, int L, int R, int index, int value) {
                int i = index;
                int j = index;
               /* if (i > R || j < L)
                    return RMQ[root];*/
                if (L == i && R == j) {
                    values[i] = value;
                    //return RMQ[root] = L;
                    return RMQ[root] = value;
                }
                int mid = (L+R)/2;
                int oldV = 0;
                int newV = 0;
                if(index <= mid)
                {   oldV = RMQ[root*2];
                    newV = update(root * 2, L, (L + R) / 2, index, value);
                }else{  
                    oldV = RMQ[root*2+1];
                    newV = update(root * 2 + 1, (L + R) / 2 + 1, R, index, value);
                }
               // return RMQ[root] = ((values[pL] <= values[pR]) ? pL : pR);
                return RMQ[root] += newV-oldV;
            }
                
                 static public int QR(int i, int j)
                {
                    return QR(1, 0, m-1, i, j);
                }

               static private int QR(int root, int L, int R, int i, int j) {
                    //System.out.println(root + " * "+L+" * "+R);
                     if(i > R || j < L) return 0;
                     if(L >= i && R <= j)return RMQ[root];
                     
                     int pL = QR(root*2, L, (L+R)/2, i, j);
                     int pR = QR(root*2+1,(L+R)/2+1, R, i, j);
                    /* if(pL == -1)return pR;
                     if(pR == -1)return pL;
                     return values[pL] <= values [pR]?pL:pR;*/
                     return pL + pR;
                     
            
                 }
	
        
	public static void main(String[] args) throws IOException
	{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer r;
            StringBuilder output = new StringBuilder();
            int n, u, v;
            boolean noFirst = false;
            boolean noFirstC = false;
            int cases = 1;
            while(true)
            {
                n = Integer.parseInt(in.readLine());
                if(n == 0)break;
                
                if(noFirst)output.append("\n");
                output.append("Case ").append(cases++).append(":").append("\n");
                noFirst = true;
                values = new int[n];
                for(int i=0;i<n;i++)
                    values[i] = Integer.parseInt(in.readLine());
                
                create();
                /*System.out.println(Arrays.toString(values));
                System.out.println(sT.QR(0, 0));*/
                noFirstC = false;
                while(true)
                {
                    r = new StringTokenizer(in.readLine());
                    String first = r.nextToken();
                    if(first.charAt(0) == 'E')break;
                    u = Integer.parseInt(r.nextToken());
                    v = Integer.parseInt(r.nextToken());
                    if(first.charAt(0) == 'S')update(u-1, v);
                    else  output.append(QR(u-1, v-1)).append("\n");
                }
            }
            System.out.print(output);
            in.close();
            System.exit(0);
            
	}

}