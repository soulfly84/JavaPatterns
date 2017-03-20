package behavioral;

/*решающий часто встречающуюся, но подверженную изменениям, задачу.
Также известен как Little (Small) Language*/
public class InterpreterApp {
    public static void main(String[] args) {
        Context context = new Context();
        Expression expression = context.evaluate("5-2+3");
        System.out.println(expression.interpret());
        //Вычислить 1-2+3
        //Здесь 3 составляющие: число, минус, плюс
    }
}

interface Expression{
    int interpret();
}

//Терминальное (конечное, минимальное чимло) выражение
class NumberExpression implements Expression{
    int numder;

    public NumberExpression(int numder) {
        this.numder = numder;
    }
    @Override
    public int interpret() {
        return numder;
    }
}

class MinusExpression implements Expression{
    Expression left;
    Expression right;

    public MinusExpression(Expression left, Expression right) {
        //Левая и правая операнда
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        //Из левого вычитаем правое
        return left.interpret() - right.interpret();
    }
}

class PlusExpression implements Expression{
    Expression left;
    Expression right;

    public PlusExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        //Складываем левое и правое
        return left.interpret() + right.interpret();
    }
}

//Контекст - хранит логику вычисления - используется не везде
class Context {
    Expression evaluate(String s){
        //Вычитаемая позиция, убираем правую часть, если есть
        int pos = s.length()-1;
        while (pos > 0){
            if(Character.isDigit(s.charAt(pos))){
                pos--;
            }
            //Нашли число, дошли до знака и считаем
            else {
                Expression left = evaluate(s.substring(0, pos));
                Expression right = new NumberExpression(Integer.valueOf(s.substring(pos+1, s.length())));
                char operator = s.charAt(pos);
                switch (operator){
                    case '-': return  new MinusExpression(left, right);
                    case '+': return  new PlusExpression(left, right);

                }
            }
        }
        int result = Integer.valueOf(s);
        return new NumberExpression(result);
    }
}