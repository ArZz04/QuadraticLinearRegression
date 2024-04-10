import java.util.Arrays;

public class QuadraticLinearRegression {

    private double a, b, c;

    public void fit(double[] x, double[] y) {
        int n = x.length;
        DiscreteMaths dm = new DiscreteMaths();

        double sumX = dm.sumX(x);
        double sumY = dm.sumY(y);
        double sumXY = dm.sumXY(x, y);
        double sumXSquare = dm.sumXSquare(x);
        double sumXSquareY = dm.sumXSquareY(x, y);
        double sumXCube = dm.sumXCubic(x);
        double sumXQuartic = dm.sumXQuartic(x);

        System.out.println(sumX);
        System.out.println(sumY);
        System.out.println(sumXSquare);
        System.out.println(sumXQuartic);
        System.out.println(sumXY);
        System.out.println(sumXSquareY);
        System.out.println(sumXCube);
        System.out.println(n);

        /*
        // Ecuaciones para encontrar coeficientes cuadráticos (a, b, c)
        double[][] equations = {
                {n, sumX, sumXSquare},
                {sumX, sumXSquare, sumXCube},
                {sumXSquare, sumXCube, sumXSquare * sumXSquare}
        };

        double[] results = {sumY, sumXY, sumXSquareY};

        Cleaner solver = new Cleaner();
        double[] coefficients = solver.solve(equations, results);

        // Assigning coefficients
        a = coefficients[0];
        b = coefficients[1];
        c = coefficients[2];
        */

        double sup1 = ( (n * sumXSquareY) - ( (sumXSquare) * (sumY) ) * ((n * sumXSquare) - (Math.pow(sumXSquare, 2)) - (n * sumXY)));
        double sup2 = ( (sumXQuartic * sumXSquare) - (Math.pow(sumXSquare, 2)) );

        a = -16 ;
        b = ( (n * (sumXY)-(sumX)*(sumY) ) * ( n * ( (sumXQuartic) - (Math.pow(sumXQuartic, 2)) ) - (n * (sumXSquareY) - (sumXSquare) * (sumY)) * (n * (sumXCube) - (sumXSquare) * (sumX)) ) ) / ( () * (n *) - Math.pow((n * (sumXCube) - (sumXSquare) * (sumX)),2) ) ;
        c = ( sumY - (b * sumX) - (a * sumXSquare) ) /n;

    }


    public double predict(double x) {
        return (a * Math.pow(x, 2)) + (b * x) + c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
    public static void calculateQuadraticRegression(double newXQuadratic) {
        DataSet ds = new DataSet();
        double[] xData = ds.getX();
        double[] yData = ds.getY();

        // Calcular la regresión cuadrática
        QuadraticLinearRegression quadraticRegression = new QuadraticLinearRegression();
        quadraticRegression.fit(xData, yData);

        // Obtener los coeficientes de la regresión cuadrática
        double aQuadratic = quadraticRegression.getA();
        double bQuadratic = quadraticRegression.getB();
        double cQuadratic = quadraticRegression.getC();

        // Predecir el valor de Y para un nuevo valor de X usando regresión cuadrática
        double predictedYQuadratic = quadraticRegression.predict(newXQuadratic);

        // Imprimir la ecuación de regresión cuadrática
        System.out.println("Ecuación de regresión cuadrática: Y = (" + aQuadratic + "(a) * " + newXQuadratic + "^2) + (" + bQuadratic + "(b) * X) + " + cQuadratic + "(c)");
        System.out.println("Predicción cuadrática para X = " + newXQuadratic + ": Y = " + predictedYQuadratic);
    }
}
