/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ast;

import java.beans.Statement;
import java.util.List;

/**
 *
 * @author michael
 */
public class Program {
    public List<Stmt> stmts;

    public Program() {
    }

    public Program(List<Stmt> stmts) {
        this.stmts = stmts;
    }

    @Override
    public String toString() {
        String s = "";
        for(Stmt st : stmts) { 
            s += st.toString() + "\n";
        }
        return s;
    }
    
    
}
