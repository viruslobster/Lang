package mpp;

import java.util.ArrayList;
import java.util.List;

public class Lexer {

    public Lexer() {
    }

    public java.util.List<String> Tokenize(String str) throws Exception {
        List tokens = new ArrayList();

        for (int i = 0; i < str.length(); i++) {
            String token = "";
            if (!Character.isWhitespace(str.charAt(i))) {
                if (Character.isDigit(str.charAt(i))) {
                    for (int a = i; a < str.length(); a++) {
                        if (!Character.isDigit(str.charAt(i))) {
                            i--;
                            break;
                        }
                        token += str.charAt(i);
                        i++;
                    }

                } else {
                    switch (str.charAt(i)) {
                        case '+':
                            token = "+";
                            break;
                        case '-':
                            //add a negative
                            tokens.add("+");
                            token = "-";
                            
                            i++;
                            for (int a = i; a < str.length(); a++) {
                                if (!Character.isDigit(str.charAt(i))) {
                                    i--;
                                    break;
                                }
                                token += str.charAt(i);
                                i++;
                            }
                            break;
                        case '*':
                            token = "*";
                            break;
                        case '/':
                            token = "/";
                            break;

                        default:
                            throw new Exception("\"" + str.charAt(i) + "\""
                                    + " not recognized");
                    }
                }

                tokens.add(token);
            }
        }
        return tokens;
    }
}
