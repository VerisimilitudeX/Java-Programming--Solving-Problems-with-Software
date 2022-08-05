// This class provides methods for accessing a web page. You can create a URLResource by giving it a complete 
// URL, or web address (note, it must start with either http:// or https://):
import edu.duke.URLResource;
import java.util.Scanner;

// This class finds all the YouTube videos in a web page and returns the URLs of the videos.
public class Part4 {
    public static void returnYouTubeLinks() {
        Scanner ur = new Scanner(System.in);
        System.out.println("Enter the URL of the document you want to search within: ");
        String URL = ur.nextLine();
        ur.close();
        System.out.println("----------------------------------------------------");
        URLResource resource = new URLResource(URL);
        for (String word : resource.words()) {
            String wordl = word.toLowerCase();
            int index = wordl.indexOf("youtube.com");
            if (index != -1) {
                int start = word.indexOf("\"", index - 13);
                int stop = word.indexOf("\"", index);
                System.out.println(word.substring(start + 1, stop));
            }
        }
    }
    public static void main(String[] args) {
         returnYouTubeLinks();
    }
}