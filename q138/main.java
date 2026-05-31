package q138;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class main {
    
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        List<Node> lists = new ArrayList<>();
        Map<Node , Integer> map = new HashMap<>();
        Node cur = head;int idx = 0;
        while(cur!=null){
            lists.add(cur);
            map.put(cur, idx++);
            cur = cur.next;
        }
        List<Node> newLists = new ArrayList<>();
        int size = lists.size();
        for(int i = 0 ; i <size ; i++){
            newLists.add(new Node(lists.get(i).val));
        }
        for(int i = 0 ; i < size ; i++){
            Node copycur = newLists.get(i);
            Node oldcur = lists.get(i);
            copycur.next = i < size - 1 ? newLists.get(i+1) : null;  
            int oldrandidx =map.getOrDefault(oldcur.random, -1);
            copycur.random = oldrandidx == -1 ? null : newLists.get(oldrandidx);

        }
        return newLists.get(0);

    }
}