public class TectCalculator {
    public static void main(String args[]){
        System.out.println(Calc.ConvertToRPN("2*(2+2)"));
        System.out.println(Calc.RPNtoAnswer(Calc.ConvertToRPN("(2+2)*2")));
    }
}
//Короче, смотри. Я тебе отправлю видео с этим калькулятором, мб тебе придет идея в голову, но я нашел в чем
//проблема, он работает с очередью так, как работал бы со стеком поэтому, если записать выражение, как во 2 выводе он посчитает верно, так как
//оно по факту эквивалентно тому, что было бы при помещении его в стек, как исправить не знаю