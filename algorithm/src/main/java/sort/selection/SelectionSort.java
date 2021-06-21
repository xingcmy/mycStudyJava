package sort.selection;

import find.binarySearch.BinarySearch;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;

@Log
public class SelectionSort {

    private BinarySearch binarySearch;

    public SelectionSort(){
        this.binarySearch = createBinarySearch();
    }

    /**
     * 选择排序
     * @param arr
     * @return
     */
    public List<Integer> selectionSortAscendingOrder(List<Integer> arr){
        return listAscendingOrder(arr);
    }

    public int[] selectionSortAscendingOrder(int[] arr){
        return intAscendingOrder(arr);
    }

    public long[] selectionSortAscendingOrder(long[] arr){
        return longAscendingOrder(arr);
    }

    public Object[] selectionSortAscendingOrder(Object[] arr){
        return objectAscendingOrder(arr);
    }

    public String[] selectionSortAscendingOrder(String[] arr){
        return stringAscendingOrder(arr);
    }

    public List<Integer> selectionSortDescendingOrder(List<Integer> arr){
        return listDescendingOrder(arr);
    }

    public int[] selectionSortDescendingOrder(int[] arr){
        return intDescendingOrder(arr);
    }

    public long[] selectionSortDescendingOrder(long[] arr){
        return longDescendingOrder(arr);
    }

    public Object[] selectionSortDescendingOrder(Object[] arr){
        return objectDescendingOrder(arr);
    }

    public String[] selectionSortDescendingOrder(String[] arr){
        return stringDescendingOrder(arr);
    }

    /**
     * 创建 BinarySearch 对象
     * @return
     */
    public BinarySearch createBinarySearch(){
        return new BinarySearch();
    }

    /**
     * object[] --> int[]
     * @param list
     * @return
     */
    public int[] toInt(Object[] list){
        int[] intList = new int[list.length];
        int length = 0;
        for (Object o : list){
            intList[length]=(int)o;
            length++;
        }
        return intList;
    }

    /**
     * object[] --> string[]
     * @param list
     * @return
     */
    public String[] toString(Object[] list){
        String[] stringList = new String[list.length];
        int length = 0;
        for (Object o : list){
            stringList[length]=(String) o;
            length++;
        }
        return stringList;
    }

    /**
     * object[] --> long[]
     * @param list
     * @return
     */
    public long[] toLong(Object[] list){
        long[] longList = new long[list.length];
        int length = 0;
        for (Object o : list){
            longList[length]=(long)o;
            length++;
        }
        return longList;
    }

    /**
     * object[] --> list[]
     * @param list
     * @return
     */
    public List<Integer> toListInteger(Object[] list){
        List<Integer> integerList = new ArrayList<>(list.length);
        for (Object o : list){
            integerList.add((int)o);
        }
        return integerList;
    }

    /**
     * 将 string 第一个字符转为 byte
     * @param arr
     * @return
     */
    public byte[] stringFirstLetterToByte(String[] arr){
        byte[] bytes = new byte[arr.length];
        int length = 0;
        for (String s : arr){
            byte[] b=binarySearch.stringToByte(s);
            bytes[length] = b[0];
            length++;
        }
        return bytes;
    }

    private List<Integer> listAscendingOrder(List<Integer> arr){
        int size = arr.size();
        List<Integer> listArr = new ArrayList<>(size);
        for (int i = 0;i < size;i++){
            int small = findSmallSubscript(arr);
            listArr.add(arr.get(small));
            arr.remove(small); //移除已排数据
        }
        return listArr;
    }

    private List<Integer> listDescendingOrder(List<Integer> arr){
        int size = arr.size();
        List<Integer> listArr = new ArrayList<>(size);
        for (int i = 0;i < size;i++){
            int big = findBigSubscript(arr);
            listArr.add(arr.get(big));
            arr.remove(big);
        }
        return listArr;
    }

    private Object[] objectAscendingOrder(Object[] arr){
        return checkThePropertiesAscendingOrder(arr);
    }

    private Object[] objectDescendingOrder(Object[] arr){
        return checkThePropertiesDescendingOrder(arr);
    }

    private String[] stringAscendingOrder(String[] arr){
        byte[] bytes = stringFirstLetterToByte(arr);
        int length = arr.length;
        String[] stringArr = new String[length];
        for (int i =0;i<length;i++){
            int small = findSmallSubscript(bytes);
            stringArr[i] = arr[small];
            arr = newArr(arr,small); //移除已排数据
            bytes = newArr(bytes,small);
        }
        return stringArr;
    }

    private String[] stringDescendingOrder(String[] arr){
        byte[] bytes = stringFirstLetterToByte(arr);
        int length = arr.length;
        String[] stringArr = new String[length];
        for (int i =0;i<length;i++){
            int big = findBigSubscript(bytes);
            stringArr[i] = arr[big];
            arr = newArr(arr,big);
            bytes = newArr(bytes,big);
        }
        return stringArr;
    }

    private int[] intAscendingOrder(int[] arr){
        int size = arr.length;
        int[] intArr = new int[size];
        for (int i = 0;i < size;i++ ){
            int small = findSmallSubscript(arr);
            intArr[i] = arr[small];
            arr = newArr(arr,small);
        }
        return intArr;
    }

    private int[] intDescendingOrder(int[] arr){
        int length = arr.length;
        int[] intArr = new int[length];
        for (int i = 0;i < length;i++ ){
            int big = findBigSubscript(arr);
            intArr[i] = arr[big];
            arr = newArr(arr,big);
        }
        return intArr;
    }

    private long[] longAscendingOrder(long[] arr) {
        int size = arr.length;
        long[] intArr = new long[size];
        for (int i = 0;i < size;i++ ){
            int small = findSmallSubscript(arr);
            intArr[i] = arr[small];
            arr = newArr(arr,small);
        }
        return intArr;
    }

    private long[] longDescendingOrder(long[] arr) {
        int size = arr.length;
        long[] intArr = new long[size];
        for (int i = 0;i < arr.length;i++ ){
            int big = findBigSubscript(arr);
            intArr[i] = arr[big];
            arr = newArr(arr,big);
        }
        return intArr;
    }

    private Object[] checkThePropertiesAscendingOrder(Object[] list){
        Object o = list[0];
        if (o instanceof Integer){
            log.info(o+"is Integer");
            return binarySearch.toObject(selectionSortAscendingOrder(toInt(list)));
        }else if (o instanceof String){
            log.info(o+"is String");
            return binarySearch.toObject(selectionSortAscendingOrder(toString(list)));
        }else if (o instanceof Long){
            log.info(o+"is Long");
            return binarySearch.toObject(selectionSortAscendingOrder(toLong(list)));
        }else {
            throw new RuntimeException(o+"is not a judgment type");
        }
    }

    private Object[] checkThePropertiesDescendingOrder(Object[] list){
        Object o = list[0];
        if (o instanceof Integer){
            log.info(o+"is Integer");
            return binarySearch.toObject(selectionSortDescendingOrder(toInt(list)));
        }else if (o instanceof String){
            log.info(o+"is String");
            return binarySearch.toObject(selectionSortDescendingOrder(toString(list)));
        }else if (o instanceof Long){
            log.info(o+"is Long");
            return binarySearch.toObject(selectionSortDescendingOrder(toLong(list)));
        }else {
            throw new RuntimeException(o+"is not a judgment type");
        }
    }

    /**
     * 查找数组中的最大数
     * @param arr
     * @return 最大数的下标
     */
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

    private int findBigSubscript(int[] arr) {
        int flag = arr[0];
        int subscript = 0;
        for (int i = 1; i < arr.length;i++ ){
            if (arr[i] > flag){
                flag = arr[i];
                subscript = i;
            }
        }
        return subscript;
    }

    private int findBigSubscript(long[] arr) {
        long flag = arr[0];
        int subscript = 0;
        for (int i = 1; i < arr.length;i++ ){
            if (arr[i] > flag){
                flag = arr[i];
                subscript = i;
            }
        }
        return subscript;
    }

    private int findBigSubscript(byte[] arr) {
        byte flag = arr[0];
        int subscript = 0;
        for (int i = 1; i < arr.length;i++ ){
            if (arr[i] > flag){
                flag = arr[i];
                subscript = i;
            }
        }
        return subscript;
    }

    /**
     * 移除 code 下标的数据
     * @param arr
     * @param code
     * @return
     */
    private int[] newArr(int[] arr, int code) {
        int size = arr.length;
        int[] newArr = new int[size-1];
        int i = 0;
        do{
            if (i<code){
                newArr[i]=arr[i];
            }else if (i > code){
                newArr[i-1]=arr[i];
            }
            i++;
        }while (i<size);
        return newArr;
    }

    private long[] newArr(long[] arr, int code) {
        int size = arr.length;
        long[] newArr = new long[size-1];
        int i = 0;
        while (i<size){
            if (i<code){
                newArr[i]=arr[i];
            }else if (i>code){
                newArr[i-1]=arr[i];
            }
            i++;
        }
        return newArr;
    }

    private String[] newArr(String[] arr, int code) {
        int size = arr.length;
        String[] newArr = new String[size-1];
        for (int i = 0;i<size;i++){
            if (i<code){
                newArr[i]=arr[i];
            }else if (i>code){
                newArr[i-1]=arr[i];
            }
        }
        return newArr;
    }

    private byte[] newArr(byte[] arr, int code) {
        int size = arr.length;
        byte[] newArr = new byte[size-1];
        for (int i = 0;i<size;i++){
            if (i<code){
                newArr[i]=arr[i];
            }else if (i>code){
                newArr[i-1]=arr[i];
            }
        }
        return newArr;
    }

    /**
     * 查找数组中的最小数
     * @param arr
     * @return 最小数的下标
     */
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

    private int findSmallSubscript(long[] arr){
        long flag = arr[0];
        int subscript = 0;
        for (int i = 1; i < arr.length;i++ ){
            if (arr[i] < flag){
                flag = arr[i];
                subscript = i;
            }
        }
        return subscript;
    }

    private int findSmallSubscript(byte[] arr){
        byte flag = arr[0];
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
