import java.util.Stack;

public class Calc {
    public static String ConvertToRPN(String Data)
    {

        String current = "";
        Stack<Character> stack = new Stack<>();
        int priority;

        for(int i = 0; i < Data.length(); i++) {
            priority = getP(Data.charAt(i));

            if(priority == 0)current += Data.charAt(i);
            if(priority == 1)stack.push(Data.charAt(i));

            if(priority > 1){

                current+=' ';
                while(!stack.empty()){
                    if(getP(stack.peek()) >= priority){
                        current += stack.pop();
                    }
                    else break;
                }
                stack.push(Data.charAt(i));
            }

            if(priority == -1){
                current+=' ';

                while (getP(stack.peek()) != 1){
                    current+=stack.pop();
                }
                stack.pop();
            }
        }

        while (!stack.empty())current+=stack.pop();


        return current;

        /*
        String current = "";
        Queue queue1 = new Queue();
        Stack<Character> stack = new Stack<>();
        int priority;

        for(int i = 0; i < Data.length(); i++) {
            priority = getP(Data.charAt(i));

            if(priority == 0)current += Data.charAt(i);
            if(priority == 1)queue1.insert(Data.charAt(i));

            if(priority > 1){

                current+=' ';

                if (!queue1.isEmpty())
                {
                    do{
                        stack.push(queue1.remove());
                    }while(!queue1.isEmpty());
                    while (!stack.empty()){
                        if(getP(stack.peek()) >= priority){

                            current+=stack.pop();
                        }
                        else break;
                    }
                }
                queue1.insert(Data.charAt(i));
            }

            if(priority == -1){
                current+=' ';
                do{
                    stack.push(queue1.remove());
                }while(!queue1.isEmpty());
                while (getP(stack.peek()) != 1){
                    current+=stack.pop();
                }
                stack.pop();
            }
        }

        while (!stack.empty())current+=stack.pop();
        while(!queue1.isEmpty())current+=queue1.remove();


        return current;
        */

    }

    public static double RPNtoAnswer(String rpn)
    {
        String operand = new String();
        QueDouble que1 = new QueDouble();
        //Stack<Double> stack = new Stack<>();
        for(int i = 0; i < rpn.length(); i++){
            if(rpn.charAt(i) == ' ') continue;

            if(getP(rpn.charAt(i)) == 0){
                while(rpn.charAt(i) != ' ' && getP(rpn.charAt(i)) == 0){
                    operand+=rpn.charAt(i++);
                    if(i == rpn.length()) break;
                }
                que1.insert(Double.parseDouble(operand));
                //stack.push(Double.parseDouble(operand));
                operand = new String();
            }

            if(getP(rpn.charAt(i)) > 1){
                double a = que1.remove();
                double b = que1.remove();

                if(rpn.charAt(i) == '+')que1.insert(a+b);
                if(rpn.charAt(i) == '-')que1.insert(a-b);
                if(rpn.charAt(i) == '*')que1.insert(a*b);
                if(rpn.charAt(i) == '/')que1.insert(a/b);
            }
        }

        return que1.remove();
    }

    private static int getP(char token)
    {
        if(token == '*' || token == '/') return 3;
        else if(token == '+' || token == '-') return 2;
        else if(token == '(') return 1;
        else if(token == ')') return -1;
        else return 0;
    }
}
