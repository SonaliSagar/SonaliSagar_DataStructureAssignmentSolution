package com.greatlearning.dsmain;

import java.util.*;

class MyComparator implements Comparator

{
	public int compare(Object obj1, Object obj2)

	{
		Integer i1 = (Integer) obj1;

		Integer i2 = (Integer) obj2;

		return i2.compareTo(i1);
	}
}

public class DriverSkyScrapperTower

{

	public static void main(String[] args)

	{
		System.out.println("enter the total no of floors in the building : ");
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int max = n;

		Queue<Integer> queue = new PriorityQueue<Integer>(new MyComparator());

		int disks[] = new int[n + 1];

		for (int i = 1; i <= n; i++)

		{
			System.out.println("enter the floor size given on day : " + i);
			disks[i] = sc.nextInt();

			queue.add(disks[i]);
		}
		System.out.println("The order of construction is as follows ");

		for (int i = 1; i <= n; i++) {
			System.out.println("Day : " + i);
			while (!queue.isEmpty() && queue.peek() == max) {
				if (queue.peek() < disks[i]) {
					break;
				} else {
					System.out.print(queue.poll() + " ");
				}
				max--;
			}

			System.out.println();
		}
	}
}