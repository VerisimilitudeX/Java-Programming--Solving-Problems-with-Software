// Module provided by Duke University and is used for the purpose of this course.
// I have added the code for this class to this GitHub repository.
import java.io.File;
import edu.duke.*;

public class PerimeterRunner {
    // Calculate the perimeter of a shape
    public double getPerimeter (Shape s) {
        double totalPerim = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            totalPerim = totalPerim + currDist;
            prevPt = currPt;
        }
        return totalPerim;
    }
    
    // Return the number of points in Shape s.
    public int getNumPoints(Shape s) {
        int count = 0;
        for (Point pt : s.getPoints()) {
            count = count + 1;
        }
        return count;
    }
    
    // Find the average length of the sides in Shape s.
    public double getAverageLength(Shape s) {
        double totalPerim = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            totalPerim = totalPerim + currDist;
            prevPt = currPt;
        }
        int numpoints = 0;
        for (Point pt : s.getPoints()) {
            numpoints = numpoints + 1;
        }
        double avglen = totalPerim / numpoints;
        return avglen;
    }

    // Find a shape's largest side.
    public double getLargestSide(Shape s) {
        Point prevPt = s.getLastPoint();
        double maxLen = 0.0;
        for (Point currPt : s.getPoints()) {
            double currLen = currPt.distance(prevPt);
            if (currLen > maxLen) {
                maxLen = currLen;
            }
            currPt = prevPt;
        }
        return maxLen;
    }
    
    // Find a shape's largest X coordinate value.
    public double getLargestX(Shape s) {
        double largestX = 0.0;
        for (Point currPt : s.getPoints()) {
            double currX = currPt.getX();
            if (currX > largestX) {
                largestX = currX;
            }
        }
        return largestX;
    }

    // Find the largest perimeter of all shapes selected by the user.
    public double getLargestPerimeterMultipleFiles() {
        DirectoryResource dr = new DirectoryResource();
        double largestPerim = 0.0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currPerim = getPerimeter(s);
            if (currPerim > largestPerim) {
                largestPerim = currPerim;
            }
        }
        return largestPerim;
    }

    // Returns the name of the shape with the largest perimeter.
    public String getFileWithLargestPerimeter() {
        DirectoryResource dr = new DirectoryResource();
        double largestPerim = 0.0;
        String nameOfLargetPerim = "";
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currPerim = getPerimeter(s);
            if (currPerim > largestPerim) {
                largestPerim = currPerim;
                nameOfLargetPerim = f.getName();
            }
        }
        return nameOfLargetPerim;
    }

    // Used to call all the methods present in this list for Shape s.
    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("Perimeter: " + length);
        int numofpoints = getNumPoints(s);
        System.out.println("Number of points: " +  numofpoints);
        double avglen = getAverageLength(s);
        System.out.println("Average length: " + avglen);
        double largestSide = getLargestSide(s);
        System.out.println("Longest side: " + largestSide);
        double largestX = getLargestX(s);
        System.out.println("Largest X coordinate value: " + largestX);
    }

    // Used to call all the methods present in this list for Shape s (multiple files).
    public void testPerimeterMultipleFiles() {
        double largestPerim = getLargestPerimeterMultipleFiles();
        System.out.println("Largest perimeter: " + largestPerim);
        String nameOfLargetPerim = getFileWithLargestPerimeter();
        System.out.println("File with largest perimeter: " + nameOfLargetPerim);
    }
     
    public void testFileWithLargestPerimeter() {
        String nameOfLargetPerim = getFileWithLargestPerimeter();
        System.out.println("File with largest perimeter: " + nameOfLargetPerim);
    }
    // Main method
    public static void main (String[] args) {
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
        // pr.testFileWithLargestPerimeter();
    }
}