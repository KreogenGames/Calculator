public class Calc {
    public static String ConvertToRPN(String Data)
    {
        String current = "";
        Queue queue1 = new Queue();
        int priority;

        for(int i = 0; i < Data.length(); i++) {
            priority = getP(Data.charAt(i));

            if(priority == 0)current += Data.charAt(i);
            if(priority == 1)queue1.insert(Data.charAt(i));

            if(priority > 1){

                current+=' ';

                while (!queue1.isEmpty())
                {
                    if(getP(queue1.getFront()) >= priority){
                        current+=queue1.remove();
                    }
                    else break;;
                }
                queue1.insert(Data.charAt(i));
            }

            if(priority == -1){
                current+=' ';
                while (getP(queue1.getFront()) != 1)current+=queue1.remove();
                queue1.remove();
            }
        }

        while (!queue1.isEmpty())current+=queue1.remove();


        return current;
    }

    public static double RPNtoAnswer(String rpn)
    {
        String operand = new String();
        QueDouble que1 = new QueDouble();

        for(int i = 0; i < rpn.length(); i++){
            if(rpn.charAt(i) == ' ') continue;

            if(getP(rpn.charAt(i)) == 0){
                while(rpn.charAt(i) != ' ' && getP(rpn.charAt(i)) == 0){
                    operand+=rpn.charAt(i++);
                    if(i == rpn.length()) break;
                }
                que1.insert(Double.parseDouble(operand));
                operand = new String();
            }

            if(getP(rpn.charAt(i)) > 1){
                double a = que1.remove();
                double b = que1.remove();

                if(rpn.charAt(i) == '+')que1.insert(b+a);
                if(rpn.charAt(i) == '-')que1.insert(b-a);
                if(rpn.charAt(i) == '*')que1.insert(b*a);
                if(rpn.charAt(i) == '/')que1.insert(b/a);
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
