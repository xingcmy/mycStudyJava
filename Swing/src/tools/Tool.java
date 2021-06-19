package tools;

import java.awt.*;

public class Tool {

    /**
     * 获取桌面大小
     * @return
     */
    public Dimension getDimension(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return screenSize;
    }
}
