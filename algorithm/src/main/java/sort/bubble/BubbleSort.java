package sort.bubble;

public class BubbleSort {
    public int[] bubbleSortAscendingOrder(int[] array) {
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

    public int[] bubbleSortDescendingOrder(int[] array) {
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

}
