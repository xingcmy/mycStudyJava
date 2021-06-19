import com.Date;
import com.VariableType;

import java.io.File;
import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        //Scanner input=new Scanner(System.in);
        VariableType variableType=new VariableType();
        //System.out.println(VariableType.getType(input.nextInt()));
        String d="20210112155633";
        long length=Long.parseLong(d);

        int year= (int) (length/Math.pow(10,10));
        System.out.println(year+"\n"+length);
        Date date=new Date();
        System.out.println(date.getDay());
        try {
            System.out.println(date.getDay(length));
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
