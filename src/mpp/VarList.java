/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mpp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Michael
 */
public class VarList {
    public List<String> names;
    public List<Integer> IDs;
    public List<ast.Type> types;

    public VarList() {
        names = new ArrayList<String>();
        IDs = new ArrayList<Integer>();
        types = new ArrayList<ast.Type>();
    }
    
    public void add(String name, Integer ID, ast.Type type) {
        names.add(name);
        IDs.add(ID);
        types.add(type);        
    }
    
    public Integer getID(String name) {
        for(int i=0;i<names.size();i++) {
            if(name.equals(names.get(i))) {
                return IDs.get(i);
            }
        }
        
        return -1;
    }
    
    public ast.Type getType(String name) {
        for(int i=0;i<names.size();i++) {
            if(name.equals(names.get(i))) {
                return types.get(i);
            }
        }
        
        return ast.Type.Void;
    }
    
    public void setType(String name, ast.Type type) {
        for(int i=0;i<names.size();i++) {
            if(name.equals(names.get(i))) {
                types.set(i, type);
                return;
            }
        }
        
    }

    @Override
    public String toString() {
        String str = "";
        for(int i=0;i<names.size();i++) {
            str += names.get(i) + ", " + IDs.get(i) + ", " + types.get(i) + "\n";
        }
        return str;
    }
    
    
    
    
    
}
