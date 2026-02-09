package JavaRush;

public class StringLinkedList {
    private Node first = new Node();
    private Node last = new Node();

    public StringLinkedList() {
        first.next = last;
        last.prev = first;
    }

    public void add(String value) {
        Node newNode = new Node();
        newNode.value = value;

        Node prevLast = last.prev;
        prevLast.next = newNode;
        newNode.prev = prevLast;
        newNode.next = last;
        last.prev = newNode;
    }

    public String get(int index) {
        //напишите тут ваш код
        if (index < 0) {
            return null;
        }

        int size = 0;
        Node current = first.next;
        while (current != last){
            size++;
            current = current.next;
        }
        if (index >= size) {
            return null;
        }

        if (index < size / 2){
            current = first.next;
            for (int i = 0; i < index; i++){
                current = current.next;
            }
        } else {
            current = last.prev;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }

        return current.value;
    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }

    public static void main(String[] args) {
        StringLinkedList stringLinkedList = new StringLinkedList();
        stringLinkedList.add("1");
        stringLinkedList.add("2");
        stringLinkedList.add("3");
        stringLinkedList.add("4");
        stringLinkedList.add("5");

        System.out.println("🚀 GitHub портфолио!");
        System.out.println(stringLinkedList.get(0)); // должно вывести "1"
        System.out.println(stringLinkedList.get(2)); // должно вывести "3"
        System.out.println(stringLinkedList.get(4)); // должно вывести "5"
        System.out.println(stringLinkedList.get(5)); // должно вывести null
    }
}
