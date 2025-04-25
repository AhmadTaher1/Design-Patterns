//package Visitor;
//
//
////but this approach is kinda slow
//
//
//abstract class Expression {
//}
//
//class DoubleExpression extends Expression {
//
//    Double val;
//
//    public DoubleExpression(Double val) {
//        this.val = val;
//    }
//
//}
//
//
//class AdditionExpression extends Expression {
//    Expression left;
//    Expression right;
//
//    public AdditionExpression(Expression left, Expression right) {
//        this.left = left;
//        this.right = right;
//    }
//
//
//}
//
//
//class ExpressionPrinter{
//
//    public static void print(Expression e,StringBuilder sb) {
//
//        if(e.getClass() == DoubleExpression.class){
//            sb.append(((DoubleExpression) e).val);
//        }
//        else if(e.getClass() == AdditionExpression.class){
//
//            AdditionExpression ae = (AdditionExpression) e;
//            sb.append("(");
//            print(ae.left, sb);
//            sb.append("+");
//            print(ae.right, sb);
//            sb.append(")");
//        }
//        else{
//            throw new RuntimeException("Unknown expression");
//        }
//
//    }
//}
//
//
//class Demo {
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
//        ExpressionPrinter.print(a, sb);
//
//        System.out.println(sb.toString());
//    }
//}
