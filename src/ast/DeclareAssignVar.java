/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ast;

/**
 *
 * @author Michael
 */
public class DeclareAssignVar extends Stmt {
    public String id;
    public Expr expr;

    public DeclareAssignVar() {
    }

    public DeclareAssignVar(String id, Expr expr) {
        this.id = id;
        this.expr = expr;
    }
    
     @Override
    public String toString() {
        return "DeclareAssign(" + id + ", " + expr.toString() + ")";
    }
    
}
