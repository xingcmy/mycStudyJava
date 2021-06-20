package find.binarySearch;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

public class BinarySearch {

    public int binarySearch(Object[] list, Object item){
        return getSubscript(list,item);
    }

    public int binarySearch(int[] list, Object item){
        if (isEmpty(list))
            return -1;
        Object[] objectList = toObject(list);
        return getSubscript(objectList,item);
    }

    public int binarySearch(long[] list,Object item){
        if (isEmpty(list))
            return -1;
        Object[] objectList = toObject(list);
        return getSubscript(objectList,item);
    }

    private Object[] toObject(int[] list){
        Object[] objectList = new Object[list.length];
        int length = 0;
        for (Object o : list){
            objectList[length]=o;
            length++;
        }
        return objectList;
    }

    private Object[] toObject(long[] list){
        Object[] objectList = new Object[list.length];
        int length = 0;
        for (Object o : list){
            objectList[length]=o;
            length++;
        }
        return objectList;
    }

    private int getSubscript(Object[] list,Object item){
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
        return checkTheProperties(guess,item,"left");
    }

    private boolean checkTheProperties(Object guess,Object item,String around){
        if (guess instanceof Integer){
            System.out.println("Integer");
            int g = (Integer) guess;
            int i = (Integer) item;
            if (around.equals("left")){
                if (g > i)
                    return false;
            }else if (around.equals("right")){
                if (g < i)
                    return false;
            }
            return true;
        }else if (guess instanceof String){
            System.out.println("String");
            String g = (String) guess;
            String i = (String) item;
            byte[] bytesG = stringToByte(g);
            byte[] bytesI = stringToByte(i);
            if (bytesG.length == 1 && bytesI.length == 1)
                if (around.equals("left")){
                    if (bytesG[0] > bytesI[0])
                        return false;
                }else if (around.equals("right")){
                    if (bytesG[0] < bytesI[0])
                        return false;
                }
            return true;
        }else if (guess instanceof Long){
            System.out.println("Long");
            Long g = (Long) guess;
            Long i = (Long) item;
            if (around.equals("left")){
                if ( g > i)
                    return false;
            }else if (around.equals("right")){
                if ( g < i)
                    return false;
            }
            return true;
        }
        return false;
    }

    private byte[] stringToByte(String str){
        String[] strings=str.split("");
        byte[] bytes=strings[0].getBytes(StandardCharsets.UTF_8);
        return bytes;
    }

    private boolean greaterThanItem(Object guess, Object item) {
        return checkTheProperties(guess,item,"right");
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

    private boolean isEmpty(long[] list) {
        int listSize = list.length;
        if (listSize <= 0)
            return true;
        return false;
    }
}
