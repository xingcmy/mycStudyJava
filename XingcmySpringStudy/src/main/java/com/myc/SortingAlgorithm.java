package main.java.com.myc;

import main.java.com.interfaceBean.Sort;

public class SortingAlgorithm implements Sort {
    @Override
    public int[] BubbleSortGoUp(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            boolean Flag = false; // 是否发生交换。没有交换，提前跳出外层循环
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    Flag = true;
                }
            }
            if (!Flag)
            {
                break;
            }
        }
        return array;
    }

    @Override
    public int[] BBubbleSortGoDown(int[] array) {
        int temp;
        for (int i = array.length - 1,number = 0; i > 0; i--,number++) {
            boolean Flag = false; // 是否发生交换。没有交换，提前跳出外层循环
            for (int j = array.length - 1; j > number; j--) {
                if (array[j] > array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    Flag = true;
                }
            }
            if (!Flag)
            {
                break;
            }
        }
        return array;
    }

    @Override
    public int[] InsertionSortGoUp(int[] array, int value) {
        int[] variable = null;
        if (array!=null){
            variable = new int[array.length+1];
        }else {
            variable = new int[1];
            variable[0] = value;
            return variable;
        }
        boolean Flag = false;//判断插入值是否处于两边
        for (int i = 0; i < variable.length; i++){
            if (i < array.length)
                if (array[i] > value){
                    Flag = true;
                    variable[i] = value;
                    for (int j = i; j < array.length; j++){
                        variable[j+1] = array[j];
                    }
                }else {
                    variable[i] = array[i];
                }
            else {
                variable[variable.length-1] = value;
            }
            if(Flag){
                break;
            }
        }
        return variable;
    }

    @Override
    public int[] InsertionSortGoDown(int[] array, int value) {
        int[] variable;
        if (array != null){
            variable = new int[array.length+1];
        }else {
            variable = new int[1];
            variable[0] = value;
            return variable;
        }

        boolean Flag = false;
        for (int i = variable.length - 1;i >= 0;i--){
            if (array[i-1] > value){
                variable[i] = value;
                Flag=true;
                for (int n = 0;n < i;n++){
                    variable[n]=array[n];
                }
            }else {
                variable[i]=array[i-1];
            }
            if (Flag){
                break;
            }

        }
        return variable;
    }

    @Override
    public int[] CocktailSortGoUp(int[] array) {
        int i, left = 0, right = array.length - 1;
        int temp;
        while (left < right) {
            for (i = left; i < right; i++)//寻找当前最大值
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            right--;
            for (i = right; i > left; i--)//寻找当前最小值
                if (array[i - 1] > array[i]) {
                    temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                }
            left++;
        }
        return array;
    }

    @Override
    public int[] CocktailSortGoDown(int[] array) {
        int i, left = 0, right = array.length - 1;
        int temp;
        while (left < right) {
            for (i = left; i < right; i++)//寻找当前最小值
                if (array[i] < array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            right--;
            for (i = right; i > left; i--)//寻找当前最大值
                if (array[i - 1] < array[i]) {
                    temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                }
            left++;
        }
        return array;
    }
}
