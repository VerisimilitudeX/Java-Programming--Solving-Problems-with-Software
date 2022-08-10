// Reads a chosen CSV file of our preferences and prints each field.
import edu.duke.FileResource;

import org.apache.commons.csv.*;

public class FirstCSVExample {
	public void readFood() {
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser();
		for (CSVRecord record : parser){
			System.out.print(record.get("Name") + " ");
			System.out.print(record.get("Favorite Color") + " ");
			System.out.println(record.get("Favorite Food"));
		}
	}
	public static void main(String[] args) {
		(new FirstCSVExample()).readFood();
	}
}
