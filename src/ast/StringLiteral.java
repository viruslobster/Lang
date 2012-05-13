/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ast;

/**
 *
 * @author Michael
 */
public class StringLiteral extends Expr{
    public String value;

    public StringLiteral() {
        returnType = Type.String;
    }

    public StringLiteral(String value) {
        returnType = Type.String;
        this.value = value;
    }
    
    
    
   

    @Override
    public String toString() {
        return "\"" + value + "\"";
    }
    
    
    
}
