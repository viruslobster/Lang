/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ast;

import java.util.List;

/**
 *
 * @author michael
 */
public class FunctionCall extends Stmt {
    public String id;
    public List<Expr> args;

    public FunctionCall() {
    }

    public FunctionCall(String id, List<Expr> args) {
        this.id = id;
        this.args = args;
    }
    

    @Override
    public String toString() {
        String list = "";
        for(Expr expr : args) {
            list += expr.toString() + ", ";
        }
        list = list.substring(0,list.length() - 2);
        return id + "(" + list + ")";
    }
    
    
    
}
