package huawei.test06;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String line = "123.45#1+126.53@";
        String str = line.replace("+", " ");

        // 这里就是把字符串分成了两部分
        String[] strs = str.split("");

        // 把两个量的整数和小数分开
        // 如果只有整数，则数组只有一个元素
        String[] s1 = strs[0].replace(".", " ").split(" ");
        String[] s2 = strs[1].replace(".", " ").split(" ");


        String sss = "123.45#1";

        String[] s222 = sss.replace(".", " ").split(" ");

        System.out.println(Arrays.toString(s222));

    }
}
