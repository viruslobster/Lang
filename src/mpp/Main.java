package mpp;

import ast.Expr;
import ast.Program;
import ast.Stmt;
import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileReader;
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

        
        File file = new File("/home/michael/hello.yo");
        BufferedReader reader = new BufferedReader(new FileReader(file));



        List<List<String>> tokens = lexer.Tokenize(reader);
        
        Program program = parser.parseProgram(tokens);
        
        System.out.println(program.toString());
      






    }
}
