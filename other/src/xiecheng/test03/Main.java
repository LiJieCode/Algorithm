package xiecheng.test03;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        ArrayList<Integer> arrayList = new ArrayList<>();

        // 记录？的位置
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '?') {
                arrayList.add(i);
            }
        }

        int size = arrayList.size();

        for (int i = 0; i < size; i++) {
            // 提取出？的位置
            Integer ans = arrayList.get(i);

            if (ans == 0) {
                for (int j = 0; j < 3; j++) {
                    if (i == 0) {
                        str = str.replace('?', '0');
                        boolean b2 = str.charAt(ans + 1) != str.charAt(ans);
                        String sub3 = str.substring(ans, ans + 3);
                        if( b2  && isEven(sub3)) break;
                    } else if (i == 1) {
                        str = str.replace('?', '1');
                        boolean b2 = str.charAt(ans + 1) != str.charAt(ans);
                        String sub3 = str.substring(ans, ans + 3);
                        if( b2  && isEven(sub3)) break;
                    } else {
                        str = str.replace('?', '2');
                        boolean b2 = str.charAt(ans + 1) != str.charAt(ans);
                        String sub3 = str.substring(ans, ans + 3);
                        if( b2  && isEven(sub3)) break;
                    }
                }
            } else if (ans == str.length() - 1) {
                for (int j = 0; j < 3; j++) {
                    if (i == 0) {
                        str = str.replace('?', '0');
                        boolean b1 = str.charAt(ans - 1) != str.charAt(ans);
                        String sub1 = str.substring(ans - 2);
                        if(b1 && isEven(sub1) ) break;
                    } else if (i == 1) {
                        str = str.replace('?', '0');
                        boolean b1 = str.charAt(ans - 1) != str.charAt(ans);
                        String sub1 = str.substring(ans - 2);
                        if(b1 && isEven(sub1) ) break;
                    } else {
                        str = str.replace('?', '0');
                        boolean b1 = str.charAt(ans - 1) != str.charAt(ans);
                        String sub1 = str.substring(ans - 2);
                        if(b1 && isEven(sub1) ) break;
                    }
                }
            } else if(ans == 1){
                for (int j = 0; j < 3; j++) {
                    if (i == 0) {
                        str = str.replace('?', '0');
                        boolean b1 = str.charAt(ans - 1) != str.charAt(ans);
                        boolean b2 = str.charAt(ans + 1) != str.charAt(ans);
                        String sub2 = str.substring(ans - 1, ans + 2);
                        String sub3 = str.substring(ans, ans + 3);
                        if(b1 && b2 && isEven(sub2) && isEven(sub3)) break;
                    } else if (i == 1) {
                        str = str.replace('?', '1');
                        boolean b1 = str.charAt(ans - 1) != str.charAt(ans);
                        boolean b2 = str.charAt(ans + 1) != str.charAt(ans);
                        String sub2 = str.substring(ans - 1, ans + 2);
                        String sub3 = str.substring(ans, ans + 3);
                        if(b1 && b2  && isEven(sub2) && isEven(sub3)) break;
                    } else {
                        str = str.replace('?', '2');
                        boolean b1 = str.charAt(ans - 1) != str.charAt(ans);
                        boolean b2 = str.charAt(ans + 1) != str.charAt(ans);
                        String sub2 = str.substring(ans - 1, ans + 2);
                        String sub3 = str.substring(ans, ans + 3);
                        if(b1 && b2  && isEven(sub2) && isEven(sub3)) break;
                    }
                }
            }else if (ans == str.length() - 2 ){
                for (int j = 0; j < 3; j++) {
                    if (i == 0) {
                        str = str.replace('?', '0');
                        boolean b1 = str.charAt(ans - 1) != str.charAt(ans);
                        boolean b2 = str.charAt(ans + 1) != str.charAt(ans);
                        String sub1 = str.substring(ans - 2, ans + 1);
                        String sub2 = str.substring(ans - 1);
                        if(b1 && b2 && isEven(sub1) && isEven(sub2) ) break;
                    } else if (i == 1) {
                        str = str.replace('?', '0');
                        boolean b1 = str.charAt(ans - 1) != str.charAt(ans);
                        boolean b2 = str.charAt(ans + 1) != str.charAt(ans);
                        String sub1 = str.substring(ans - 2, ans + 1);
                        String sub2 = str.substring(ans - 1);
                        if(b1 && b2 && isEven(sub1) && isEven(sub2) ) break;
                    } else {
                        str = str.replace('?', '0');
                        boolean b1 = str.charAt(ans - 1) != str.charAt(ans);
                        boolean b2 = str.charAt(ans + 1) != str.charAt(ans);
                        String sub1 = str.substring(ans - 2, ans + 1);
                        String sub2 = str.substring(ans - 1);
                        if(b1 && b2 && isEven(sub1) && isEven(sub2) ) break;
                    }
                }
            } else {
                for (int j = 0; j < 3; j++) {
                    if (i == 0) {
                        str = str.replace('?', '0');
                        boolean b1 = str.charAt(ans - 1) != str.charAt(ans);
                        boolean b2 = str.charAt(ans + 1) != str.charAt(ans);
                        String sub1 = str.substring(ans - 2, ans + 1);
                        String sub2 = str.substring(ans - 1, ans + 2);
                        String sub3 = str.substring(ans, ans + 3);
                        if(b1 && b2 && isEven(sub1) && isEven(sub2) && isEven(sub3)) break;
                    } else if (i == 1) {
                        str = str.replace('?', '1');
                        boolean b1 = str.charAt(ans - 1) != str.charAt(ans);
                        boolean b2 = str.charAt(ans + 1) != str.charAt(ans);
                        String sub1 = str.substring(ans - 2, ans + 1);
                        String sub2 = str.substring(ans - 1, ans + 2);
                        String sub3 = str.substring(ans, ans + 3);
                        if(b1 && b2 && isEven(sub1) && isEven(sub2) && isEven(sub3)) break;
                    } else {
                        str = str.replace('?', '2');
                        boolean b1 = str.charAt(ans - 1) != str.charAt(ans);
                        boolean b2 = str.charAt(ans + 1) != str.charAt(ans);
                        String sub1 = str.substring(ans - 2, ans + 1);
                        String sub2 = str.substring(ans - 1, ans + 2);
                        String sub3 = str.substring(ans, ans + 3);
                        if(b1 && b2 && isEven(sub1) && isEven(sub2) && isEven(sub3)) break;
                    }
                }
            }
        }
        System.out.println(str);
    }
    public static boolean isEven(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += str.charAt(i) * (int) Math.pow(2, 3 - i);
        }
        if (sum % 2 == 0 ) return true;
        return false;
    }
}
