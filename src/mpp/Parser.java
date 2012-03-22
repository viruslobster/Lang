package mpp;

import ast.Number;
import ast.*;
import java.util.ArrayList;
import java.util.List;

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

    public Program parseProgram(List<List<String>> tokens) throws Exception {
        List<Stmt> stmts = new ArrayList<Stmt>();
        for (List<String> list : tokens) {
            
            Stmt s = parseStmt(list);
            //System.out.println(s.toString());
            stmts.add(s);
            
            reset();
        }
        
        return new Program(stmts);
    }

    public Stmt parseStmt(List<String> tokens) throws Exception {
        Stmt stmt = null;
        
        for (; i < tokens.size(); i++) {
            
            if (Character.isLetter(tokens.get(i).charAt(0))) {
                FunctionCall functionCall = new FunctionCall();
                functionCall.id = tokens.get(i);
                List<Expr> l = new ArrayList<Expr>();
                i++;
                l.add(parseExpr(tokens));
                functionCall.args = l;
                stmt = functionCall;

            }
        }

        return stmt;
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
