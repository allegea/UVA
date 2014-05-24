
import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class FibonacciWords {

	static int N = 100;
	static int MAX = 199999;
	static BigInteger ONE = BigInteger.ONE;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] fibos = new String[N + 1];
		fibos[0] = "0";
		fibos[1] = "1";
		
		for(int i = 2; i <= N; i ++)
		{
			int max1 = fibos[i - 1].length();
			int max2 = fibos[i - 2].length();
			fibos[i] = fibos[i - 1].substring(Math.max(0, max1 - MAX)) ;
			fibos[i] += fibos[i - 2].substring(0, Math.min(max2, MAX)) ;
		}
		System.out.println( " - ");
		while(true)
		{
			int n = Integer.parseInt(in.readLine());
			if(n == -1)break;
			String p = in.readLine();
			int mm = p.length();
			
			int curr = 0;
			System.out.println(p + " - ");
			while(fibos[curr].length() < mm)curr++;
				
			System.out.println(curr+ " - " + fibos[curr]);
			//BigInteger count, f, s;
                        long count, f, s;
			//long count = 0;
			String x = fibos[curr];
			//long f, s = 0;
			/*f = BigInteger.ZERO;
			count = BigInteger.ZERO;
			s = BigInteger.ZERO;*/
                        count = 0;
                        s = 0;
                        if(mm == 1)
                        {
                            count = 1;
                            if(p.equals("1") && n == 0)count--;
                            if(p.equals("0") && n == 1)count--;
                                
                            curr = 1;
                        }else{
                            
                        
			for(int i = 0; i <= x.length() - mm; i++)
				if(x.substring(i, i + mm).equals(p))
					count++;
					//count = count.add(BigInteger.ONE);
                        }
			System.out.println(count + " ---");
			f = count;
                        
                        
			
			for(int i = curr + 1; i <= n; i ++)
			{
				System.out.println(i);
				count = f + s;
				//count = f.add(s);
                                int n1  = fibos[i - 1].length();
                                int n2  = fibos[i - 2].length();
                                int n3 = fibos[i].length();
				System.out.println(n1+" -*- "+n2+" -*- "+n3+" -*- "+mm + " - "+(n2 + n1 - mm));
				System.out.println(i + " - " + mm+" -*- "+fibos[i]);
                                int limit = mm - 1 ;
                                int j = n1 - mm + 1;
                                while(limit--!=0 && j + mm <= n3)
				//for(int j = n1 - mm + 1; j < n1 + (n2 - mm); j++)
					{
                                                System.out.println("Sub - " +j+" - " + (j + mm)+" - ");
						System.out.println("Sub - " +j+" - " + (j + mm)+" - "+fibos[i]+" - "+fibos[i].substring(j, j + mm));
						if(fibos[i].substring(j, j + mm).equals(p))
							//count = count.add(BigInteger.ONE);
                                                    count++;
                                                j++;
					}
	
				s = f;
				f = count;
				System.out.println("Count - " + count + " - "+s+" - "+f);
				
			}
			System.out.println("**************** " +count);
		}
		
		in.close();
		System.exit(0);

	}

	
}
