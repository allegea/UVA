/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import java.util.*;

/**
 *
 * @author Alejandro E. Garces
 */
public class   ThroughTheDesert {

	public static class Event{
	
		int x;
		int value;
		int type; //0, Fuel cons
				  //1, Leak
				  //2, Gas
				  //3, Mechanic
				  //4, Goal
		Event(int xx, int tt, int vv)
		{
			x = xx;
			value = vv;
			type = tt;
		}
                
                public String toString()
                {
                    return x+" - "+value+" - "+type;
                }
		
	}
	
	public static ArrayList<Event> events;
	
	public static double BS()
	{
               // System.out.println(events);
		double L = 0.0;
		double R = 10000;
                
                //double L = 50;
		//double R = 120;
		double sln = 0.0;
		while(Math.abs(L - R) > 0.00001)
		{
                        
			double mid = (L + R)/2;
                        //System.out.println("** "+L + " - "+mid+" - "+R);
			if(simulate(mid)) R = sln = mid;
			else L = mid;
		
                        //break;
		}
		return sln;
	}
	
	public static boolean simulate(double tank)
	{
		double ori = tank;
		int pos = 0;
		int consum = 1;
		int leaks = 0;
		int dX = 0;
		
		for(Event v:events)
		{
			
			double d = 0;
			dX = v.x - pos;
                        if(dX != 0)
                            d = ((double)(dX)/(double)100)*consum + (dX)*leaks;
			pos = v.x;
                        //System.out.println(tank+" - "+d+" - "+pos+" - "+dX+" - "+consum + " - "+v.x+" - "+leaks);
			tank-=d;
			if(tank < 0.0)return false;
			switch(v.type)
			{
				case 0:
					consum = v.value;
					break;
				case 1:
				case 3:
					leaks++;
					if(v.type == 3)leaks = 0;
					break;
				case 2:
					tank = ori;
					break;
				case 4:
					
					break;
				
			}
			
		}
		//System.out.println("FINALE - "+tank+" - "+(tank >= 0.0));
		return tank >= 0.0;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		StringTokenizer st;
		while(true)
		{
			line = in.readLine();
			if(line.equals("0 Fuel consumption 0"))break;
			events = new ArrayList<Event>();
			while(true)
			{
				st = new StringTokenizer(line);
				int type = 0;
				int x = 0;
				int value = 0;
				if(st.countTokens() == 4)
				{
					x =  Integer.parseInt(st.nextToken());
					st.nextToken();
					st.nextToken();
					value = Integer.parseInt(st.nextToken());
				}else{
					x =  Integer.parseInt(st.nextToken());
					String info = st.nextToken();
					if(info.equals("Leak"))
					type = 1;
					else if(info.equals("Gas"))
					type = 2;
					else if(info.equals("Mechanic"))
					type = 3;
					else type = 4;
				}
				events.add(new Event(x, type, value));
				if(type == 4)break;
				line = in.readLine();
			}
			
			System.out.printf("%.3f\n",BS());
			
		}
		
		in.close();
		System.exit(0);
	}
}