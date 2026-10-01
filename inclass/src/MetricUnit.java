public class MetricUnit {
    private double height ,weight,bmi;
    public MetricUnit(double height, double weight) {
        this.height = height;
        this.weight = weight;

    }
    public void calculate(){
        bmi = ((weight * 703.0) / (height * height));
    }

    public double getBmi() {
        return bmi;
    }
}
