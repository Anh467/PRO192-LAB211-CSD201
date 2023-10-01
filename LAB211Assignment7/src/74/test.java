/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0074;

/**
 *
 * @author TCNJK
 */
public class test {
    
    public static void main(String[] args) {
        String menu[]={
            "Addition matrixes","Subtraction matrixes","Multiplication matrixes","Read file"//,"Save Result"
        };
        Calculator res= new Calculator();

        int choice;
        do {
            choice=Menu.menu("Calculator program ", menu);

            switch (choice) {
                case 1:
                    res.sum();
                    break;
                case 2:
                    res.sub();
                    break;
                case 3:
                    res.multi();
                    break;
                case 4:
                    res.loadFile("src\\calcMatrix.txt", 'o');
            }
        } while (choice!=menu.length+1);
    }
}
