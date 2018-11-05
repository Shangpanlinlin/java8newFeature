package com.asd.nashorn;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Java8TesterNashorn {
    /*
    * nashorn是一个javascript引擎，从jdk8开始取代 rhino,
    *
    * */
    public static void main(String[] args) {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");

        String name = "Runoob";
        Integer result = null;
        try{
            nashorn.eval("print('" + name + "')");
            result = (Integer) nashorn.eval("10 + 2");
        }catch (ScriptException e){
            System.out.println("脚本执行错误："+ e.getMessage());
        }
        System.out.println(result.toString());
    }
}
