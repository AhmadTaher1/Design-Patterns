//package Visitor;
//
//
 //thus we violate single responsibility principle & open close principle
//
//abstract class Expression {
//    public abstract void print(StringBuilder sb);
//}
//
//class DoubleExpression extends Expression {
//
//    private Double val;
//
//    public DoubleExpression(Double val) {
//        this.val = val;
//    }
//
//    @Override
//    public void print(StringBuilder sb) {
//        sb.append(val);
//    }
//}
//
//
//class AdditionExpression extends Expression {
//    private Expression left;
//    private Expression right;
//
//    public AdditionExpression(Expression left, Expression right) {
//        this.left = left;
//        this.right = right;
//    }
//
//    @Override
//    public void print(StringBuilder sb) {
//        sb.append("(");
//        left.print(sb);
//        sb.append("+");
//        right.print(sb);
//        sb.append(")");
//    }
//}
//
//
//public class Demo {
//    public static void main(String[] args) {
//        //1+(2+3)
//
//        Expression a = new AdditionExpression(
//                new DoubleExpression(1.0),
//                new AdditionExpression(
//                        new DoubleExpression(2.0),
//                        new DoubleExpression(3.0)
//                )
//        );
//
//
//        StringBuilder sb = new StringBuilder();
//        a.print(sb);
//        System.out.println(sb.toString());
//    }
//}
