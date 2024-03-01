package Serie2;

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class LinkedListSorter {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Dividir la lista en dos mitades
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        // Ordenar cada mitad de forma recursiva
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // Combinar las mitades ordenadas
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        // Agregar los nodos restantes de l1 o l2
        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }

        return dummy.next;
    }

    // Método para imprimir los elementos de la lista enlazada
    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListSorter sorter = new LinkedListSorter();
        Scanner scanner = new Scanner(System.in);

        // Prueba 1
        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(1);
        head1.next.next.next = new ListNode(3);
        System.out.println("Prueba 1:");
        System.out.print("Entrada: ");
        sorter.printList(head1);
        ListNode sortedList1 = sorter.sortList(head1);
        System.out.print("Salida: ");
        sorter.printList(sortedList1);

        // Prueba 2
        ListNode head2 = new ListNode(-1);
        head2.next = new ListNode(5);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(0);
        System.out.println("\nPrueba 2:");
        System.out.print("Entrada: ");
        sorter.printList(head2);
        ListNode sortedList2 = sorter.sortList(head2);
        System.out.print("Salida: ");
        sorter.printList(sortedList2);

        // Prueba 3
        System.out.println("\nPrueba 3:");
        System.out.println("Ingrese los valores de la lista enlazada separados por espacios (por ejemplo: 1 2 3):");
        String input = scanner.nextLine();
        String[] values = input.split(" ");

        ListNode head3 = null;
        ListNode current = null;
        for (String value : values) {
            int num = Integer.parseInt(value);
            if (head3 == null) {
                head3 = new ListNode(num);
                current = head3;
            } else {
                current.next = new ListNode(num);
                current = current.next;
            }
        }

        System.out.print("Entrada: ");
        sorter.printList(head3);
        ListNode sortedList3 = sorter.sortList(head3);
        System.out.print("Salida: ");
        sorter.printList(sortedList3);

        scanner.close();
    }
}
