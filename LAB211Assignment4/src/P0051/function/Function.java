/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0051.function;

import java.util.Scanner;
import java.util.Stack;
import P0051.myException.MyException;
import P0051.control.Control;
import P0051.model.BMI;
public class Function {
    public BMI BMICalculator(){
        Control control= new Control();
        BMI BMIStatus= new BMI();
        BMIStatus.setWeight(control.getDouble("Enter Weight(kg): ", "BMI is digit"));
        BMIStatus.setHeight(control.getDouble("Enter height(cm): ", "BMI is digit"));
        return BMIStatus;
    }
    public double NormalCalculator(){
        Control control= new Control();
        Stack<String> stack= new Stack();
        do{
            if(stack.isEmpty()){
                stack.push(Double.toString(control.getDouble("Enter number: ","Please input digit")));
                continue;
            }
            if(control.CheckOperator(stack.peek())){
                double number=0, numStack;
                switch(stack.peek()){
                    case "+": number= control.getDouble("Enter number: ","Please input digit");
                            stack.pop();
                            numStack= Double.parseDouble(stack.pop());
                            stack.push(Double.toString(numStack+ number));
                            break;
                    case "-":number= control.getDouble("Enter number: ","Please input digit");
                            stack.pop();
                            numStack= Double.parseDouble(stack.pop());
                            stack.push(Double.toString(numStack- number));
                            break;
                    case "*":number= control.getDouble("Enter number: ","Please input digit");
                            stack.pop();
                            numStack= Double.parseDouble(stack.pop());
                            stack.push(Double.toString(numStack* number));
                            break;
                    case "^":number= control.getDouble("Enter number: ","Please input digit");
                            stack.pop();
                            numStack= Double.parseDouble(stack.pop());
                            stack.push(Double.toString(Math.pow(numStack, number)));
                            break;        
                    case "/":do{
                                try {
                                    number= control.getDouble("Enter number: ","Please input digit");
                                    if(number==0) throw new MyException("Cant divide to number 0");
                                } catch(MyException e){
                                    System.out.println(e.getMessage());
                                }catch (Exception e) {
                                }
                            }while(number==0);
                            stack.pop();
                            numStack= Double.parseDouble(stack.pop());
                            stack.push(Double.toString(numStack/ number));
                            break;   
                    case "=":stack.pop();
                            return Double.parseDouble(stack.pop());
                }   
                System.out.println("Memory: "+stack.peek());
            }
            else stack.push(control.getOperator());
        }while(!stack.peek().equalsIgnoreCase("="));
        stack.pop();
        return Double.parseDouble(stack.pop());
    }
    public static void main(String[] args) {
        Function func= new Function();
        System.out.println(func.NormalCalculator());
        
    }
}
