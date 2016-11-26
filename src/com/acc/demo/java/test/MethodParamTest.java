package com.acc.demo.java.test;

/**
 * Created by AfirSraftGarrier on 2016/11/25 0025.
 */
public class MethodParamTest {
    private static void change(int intNumm) {
        intNumm = 10;
    }

    private static void change(String string) {
        string = "Another string...";
    }

    private static void change(StringBuilder stringBuilder) {
        stringBuilder.append(" append...");
    }

    private static class TestClass {
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private String name;
    }

    private static void change(TestClass testClass) {
        testClass.setName("Hi, i'm changed...");
    }

    public static void main(String args[]) {
        int intNum = 99;
        change(intNum);
        System.out.println("After change, intNum is: " + intNum);
        String string = "Original string...";
        change(string);
        System.out.println("After change, string is: " + string);
        StringBuilder stringBuilder = new StringBuilder(string);
        change(stringBuilder);
        System.out.println("After change, stringBuilder is: " + stringBuilder);
        TestClass testClass = new TestClass();
        testClass.setName("Hi, i'm acc...");
        change(testClass);
        System.out.println("After change, testClass's name is: " + testClass.getName());
    }
}
