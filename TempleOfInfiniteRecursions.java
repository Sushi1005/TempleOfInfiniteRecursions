import java.util.*;

public class TempleOfInfiniteRecursions {
    public static void main(String[] args) {
        IndianaJones indy = new IndianaJones();
        indy.startAdventure();
    }

    // Chapter 1: The Array Abyss
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;  // Element not found
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;  // Element not found
    }
}

class IndianaJones {
    private int health = 100;
    private List<String> inventory = new ArrayList<>();

    public void startAdventure() {
        System.out.println("Indiana Jones enters the Temple of Infinite Recursions...");
    }
}

// Generic Stack class
class Stack<T> {
    private List<T> data;

    Stack() {
        data = new ArrayList<>();
    }

    void push(T item) {
        data.add(item);
    }

    T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return data.remove(data.size() - 1);
    }

    T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return data.get(data.size() - 1);
    }

    boolean isEmpty() {
        return data.isEmpty();
    }
}

// Generic LinkedList class
class LinkedList<T> {
    class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    Node<T> head;

    void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    void delete(T data) {
        if (head == null) return;
        if (head.data.equals(data)) {
            head = head.next;
            return;
        }
        Node<T> current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    boolean hasCycle() {
        Node<T> slow = head;
        Node<T> fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}

// Using Stack<Character> in isBalanced() method
class BalancedParentheses {
    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();  // Correct use of generics
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (c == ')' && top != '(' || c == '}' && top != '{' || c == ']' && top != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
