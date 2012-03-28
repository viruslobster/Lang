package ast;

public class Number extends Expr {

    public double value;
    

    public Number() {
        returnType = Type.Float;
    }    

    public Number(double value) {
        returnType = Type.Float;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
