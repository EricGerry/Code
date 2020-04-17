package bridge.test;

import bridge.platform.Windowsplatform;
import bridge.file.MPEG;
import bridge.file.VideoFile;

/**
 * @Author：Eric
 * @Date：2020/4/17 19:23
 */
//客户端
public class Client {
    public static void main(String[] args) {
        VideoFile VF = new MPEG();
        VF.opf = new Windowsplatform();
        VF.play();
    }

}
