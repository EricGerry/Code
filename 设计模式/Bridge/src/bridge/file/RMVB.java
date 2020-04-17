package bridge.file;

/**
 * @Author：Eric
 * @Date：2020/4/17 19:22
 */
//rmvb格式
public class RMVB extends VideoFile {
    @Override
    public void play () {
        opf.playvideo();
    }
}