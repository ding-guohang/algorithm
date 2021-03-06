package com.dgh.leetcode;

/**
 * 设计实现双端队列。
 * 你的实现需要支持以下操作：
 * <p>
 * MyCircularDeque(k)：构造函数,双端队列的大小为k。
 * insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 * insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 * deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 * deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 * getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 * getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
 * isEmpty()：检查双端队列是否为空。
 * isFull()：检查双端队列是否满了。
 * 示例：
 * <p>
 * MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
 * circularDeque.insertLast(1);			        // 返回 true
 * circularDeque.insertLast(2);			        // 返回 true
 * circularDeque.insertFront(3);			        // 返回 true
 * circularDeque.insertFront(4);			        // 已经满了，返回 false
 * circularDeque.getRear();  				// 返回 2
 * circularDeque.isFull();				        // 返回 true
 * circularDeque.deleteLast();			        // 返回 true
 * circularDeque.insertFront(4);			        // 返回 true
 * circularDeque.getFront();				// 返回 4
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-circular-deque
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 丁国航 Meow on 2020/9/14
 */
public class Number641_Queue {

    static class MyCircularDeque {

        static class Node {
            int val;
            Node left;
            Node right;

            public Node(int val) {
                this.val = val;
            }
        }

        private Node head;
        private Node tail;
        private int size;
        private final int capacity;

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {
            capacity = k;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }

            Node node = new Node(value);
            if (size == 0) {
                head = node;
                tail = node;
            } else {
                node.right = head;
                head.left = node;
                head = node;
            }
            size++;
            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }

            Node node = new Node(value);
            if (size == 0) {
                tail = node;
                head = node;
            } else {
                tail.right = node;
                node.left = tail;
                tail = node;
            }
            size++;
            return true;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }

            if (size == 1) {
                head = null;
                tail = null;
            } else {
                head = head.right;
            }
            size--;
            return true;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }

            if (size == 1) {
                head = null;
                tail = null;
            } else {
                tail = tail.left;
            }

            size--;
            return true;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            if (isEmpty()) {
                return -1;
            }

            return head.val;
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            if (isEmpty()) {
                return -1;
            }

            return tail.val;
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            return size >= capacity;
        }
    }

    public static void main(String[] args) {
        MyCircularDeque queue = new MyCircularDeque(8);
        System.out.println(queue.insertFront(5));
        System.out.println(queue.getFront());
        System.out.println(queue.isEmpty());
        System.out.println(queue.deleteFront());
        System.out.println(queue.insertLast(3));
        System.out.println(queue.getRear());
        System.out.println(queue.insertLast(7));
        System.out.println(queue.insertFront(7));
        System.out.println(queue.deleteLast());
        System.out.println(queue.insertLast(4));
        System.out.println(queue.isEmpty());
    }

}
