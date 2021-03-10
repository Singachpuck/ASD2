public class Main {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.add(500);

        long start = System.nanoTime();
        for(int i = 0; i<1000 ;i++ )
        {
            tree.add(i);
        }
        long end = System.nanoTime();

        System.out.println("addTest     | " + (end - start) +" нс/1000");

        start = System.nanoTime();
        for(int i = 0; i<1000 ;i++ )
        {
            tree.remove(i);
        }
        end = System.nanoTime();

        System.out.println("removeTest  | " + (end-start) + " нс/1000");

        for(int i = 0; i<1000 ;i++ )
        {
            tree.add(i);
        }

        start = System.nanoTime();
        for(int i = 0; i<1000 ;i++ )
        {
            tree.contains(i);
        }
        end = System.nanoTime();

        System.out.println("containsTest| " + (end-start) + " нс/1000");

        start = System.nanoTime();
        for(int i = 0; i<1000 ;i++ )
        {
            tree.sum();
        }
        end = System.nanoTime();

        System.out.println("sumTest     | " + (end-start) + " нс/1000");



    }
}
