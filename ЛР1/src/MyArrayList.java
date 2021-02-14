import java.util.NoSuchElementException;


public class MyArrayList<T> implements List<T> {
    private final int INIT_SIZE = 16;
    private final int CUT_RATE = 4;
    private int pointer = -1;
    private Object[] array = new Object[INIT_SIZE];


    MyArrayList(){
    }

    @Override
    public void addFirst(T value){
        if (value != null) {
            if (pointer == array.length-1){
                resize(array.length*2);
            }
            for (int i = pointer + 1; i > 0; i--){
                array[i] = array[i-1];
            }
            array[0] = value;
            pointer++;
        }
    }

    @Override
    public void addLast(T value){
        if (value != null){
            if (pointer == array.length-1){
                resize(array.length*2);
            }
            pointer++;
            array[pointer] = value;
        }
    }

    @Override
    public void add(int index, T value){
        checkIndex(index-1);
        if (value != null){
            if (pointer == array.length-1){
                resize(array.length*2);
            }
            for (int i = pointer + 1; i > index; i--){
                array[i] = array[i-1];
            }
            array[index] = value;
            pointer++;
        }
    }

    @Override
    public void removeFirst(){
        for (int i = 0; i < pointer; i++){
            array[i] = array[i+1];
        }
        array[pointer] = null;
        pointer--;
        if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE){
            resize(array.length/2);
        }
    }

    @Override
    public void removeLast(){
        array[pointer] = null;
        pointer--;
        if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE){
            resize(array.length/2);
        }
    }

    @Override
    public void remove(int index){
        checkIndex(index);
        for (int i = index; i < pointer; i++){
            array[i] = array[i+1];
        }
        array[pointer] = null;
        pointer--;
        if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE){
            resize(array.length/2);
        }
    }

    @Override
    public void replaceFirst(T value){
        array[0] = value;
    }

    @Override
    public void replaceLast(T value){
        array[pointer] = value;
    }

    @Override
    public void replace(int index, T value){
        checkIndex(index);
        array[index] = value;
    }

    @Override
    public int indexOf(T value){
        int index = -1;
        for (int i = 0; i <= pointer; i++){
            if (array[i] == value){
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new NoSuchElementException("Element not found...");
        }
        return index;
    }

    @Override
    public int sum(){
        if (pointer == -1) {
            throw new NoSuchElementException("Elements not found...");
        }
        Integer result = 0;
        for (int i = 0; i <= pointer; i++) {
            if (array[i] instanceof Integer){
                result += (Integer)array[i];
            }
            else{
                throw new NumberFormatException("Value is not Integer...");
            }
        }
        return result;
    }

    @Override
    public int getSize(){
        return pointer + 1;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= pointer + 1) {
            throw new IndexOutOfBoundsException("Incorrect index output...");
        }
    }

    private void resize(int newLength){
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder("{ ");
        for (int i = 0; i <= pointer; i++) {
            str.append(array[i]).append(" ");
        }
        str.append("}");
        return str.toString();
    }

}
