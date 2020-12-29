/**
 * @author Nguyen The Truong
 */

 package StackAndQueue;

 public class Exercise1 {
     public static double calculate(String infix) {
        Stack<Character> myStack  = new Stack<Character>();
        for(int i = infix.length()-1; i >= 0; i--) {
            if(infix.charAt(i) != '(' && infix.charAt(i) != ')') {
                myStack.push(infix.charAt(i));
            }
        }
        int num1 = Integer.parseInt(String.valueOf(myStack.pop()));
        char ope = myStack.pop();
        int num2 = Integer.parseInt(String.valueOf(myStack.pop()));
        double result;
        if(ope == '+')
            result = num1 + num2;
        else if(ope == '-')
            result = num1 - num2;
        else if(ope == '*')
            result = num1 * num2;
        else if(ope == '/')
            result = num1 / num2;
        else 
            result = 0;
        while(myStack.getNumNode() != 0) {
            ope = myStack.pop();
            int num = Integer.parseInt(String.valueOf(myStack.pop()));
            if(ope == '+')
                result += num;
            if(ope == '-')
                result -= num;
            if(ope == '*')
                result *= num;
            if(ope == '/')
                result /= num;
        }
        return result;
     }
    

     // Main
     public static void main(String[] args) {
         String infix = "((9-2)*6+7)/7";
         System.out.println("Result: " + calculate(infix));
     }
 }
 