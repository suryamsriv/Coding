package june;

import java.util.*;

public class Practice {

//    public static void main(String args[]) {
//        LinkedList list = new LinkedList();
//        list.addlast(4);
//        list.addFirst(2);
//        System.out.println(list.isEmpty());
//
//    }

     static class LinkedList {

        private class Node {
            private int value;
            private Node next;

            public Node(int value) {
                this.value = value;
            }
        }

        private Node first;
        private Node last;

        private int size;

        public void addlast(int item) {
            var node = new Node(item);
            if (first == null)
                first = last = node;
            else {
                last.next = node;
                last = node;
            }
            size++;
        }

        public void addFirst(int item) {
            var node = new Node(item);
            if (first == null)
                first = last = node;
            else {
                node.next = first;
                first = node;
            }
            size++;
        }

        public boolean isEmpty() {
            return first == null;
        }

        public int indexOf(int item) {
            int index = 0;
            var current = first;
            while (current != null) {
                if (current.value == item)
                    return index;
                current = current.next;
                index++;
            }
            return -1;
        }

        public boolean contains(int item) {
            return indexOf(item) != -1;
        }

        private Node getPrevious(Node node) {
            var current = first;
            while (current != null) {
                if (current.next == node)
                    return current;
                current = current.next;
            }
            return null;
        }

        public void removeLast() {
            if (isEmpty())
                throw new NoSuchElementException();
            if (first == last)
                first = last = null;
            else {
                var previous = getPrevious(last);
                last = previous;
                last.next = null;
            }
            size--;
        }

        public int size() {
            return size;
        }

        public void reverse() {
            if (isEmpty())
                return;

            var previous = first;
            var current = first.next;
            while (current != null) {
                var next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            last = first;
            last.next = null;
            first = previous;
        }

        public int getKthFromEnd(int k) {
            if (isEmpty())
                throw new IllegalStateException();

            var a = first;
            var b = first;
            for (int i = 0; i < k; i++) {
                b = b.next;
                if (b == null)
                    throw new IllegalArgumentException();
            }
            while (b != last) {
                a = a.next;
                b = b.next;
            }
            return a.value;
        }
    }

    class StringReverser {
        public String reverse(String str) {
            if(str == null)
                throw new IllegalArgumentException();

            Stack<Character> stack = new Stack<>();
            for(char ch : str.toCharArray())
                stack.push(ch);

            StringBuffer reversed = new StringBuffer();
            while(!stack.isEmpty()) {
                reversed.append(stack.pop());
            }
            return reversed.toString();
        }
    }

    class BalancedExpression {
        private List<Character> leftBrackets = Arrays.asList('(','[','{','<');
        private List<Character> rightBrackets = Arrays.asList(')',']','}','>');

        public boolean isBalanced(String input) {
            Stack<Character> stack = new Stack<>();

            for (char ch : input.toCharArray()) {
                if (isLeftBracket(ch))
                    stack.push(ch);
                if (isRightBracket(ch)) {
                    if (stack.isEmpty())
                        return false;

                    var top = stack.pop();
                    if (!bracketsMatch(top, ch))
                        return false;
                }
            }
            return stack.isEmpty();
        }

        private boolean isLeftBracket(char ch) {
            return leftBrackets.contains(ch);
        }
        private boolean isRightBracket(char ch) {
            return rightBrackets.contains(ch);
        }

        private boolean bracketsMatch(char left, char right) {
            return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
        }
    }

    class MyStack {
        private int[] items = new int[5];
        private int count;

        public void push(int item) {
            if(count == items.length)
                throw new StackOverflowError();
            items[count++] = item;
        }

        public int pop() {
            if(count == 0)
                throw new IllegalStateException();
            return items[--count];
        }
        public int peek () {
            if(count == 0)
                throw new IllegalStateException();
            return items[count - 1];
        }

        public boolean IsEmpty()
        {
            return count == 0;
        }

        @Override
        public String toString() {
            return Arrays.toString(Arrays.copyOfRange(items, 0, count));
        }
    }

    class ReverseQueue {
        public void reverse(Queue<Integer> queue) {
            Stack<Integer> stack = new Stack<>();
            while(!queue.isEmpty())
                stack.push(queue.remove());
            while(!stack.isEmpty())
                queue.add(stack.pop());
        }
    }

    class ArrayQueue {
        private int[] items;
        private int front;
        private int rear;
        private int count;

        public ArrayQueue(int capacity) {
            items = new int[capacity];
        }
        public void enqueue(int item) {
            if(count == items.length)
                throw new IllegalStateException();
            items[rear] = item;
            rear = (rear + 1) % items.length;
            count++;
        }

        public int dequeue() {
            var item = items[front];
            front = (front + 1) % items.length;
            count--;
            return item;
        }

        @Override
        public String toString() {
            return Arrays.toString(items);
        }
    }

    class QueueWithTwoStacks {
        private Stack<Integer> stack1 = new Stack<>();
        private Stack<Integer> stack2 = new Stack<>();

        public void enqueue(int item) {
            stack1.push(item);
        }
        public int dequeue() {
            if(isEmpty())
                throw new IllegalStateException();

            moveStack1toStack2();

            return stack2.pop();
        }
        private boolean isEmpty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }

        private void moveStack1toStack2() {
            if(stack2.isEmpty())
                while(!stack1.isEmpty())
                    stack2.push(stack1.pop());
        }
    }

    class MyPriorityQueue {
        private int[] items = new int[5];
        private int count;

        public void add(int item) {
            if(count == items.length)
                throw new IllegalStateException();
            int i = shiftItemsToInsert(item);
            items[i] = item;
            count++;
        }

        public int remove() {
            if(count == 0)
                throw new IllegalStateException();
            return items[--count];
        }

        public boolean isEmpty() {
            return count == 0;
        }

        private int shiftItemsToInsert(int item) {
            int i;
            for(i=count-1; i>=0; i--) {
                if(items[i] > item)
                    items[i+1] = items[i];
                else
                    break;
            }
            return i+1;
        }
    }

     class CharFinder {
        public char firstNonRepeatingChar(String str) {
            Map<Character, Integer> map = new HashMap<>();
            for(var ch:str.toCharArray()) {
                var count = map.containsKey(ch) ? map.get(ch) : 0;
                map.put(ch, count + 1);
            }
            for(var ch:str.toCharArray()) {
                if(map.get(ch) == 1)
                    return ch;
            }
            return Character.MIN_VALUE;
        }

        public char firstRepeatingChar(String str) {
            Set<Character> set =  new HashSet<>();

            for(var ch:str.toCharArray()) {
                if(set.contains(ch))
                    return ch;
                set.add(ch);
            }
            return Character.MIN_VALUE;
        }
    }

    class MyHashTable {
        private class Entry {
            private int key;
            private String value;

            public Entry(int key, String value) {
                this.key = key;
                this.value = value;
            }
        }

        private java.util.LinkedList<Entry>[] entries = new java.util.LinkedList[5];

        public void put(int key, String value) {
            var entry = getEntry(key);
            if(entry != null) {
                entry.value = value;
                return;
            }
            getOrCreateBucket(key).add(new Entry(key,value));
        }

        public String get(int key) {
            var entry = getEntry(key);
            return (entry==null) ? null : entry.value;
        }

        public void remove(int key) {
            var entry = getEntry(key);
            if(entry == null)
                throw new IllegalStateException();
            getBucket(key).remove(entry);
        }

        private int hash(int key) {
            return key % entries.length;
        }

        private Entry getEntry(int key) {
            var bucket = getBucket(key);
            if(bucket != null) {
                for(var entry : bucket) {
                    if(entry.key == key)
                        return entry;
                }
            }
            return null;
        }

        private java.util.LinkedList<Entry> getBucket(int key)
        {
            return entries[hash(key)];
        }

        private java.util.LinkedList<Entry> getOrCreateBucket(int key) {
            var index = hash(key);
            var bucket = entries[index];
            if(bucket == null)
                entries[index] = new java.util.LinkedList<>();

            return bucket;
        }
    }

    class MyTree {
        private class Node {
            private int value;
            private Node leftChild;
            private Node rightChild;

            public Node(int value) {
                this.value = value;
            }

            @Override
            public String toString() {
                return "Node= " + value;
            }
        }

        private Node root;
        public void insert(int value) {
            var node = new Node(value);
            if(root == null) {
                root = node;
                return;
            }
            var current = root;
            while(true) {
                if(value < current.value) {
                    if(current.leftChild == null) {
                        current.leftChild = node;
                        break;
                    }
                    current = current.leftChild;
                }
                else {
                    if(current.rightChild == null) {
                        current.rightChild = node;
                        break;
                    }
                    current = current.rightChild;
                }
            }
        }

        public boolean find(int value) {
            var current = root;
            while(current != null) {
                if(value < current.value)
                    current = current.leftChild;
                else if(value > current.value)
                    current = current.rightChild;
                else
                    return true;
            }
            return false;
        }

        public void traversePreOrder() {
            traversePreOrder(root);
        }
        private void traversePreOrder(Node root) {
            if(root == null)
                return;
            System.out.println(root.value);
            traversePreOrder(root.leftChild);
            traversePreOrder(root.rightChild);
        }

        public void traverseInOrder() {
            traverseInOrder(root);
        }
        private void traverseInOrder(Node root) {
            if(root == null)
                return;
            traverseInOrder(root.leftChild);
            System.out.println(root.value);
            traverseInOrder(root.rightChild);
        }

        public void traversePostOrder() {
            traversePostOrder(root);
        }
        private void traversePostOrder(Node root) {
            if(root == null)
                return;
            traversePostOrder(root.leftChild);
            traversePostOrder(root.rightChild);
            System.out.println(root.value);
        }

    }
}
