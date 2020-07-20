package com.epam.mavendemo;
import java.util.*;
public class NewYearGiftAnalysis {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Choclate> choclate = new ArrayList<Choclate>();
	static ArrayList<Choclate> candies = new ArrayList<Choclate>();
	static ArrayList<Sweets> sweets = new ArrayList<Sweets>();
	static HashMap<String,Integer> nameToWeight = new HashMap<String,Integer>();
	static HashMap<String,Integer> nameToPrice = new HashMap<String,Integer>();

	

	public static void main(String[] args) {
		inputChoclates();
		inputSweets();
		System.out.println("Total weights of git is"+calculateTotalWeight());
		System.out.println("Choose the way to sort(Enter the number):1 By price 2. By Weight");
		int sortType = sc.nextInt();
		if(sortType == 1) {
			Comparator<Choclate> compareByPrice = (Choclate c1,Choclate c2)->((Integer) c1.getPrice()).compareTo(c2.getPrice());
			Collections.sort(choclate,compareByPrice);
			System.out.println("The sorted result :");
			for(Choclate choc:choclate) {
				System.out.println(choc.getPrice());
			}
		}else {
			Comparator<Choclate> compareByWeight = (Choclate c1,Choclate c2)->((Integer) c1.getWeight()).compareTo(c2.getWeight());
			Collections.sort(choclate,compareByWeight);
			System.out.println("The sorted result :");
			for(Choclate choc:choclate) {
				System.out.println(choc.getWeight());
			}
			
		}
		calcRange(sortType);
	}
    private static void calcRange(int sortType) {
		System.out.println("lets find the range");
		int lowerLimit,higherLimit;
		if(sortType ==1) {
			System.out.println("Enter the lower limit of price");
			lowerLimit = sc.nextInt();
			System.out.println("Enter the Higher limit of price");
			higherLimit = sc.nextInt();
			Set<Map.Entry<String,Integer>> candySet = nameToPrice.entrySet();
			Iterator<Map.Entry<String,Integer>> candyIterator = candySet.iterator();
			while(candyIterator.hasNext()) {
				Map.Entry candyElement = (Map.Entry)candyIterator.next();
				int currentprice = (int) candyElement.getValue();
				if(currentprice>=lowerLimit &&currentprice <= higherLimit ) {
					System.out.println(candyElement.getKey());
				}
			}
		}else {
			System.out.println("Enter the lower limit of weight");
			lowerLimit = sc.nextInt();
			System.out.println("Enter the Higher limit of weight");
			higherLimit = sc.nextInt();
			Set<Map.Entry<String,Integer>> candySet = nameToWeight.entrySet();
			Iterator<Map.Entry<String,Integer>> candyIterator = candySet.iterator();
			while(candyIterator.hasNext()) {
				Map.Entry candyElement = (Map.Entry)candyIterator.next();
				int currentweight = (int) candyElement.getValue();
				if(currentweight>=lowerLimit &&currentweight <= higherLimit ) {
					System.out.println(candyElement.getKey());
				}
			}
			
		}
		
	}
	private static int calculateTotalWeight() {
		int total = 0;
		for(Choclate choco:choclate) {
			total += choco.getWeight();
			
		}
		for(Sweets sweet :sweets) {
			total += sweet.getWeight();
		}
		return total;
	}



	private static void inputSweets() {
		System.out.print("Enter no of sweets:");
		int noSweets = sc.nextInt();
		for(int i = 1;i<=noSweets;i++) {
			System.out.println("Enter type of sweet(Enter the number):1.kaajukatli 2.gulabjam ");
			System.out.print("Enter weight of sweet");
			int sweetWeight = sc.nextInt();
			System.out.println("Enter price of sweet");
			int sweetPrice = sc.nextInt();
			Sweets sweet = new Sweets(sweetWeight,sweetPrice);
			sweets.add(sweet);
		}
	}

    private static void inputChoclates() {
		System.out.print("Enter no of choclates:");
		int noChoclates = sc.nextInt();
		for(int i = 1;i<=noChoclates;i++) {
			System.out.println("Enter type of choclate(Enter the number):1.candy 2.Wafer ");
			int chocoType = sc.nextInt();
			System.out.print("Enter weight of choclate");
			int chocoWeight = sc.nextInt();
			System.out.println("Enter price of choclate");
			int chocoPrice = sc.nextInt();
			if(chocoType == 1) {
				System.out.println("Enter the name of candy:");
				String candyName = sc.next();
				if(nameToWeight.containsKey(candyName))
					nameToWeight.put(candyName,(int)nameToWeight.get(candyName)+chocoWeight);
				else
					nameToWeight.put(candyName, chocoWeight);
				if(nameToPrice.containsKey(candyName))
					nameToPrice.put(candyName,(int)nameToWeight.get(candyName)+chocoPrice);
				else
					nameToPrice.put(candyName, chocoPrice);
				Candy candy = new Candy(chocoPrice,chocoWeight,candyName);
			}else {
				System.out.println("Enter the name of wafer:");
				String waferName = sc.next();
				if(nameToWeight.containsKey(waferName))
					nameToWeight.put(waferName,(int)nameToWeight.get(waferName)+chocoWeight);
				else
					nameToWeight.put(waferName, chocoWeight);
				if(nameToPrice.containsKey(waferName))
					nameToPrice.put(waferName,(int)nameToWeight.get(waferName)+chocoPrice);
				else
					nameToPrice.put(waferName, chocoPrice);
				Wafer wafer = new Wafer(chocoPrice,chocoWeight,waferName);
			}
			Choclate choco = new Choclate(chocoPrice,chocoWeight);
			choclate.add(choco);
			
		}
		
	}

}
