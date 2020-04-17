package bridge.file;

/**
 * @Author：Eric
 * @Date：2020/4/17 19:22
 */
//avi格式
public class AVI extends VideoFile {
    @Override
    public void play () {
        opf.playvideo();
    }
}
