package j1.s.p0074;
public interface MatrixCalc {
    public Double[][] sub(Double [][]Matrix1, Double [][]Matrix2);
    public Double[][] add(Double [][]Matrix1, Double [][]Matrix2);
    public Double[][] multi(Double [][]Matrix1, Double [][]Matrix2);
    public Double[][] getMatrix(int i, int j);
    public int getHeight(Double[][] matrix);
    public int getWeight(Double[][] matrix);
}
