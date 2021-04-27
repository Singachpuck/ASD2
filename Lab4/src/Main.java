public class Main {
    public static void main (String[] args) {
        randTest();
        increaseTest();
        decreaseTest();
        sortTest();
    }

    static void sortTest(){
        System.out.println("----------Heap Test-----------");
        BinaryHeap <Integer> test = new BinaryHeap<Integer> ();

        test.insert(500);

        for(int i = 0; i<10 ;i++ )
        {
            test.insert((int)(Math.random()*100));
        }
        System.out.println("----------Print Array-----------");
        test.print();
        System.out.println("----------Print Heap-----------");
        test.outHeap();
        System.out.println("----------Sort Test-----------");
        test.sort();
    }

    static void randTest(){
        System.out.println("----------Random Test-----------");
        BinaryHeap <Integer> test = new BinaryHeap<Integer> ();

        test.insert(500);

        long start = System.nanoTime();
        for(int i = 1; i<=100000 ;i++ )
        {
            test.insert((int)(Math.random()*1000));
        }
        long end = System.nanoTime();
        System.out.println("insertTest  | " + (end - start)/1000000 +" мс/100 000");

        start = System.nanoTime();
        for(int i = 0; i<100000 ;i+=2 )
        {
            test.findIndexByValue((int)(Math.random()*1000));
        }
        end = System.nanoTime();
        System.out.println("findTest    | " + (end-start)/1000000 + " мс/100 000");

        start = System.nanoTime();
        for(int i = 0; i<100000 ;i++ )
        {
            test.delete((int)(Math.random()*1000));
        }
        end = System.nanoTime();
        System.out.println("deleteTest  | " + (end-start)/1000000 + " мс/100 000");
    }

    static void increaseTest(){
        System.out.println("----------1 - 100 000 Test-----------");
        BinaryHeap <Integer> test = new BinaryHeap<Integer> ();

        test.insert(500);

        long start = System.nanoTime();
        for(int i = 1; i<=100000 ;i++ )
        {
            test.insert(i);
        }
        long end = System.nanoTime();
        System.out.println("insertTest  | " + (end - start)/1000000 +" мс/100 000");

        start = System.nanoTime();
        for(int i = 1; i<=100000 ;i++ )
        {
            test.findIndexByValue(i);
        }
        end = System.nanoTime();
        System.out.println("findTest    | " + (end-start)/1000000 + " мс/100 000");

        start = System.nanoTime();
        for(int i = 1; i<=100000 ;i++ )
        {
            test.delete(i);
        }
        end = System.nanoTime();
        System.out.println("deleteTest  | " + (end-start)/1000000 + " мс/100 000");
    }

    static void decreaseTest(){
        System.out.println("----------100 000 - 1 Test-----------");
        BinaryHeap <Integer> test = new BinaryHeap<Integer> ();

        test.insert(500);

        long start = System.nanoTime();
        for(int i = 100000; i>=1 ;i-- )
        {
            test.insert(i);
        }
        long end = System.nanoTime();
        System.out.println("insertTest  | " + (end - start)/1000000 +" мс/100 000");

        start = System.nanoTime();
        for(int i = 100000; i>=1 ;i-- )
        {
            test.findIndexByValue(i);
        }
        end = System.nanoTime();
        System.out.println("findTest    | " + (end-start)/1000000 + " мс/100 000");

        start = System.nanoTime();
        for(int i = 100000; i>=1 ;i-- )
        {
            test.delete(i);
        }
        end = System.nanoTime();
        System.out.println("deleteTest  | " + (end-start)/1000000 + " мс/100 000");
    }
}
