package com.prateek.Test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class App_Concurrent {
	public static void main(String[] args) throws InterruptedException {

//		Map<String, Integer> map = new HashMap<String, Integer>(); // this will cause concurrent modifcation exception
		Map<String,Integer>map = new ConcurrentHashMap<String, Integer>();
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);

		for (String s : map.keySet()) {
			if (s.equals("a")) {
				map.put("d", 45);
			}
		}

	}

}
