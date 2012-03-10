package mpp;

import java.util.List;
import ast.Expr;
import ast.Number;
import ast.Op;
import ast.Operators;

public class Parser {

    int i = 0;

    public Parser() {
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(.\\d+)?");
    }

    public void reset() {
        i = 0;
    }

    public Expr parseExpr(List<String> tokens) throws Exception {
        Expr expr = null;

        for (; i < tokens.size(); i++) {
            if (isNumeric(tokens.get(i))) {
                expr = new Number(java.lang.Integer.parseInt(tokens.get(i)));
            } else {
                if ("+".equals(tokens.get(i))) {
                    i++;
                    expr = new Op(expr, Operators.plus, parseExpr(tokens));

                } else if ("-".equals(tokens.get(i))) {
                    i++;
                    expr = new Op(expr, Operators.minus, parseExpr(tokens));

                } else if ("*".equals(tokens.get(i))) {
                    i++;
                    expr = new Op(expr, Operators.miltiply, new Number(Double.parseDouble(tokens.get(i))));

                } else if ("/".equals(tokens.get(i))) {
                    i++;
                    expr = new Op(expr, Operators.divide, new Number(Double.parseDouble(tokens.get(i))));

                } else {
                    throw new Exception("no match");
                }
            }
        }



        return expr;
    }
}
