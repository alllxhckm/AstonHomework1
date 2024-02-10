import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();//simple constructor
        myArrayList.addAll(List.of(2,7,0,9,3));//add from another collection
        myArrayList.add(10);//add at the end
        MyArrayList.bubbleSort(myArrayList);//static sort
        System.out.println(myArrayList);


        List<Integer> anotherList = Arrays.asList(14, 22, 77, 13);
        MyArrayList<Integer> anotherMyList = new MyArrayList<>(anotherList);//constructor with another collection
        System.out.println(anotherMyList);

        MyArrayList<Integer> addRemove = new MyArrayList<>();
        addRemove.add(1);
        addRemove.add(2);
        addRemove.add(3);
        addRemove.add(4);
        addRemove.add(5);
        System.out.println(addRemove);
        addRemove.add(2,10);//add to the middle of list
        System.out.println(addRemove);
        addRemove.remove(4);//remove from the middle of list
        System.out.println(addRemove);


        MyArrayList<Integer> getElem = new MyArrayList<>();
        getElem.add(1);
        getElem.add(2);
        getElem.add(3);
        getElem.add(4);
        System.out.println(getElem.get(3));
    }
}