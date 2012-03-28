/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ast;

/**
 *
 * @author Michael
 */
public class DelcareVar extends Stmt{
    public String id;
    

    public DelcareVar() {
    }

    public DelcareVar(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DeclarVar("+ id + ")";
    }
    
    
    
    
}
