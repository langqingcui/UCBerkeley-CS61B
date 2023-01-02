public class Planet {
    public double xxPos, yyPos, xxVel, yyVel, mass;
    public String imgFileName;

    private static final double G = 6.67e-11;

    public Planet(double xp, double yp, double xV, double yV, double m, String img) {
        xxPos = xp;
        yyPos = yp;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double r = Math.sqrt((this.xxPos - p.xxPos) * (this.xxPos - p.xxPos) 
                    + (this.yyPos - p.yyPos) * (this.yyPos - p.yyPos));
        return r;
    }

    public double calcForceExertedBy(Planet p) {
        double r = calcDistance(p);
        return G * this.mass * p.mass / (r * r);
    }

    public double calcForceExertedByX(Planet p) {
        double f = this.calcForceExertedBy(p);
        double r = this.calcDistance(p);
        double fx = (f * (p.xxPos - this.xxPos)) / r;
        return fx;
    }

    public double calcForceExertedByY(Planet p) {
        double f = this.calcForceExertedBy(p);
        double r = this.calcDistance(p);
        double fy = (f * (p.yyPos - this.yyPos)) / r;
        return fy;
    }

    public double calcNetForceExertedByX(Planet[] allPlanets) {
        double netForceX = 0;
        for (Planet planet : allPlanets) {
            if (this.equals(planet)) {
                continue;
            } else {
                netForceX += this.calcForceExertedByX(planet);
            }
        }
        return netForceX;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets) {
        double netForceY = 0;
        for (Planet planet : allPlanets) {
            if (this.equals(planet)) {
                continue;
            } else {
                netForceY += this.calcForceExertedByY(planet);
            }
        }
        return netForceY;
    }

    public void update(double dt, double fX, double fY) {
        double aX = fX / this.mass;
        double aY = fY / this.mass;
        this.xxVel += dt * aX;
        this.yyVel += dt * aY;
        this.xxPos += dt * this.xxVel;
        this.yyPos += dt * this.yyVel;
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }

}