// Reads a chosen CSV file of country exports and performs actions on it as defined by the methods below.
import edu.duke.*;
import org.apache.commons.csv.*;
import java.util.Scanner;

public class WhichCountriesExport {
	public static void listExporters(CSVParser parser, String exportOfInterest) {
		// For each row in the CSV File
		for (CSVRecord record: parser) {
			// Look at the "Exports" column
			String export = record.get("Exports");
			// Check if it contains exportOfInterest
			if (export.contains(exportOfInterest)) {
				// If so, write down the "Country" from that row
				String country = record.get("Country");
				System.out.println(country);
			}
		}
	}
	public static void countryInfo(CSVParser parser, String country) {
		String info = "";
		for (CSVRecord record: parser) {
			if (record.get("Country").equals(country)) {
				info += (record.get("Country") + ": " + record.get("Exports") + ": " + record.get("Value (dollars)"));
			}
		}
		if (info.length() == 0) {
			System.out.println("NOT FOUND");
		} else {
			System.out.println(info);
		}
	}
	public static void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
		for (CSVRecord record: parser) {
			String export = record.get("Exports");
			if (export.contains(exportItem1) && export.contains(exportItem2)) {
				String country = record.get("Country");
				System.out.println(country);
			}
		}
	}
	public static void numberOfExporters(CSVParser parser, String exportitem) {
		int count = 0;
		for (CSVRecord item: parser) {
			String
			export = item.get("Exports");
			if ((export.toLowerCase()).contains(exportitem.toLowerCase())) {
				count++;
			}
		}
		System.out.println(count);
	}
	public static void bigExporters(CSVParser parser, String amount) {
		for (CSVRecord item: parser) {
			String value = item.get("Value (dollars)");
			if (value.length() > amount.length()) {
				System.out.println(item.get("Country") + ": " + value);
			}
		}
	}
	public static void main(String[] args) {

		// Gets the country name from the user
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a country: ");
		String country = sc.nextLine();
		sc.close();

		// Prints the country info based on the user input
		countryInfo(parser, country);
		System.out.println();

		// Prints a list of countries that export both items
		parser = fr.getCSVParser();
		listExportersTwoProducts(parser, "fish", "nuts");
		System.out.println();

		// Prints the number of countries that export the item
		parser = fr.getCSVParser();
		numberOfExporters(parser, "sugar");
		System.out.println();

		// Prints the list of countries that have a value greater than the one specified.
		parser = fr.getCSVParser();
		bigExporters(parser, "$999,999,999,999");
		System.out.println();
	}
}