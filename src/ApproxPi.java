
import java.text.DecimalFormat;
import java.util.Random;

/*
Random Pi - Approximating Pi Monte Carlo Style

Given:
    pi = 4 w / n
    w = points in circle
    n = total points generated

    for a given point, if x**2 + y**2 < radius, it falls within radius of the circle.
 */

public class ApproxPi {

    public ApproxPi() {
    }

    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat("##,###,###,###,###");

        for(int i2 = 1; i2 <= 1000000000 ; i2*=10 ) {

            System.out.println("Iterations: "+ df.format(i2));

            try {
                SimpleMethodTimer smt1 = new SimpleMethodTimer();
                System.out.println(monteCarloPi(i2) + " Monte Carlo");
                System.out.println("Runtime was ~ " + smt1 + " milliseconds.");
            } catch (java.lang.OutOfMemoryError e) {
                System.out.println("Couldn't finish Monte Carlo, ran out of memory");
            }


            SimpleMethodTimer smtLeibniz = new SimpleMethodTimer();
            System.out.println(leibnizPi(i2) + " Leibniz");
            System.out.println("Runtime was ~ " + smtLeibniz + " milliseconds.");


            System.out.println(Math.PI + " Math.PI Value\n");
        }


    }

    private static double monteCarloPi(int i) {

        double[] xCoords = new double[i];
        double[] yCoords = new double[i];
        int numerator = 0;

        Random random = new Random(System.currentTimeMillis());

        for (int index = 0; index < xCoords.length; index++) {
            xCoords[index] = random.nextDouble();
            yCoords[index] = random.nextDouble();
        }

        for (int index2 = 0; index2 < xCoords.length; index2++) {
            if ((Math.pow(xCoords[index2], 2) + (Math.pow(yCoords[index2], 2)) < 1)) {
                numerator++;
            }
        }

        return 4 * (double) numerator / i;

    }

    // Leibniz formula for π
    // π4 = ∑∞k=0 (−1)^k / (2k+1)

    private static double leibnizPi(int input) {

        double myPi = 0;
        for (int k = input; k >= 0; k--) {
            //myPi += Math.pow(-1, k + 1) / (2 * k - 1); // Calculate series in parenthesis
            myPi +=  Math.pow(-1, k) / ((2 * k) + 1)  ; // Calculate series in parenthesis
        }
        myPi *= 4;
        return myPi;
    }
}
