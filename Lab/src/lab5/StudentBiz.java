package lab5;

public class StudentBiz extends Student {

    private double marketingScore, accScore;

    public StudentBiz() {

    }

    public StudentBiz(String fullName, Address address, double marketingScore, double accScore) {
        super(fullName, address);
        this.marketingScore = marketingScore;
        this.accScore = accScore;
    }

    public double getMarketingScore() {
        return marketingScore;
    }

    public void setMarketingScore(double marketingScore) {
        this.marketingScore = marketingScore;
    }

    public double getAccScore() {
        return accScore;
    }

    public void setAccScore(double keToan) {
        this.accScore = accScore;
    }

    public double mediumScore() {
        return (accScore * 2 + marketingScore) / 3;
    }

    @Override
    public String toString() {
        return super.toString() + " Marketing: " + this.getMarketingScore() + " ke toan: " + this.getAccScore() + " GPA: " + this.mediumScore();
    }

    @Override
    public int count() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
