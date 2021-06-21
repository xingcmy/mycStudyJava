package sort.selection;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectionSortTest {

    private SelectionSort selectionSort = new SelectionSort();

    @Test
    public void setSelectionSort(){
        Object[] arr = new Object[]{"a15L","c54L","b41L","a62L","d23L","f88L","g76L","s92L","o10L","d12L","m14L","z45L","q65L","v19L","h13L"};
        //System.out.println(selectionSort.selectionSortDescendingOrder(arr));
        Object[] s=selectionSort.selectionSortAscendingOrder(arr);
        for (Object o : s){
            System.out.println(o.toString());
        }


        int[] arr1 = {5, 3, 6, 2, 10};
        System.out.println(Arrays.toString(selectionSort.selectionSortDescendingOrder(arr1)));
    }
}