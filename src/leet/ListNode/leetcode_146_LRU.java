package leet.ListNode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class leetcode_146_LRU {
    class LRUCache {
        // 内部形成双向链表类 内部数据结构并没有封装方法
        class LinkedNode{
            int key;
            int value;
            LinkedNode pre;
            LinkedNode next;
            public LinkedNode(){}
            public LinkedNode(int _key,int _value){
                key = _key;value = _value;
            }
        }
        private Map<Integer,LinkedNode> cache = new HashMap<Integer, LinkedNode>();
        private int size;
        private int capacity;
        // 定义头尾节点。
        private LinkedNode head;
        private LinkedNode tail;


        // 初始化链表作为缓存
        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            // 初始化链表头尾节点
            // head 、 tail 作为哨兵节点
            head = new LinkedNode();
            tail = new LinkedNode();
            head.next = tail;
            tail.pre = head;
        }

        /**
         * 根据键去找值
         * @param key
         * @return
         */
        public int get(int key) {
            // 1、 查询链表中是否有该key
            LinkedNode node = cache.get(key);
            // 没有则返回-1
            if (node == null)
                return -1;
            // 2、 有则获取值并移动链表到头节点和哈希映射
            moveToHead(node);
            return node.value;
        }



        public void put(int key, int value) {
            // 1、查询是否有key
            LinkedNode node = cache.get(key);
            // 2、没有直接添加到头节点，创建一个值
            if (node == null){
                // 创建节点
                LinkedNode newNode = new LinkedNode(key,value);
                // 放入缓存
                cache.put(key, newNode);
                addToHead(newNode);
                ++ size;
                // 判断是否达最长长度
                if (size >capacity){
                    LinkedNode tail = removeTail();
                    cache.remove(tail.key);
                    -- size;
                }
            }else {
                // 3、有则则将value 更新并添加到头节点。
                node.value = value;
                moveToHead(node);
            }
        }

        private void moveToHead(LinkedNode node) {
            removeTNode(node);
            addToHead(node);
        }

        private LinkedNode removeTail() {
            LinkedNode res = tail.pre;
            removeTNode(res);
            return res;
        }

        private void removeTNode(LinkedNode node){
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        private void addToHead(LinkedNode node) {
            node.pre = head;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
        }
    }
}











