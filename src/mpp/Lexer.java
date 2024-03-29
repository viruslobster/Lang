package mpp;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class Lexer {
    //private static String[] breakCodes = {"+", "-", "/", "*", ","};

    public Lexer() {
    }

    public java.util.List<String> getTokens(String str) throws Exception {
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

                } else if (Character.isLetter(str.charAt(i))) {
                    for (int a = i; a < str.length(); a++) {
                        if (!Character.isLetter(str.charAt(i))) {
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
                                if (!Character.isWhitespace(str.charAt(i))) {
                                    if (!Character.isDigit(str.charAt(i))) {
                                        i--;
                                        break;
                                    }
                                    token += str.charAt(i);
                                }
                                i++;
                            }


                            break;
                        case '*':
                            token = "*";
                            break;
                        case '/':
                            token = "/";
                            break;
                        case ',':
                            token = ",";
                            break;
                        case '=':
                            token = "=";
                            break;
                        case '"':
                            tokens.add("\"");
                            token = "";
                            i++;
                            for (int a = i; a < str.length(); a++) {

                                if (str.charAt(i) == '"') {
                                    
                                    break;
                                }
                                token += str.charAt(i);

                                i++;
                            }
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

    public java.util.List<java.util.List<String>> Tokenize(BufferedReader reader) throws Exception {
        java.util.List<java.util.List<String>> result = new ArrayList<List<String>>();

        String str = "";

        while ((str = reader.readLine()) != null) {
            List<String> t = getTokens(str);
            if (!t.isEmpty()) {
                result.add(t);
            }
        }



        return result;
    }
}
