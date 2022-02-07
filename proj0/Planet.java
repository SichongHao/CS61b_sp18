public class Planet{
	/* Instance variable */
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	double mass;
	public String imgFileName;

	/* Constructor 1 */
	public Planet(double xP, double yP, double xV,
              double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	/* Constructor 2 */
	public Planet(Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	/* calculate distance */
	public double calcDistance(Planet p2){
		double distance;
		double xdis = this.xxPos - p2.xxPos;
		double ydis = this.yyPos - p2.yyPos;
		distance = Math.sqrt(xdis * xdis + ydis * ydis);
		return distance;
	}

	/* force exerted */
	public double calcForceExertedBy(Planet p){
		double force;
		force = 6.67e-11 * this.mass * p.mass / (this.calcDistance(p) * this.calcDistance(p));
		return force; 
	}

	public double calcForceExertedByX(Planet p){
		double dx = p.xxPos - this.xxPos;
		double forceX = this.calcForceExertedBy(p) * dx / this.calcDistance(p);
		return forceX;
	}

	public double calcForceExertedByY(Planet p){
		double dy = p.yyPos - this.yyPos;
		double forceY = this.calcForceExertedBy(p) * dy / this.calcDistance(p);
		return forceY;
	}

	/* calculate net X & Y force */
	public double calcNetForceExertedByX(Planet[] allp){
		double netX_sum = 0;
		for (int i = 0; i < allp.length; i = i + 1) {
			if (this.equals(allp[i])){
				continue;
			}
			double netX = this.calcForceExertedByX(allp[i]);
			netX_sum = netX_sum + netX; 
		}
		return netX_sum;
	}

		public double calcNetForceExertedByY(Planet[] allp){
		double netY_sum = 0;
		for (int i = 0; i < allp.length; i = i + 1) {
			if (this.equals(allp[i])){
				continue;
			}
			double netY = this.calcForceExertedByY(allp[i]);
			netY_sum = netY_sum + netY; 
		}
		return netY_sum;
	}

	/* update */
	public void update(double dt, double fX, double fY) {
		double a_netx = fX / this.mass;
		double a_nety = fY / this.mass;
		double v_x = this.xxVel + a_netx * dt;
		double v_y = this.yyVel + a_nety * dt;
		double p_x = this.xxPos + v_x * dt;
		double p_y = this.yyPos + v_y * dt;
		xxVel = v_x;
		yyVel = v_y;
		xxPos = p_x;
		yyPos = p_y; 
	}

	public void draw() {
		StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
	}

}