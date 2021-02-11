public class User {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.addLast(10);
        list.addLast(10);
        list.addLast(10);
        for (int i = 0; i < 20; i++)
        {
            list.add(1, i);
            System.out.println(list);
        }

        System.out.println(list);
    }
}

