
/**
 * Print out total number of babies born, as well as for each gender, in a given CSV file of baby name data.
 * 
 * @author Duke Software Team 
 */
import duke.*;

import java.io.File;

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

	public static int getRank(int year, String name, String gender) {
		int rank = 0;
		FileResource fr = new FileResource("data/yob" + year + ".csv");
		for (CSVRecord currentRow : fr.getCSVParser()) {
			if (currentRow.get(1).equals(gender)) {
				rank++;
			}
			if (currentRow.get(0).equals(name) && currentRow.get(1).equals(gender)) {
				return rank;
			}
		}
		return -1;
	}

	public static String getName(int year, int rank, String gender) {
		int count = 0;
		FileResource fr = new FileResource("data/yob" + year + ".csv");
		for (CSVRecord currentRow : fr.getCSVParser()) {
			if (currentRow.get(1).equals(gender)) {
				count++;
			}
			if (currentRow.get(1).equals(gender) && count == rank) {
				return currentRow.get(0);
			}
		}
		return "No name found";
	}

	public static String whatIsNameInYear(String name, int year, int newYear, String gender) {
		int rank = getRank(year, name, gender);
		String newName = getName(newYear, rank, gender);
		if (newName != null) {
			return newName;
		} else {
			return "No name found";
		}
	}

	public static int yearOfHighestRank(String name, String gender) {
		DirectoryResource dr = new DirectoryResource();
		int highestRankSoFar = 999999999;
		int rank = 0;
		for (File f : dr.selectedFiles()) {
			FileResource fr = new FileResource(f);
			for (CSVRecord currentRow : fr.getCSVParser()) {
				if (currentRow.get(1).equals(gender)) {
					rank++;
				}
				if (currentRow.get(0).equals(name) && currentRow.get(1).equals(gender)) {
					if (rank < highestRankSoFar) {
						highestRankSoFar = rank;
					}
				}
			}
			rank = 0;
		}
		return highestRankSoFar;
	}

	public static double getAverageRank(String name, String gender) {
		DirectoryResource dr = new DirectoryResource();
		double sumRank = 0;
		int fileCount = 0;
		int currRank = 0;
		for (File f : dr.selectedFiles()) {
			fileCount++;
			FileResource fr = new FileResource(f);
            for (CSVRecord currentRow : fr.getCSVParser()) {
				if (currentRow.get(1).equals(gender)) {
					currRank++;
					if (currentRow.get(0).equals(name)) {
						sumRank += currRank;
					}
				}
			}
			currRank = 0;
		}
		return (int)(sumRank / fileCount);
	}
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println("");
		}
		// FileResource fr = new FileResource();
		FileResource fr = new FileResource("data/yob2014.csv");
		totalBirths(fr);
		System.out.println("");
		System.out.println("The rank is " + getRank(2007, "Piyush", "M"));
		System.out.println(getName(2012, 45, "M"));
		System.out.println("Your name in 2004 would be: " + whatIsNameInYear("Piyush", 2007, 2004, "M") +".");
		System.out.println(yearOfHighestRank("Piyush", "M"));
		System.out.println("The average rank of the name is: " + getAverageRank("Mason", "M"));
	}
}