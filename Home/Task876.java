package Home;
//876. Middle of the Linked List (Середина односвязного списка)
//Для head односвязного списка верните средний узел связного списка.
//Если есть два средних узла, верните второй средний узел.

public class Task876 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Метод для создания списка из массива
    private static ListNode createLinkedList(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        ListNode head = new ListNode(values[0]);
        ListNode current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        return head;
    }

    // Метод для печати списка
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    // Основной метод решения задачи. Способ "Черепахи и Зайца"
    // slow всегда останавливается на середине
    public static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {     // цикл будет работать, пока fast не дойдёт до конца списка
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        // Создаем тестовый список
        int[] values = {1, 2, 3, 4, 5};
        ListNode head = createLinkedList(values);

        // Печатаем список для наглядности
        System.out.print("Исходный список: ");
        printList(head);

        // Находим середину
        ListNode middle = findMiddle(head);
        System.out.println("Средний узел: " + middle.val);

        // Тест с четным количеством элементов
        int[] values2 = {1, 2, 3, 4, 5, 6};
        ListNode head2 = createLinkedList(values2);
        System.out.print("\nСписок с четным числом элементов: ");
        printList(head2);

        ListNode middle2 = findMiddle(head2);
        System.out.println("Средний узел (возвращается второй): " + middle2.val);
    }
}