package sort.insertion;

public class InsertionSort {
    public int[] insertionSortAscendingOrder(int[] array, int value) {
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

    public int[] insertionSortDescendingOrder(int[] array, int value) {
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
}
