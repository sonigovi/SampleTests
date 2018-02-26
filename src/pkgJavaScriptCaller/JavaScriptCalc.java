package pkgJavaScriptCaller;

import java.nio.file.Path;
import java.nio.file.Paths;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class JavaScriptCalc {
    public static void main(String[] args) throws Exception {
        String current = new java.io.File(".").getCanonicalPath();
        System.out.println("Current dir:" + current);
        String currentDir = System.getProperty("user.dir");
        System.out.println("Current dir using System:" + currentDir);

        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current relative path is: " + s);

        String scriptPath = s.replace("\\", "/") + "/javaScripts/calculator.js";
        System.out.println(scriptPath);

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        engine.eval("load('" + scriptPath + "')");
        Object calculator = engine.get("calculator");

        int x = 10;
        int y = 20;

        Invocable inv = (Invocable) engine;

        Object addResult = inv.invokeMethod(calculator, "add", x, y);
        Object subResult = inv.invokeMethod(calculator, "subtract", x, y);
        Object mulResult = inv.invokeMethod(calculator, "multiply", x, y);
        Object divResult = inv.invokeMethod(calculator, "divide", x, y);

        System.out.println(addResult);
        System.out.println(subResult);
        System.out.println(mulResult);
        System.out.println(divResult);
    }
}
