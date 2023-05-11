package xiecheng.test04;

public class Main {
    public static void main(String[] args) {

        String str = "1?11?11?";
        System.out.println(isEven(str));

        System.out.println(str.replace('?', '9'));



        System.out.println(str.substring(0));

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
