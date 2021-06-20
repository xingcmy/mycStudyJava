package find.binarySearch;

import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

public class BinarySearchTest{

    private BinarySearch binarySearch = new BinarySearch();

    @Test
    public void binarySearch(){
        String[] list={"21", "45","87","93"};
        System.out.println(binarySearch.binarySearch(list,"21"));
    }

}