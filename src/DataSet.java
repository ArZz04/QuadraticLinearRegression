public class DataSet {
    private double x[];
    private double y[];

    public DataSet() {
        y = new double[] {12, 18, 30, 42, 48, 79, 90, 96, 96, 90, 84, 78, 66, 54, 36, 24};
        x = new double[] {6, 9, 12, 12, 15, 21, 24, 24, 27, 30, 36, 39, 45, 48, 57, 60};
    }

    public double[] getX() {
        return this.x;
    }

    public double[] getY() {
        return this.y;
    }
}