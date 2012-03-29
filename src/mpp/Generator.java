/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mpp;

import ast.*;
import java.util.*;

/**
 *
 * @author Michael
 */
public class Generator {
    private int stack = 0;
    private int i = 0;
    private int varCount = 0;
    private VarList vars;

    public Generator() {
    }
    
    private void checkStack(int num) {
        i += num;
            
        if(i > stack) {
            stack = i;
        }
    }
    
    public String genProgram(Program program) throws Exception {
        return genMain(program.stmts);
    }
    
    private String listToString(List<String> code) {
        String str = "\n";
        for(String s : code) {
            str += s + "\n";
        }
        return str;
    }
    
    public String genMain(List<Stmt> stmts) throws Exception {
        vars = new VarList();
        List<String> code = new ArrayList<String>();
        code.add(".class public main\n.super java/lang/Object");
        code.add(".method public static main([Ljava/lang/String;)V");
        
        for(Stmt stmt : stmts) {
            code.add(genStmt(stmt));
        }
        code.add(2, ".limit stack " + stack);
        code.add(2,".limit locals " + (varCount + 1));
        code.add("return");
        code.add(".end method");
        
        System.out.println("------------------------");       
        System.out.println(vars.toString());       
        System.out.println("------------------------");
        
        return listToString(code);
    }
    
    public String genStmt(Stmt stmt) throws Exception {
        List<String> code = new ArrayList<String>();
        
        if(stmt instanceof FunctionCall) {
            FunctionCall call = (FunctionCall) stmt;
            
            code.add("getstatic java/lang/System/out Ljava/io/PrintStream;");
            checkStack(1);
            genExpr(code, call.args.get(0));
            switch(call.args.get(0).returnType) {
                case Float:
                    code.add("invokestatic java/lang/String/valueOf(F)Ljava/lang/String;");
                    break;
                case String:
                    
                    break;            
                    
                 
            }
            
            code.add("invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V");
            checkStack(-1);
            
            
        } else if(stmt instanceof DelcareVar) {
            DelcareVar declarVar = (DelcareVar) stmt;
            vars.add(declarVar.id, varCount, Type.Void);
            
            varCount++;
            
        } else if(stmt instanceof Assign) {
            Assign assign = (Assign) stmt;
            genExpr(code, assign.expr);
            int num = (Integer)vars.getID(assign.id);
            switch(assign.expr.returnType) {
                case Float:
                    code.add("fstore " + num);
                    vars.setType(assign.id, Type.Float);
                    break;
                case String:
                    code.add("astore " + num);
                    vars.setType(assign.id, Type.String);
                    break;                    
                case Void:
                    throw new Exception("Cannot assign type void!!");
                    
            }
        } else if(stmt instanceof DeclareAssignVar) {
            DeclareAssignVar var = (DeclareAssignVar) stmt;
            vars.add(var.id, varCount, Type.Void);            
            varCount++;
            genExpr(code, var.expr);
            int num = (Integer)vars.getID(var.id);
            switch(var.expr.returnType) {
                case Float:
                    code.add("fstore " + num);
                    vars.setType(var.id, Type.Float);
                    break;
                case String:
                    code.add("astore " + num);
                    vars.setType(var.id, Type.String);
                    break;                    
                case Void:
                    throw new Exception("Cannot assign type void!!");
                    
            }
        }
       
                
        return listToString(code);
    }
    
    public void genExpr(List<String> code, Expr expr) throws Exception {
        if(expr instanceof ast.Number) {
            ast.Number num = (ast.Number) expr;
            code.add("ldc " + num.value);
            checkStack(1);
        } else if (expr instanceof StringLiteral){
            StringLiteral str = (StringLiteral) expr;
            code.add("ldc \"" + str.value + "\"");
            checkStack(1);
        } else if(expr instanceof Op) {
            Op op = (Op) expr;
            genExpr(code, op.left);
            genExpr(code, op.right);
            
            switch(op.operator) {
                case plus:
                    code.add("fadd");
                    break;
                case minus:
                    code.add("fsub");
                    break;
                case miltiply:
                    code.add("fmul");
                    break;
                case divide:
                    code.add("fdiv");
                    break;
            }
            checkStack(-1);
        } else if(expr instanceof GetVar) {
            GetVar getVar = (GetVar) expr;
            
            switch(vars.getType(getVar.id)) {
                case Float:
                    code.add("fload " + vars.getID(getVar.id));
                    expr.returnType = Type.Float;
                    break;
                case String:
                    code.add("aload " + vars.getID(getVar.id));
                    expr.returnType = Type.String;
                    break;
                case Void:
                    throw new Exception("Variable \"" + getVar.id + "\" never initialized");
                    
            }
        }
    }
}
