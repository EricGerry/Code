package bridge.file;

/**
 * @Author：Eric
 * @Date：2020/4/17 19:21
 */
//mpeg格式
public class MPEG extends VideoFile {
    @Override
    public void play () {
        opf.playvideo();
    }
}