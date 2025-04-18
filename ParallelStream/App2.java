package com.prateek.Test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import com.prateek.Test3.Test3;

public class App2  extends Test3{
	private static int counter = 0;
	public static void main(String[] args) throws InterruptedException {
		
		List<Integer>list = new ArrayList<Integer>();
		long starttime,endTime;
for(int i=0;i<60000;i++)
{
	list.add(i+1);
}
starttime = System.currentTimeMillis();
//list.stream().map(App2::factorial).collect(Collectors.toList()); normal stream 
list.parallelStream().map(App2::factorial).collect(Collectors.toList());
endTime = System.currentTimeMillis();
System.out.println("totalTime Taken is "+(endTime-starttime));

	}
	
	public static int factorial(int x)
	{
		int fact =1;
		while(x>1)
		{
			fact = fact*x;
			x--;
		}
		return fact;
	}
		
}
