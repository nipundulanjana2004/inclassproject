public class EnglishUnit implements Unit {
    private double weight;
    private double height;
    private double bmi;

    public EnglishUnit(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public void calculate() {
        this.bmi = this.weight / (this.height * this.height);
    }

    public double getBmi() {
        return this.bmi;
    }
}
