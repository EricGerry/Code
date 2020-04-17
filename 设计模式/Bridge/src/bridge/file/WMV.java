package bridge.file;

/**
 * @Author：Eric
 * @Date：2020/4/17 19:22
 */
//wmv格式
public class WMV extends VideoFile {
    @Override
    public void play () {
        opf.playvideo();
    }
}