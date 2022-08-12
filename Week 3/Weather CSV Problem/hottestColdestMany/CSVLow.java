import duke.*;
import csv.*;
import java.io.*;

public class CSVLow {
	public static CSVRecord hottestHourInFile(CSVParser parser) {
		// start with largestSoFar as nothing
		CSVRecord largestSoFar = null;
		// For each row (currentRow) in the CSV File
		for (CSVRecord currentRow : parser) {
			// If largestSoFar is nothing
			if (largestSoFar == null) {
				largestSoFar = currentRow;
			}
			// Otherwise
			else {
				double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
				double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
				// Check if currentRow’s temperature > largestSoFar’s
				if (currentTemp > largestTemp) {
					// If so update largestSoFar to currentRow
					largestSoFar = currentRow;
				}
			}
		}
		// The largestSoFar is the answer
		return largestSoFar;
	}

	public static void testHottestInDay() {
		FileResource fr = new FileResource("data/2015/weather-2015-01-02.csv");
		CSVRecord largest = hottestHourInFile(fr.getCSVParser());
		System.out.println("hottest temperature was " + largest.get("TemperatureF") + " at " + largest.get("TimeEST"));
	}

	public static CSVRecord hottestInManyDays() {
		CSVRecord largestSoFar = null;
		DirectoryResource dr = new DirectoryResource();
		// iterate over files
		for (File f : dr.selectedFiles()) {
			FileResource fr = new FileResource(f);
			// use method to get largest in file.
			CSVRecord currentRow = hottestHourInFile(fr.getCSVParser());
			if (largestSoFar == null) {
				largestSoFar = currentRow;
			}
			// Otherwise
			else {
				double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
				double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
				// Check if currentRow’s temperature > largestSoFar’s
				if (currentTemp > largestTemp) {
					// If so update largestSoFar to currentRow
					largestSoFar = currentRow;
				}
			}
		}
		// The largestSoFar is the answer
		return largestSoFar;
	}

	public static CSVRecord coldestHourInFile(CSVParser parser) {
		CSVRecord lowestInFile = null;
		for (CSVRecord currentRow : parser) {
			if (lowestInFile == null) {
				lowestInFile = currentRow;
			} else {
				double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
				double lowestTemp = Double.parseDouble(lowestInFile.get("TemperatureF"));
				if (currentTemp < lowestTemp && currentTemp != -9999) {
					lowestInFile = currentRow;
				}
			}
		}
		return lowestInFile;
	}

	public static CSVRecord fileWithColdestTemperature() {
		CSVRecord lowestSoFar = null;
		DirectoryResource dr = new DirectoryResource();
		for (File f : dr.selectedFiles()) {
			FileResource fr = new FileResource(f);
			CSVRecord cr = coldestHourInFile(fr.getCSVParser());
			if (cr != null) {
				lowestSoFar = cr;
			}
			double currentTemp = Double.parseDouble(cr.get("TemperatureF"));
			double lowestTemp = Double.parseDouble(lowestSoFar.get("TemperatureF"));
			if (currentTemp < lowestTemp) {
				lowestTemp = currentTemp;
			}
		}
		return lowestSoFar;
	}

	public static CSVRecord lowestHumidityInFile(CSVParser parser) {
		CSVRecord lowestHumiditySoFar = null;
		for (CSVRecord currentRow : parser) {
			if (lowestHumiditySoFar == null) {
				lowestHumiditySoFar = currentRow;
			} else if (currentRow.get("Humidity") == "N/A") {
				continue;
			}
			double currentHumidity = Double.parseDouble(currentRow.get("Humidity"));
			double lowestHumidity = Double.parseDouble(lowestHumiditySoFar.get("Humidity"));
			if (currentHumidity < lowestHumidity) {
				lowestHumidity = currentHumidity;

			}
		}
		return lowestHumiditySoFar;
	}
	public static CSVRecord lowestHumidityInManyFiles() {
		CSVRecord lowestSoFar = null;
		DirectoryResource dr = new DirectoryResource();
		for (File f : dr.selectedFiles()) {
			FileResource fr = new FileResource(f);
			CSVRecord cr = new CSVRecord(fr.get)
			if (lowestSoFar == null) {
				l
			} 
		}
	}

	public static void main(String[] args) {
		CSVRecord largest = hottestInManyDays();
		System.out.println("Hottest temperature was " + largest.get("TemperatureF") + " at " + largest.get("DateUTC"));

		CSVRecord lowest = fileWithColdestTemperature();
		System.out.println("Coldest temperature was " + lowest.get("TemperatureF") + " at " + lowest.get("TimeEST"));

		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser();
		CSVRecord csv = lowestHumidityInFile(parser);
		System.out.println("Lowest humidity was " + csv.get("Humidity") + " at " + csv.get("DateUTC"));
	}
}
