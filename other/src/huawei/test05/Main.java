package huawei.test05;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        String s = "123+234";

//        System.out.println(s.replace("+", " "));

//        String s2 = s.replace("+", " ");
//        String[] s1 = s2.split(" ");
//
//        System.out.println(Arrays.toString(s1));
//
//
//        System.out.println(Integer.parseInt(String.valueOf('4')));


        String s = "123123";
        String[] split = s.replace(".", " ").split(" ");

        System.out.println(Arrays.toString(split));





    }
}
