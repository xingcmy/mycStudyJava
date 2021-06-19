package main.java.com.interfaceBean;

public interface Sort {

    /**
     *整型升序冒牌排序
     * @param array
     * @return
     */
    public int[] BubbleSortGoUp(int[] array);

    /**
     *整型降序冒泡排序
     * @param array
     * @return
     */
    public int[] BBubbleSortGoDown(int[] array);

    /**
     *整型升序插入排序
     * @param array
     * @param value
     * @return
     */
    public int[] InsertionSortGoUp(int[] array,int value);

    /**
     *整型降序插入排序
     * @param array
     * @param value
     * @return
     */
    public int[] InsertionSortGoDown(int[] array,int value);


    /**
     *整型升序定向冒泡排序
     * @param array
     * @return
     */
    public int[] CocktailSortGoUp(int[] array);

    /**
     *整型降序定向冒泡排序
     * @param array
     * @return
     */
    public int[] CocktailSortGoDown(int[] array);
}
