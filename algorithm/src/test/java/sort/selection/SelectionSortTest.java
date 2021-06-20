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
        List<Integer> arr = new ArrayList<>(Arrays.asList(5, 3, 6, 2, 10));
        //System.out.println(selectionSort.selectionSortDescendingOrder(arr));
        System.out.println(selectionSort.selectionSortAscendingOrder(selectionSort.selectionSortDescendingOrder(arr)));


        int[] arr1 = {5, 3, 6, 2, 10};
        System.out.println(Arrays.toString(selectionSort.selectionSortDescendingOrder(arr1)));
    }
}