package mpp;

import ast.Expr;
import ast.FunctionCall;
import ast.Number;
import ast.Op;
import ast.Stmt;

public class Executer {
	public Executer() {

	}
        
        public void executeStmt(Stmt stmt) {
            if (stmt instanceof FunctionCall) {
                FunctionCall functionCall = (FunctionCall) stmt;
                
                for(Expr expr : functionCall.args)
                System.out.println(executeExpr(expr));
            }
        }
        
        

	public Double executeExpr(Expr expr) {
		if (expr instanceof Number) {
			return ((Number) expr).value;
		} else if (expr instanceof Op) {
			Op op = (Op) expr;
			double res;
			switch (op.operator) {
			case plus:
				res = executeExpr(op.left) + executeExpr(op.right);
				break;
			case minus:
				res = executeExpr(op.left) - executeExpr(op.right);
				break;
			case miltiply:
				res = executeExpr(op.left) * executeExpr(op.right);
				break;
			case divide:
				res = executeExpr(op.left) / executeExpr(op.right);
				break;
			default:
				res = 0;
				break;
			}
			return res;

		}

		return 0.0;
	}

}
