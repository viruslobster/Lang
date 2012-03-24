/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mpp;

import ast.Expr;
import ast.FunctionCall;
import ast.Program;
import ast.Stmt;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Michael
 */
public class Generator {
    private int stack = 0;

    public Generator() {
    }
    
    public String genProgram(Program program) {
        return genMain(program.stmts);
    }
    
    private String listToString(List<String> code) {
        String str = "\n";
        for(String s : code) {
            str += s + "\n";
        }
        return str;
    }
    
    public String genMain(List<Stmt> stmts) {
        List<String> code = new ArrayList<String>();
        code.add(".class public main\n.super java/lang/Object");
        code.add(".method public static main([Ljava/lang/String;)V");
        
        for(Stmt stmt : stmts) {
            code.add(genStmt(stmt));
        }
        code.add(2, ".limit stack " + stack);
        code.add("return");
        code.add(".end method");
        
        
        
        return listToString(code);
    }
    
    public String genStmt(Stmt stmt) {
        List<String> code = new ArrayList<String>();
        
        if(stmt instanceof FunctionCall) {
            FunctionCall call = (FunctionCall) stmt;
            code.add("getstatic java/lang/System/out Ljava/io/PrintStream;");
            genExpr(code, call.args.get(0));
            
            code.add("invokestatic java/lang/String/valueOf(F)Ljava/lang/String;");
            code.add("invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V");
            
            if(stack < 2) {
                stack = 2;
            }
            
        } 
       
                
        return listToString(code);
    }
    
    public void genExpr(List<String> code, Expr expr) {
        if(expr instanceof ast.Number) {
            ast.Number num = (ast.Number) expr;
            code.add("ldc " + num.value);
        }
    }
}
