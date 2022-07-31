import edu.duke.*;

public class PerimeterRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }
    
    public int getNumPoints(Shape s) {
        int count = 0;
        
        for (Point pt : s.getPoints()) {
            count = count + 1;
        }
        
        return count;
    }
    
    public double getAverageLength(Shape s) {
        // Get perimeter
        double totalPerim = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            totalPerim = totalPerim + currDist;
            prevPt = currPt;
        }
        // Get the number of points
        int numpoints = 0;
        for (Point pt : s.getPoints()) {
            numpoints = numpoints + 1;
        }
        // Find the average length of the points in Shape s
        double avglen = totalPerim / numpoints;
        return avglen;
    }

    public double getLargestSide(Shape s) {
        // Find the largest side of the shape
        Point prevPt = s.getLastPoint();
        double maxLen = 0.0;
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            double currLen = currPt.distance(prevPt);
            if (currLen > maxLen) {
                maxLen = currLen;
            }
            currPt = prevPt;
        }
        // Return the largest side
        return maxLen;
    }
    
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
        System.out.println("Largest side: " + largestSide);
    }

    public static void main (String[] args) {
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeter();
    }
}
