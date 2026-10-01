public class EnglshUnit {
    private double height,weight, bmi;

    public EnglshUnit(double height, double weight) {
        this.height = height;
        this.weight = weight;
    }
    public void calculate() {
        bmi = (weight / (height * height));
    }

    public double getBmi() {
        return bmi;
    }
}
