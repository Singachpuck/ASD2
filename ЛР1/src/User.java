public class User {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        System.out.println(list.getSize());
        list.addFirst(10);
        list.add("ss");
        list.addLast("hello");
        System.out.println(list);
        System.out.println(list.getSize());
        list.replace(2,2);
        System.out.println(list.getSize());
        System.out.println(list);
        list.replace(3,"heh");
        System.out.println(list);
        System.out.println(list.getSize());
        System.out.println(list.indexOf("he"));


    }
}
