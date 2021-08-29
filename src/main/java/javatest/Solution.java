package javatest;

import java.util.*;

/**
 * @author Liver
 * @Description
 * @date 2020/10/22 18:55
 */

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

}


public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            assert l1 != null;
            int n1 = l1.val;
            int n2 = l2.val;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();

        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }

    int iPos = 10;

    public int reverse(int num) {
        if (num / 10 == 0) {
            iPos = 10;
            return num;
        }
        int result = reverse(num / 10) + num % 10 * iPos;
        iPos *= 10;
        return result;

    }

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index/*决定递归次数*/, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                //撤回,消除分支污染
                combination.deleteCharAt(combination.length()-1/*index*/);
            }
        }
    }

    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if (l1==null){
            return l2;
        }else if (l2 == null){
            return l1;
        }else if (l1.val<l2.val){
            l1.next=mergeTwoLists(l1.next,l2);
        }else {
            l2.next=mergeTwoLists(l1,l2.next);
        }
        return null;
    }

    public ListNode swapPairs(ListNode head) {
        if (head==null|| head.next==null){
            return head;
        }
        ListNode newHead = head.next;
        head.next=swapPairs(head.next.next);
        newHead.next=head;
        return newHead;
    }
}
