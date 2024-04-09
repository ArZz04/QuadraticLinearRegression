
public class QuadraticLinearRegression {

    private double a, b, c;

    public void fit(double[] x, double[] y) {
        int n = x.length;
        DiscreteMaths dm = new DiscreteMaths();

        double sumX = dm.sumX(x);
        double sumY = dm.sumY(y);
        double sumXY = dm.sumXY(x, y);
        double sumXSquare = dm.sumXSquare(x);
        double sumXCube = dm.sumXCube(x);
        double sumXSquareY = dm.sumXSquareY(x, y);

        // Ecuaciones para encontrar coeficientes cuadráticos (a, b, c)
        double[][] equations = {
                {n, sumX, sumXSquare},                          // | n   Σx  Σx2 | c |   | Σy   |
                {sumX, sumXSquare, sumXCube},                   // | Σx  Σx2 Σx3 | b | = | Σxy  |
                {sumXSquare, sumXCube, sumXSquare * sumXSquare} // | Σx2 Σx3 Σx4 | a |   | Σx2y |
        };

        double[] results = {sumXY, sumXSquareY, sumY};

        /* No me quise arriescar a equivocarme aqui JAJAJA
        Cleaner solver = new Cleaner();
        double[] coefficients = solver.solve(equations, results);

        // Assigning coefficients
        a = coefficients[0];
        b = coefficients[1];
        c = coefficients[2];
        */


        // Reemplaza con los cálculos directos
        double deno = n * sumXSquare - sumX * sumX;

        if (deno == 0) {
            System.out.println("Error: el denominador es cero.");
            return;
        }

        a = (sumXSquareY * sumX - sumXY * sumXSquare) / deno;
        b = (n * sumXY - sumX * sumY) / deno;
        c = (sumY * sumXSquare - sumX * sumXSquareY) / deno;


    }

    public double predict(int x) {
        return (a * (x * x)) + (b * x) + c;
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
    public static void calculateQuadraticRegression(int newXQuadratic) {
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
        System.out.println("Ecuación de regresión cuadrática: Y = (" + aQuadratic + " * " + newXQuadratic + "^2) + (" + bQuadratic + " * X) + " + cQuadratic);
        System.out.println("Predicción cuadrática para X = " + newXQuadratic + ": Y = " + predictedYQuadratic);
    }
}
