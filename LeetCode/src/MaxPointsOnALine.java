import java.util.ArrayList;
import java.util.Collections;


public class MaxPointsOnALine {
	class Point {
		int x;
		int y;
		Point() {
			x = 0;
			y = 0;
		}
		Point(int a, int b) {
			x = a;
			y = b;
		}
	}
	public int maxPoints(Point[] points) {
        int num = points.length;
        int max = 2;
        if (num == 0) {
        	return 0;
        }
        if (num == 1) {
        	return 1;
        }
        if (num == 2) {
        	return 2;
        }
        Point a;
        Point b;
        int sameCount = 0;
        int vertCount = 0;
        ArrayList<Double> temp = new ArrayList<Double>();
        for (int i = 0; i < num - 2; i++) {
        	a = points[i];
        	for (int j = i + 1; j < num; j++) {
        		System.out.println("i = " + i + "; j = " + j);
        		b = points[j];
        		if (a.x == b.x) {
        			if (a.y == b.y) {
        				sameCount++;
        			}
        			else {
        				vertCount++;
        			}
        		}
        		else {
        			temp.add(slope(a, b));
        		}
        	}
        	int count = 1;
        	int maxSameSlope = 1;
        	int thisMax = 1;
        	if (temp.size() == 0) {
        		System.out.println("temp size == 0");
        		thisMax = Math.max(sameCount, vertCount);
        		max = Math.max(thisMax + 1, max);
        		continue;
        	}
        	Collections.sort(temp);
        	System.out.println("temp:" + temp.toString());
        	
        	for (int k = 1; k < temp.size(); k++) {
        		if (temp.get(k).equals(temp.get(k - 1))) {
        			//System.out.println("count++");
        			count++;
        		}
        		else {
        			maxSameSlope = count > maxSameSlope ? count : maxSameSlope;
        			count = 1;
        		}
        	}
        	if (count > maxSameSlope) {
        		maxSameSlope = count;
        	}
        	System.out.println("count = " + count + "; thisMax = " + thisMax + "; maxsameslope = " + maxSameSlope);
        	thisMax = Math.max(maxSameSlope,vertCount);
        	thisMax += sameCount;
        	max = Math.max(max, thisMax + 1);
        	temp.clear();
        	sameCount = 0;
        	vertCount = 0;
        	//System.out.println("thisMax = " + thisMax);
        }
        return max;
    }
	
	public double slope(Point a, Point b) {
		//note: Double(0.0).equals(Double(-0.0)) = false;
		if (b.y - a.y == 0) {
			return (double)0.0;
		}
		return (double)(b.y - a.y) / (double)(b.x - a.x);
	}
	
	public void test() {
		/*
		Point [] points = new Point[9];
		points[0] = new Point(84,250);
		points[1] = new Point(0,0);
		points[2] = new Point(1,0);
		points[3] = new Point(0,-70);
		points[4] = new Point(0,-70);
		points[5] = new Point(1,-1);
		points[6] = new Point(21,10);
		points[7] = new Point(42,90);
		points[8] = new Point(-42,-230);
		*/
		Point[] points = new Point[3];
		points[0] = new Point(2,3);
		points[1] = new Point(3,3);
		points[2] = new Point(-5,3);
		System.out.println(maxPoints(points));
	}
}
