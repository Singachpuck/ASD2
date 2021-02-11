public class User {
    public static void main(String[] args) {

        //----Initializing----
        List<Integer> linkList = new LinkedList<>();
        List<Integer> doubleList = new DoublyLinkedList<>();
        List<Integer> circleList = new CircledList<>();

        //----Filling----
        for (int i = 0; i < 1000; i++) {
            linkList.addLast(i);
            doubleList.addLast(i);
            circleList.addLast(i);
        }
        //----addTest----
        System.out.println("----addTest----");
        long st1 = System.nanoTime();
        linkList.add(50, 123);
        long end1 = System.nanoTime();

        long st2 = System.nanoTime();
        doubleList.add(50, 123);
        long end2 = System.nanoTime();

        long st3 = System.nanoTime();
        circleList.add(50, 123);
        long end3 = System.nanoTime();

        System.out.println("linkList   | " + (end1 - st1) + " ns");
        System.out.println("doubleList | " + (end2 - st2) + " ns");
        System.out.println("circleList | " + (end3 - st3) + " ns");

        //----addLastTest----
        System.out.println("----addLastTest----");

        st1 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkList.addLast(312);
        }
        end1 = System.nanoTime();

        st2 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            doubleList.addLast(312);
        }
        end2 = System.nanoTime();

        st3 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            circleList.addLast(312);
        }
        end3 = System.nanoTime();

        System.out.println("linkList   | " + (end1 - st1) + " ns/1000");
        System.out.println("doubleList | " + (end2 - st2) + " ns/1000");
        System.out.println("circleList | " + (end3 - st3) + " ns/1000");

        //----addFirstTest----
        System.out.println("----addFirstTest----");

        st1 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkList.addFirst(312);
        }
        end1 = System.nanoTime();

        st2 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            doubleList.addFirst(312);
        }
        end2 = System.nanoTime();

        st3 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            circleList.addFirst(312);
        }
        end3 = System.nanoTime();

        System.out.println("linkList   | " + (end1 - st1) + " ns/1000");
        System.out.println("doubleList | " + (end2 - st2) + " ns/1000");
        System.out.println("circleList | " + (end3 - st3) + " ns/1000");

        //----removeFirstTest----
        System.out.println("----removeFirstTest----");

        st1 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkList.removeFirst();
        }
        end1 = System.nanoTime();

        st2 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            doubleList.removeFirst();
        }
        end2 = System.nanoTime();

        st3 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            circleList.removeFirst();
        }
        end3 = System.nanoTime();

        System.out.println("linkList   | " + (end1 - st1) + " ns/1000");
        System.out.println("doubleList | " + (end2 - st2) + " ns/1000");
        System.out.println("circleList | " + (end3 - st3) + " ns/1000");

        //----removeLastTest----
        System.out.println("----removeLastTest----");

        st1 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkList.removeLast();
        }
        end1 = System.nanoTime();

        st2 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            doubleList.removeLast();
        }
        end2 = System.nanoTime();

        st3 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            circleList.removeLast();
        }
        end3 = System.nanoTime();

        System.out.println("linkList   | " + (end1 - st1) + " ns/1000");
        System.out.println("doubleList | " + (end2 - st2) + " ns/1000");
        System.out.println("circleList | " + (end3 - st3) + " ns/1000");

        //----removeTest----
        System.out.println("----removeTest----");

        st1 = System.nanoTime();
        linkList.remove(50);
        end1 = System.nanoTime();

        st2 = System.nanoTime();
        doubleList.remove(50);
        end2 = System.nanoTime();

        st3 = System.nanoTime();
        circleList.remove(50);
        end3 = System.nanoTime();

        System.out.println("linkList   | " + (end1 - st1) + " ns");
        System.out.println("doubleList | " + (end2 - st2) + " ns");
        System.out.println("circleList | " + (end3 - st3) + " ns");

        //----replaceLastTest----
        System.out.println("----replaceLastTest----");

        st1 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkList.replaceLast(12);
        }
        end1 = System.nanoTime();

        st2 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            doubleList.replaceLast(12);
        }
        end2 = System.nanoTime();

        st3 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            circleList.replaceLast(12);
        }
        end3 = System.nanoTime();

        System.out.println("linkList   | " + (end1 - st1) + " ns/1000");
        System.out.println("doubleList | " + (end2 - st2) + " ns/1000");
        System.out.println("circleList | " + (end3 - st3) + " ns/1000");

        //----replaceFirstTest----
        System.out.println("----replaceFirstTest----");

        st1 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkList.replaceFirst(12);
        }
        end1 = System.nanoTime();

        st2 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            doubleList.replaceFirst(12);
        }
        end2 = System.nanoTime();

        st3 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            circleList.replaceFirst(12);
        }
        end3 = System.nanoTime();

        System.out.println("linkList   | " + (end1 - st1) + " ns/1000");
        System.out.println("doubleList | " + (end2 - st2) + " ns/1000");
        System.out.println("circleList | " + (end3 - st3) + " ns/1000");

        //----replaceTest----
        System.out.println("----removeTest----");

        st1 = System.nanoTime();
        linkList.replace(50,123);
        end1 = System.nanoTime();

        st2 = System.nanoTime();
        doubleList.replace(50,123);
        end2 = System.nanoTime();

        st3 = System.nanoTime();
        circleList.replace(50,123);
        end3 = System.nanoTime();

        System.out.println("linkList   | " + (end1 - st1) + " ns");
        System.out.println("doubleList | " + (end2 - st2) + " ns");
        System.out.println("circleList | " + (end3 - st3) + " ns");

        //----indexOfTest----
        System.out.println("----indexOfTest----");

        st1 = System.nanoTime();
        linkList.indexOf(123);
        end1 = System.nanoTime();

        st2 = System.nanoTime();
        doubleList.indexOf(123);
        end2 = System.nanoTime();

        st3 = System.nanoTime();
        circleList.indexOf(123);
        end3 = System.nanoTime();

        System.out.println("linkList   | " + (end1 - st1) + " ns");
        System.out.println("doubleList | " + (end2 - st2) + " ns");
        System.out.println("circleList | " + (end3 - st3) + " ns");




    }
}

