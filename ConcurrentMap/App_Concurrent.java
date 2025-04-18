package com.prateek.Test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class App_Concurrent {
	public static void main(String[] args) throws InterruptedException {
		Map<Integer, String> map = new ConcurrentHashMap<>();
     map.put(1, "a");
     map.put(2, "b");
     map.put(3, "c");
     
     Thread t1 = new Thread(()->
     {
    	for(Entry<Integer, String>e:map.entrySet())
    	{
    	
    		try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		System.out.println("key Val "+e.getKey()+" value --->"+e.getValue());
    		
    	}
    	 
     });

     Thread t2 = new Thread(()->
     {
    		try {
				Thread.sleep(45);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
       	 map.put(45, "ty");

    		
    	
    	 
     });
t1.start();
t2.start();
	
	}
	
	public  static <T>int findLength (T[]arr)
	{
		
		return arr.length;
	}
	public static  int minOperations(int[] nums, int k) {
	     
        int firstMax,secondMax,i;
        firstMax = -1;
secondMax = firstMax;
for(int x:nums)
{
    if(x>firstMax)
    {
        secondMax=firstMax;
        firstMax =  Math.max(firstMax,x);

    } 
    else
    {
    	secondMax =  Math.max(secondMax, x);
    }
}
for(i=0;i<nums.length;i++)
{
    if(nums[i]==firstMax)
    {
        nums[i]=secondMax;
    }
    if(nums[i]<k)
    {
        return -1;
    }
}
Map<Integer,Long>map =  		Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));		
	long z =  map.entrySet().stream().map(e->e.getKey()).filter(x->x>k).count();
    return (int)z;
    }

}
