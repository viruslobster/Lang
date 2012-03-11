package mpp;

import ast.Expr;
import ast.Stmt;
import java.io.Console;
import java.util.List;

public class Main {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        
        Lexer lexer = new Lexer();        
        Parser parser = new Parser();
        Executer executer = new Executer();
        
        Console console = System.console();
        if (console == null) {
            System.err.println("unable to obtain console");
            return;
        }
        
        
        String input;
        while (true) {
            System.out.print(">>>");
            input = console.readLine();
            if ("exit".equals(input)) {
                break;
            }
            List<String> tokens = lexer.Tokenize(input);
           // Stmt stmt = parser.parseStmt(tokens);
            
            for(String s : tokens) {
                System.out.println(s);
            }
            System.out.println("--------------------");
            //System.out.println(stmt.toString());
           // System.out.println("--------------------");
            //executer.executeStmt(stmt);
            //parser.reset();
        }




    }
}
