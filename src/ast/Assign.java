/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ast;

/**
 *
 * @author Michael
 */
public class Assign extends Stmt{
    public String id;
    public Expr expr;

    public Assign() {
    }

    public Assign(String id, Expr expr) {
        this.id = id;
        this.expr = expr;
    }

    @Override
    public String toString() {
        return "Assign(" + id + ", " + expr.toString() + ")";
    }
    
    
    
}
