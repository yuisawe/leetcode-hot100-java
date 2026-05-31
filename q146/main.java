package q146;

import java.util.HashMap;
import java.util.Map;

public class main {
    
}
class LRUCache {

    private int currentSize;
    private int capacity;
    private DLinkedNode head;
    private DLinkedNode tail;
    //头部代表刚刚使用，尾部代表没有使用
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(int key,int value){
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        };
        void setValue(int value){this.value = value;};
    }
    Map<Integer , DLinkedNode> map = new HashMap<>();
    public LRUCache(int capacity) {
        currentSize = 0;
        this.capacity = capacity;
        head = null;
        tail = null;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        DLinkedNode node = map.get(key);
        toHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            DLinkedNode node = map.get(key);
            node.setValue(value);
            toHead(node);
            return ;
        }
        DLinkedNode newNode = new DLinkedNode(key,value);
        if(currentSize == 0) {
            tail = newNode;
        }
        newNode.next = head;
        if(head != null) head.prev = newNode;
        head = newNode;
        if(currentSize == capacity){
            if(tail!=null&&tail.prev!=null) {
                map.remove(tail.key);
                tail.prev.next = null;
                tail = tail.prev;
            }
        }else{
            currentSize++;
        }
        map.put(key, newNode);

    }
    private void toHead(DLinkedNode node){
        if(head == node) return ;
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;
        if(prev!=null){
            prev.next = next;
        }
        if(next!=null){
            next.prev = prev;
        }
        node.next = head;
        head.prev = node;
        head = node;
        if(node == tail) {
            tail = tail.prev;
        }
    }
}