package javaInterview.question.concurrentMAp;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class App {
	public static void main(String[] args) throws InterruptedException  {
//      Map<Integer, String> map = new HashMap<>(); //	This will create an exception as we are trying to iterate and modify the map at the same time
	      Map<Integer, String> map = new ConcurrentHashMap<>();
	        map.put(1, "A");
	        map.put(2, "B");
	        map.put(3, "C");

	        // Thread 1: Iterating over the HashMap
	        Thread thread1 = new Thread(() -> {
	            try {
	                for (Map.Entry<Integer, String> entry : map.entrySet()) {
	                    System.out.println("Iterating: " + entry.getKey() + " -> " + entry.getValue());
	                    Thread.sleep(100); // Simulate some processing time
	                }
	            } catch (Exception e) {
	                System.out.println("Exception in thread1: " + e);
	            }
	        });

	        // Thread 2: Modifying the HashMap
	        Thread thread2 = new Thread(() -> {
	            try {
	                Thread.sleep(50); // Ensure modification happens while iteration is in progress
	                map.put(4, "D");  // This modification will cause ConcurrentModificationException
	                System.out.println("Added new element (4, D)");
	            } catch (Exception e) {
	                System.out.println("Exception in thread2: " + e);
	            }
	        });

	        thread1.start();
	        thread2.start();
        
	}

}
