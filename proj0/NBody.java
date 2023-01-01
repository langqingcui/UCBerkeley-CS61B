public class NBody {
    public static double readRadius(String fileName) {
        In in = new In(fileName);
        int N = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String fileName) {
        In in = new In(fileName);
        int N = in.readInt();
        double radius = in.readDouble();
        Planet[] planets = new Planet[N];
        for (int i = 0; i < N; i++) {
            double xp = in.readDouble();
            double yp = in.readDouble();
            double xv = in.readDouble();
            double yv = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            planets[i] = new Planet(xp, yp, xv, yv, m, img);
        }
        return planets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        
    }
}