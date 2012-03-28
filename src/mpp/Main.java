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

        //String fileName = args[0];
        String fileName = "C:\\Cygwin\\home\\Michael\\Calc\\dist\\main.foo";
        File file = new File(fileName);
        BufferedReader reader = new BufferedReader(new FileReader(file));



        List<List<String>> tokens = lexer.Tokenize(reader);
        
        
        System.out.println(tokens.toString());
        System.out.println("---------------------------");
        Program program = parser.parseProgram(tokens);
        System.out.println(program.toString());
        System.out.println("---------------------------");
        String aout = generator.genProgram(program);
        System.out.print(aout);
        
        BufferedWriter out = new BufferedWriter(new FileWriter("Main.j"));
        out.write(aout);
        out.close();
        jasmin.Main.main(new String[]{"Main.j"});
      






    }
}
