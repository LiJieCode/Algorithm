package huawei.test03;

import com.sun.istack.internal.localization.NullLocalizable;

import java.util.List;

public class Main {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        int count = 0;

        ListNode tempList1 = list1;
        ListNode tempLista = null;
        ListNode tempList2 = list2;

        while (tempList2 != null){
            if (tempList2.next == null){
                break;
            }
            tempList2 = tempList2.next;
        }


        while (tempList1 != null) {
            if(count + 1 == a){
                tempLista = tempList1;
                tempList1 = tempList1.next;
                count++;
            } else if (count == b + 1){
                tempLista.next = list2;
                tempList2.next = tempList1;
                break;
            }else {
                tempList1 = tempList1.next;
                count++;
            }
        }

        return list1;
    }
}
