//package Visitor.newEX;
//
//
//
//interface ExpressionVisitor {
//
//
//    //should visit all elements in the hierarchy
//    void visit(DoubleExpression de);
//    void visit(AdditionExpression ae);
//}
//
//
//abstract class Expression  {
//    public abstract void accept(ExpressionVisitor ev);
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
//    @Override
//    public void accept(ExpressionVisitor ev) {
//        ev.visit(this);
//    }
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
//    @Override
//    public void accept(ExpressionVisitor ev) {
//        ev.visit(this);
//    }
//
//}
//
//
//class ExpressionPrinter implements ExpressionVisitor {
//    //it should be able to visit all elements in the hierarchy
//
//
//    private StringBuilder buf = new StringBuilder();
//
//    @Override
//    public void visit(DoubleExpression de) {
//        buf.append(de.val);
//    }
//
//    @Override
//    public void visit(AdditionExpression ae) {
//
//        buf.append("(");
//        ae.left.accept(this);
//        buf.append("+");
//        ae.right.accept(this);
//        buf.append(")");
//
//
//    }
//
//    @Override
//    public String toString() {
//        return buf.toString();
//    }
//
//}
//
//class ExpressionCalculator implements ExpressionVisitor {
//    //it should be able to visit all elements in the hierarchy
//
//
//   static double result=0;
//
//    @Override
//    public void visit(DoubleExpression de) {
//        result+= de.val;
//    }
//
//    @Override
//    public void visit(AdditionExpression ae) {
//
//
//        ae.left.accept(this);
//        ae.right.accept(this);
//
//
//
//    }
//
//    public static double getResult() {
//        return result;
//    }
//}
//
//
//
//
//
//
//
//
//
//    class Demo {
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
//        ExpressionPrinter p = new ExpressionPrinter();
//        a.accept(p);
//        System.out.println(p);
//
//        ExpressionCalculator c = new ExpressionCalculator();
//        a.accept(c);
//        System.out.println(ExpressionCalculator.getResult());
//
//    }
//}
