
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
		int totalNamesBoys = 0;
		int totalNamesGirls = 0;
		for (CSVRecord rec : fr.getCSVParser(false)) {
			int numBorn = Integer.parseInt(rec.get(2));
			totalBirths += numBorn;
			if (rec.get(1).equals("M")) {
				totalBoys += numBorn;
				totalNamesBoys++;
			} else {
				totalGirls += numBorn;
				totalNamesGirls++;
			}
		}
		System.out.println("total births = " + totalBirths);
		System.out.println("female girls = " + totalGirls);
		System.out.println("male boys = " + totalBoys);
		System.out.println("Boys' names = " + totalNamesBoys);
		System.out.println("Girls' names = " + totalNamesGirls);
	}

	// Given a year, read a file containing the year.
	// Read all rows in the file, if gender is matched, keep a count.
	// If gender and name are matched, then return the count.
	public static int getRank(int year, String name, String gender) {
		int rank = 0;
		int toReturn = 0;
		FileResource fr = new FileResource("data/yob" + year + ".csv");
		for (CSVRecord currentRow : fr.getCSVParser()) {
			if (currentRow.get(1).equals(gender)) {
				rank++;
			}
			if (currentRow.get(0).equals(name) && currentRow.get(1).equals(gender)) {
				toReturn = rank;
				break;
			}
		}
		if (toReturn != 0) {
			return toReturn;
		} else {
			return -1;
		}
	}

	public static String getName(int year, int rank, String gender) {
		int count = 0;
		String x = null;
		FileResource fr = new FileResource("data/yob" + year + ".csv");
		for (CSVRecord currentRow : fr.getCSVParser()) {
			if (currentRow.get(1).equals(gender)) {
				count++;
			}
			if (currentRow.get(1).equals(gender) && count == rank) {
				x = currentRow.get(0);
			}
		}
		if (x != null) {
			return x;
		} else {
			return "NO NAME";
		}
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

	public static String yearOfHighestRank(String name, String gender) {
		DirectoryResource dr = new DirectoryResource();
		int highestRankSoFar = 999999999;
		String year = "";
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
						if (year != f.getName().substring(3, 7)) {
							year = f.getName().substring(3, 7);
						}
					}
				}
			}
			rank = 0;
		}
		return highestRankSoFar + " in the year " + year;
	}

	public static double getAverageRank(String name, String gender) {
		DirectoryResource dr = new DirectoryResource();
		double sumRank = 0;
		int fileCount = 0;
		for (File f : dr.selectedFiles()) {
			int genderMatched = 0;
			FileResource fr = new FileResource(f);
			for (CSVRecord currentRow : fr.getCSVParser()) {
				if (currentRow.get(1).equals(gender)) {
					genderMatched++;
					if (currentRow.get(0).equals(name)) {
						sumRank += genderMatched;
						break;
					}
				}
			}

			if (genderMatched > 0) {
				fileCount++;
			}
		}

		return (sumRank / fileCount);
	}
	public static int getTotalBirthsRankedHigher(int year, String name, String gender) {
		int totalBirths = 0;
		int rank = getRank(year, name, gender);
	}
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println("");
		}
		// FileResource fr = new FileResource();
		FileResource fr = new FileResource("data/yob1905.csv");
		totalBirths(fr);
		System.out.println("");
		System.out.println("Rank: " + getRank(1960, "Emily", "F"));
		System.out.println("Name: " + getName(1982, 450, "M"));
		System.out.println("Your name would be: " + whatIsNameInYear("Owen", 1974, 2014, "M"));
		System.out.println("Highest rank: " + yearOfHighestRank("Genevieve", "F"));
		System.out.println("Average rank: " + getAverageRank("Susan", "F"));
	}
}