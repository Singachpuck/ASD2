import java.lang.instrument.Instrumentation;

class ObjectSizeFetcher {
    private static Instrumentation instrumentation;

    public static void premain(String args, Instrumentation inst) {
        instrumentation = inst;
    }

    public static long getObjectSize(Object o) {
        System.out.println(o);
        //return instrumentation.getObjectSize(o);
        return 0;
    }
}

public class User {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        ObjectSizeFetcher.getObjectSize(new DoublyLinkedList<>());

        int i = 10;
        double d = i;
    }
}

