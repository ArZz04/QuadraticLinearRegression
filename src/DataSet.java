public class DataSet {
    private double x[];
    private double y[];

    public DataSet() {
        // y= new double[] {7.5,  3,  0.5, 1, 3, 6, 14};
        //x = new double[] {-3,  -2, -1,  0, 1, 2, 3};
        y = new double[] {305, 367, 397, 395, 361};
        x = new double[] {0, 1, 2, 3, 4};
    }

    public double[] getX() {
        return this.x;
    }

    public double[] getY() {
        return this.y;
    }
}