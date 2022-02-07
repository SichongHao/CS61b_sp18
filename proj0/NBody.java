public class NBody {

	public static double readRadius(String filePath) {
		In in = new In(filePath);
		int numPlanet = in.readInt();
		double radius = in.readDouble();

		return radius;
	}

	public static Planet[] readPlanets(String filePath) {
		In in = new In(filePath);
		int numPlanet = in.readInt();
		double radius = in.readDouble();

		Planet[] planets = new Planet[numPlanet];

		for (int i = 0; i < planets.length; i = i + 1) {
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String imgFileName = in.readString();	
			planets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
		}

		return planets;
	}

	public static void main(String[] args) {
		/* collect input information */
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		/* read file */
		Planet[] planets = readPlanets(filename);
		double radius = readRadius(filename);

		StdDraw.setScale(-radius, radius);
		StdDraw.enableDoubleBuffering();
		StdDraw.clear();
		StdDraw.picture(0, 0, "images/starfield.jpg");
		
		double[] xForce = new double[planets.length];
		double[] yForce = new double[planets.length];

		for (double t = 0; t < T; t += dt) {

			for (int i = 0; i < planets.length; i += 1) {
				xForce[i] = planets[i].calcNetForceExertedByX(planets);
				yForce[i] = planets[i].calcNetForceExertedByY(planets);
			}

			for (int i = 0; i < planets.length; i += 1) {
				planets[i].update(dt, xForce[i], yForce[i]);
			}

			for (Planet p: planets){
				p.draw();
			}

			StdDraw.show();
			StdDraw.pause(10);
		}

		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
}

	}

}