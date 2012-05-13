/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ast;

/**
 *
 * @author Michael
 */
public class GetVar extends Expr{
    public String id;

    public GetVar() {
    }

    public GetVar(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "GetVar(" + id + ")";
    }
    
    
    
}
