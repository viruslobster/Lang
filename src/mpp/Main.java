package mpp;

import ast.Expr;
import ast.Program;
import ast.Stmt;
import java.io.*;
import java.util.List;

public class Main {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        

        Lexer lexer = new Lexer();
        Parser parser = new Parser();
        Generator generator = new Generator();

        String fileName = args[0];
        File file = new File(fileName);
        BufferedReader reader = new BufferedReader(new FileReader(file));



        List<List<String>> tokens = lexer.Tokenize(reader);
        
        Program program = parser.parseProgram(tokens);
        
        System.out.println(program.toString());
        System.out.print("---------------------------");
        String aout = generator.genProgram(program);
        System.out.print(aout);
        
        BufferedWriter out = new BufferedWriter(new FileWriter("Main.j"));
        out.write(aout);
        out.close();
        jasmin.Main.main(new String[]{"Main.j"});
      






    }
}
