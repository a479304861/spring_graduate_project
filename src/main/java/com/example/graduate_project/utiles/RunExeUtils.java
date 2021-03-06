package com.example.graduate_project.utiles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RunExeUtils {

    public static void openWinExe(String command) {
        Runtime rn = Runtime.getRuntime();
        Process p = null;
        try {
            p = rn.exec(command);
        } catch (Exception e) {
            System.out.println("Error win exec!");
        }
    }

    //调用其他的 可执行文件，例如：自己制作的exe，或是 下载 安装的软件.
    public static void openExe(String path) {
        Runtime rn = Runtime.getRuntime();
        Process p = null;
        try {
            p = rn.exec(path);
        } catch (Exception e) {
            System.out.println("Error exec!");
        }
    }


    public static void openRun(List<String> param) throws InterruptedException, IOException {
        Process process = new ProcessBuilder(param).start();
        process.waitFor();
    }

    public static void main(String[] args) {
        List<String> param = new ArrayList<>();
        param.add("mono");
        param.add("Program.exe");
        param.add("123456789");
        param.add("20");
        param.add("8");
        try {
            Process process = new ProcessBuilder(param).start();
            System.out.println(process.isAlive());     //true
            process.waitFor();
            System.out.println(process.isAlive());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
