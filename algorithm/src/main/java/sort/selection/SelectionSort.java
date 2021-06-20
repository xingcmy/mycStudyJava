package sort.selection;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort {
    public List<Integer> selectionSortDescendingOrder(List<Integer> arr){
        int size = arr.size();
        List<Integer> listArr = new ArrayList<>(size);
        for (int i = 0;i < size;i++){
            int small = findSmallSubscript(arr);
            listArr.add(arr.get(small));
            arr.remove(small);
        }
        return listArr;
    }

    public int[] selectionSortDescendingOrder(int[] arr){
        int size = arr.length;
        int[] intArr = new int[size];
        for (int i = 0;i < size;i++ ){
            int small = findSmallSubscript(arr);
            intArr[i] = arr[small];
            arr = newArr(arr,small);
        }
        return intArr;
    }

    public List<Integer> selectionSortAscendingOrder(List<Integer> arr){
        int size = arr.size();
        List<Integer> listArr = new ArrayList<>(size);
        for (int i = 0;i < size;i++){
            int big = findBigSubscript(arr);
            listArr.add(arr.get(big));
            arr.remove(big);
        }
        return listArr;
    }

    public int[] selectionSortAscendingOrder(int[] arr){
        int[] intArr = new int[arr.length];
        for (int i = 0;i < arr.length;i++ ){
            int big = findSmallSubscript(arr);
            intArr[i] = arr[big];
            arr = newArr(arr,big);
        }
        return intArr;
    }

    private int findBigSubscript(List<Integer> arr) {
        int flag = arr.get(0);
        int subscript = 0;
        for (int i = 1; i < arr.size();i++ ){
            if (arr.get(i) > flag){
                flag = arr.get(i);
                subscript = i;
            }
        }
        return subscript;
    }

    private int[] newArr(int[] arr, int code) {
        int size = arr.length;
        int[] newArr = new int[size-1];
        for (int i = 0;i<size;i++){
            if (i<code){
                newArr[i]=arr[i];
            }else if (i>code){
                newArr[i-1]=arr[i];
            }
        }
        return newArr;
    }

    private int findSmallSubscript(List<Integer> arr) {
        int flag = arr.get(0);
        int subscript = 0;
        for (int i = 1; i < arr.size();i++ ){
            if (arr.get(i) < flag){
                flag = arr.get(i);
                subscript = i;
            }
        }
        return subscript;
    }

    private int findSmallSubscript(int[] arr){
        int flag = arr[0];
        int subscript = 0;
        for (int i = 1; i < arr.length;i++ ){
            if (arr[i] < flag){
                flag = arr[i];
                subscript = i;
            }
        }
        return subscript;
    }
}
