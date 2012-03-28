package ast;

public class Op extends Expr {

    public Expr left;
    public Operators operator;
    public Expr right;

    public Op() {
        returnType = Type.Float;
    }

    

    public Op(Expr left, Operators operator, Expr right) {
        returnType = Type.Float;
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    @Override
    public String toString() {
        String op = " <Error> ";
        switch (operator) {
            case plus:
                op = "+";
                break;
            case minus:
                op = "-";
                break;
            case miltiply:
                op = "*";
                break;
            case divide:
                op = "/";
                break;

        }
        return op + "(" + left.toString() + ", " + right.toString() + ")";
    }
}
