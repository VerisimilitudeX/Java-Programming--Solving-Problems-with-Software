import duke.*;
import csv.*;
public class CSVMax {
	public static CSVRecord hottestHourInFile(CSVParser parser) {
		// Start with largestSoFar as nothing
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

	public static void main(String[] args) {
		FileResource fr = new FileResource("data/2012/weather-2012-01-04.csv");
		CSVRecord largest = hottestHourInFile(fr.getCSVParser());
		System.out.println("hottest temperature was " + largest.get("TemperatureF") + " at " + largest.get("TimeEST"));
	}
}
