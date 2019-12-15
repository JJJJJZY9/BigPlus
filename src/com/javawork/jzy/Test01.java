package com.javawork.jzy;

import java.util.*;

public class Test01{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String get1 = "";
        String get2 = sc.nextLine();
        if("e".equals(get2)||"E".equals(get2)) {
            return;
        }
        while(sc.hasNext()) {
            get1=sumString(get1,get2);
            get2 = sc.nextLine();
            if("e".equals(get2)||"E".equals(get2)) {
                System.out.println(get1);
            }
        }
    }
    private static String sumString(String str1, String str2) {
        if(str1==null||"".equals(str1)) {
            return str2;
        }
        if(str2==null||"".equals(str2)) {
            return str1;
        }
        int maxLength = Math.max(str1.length(), str2.length())+1;
        StringBuilder result = new StringBuilder(maxLength);

        //翻转过程 方便对其求和
        str1 = new StringBuffer(str1).reverse().toString();
        str2 = new StringBuffer(str2).reverse().toString();

        int minLength = Math.min(str1.length(), str2.length());
        //进位标记
        int flag = 0;
        //当前位数值
        int currentNum;
        //奥利给
        int i=0;
        for(;i<minLength;i++) {
            currentNum=str1.charAt(i)+str2.charAt(i)-2*'0'+flag;
            flag=currentNum/10;
            currentNum %=10;
            result.append(currentNum);
        }
        if(str1.length()<str2.length()) {
            str1=str2;
        }
        for(;i<str1.length();i++) {
            currentNum=str1.charAt(i)-'0'+flag;
            flag=currentNum/10;
            currentNum %=10;
            result.append(currentNum);
        }
        //最后一个 判断最后有没有进位
        if(flag==1) {
            result.append(flag);
        }

        //返回翻转字符串
        return result.reverse().toString();
    }
}
