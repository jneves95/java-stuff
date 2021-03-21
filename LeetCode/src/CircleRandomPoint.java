
/*
 * y^2 = r^2 - x^2
 * -Math.sqrt(Math.pow(r, 2) - Math.pow(x, 2)) <= y <= Math.sqrt(Math.pow(r, 2) - Math.pow(x, 2))
 */
public class CircleRandomPoint {
	
	double RAD, X, Y;
	
	public CircleRandomPoint(double radius, double x_center, double y_center) {
		RAD = radius;
		X = x_center;
		Y = y_center;
	}
		
	public double[] randPoint() {
		double ang = Math.random() * 2 * Math.PI;
		double hyp = Math.random() * RAD;
		double x = X + Math.cos(ang) * hyp;
		double y = Y + Math.sin(ang) * hyp;
		
		return new double[] {x, y};
	}
	
	public static void main(String[] args) {
		CircleRandomPoint crp = new CircleRandomPoint(10, 5, -7.5);
		
		for (int i = 0; i < 10; i++) {
			System.out.println("Test " + i + ":");
			
			double[] result = crp.randPoint();
			
			for (double d : result) {
				System.out.println(d);
			}
			
			System.out.println();
		}
		
	}

}
