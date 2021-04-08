public class Main {
    public static void main(String[] args) {
        minTest();
        avgTest();
        maxTest();
    }

    static void minTest(){
        System.out.println("----------Minimum Test-----------");
        Tree<Integer> tree = new Tree<>();
        Node<Integer> n = new Node<>(10);

        tree.add(500);

        long start = System.nanoTime();
        for(int i = 1; i<=500 ;i++ )
        {
            tree.add(500);
            //tree.add(500 - i);
        }
        long end = System.nanoTime();
        System.out.println("addTest     | " + (end - start) +" нс/1000");

        start = System.nanoTime();
        for(int i = 0; i<1000 ;i+=2 )
        {
            tree.remove(500);
            //tree.remove(1000-i);
        }
        end = System.nanoTime();
        System.out.println("removeTest  | " + (end-start) + " нс/1000");

        for(int i = 0; i<1000 ;i++ )
        {
            tree.add(0);
            //tree.add(1000-i);
        }

        //System.out.println(tree.getRoot());
        start = System.nanoTime();
        for(int i = 0; i<1000 ;i++ )
        {
            tree.contains(0);
            //tree.contains(500 - i);
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

    static void avgTest(){
        System.out.println("----------Average Test-----------");
        Tree<Integer> tree = new Tree<>();
        Node<Integer> n = new Node<>(10);

        tree.add(500);

        long start = System.nanoTime();
        for(int i = 0; i<1000 ;i++ )
        {
            tree.add((int)(Math.random()*1000));
        }
        long end = System.nanoTime();
        System.out.println("addTest     | " + (end - start) +" нс/1000");

        start = System.nanoTime();
        for(int i = 0; i<1000 ;i++ )
        {
            tree.remove((int)(Math.random()*1000));
        }
        end = System.nanoTime();
        System.out.println("removeTest  | " + (end-start) + " нс/1000");

        for(int i = 0; i<1000 ;i++ )
        {
            tree.add((int)(Math.random()*1000));
        }

        start = System.nanoTime();
        for(int i = 0; i<1000 ;i++ )
        {
            tree.contains((int)(Math.random()*1000));
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

    static void maxTest(){
        System.out.println("----------Maximum Test-----------");
        Tree<Integer> tree = new Tree<>();
        Node<Integer> n = new Node<>(10);

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
            tree.remove(1000-i);
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
            tree.contains(1000);
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
