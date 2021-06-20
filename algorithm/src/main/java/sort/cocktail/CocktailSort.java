package sort.cocktail;

public class CocktailSort {
    public int[] cocktailSortAscendingOrder(int[] array) {
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

    public int[] cocktailSortDescendingOrder(int[] array) {
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
