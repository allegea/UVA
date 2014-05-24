/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Alejandro E. Garces
 */

public class DigitPrimes{
static boolean[] primes;
        public static boolean isPrime(int x)
        {
            
            if(x%2 != 0) return !primes[x];
            if(x == 2) return true;
            return false;
        }
    
	public static int digits(int x)
	{
		int sum = 0;
		while(x!=0)
		{
			sum+=x%10;
			x/=10;
		}
		return sum;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = 1000000;
                
		 primes = new boolean[n+1];
                primes[1] = true;
		//primes[1] = true;
		for(int i=3;i*i<=n;i+=2)
			if(!primes[i])
				for(int j=i*i;j<=n;j+=(i))
					primes[j] = true;
					
		int[] count = new int[n+1];
		for(int i=1;i<=n;i++)
			count[i] = count[i-1]+ (isPrime(i) && isPrime(digits(i))?1:0);
                   
                        //System.out.println(i+" - "+primes[i]+" - "+count[i]+" - "+digits(i));
		
		int N = Integer.parseInt(in.readLine());
                StringBuilder out = new StringBuilder();
		while(N-->0)
		{
			String[] read = in.readLine().split("[ ]+");
			int u = Integer.parseInt(read[0]);
			int v = Integer.parseInt(read[1]);
			out.append(count[v]-count[u-1]).append("\n");
		}
		System.out.print(out);
		in.close();
		System.exit(0);
				
	}
}

/*
 * #include<cstdio>
#include<cstring>

long digits(long x)
	{
	   // printf("%ld\n",x);
		long sum = 0;
		while(x!=0)
		{
			sum+=x%10;
			x/=10;
		}
		return sum;

	}

int main()
{
		long n = 100000;

		bool primes[n+1];
        primes[1] = true;
		//primes[1] = true;
		for(long i=2;i*i<=n;i++)
			if(!primes[i])
				for(long j=i*i;j<=n;j+=i)
					primes[j] = true;
    printf("fffff\n");
		long count[n+1];
		count[0] = 0;
		for(long i=1;i <= n;i++)
			count[i] = count[i-1]+ ((!primes[i]&&!primes[digits(i)])?1:0);
			printf("fffff\n");

                        //System.out.println(i+" - "+primes[i]+" - "+count[i]+" - "+digits(i));

		int N;
		scanf("%ld",&N);
		while(N-->0)
		{

			int u, v;
			scanf("%ld %ld",&u,&v);
			printf("%ld\n",count[v]-count[u-1]);
		}

		return 0;


}

 */