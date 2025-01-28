package com.collections;
import java.util.*;

public class ArrasyList {

	public static void main(String[] args) {
		ArrayList<String> l=new ArrayList<String>();
		l.add("Rohith");
		l.add("Mahesh");
		l.add("NTR");
		Iterator Itr=l.iterator();
		while(Itr.hasNext()) {
			System.out.println(Itr.next());
		}
		
		

	}

}
