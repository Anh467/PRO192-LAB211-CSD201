package lab5;

public class StudentIT extends Student {

    private double javaScore;
    private double cssScore;

    public StudentIT() {

    }

    public StudentIT(String fullName, Address address, double javaScore, double cssScore) {
        super(fullName, address);
        this.cssScore = cssScore;
        this.javaScore = javaScore;
    }

    public double getJavaScore() {
        return javaScore;
    }

    public void setJavaScore(double javaScore) {
        this.javaScore = javaScore;
    }

    public double getCssScore() {
        return cssScore;
    }

    public void setCssScore(double cssScore) {
        this.cssScore = cssScore;
    }

    //@Override
    public double mediumScore() {
        return (3 * javaScore + cssScore) / 4;
    }

    @Override
    public String toString() {
        return super.toString() + " CSS: " + this.getCssScore() + " Java: " + this.getJavaScore() + " GPA: " + this.mediumScore();
    }

    @Override
    public int count() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
