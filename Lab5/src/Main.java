public class Main {
    static MyHashMap<Integer> hashMap = new MyHashMap<>();

    public static void main(String[] args){
        insertTest();
        findTest();
        deleteTest();
    }

    public static void insertTest(){
        long start = System.nanoTime();
        for(int i = 1; i<=100000 ;i++ )
        {
            hashMap.insert("" + i + "",i);
        }
        long end = System.nanoTime();
        System.out.println("insertTest  | " + (end - start)/1000000 +" мс/100 000");

    }

    public static void findTest(){
        long start = System.nanoTime();
        for(int i = 0; i<100000 ;i+=2 )
        {
            hashMap.find("" + i + "");
        }
        long end = System.nanoTime();
        System.out.println("findTest    | " + (end-start)/1000000 + " мс/100 000");
    }

    public static void deleteTest(){
        long start = System.nanoTime();
        for(int i = 0; i<100000 ;i++ )
        {
            hashMap.delete("" + i + "");
        }
        long end = System.nanoTime();
        System.out.println("deleteTest  | " + (end-start)/1000000 + " мс/100 000");
    }


}
