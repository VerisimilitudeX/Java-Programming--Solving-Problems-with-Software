
/**
 * Print out total number of babies born, as well as for each gender, in a given CSV file of baby name data.
 * 
 * @author Duke Software Team 
 */
import duke.*;
import csv.*;

public class BabyBirths {
	public static void printNames() {
		FileResource fr = new FileResource();
		for (CSVRecord rec : fr.getCSVParser(false)) {
			int numBorn = Integer.parseInt(rec.get(2));
			if (numBorn <= 100) {
				System.out.println("Name " + rec.get(0) +
						" Gender " + rec.get(1) +
						" Num Born " + rec.get(2));
			}
		}
	}

	public static void totalBirths(FileResource fr) {
		int totalBirths = 0;
		int totalBoys = 0;
		int totalGirls = 0;
		for (CSVRecord rec : fr.getCSVParser(false)) {
			int numBorn = Integer.parseInt(rec.get(2));
			totalBirths += numBorn;
			if (rec.get(1).equals("M")) {
				totalBoys += numBorn;
			} else {
				totalGirls += numBorn;
			}
		}
		System.out.println("total births = " + totalBirths);
		System.out.println("female girls = " + totalGirls);
		System.out.println("male boys = " + totalBoys);
	}

	public static String getRank(int year, String name, String gender) {
		int rank = 0;
		FileResource fr = new FileResource("data/yob" + year + ".csv");
		for (CSVRecord currentRow : fr.getCSVParser()) {
			if (currentRow.get(1).equals(gender)) {
				rank++;
			}
			if (currentRow.get(0).equals(name) && currentRow.get(1).equals(gender)) {
				return "The rank of " + name + " in " + year + " is " + rank;
			}
		}
		return "The name " + name + " was not found in " + year;
	}

	public static String getName(int year, int rank, String gender) {
		int name = 0;
		int count = 0;
        FileResource fr = new FileResource("data/yob" + year + ".csv");
        for (CSVRecord currentRow : fr.getCSVParser()) {
			if (currentRow.get(1) == gender) {
				count++;
			}			
			if (currentRow.get(1).equals(gender) && count == rank) {
				return "The name at rank " + rank + " in " + year + " is " + currentRow.get(0);
			}
		}
		return "No name found";

		}
	public static void main(String[] args) {
		// FileResource fr = new FileResource();
		FileResource fr = new FileResource("data/yob2014.csv");
		totalBirths(fr);
		
		System.out.println(getRank(2007, "Piyush", "M"));
		
		System.out.println(getName(2012, 45, "M"));
	}
}