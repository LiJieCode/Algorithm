package mayi.test02;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    ArrayList<Integer> res = null;

    // 构造方法
    public Main(){
        res = new ArrayList<>();
    }

    public String push(int item) {
        res.add(item);
        return "success";
    }

    public String pop(){
        if (res.size() == 0) return "failed";
        res.remove(res.size() - 1);
        return "success";
    }

    public String front(){
        if (res.size() == 0) return "failed";
        return String.valueOf(res.get(res.size() - 1));
    }

    public boolean empty(){
        return res.size() == 0;
    }


    // main()函数
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


    }

}