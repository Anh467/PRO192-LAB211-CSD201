package j1.s.p0074;

import java.util.List;
import java.util.Scanner;

public class Calculator extends ReadSaveFile implements MatrixCalc{
    Double Matrix1[][];
    Double Matrix2[][];
    public int iNumberR(){
        Scanner sc= new Scanner(System.in);
        Integer k;
        do {
            System.out.print("Enter Row Matrix: ");
            k=Validate.iNumber(sc.nextLine());
            if (k==null) System.err.println("Row Matrix is digit");
        } while (k==null);
        return k;
    }
    public int iNumberC(){
        Scanner sc= new Scanner(System.in);
        Integer k;
        do {
            System.out.print("Enter Column Matrix: ");
            k=Validate.iNumber(sc.nextLine());
            if (k==null) System.err.println("Column Matrix is digit");
        } while (k==null);
        return k;
    }
    public Calculator() {
       
    }
    public void input(){
        int h1,h2,w1,w2;
        h1=iNumberR();
        w1=iNumberC();
        Matrix1=getMatrix(h1, w1);
        
        h2=iNumberR();
        w2=iNumberC();
        Matrix2=getMatrix(h2, w2);
    }
    @Override
    public int getHeight(Double[][] matrix) {
        return matrix.length;
    }

    @Override
    public int getWeight(Double[][] matrix) {
        return matrix[0].length;
    }
    public boolean checkAddSub(Double[][] Matrix1, Double[][] Matrix2){
        int h1=getHeight(Matrix1);
        int h2=getHeight(Matrix2);
        int w1=getWeight(Matrix1);
        int w2=getWeight(Matrix2);

        if (h1!=h2 || w1!= w2){
            System.err.println("Cannot calculate 2 matrices of different size");
            return false;
        }
        return true;
    }
    @Override
    public Double[][] sub(Double[][] Matrix1, Double[][] Matrix2) {
        
        if (!checkAddSub(Matrix1, Matrix2)) return null;
        
        int h=getHeight(Matrix1);
        int w=getWeight(Matrix1);
        
        Double[][] sub= new Double[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                sub[i][j]=Matrix1[i][j]-Matrix2[i][j];
            }
        }
        
        return sub;
    }

    @Override
    public Double[][] add(Double[][] Matrix1, Double[][] Matrix2) {
        if (!checkAddSub(Matrix1, Matrix2)) return null;
        
        int h=getHeight(Matrix1);
        int w=getWeight(Matrix1);
        
        Double[][] add= new Double[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                add[i][j]=Matrix1[i][j]+Matrix2[i][j];
            }
        }
        
        return add;
    }

    public boolean checkMulti(Double[][] Matrix1, Double[][] Matrix2){
        int h2=getHeight(Matrix2);
        int w1=getWeight(Matrix1);

        if (h2!=w1){
            System.err.println("Cannot calculate 2 matrices of different size");
            return false;
        }
        return true;
    }
    public Double multi(Double[][] Matrix1, Double[][] Matrix2,int i,int j,int k){
        Double res=0.0;
        for (int l = 0; l < k; l++) {
            res+=Matrix1[i][l]*Matrix2[l][j];
        }
        return res;
    }
    @Override
    public Double[][] multi(Double[][] Matrix1, Double[][] Matrix2) {
        if (!checkMulti(Matrix1, Matrix2)) return null;
        int h1=getHeight(Matrix1);
        int k=getHeight(Matrix2);
        int w2=getWeight(Matrix2);
        
        Double[][] multi= new Double[h1][w2];
        for (int i = 0; i < h1; i++) {
            for (int j = 0; j < w2; j++) {
                multi[i][j]=multi(Matrix1, Matrix2, i, j, k);
            }
        }
        return multi;
    }
    
    public double dNumber(int i, int j){
        Scanner sc= new Scanner(System.in);
        Double k;
        do {
            System.out.print("Enter MaTrix["+i+"]["+j+"]: ");
            k=Validate.dNumber(sc.nextLine());
            if (k==null) System.err.println("Value of matrix is digit");
        } while (k==null);
        return k;
    }
    @Override
    public Double[][] getMatrix(int h, int w) {
        Double [][] matrix= new Double[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                matrix[i][j]=dNumber(i, j);
            }
        }
        return matrix;
    }
    public void sum(){
        Double [][]sum = add(Matrix1, Matrix2);
        if (sum==null){
            return;
        }
        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < sum[0].length; j++) {
                System.out.println("sum["+i+"]["+j+"]: "+sum[i][j]);
            }
        }
    }
    public void sub(){
        Double [][]sub = sub(Matrix1, Matrix2);
        if (sub==null){
            return;
        }
        for (int i = 0; i < sub.length; i++) {
            for (int j = 0; j < sub[0].length; j++) {
                System.out.println("sub["+i+"]["+j+"]: "+sub[i][j]);
            }
        }
    }
    public void multi(){
        Double [][]multi = multi(Matrix1, Matrix2);
        if (multi==null){
            return;
        }
        for (int i = 0; i < multi.length; i++) {
            for (int j = 0; j < multi[0].length; j++) {
                System.out.println("multi["+i+"]["+j+"]: "+multi[i][j]);
            }
        }
    }

    @Override
    public boolean readFormat(List<String> line, char form) {
        int i=0;
        String []s=line.get(i).split(" ");
        try {
            int m=Integer.parseInt(s[0]);
            int n=Integer.parseInt(s[1]);
            Matrix1= new Double[m][n];
            i++;
            for(int k=0;k<m;i++,k++){
                String arr[]=line.get(i).split(" ");
                for (int j = 0; j < n; j++) {
                    Matrix1[k][j]=Double.parseDouble(arr[j]);
                }
            }
            
            s=line.get(i).split(" ");
            
            m=Integer.parseInt(s[0]);
            n=Integer.parseInt(s[1]);
            Matrix2= new Double[m][n];
            i++;
            for(int k=0;k<m;i++,k++){
                String arr[]=line.get(i).split(" ");
                for (int j = 0; j < n; j++) {
                    Matrix2[k][j]=Double.parseDouble(arr[j]);
                }
            }
        } catch (Exception e) {
            System.err.println("File have problem");
        }
        
        return true;
    }

    @Override
    public String makeString(char form) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

 
    
    
}
