public class Main {
    public static void main(String []args){
        linkedListTest();
    }

    public static void linkedListTest(){

        System.out.println("-----------AddTest---------");
        for (int k = 1000;k<=10000000;k*=10) {
            for (int p = 1;p< 10 ;p++) {
                LinkedList<Integer> list = new LinkedList<>();
                long time = 0;
                for (int i = 0; i < 3; i++) {
                    long st1 = System.nanoTime();
                    for (int j = 0; j < k*p; j++) {
                        list.addFirst((int) (Math.random() * k*p));
                    }
                    long end1 = System.nanoTime();
                    time += end1 - st1;
                }
                System.out.println(p*k+"|" + (double) time / 3/1000000 );
            }
        }

    }
}
