import java.util.*;

class Node{
    int key;
    int value;
    Node prev;
    Node next;

    Node(int key, int value){
        this.key=key;
        this.value=value;
    }
}
class LRUCache {
    int capacity;
    Map<Integer,Node> map;
    Node head = new Node(0,0);
    Node tail = new Node(0,0);

    public LRUCache(int capacity) {
        this.capacity=capacity;
        head.next=tail;
        tail.prev=head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }   
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        remove(map.get(key));

        if(map.size()==capacity)
        remove(tail.prev);

        insert(new Node(key,value));
    }

    public void insert(Node node){
        map.put(node.key,node);
        node.next=head.next;
        head.next=node;
        node.next.prev=node;
        node.prev=head;
    }

    public void remove(Node node){
        map.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */