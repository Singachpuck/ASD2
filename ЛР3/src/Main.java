public class Main {
    static int items = 1000;

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new AvlTree<>();

        long start = System.nanoTime();
        for(int i = 0; i<items; i++)
        {
            tree.add(i);
        }
        long end = System.nanoTime();

        System.out.println("addTest     | " + (end - start) +" нс/1000");

        start = System.nanoTime();
        for(int i = 0; i < items; i++)
        {
            tree.remove(i);
        }
        end = System.nanoTime();

        System.out.println("removeTest  | " + (end-start) + " нс/1000");

        for(int i = 0; i<items; i++ )
        {
            tree.add(i);
        }

        start = System.nanoTime();
        for(int i = 0; i<items; i++ )
        {
            tree.contains(i);
        }
        end = System.nanoTime();

        System.out.println("containsTest| " + (end-start) + " нс/1000");

        start = System.nanoTime();

        tree.sum();

        end = System.nanoTime();

        System.out.println("sumTest     | " + (end-start) + " нс/1000");
    }
}
