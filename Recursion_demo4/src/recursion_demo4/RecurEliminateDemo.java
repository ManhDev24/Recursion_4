/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursion_demo4;

import java.util.Stack;

/**
 *
 * @author NC
 */
public class RecurEliminateDemo {

    // recursive version
    public static String rec_convert(int n, int base) {
        if (n == 0) {
            return "0";
        }
        return rec_convert(n / base, base) + Character.forDigit(n % base, base);

    }

    // loop version : using as a stack
    public static String convert2(int n, int base) {
        String result = "";
        do {
            result = Character.forDigit(n % base, base) + result;
            n /= base;
        } while (n > 0);
        return result;
    }

    public static String covert3(int n, int base) {
        Stack<Character> stk = new Stack();

        do {
            stk.push(Character.forDigit(n % base, base));
            n /= base;
        } while (n > 0);

        // pop character from stack
        String result = "";
        while (!stk.empty()) {
            result += stk.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("10-base: " + rec_convert(122, 10));
        System.out.println("2-base: " + rec_convert(122, 2));
        System.out.println("8-base: " + rec_convert(122, 8));
        System.out.println("16-base: " + rec_convert(122, 16));
        String s1 = rec_convert(122, 16);
        String s2 = covert3(122, 16);
        String s3 = covert3(122, 16);
        System.out.println(s1 + ", " + s2 + ", " + s3);
    }
}
