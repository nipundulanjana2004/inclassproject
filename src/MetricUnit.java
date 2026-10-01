public class MetricUnit implements Unit {
    private double weight;
    private double height;
    private double bmi;

    public MetricUnit(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public void calculate() {
        this.bmi = this.weight * 703.0 / (this.height * this.height);
    }

    public double getBmi() {
        return this.bmi;
    }
}
