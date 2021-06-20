package find.binarySearch;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class BinarySearch {

    public int binarySearch(Object[] list, Object item){
        return getSubscript(list,item);
    }

    public int binarySearch(int[] list, Object item){
        if (isEmpty(list))
            return -1;
        Object[] objectList = new Object[list.length];
        int length = 0;
        for (Object o : list){
            objectList[length]=o;
            length++;
        }
        return getSubscript(objectList,item);
    }

    public int getSubscript(Object[] list,Object item){
        if (isEmpty(list))
            return -1;
        int left = 0;
        int right = list.length;
        for (;left <= right;){
            int mid = (left+right) / 2;
            Object guess = list[mid];
            if (equalsItem(guess,item))
                return mid;
            else if (greaterThanItem(guess,item))
                right = mid - 1;
            else if (lessThanItem(guess,item))
                left = mid + 1;
        }
        return -1;
    }

    private boolean lessThanItem(Object guess, Object item) {
        if (guess instanceof Integer){
            //if (guess < item)
            System.out.println("Integer");
                return true;
        }else if (guess instanceof String){
            System.out.println("String");
            return true;
        }
        return false;
    }

    private boolean greaterThanItem(Object guess, Object item) {
        return false;
    }

    private boolean equalsItem(Object guess, Object item) {
        if (!guess.equals(item) || guess != item)
            return false;
        return true;
    }

    private boolean isEmpty(Object[] list) {
        int listSize = list.length;
        if (listSize <= 0)
            return true;
        return false;
    }

    private boolean isEmpty(int[] list) {
        int listSize = list.length;
        if (listSize <= 0)
            return true;
        return false;
    }
}
