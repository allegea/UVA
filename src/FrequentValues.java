/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author Alejandro E. Garces
 */


class FrequentValues{

	static class SegTree{
	
		int[] RMQ;
                int[] FRE;
		int[] values;
		int n;
		SegTree()
		{
		
		}
		
		void create(int[] val)
		{
                        int m = val.length;
			n = m * 10;
			RMQ = new int[n];
                        FRE = new int[n];
			values = new int[m];
			for(int i=0;i<m;i++)values[i] = val[i];
			buildSTF(1, 0, val.length-1);
		}

                void buildSTF(int root, int L, int R)
		{
			if(L == R){
                            RMQ[root] = L;
                            FRE[root] = 1;
                        }
			else{
				int nL = root*2;
				int nR = root*2+1;
				buildSTF(nL, L, (L+R)/2);
				buildSTF(nR,(L+R)/2+1, R);
				int pL = RMQ[nL];
				int pR = RMQ[nR];
				int vL = values[pL];
				int vR = values[pR];
                                if(vL  == vR) {
                                    FRE[root] += FRE[nL] + FRE[nR];
                                    RMQ[root] = pL;
                                }
                                else {
                                    
                                    FRE[root] = ((FRE[nL] <= FRE[nR])?FRE[nL]:FRE[nR]);
                                    RMQ[root] = ((FRE[nL] <= FRE[nR])?pL:pR);
                                }
			}
		}
                
                public int query(int i, int j)
                {
                    return QRF(1, 0, values.length-1, i, j);
                }

                private int QRF(int root, int L, int R, int i, int j) {
                    System.out.println(root + " * "+L+" * "+R);
                     if(i > R || j < L) return -1;
                     if(L >= i && R <= j)return FRE[root];
                     
                     int pL = QRF(root*2, L, (L+R)/2, i, j);
                     int pR = QRF(root*2+1,(L+R)/2+1, R, i, j);
                     if(pL == -1)return pR;
                     if(pR == -1)return pL;
                     if(values[pL] == values [pR])return FRE[]
                     return values[pL] <= values [pR]?pL:pR;
                     
            
                 }
	}
	public static void main(String[] args) throws IOException
	{
            int n = 7;
            int[] vector = new int[n];
            SegTree sT = new SegTree();
            Random r = new Random();
            for(int i=0;i<n;i++)vector[i] = r.nextInt()%100;
            
            System.out.println(Arrays.toString(vector));
            sT.create(vector);
            System.out.println(sT.query(0, 7));
            
	}

}