package String;

import java.util.Stack;

public class Solution_71 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] splittedPath = path.split("/");

        for (String sPath: splittedPath) {
            if (!stack.isEmpty() && sPath.equals("..")) {
                stack.pop();
            } else if (!sPath.equals(".") && !sPath.equals("..") && !sPath.equals("")) {
                stack.push(sPath);
            }
        }
        return "/" + String.join("/", stack);
    }
}
