package bridge.file;

import bridge.platform.Operationplatform;

/**
 * @Author：Eric
 * @Date：2020/4/17 19:21
 */
//视频类
public abstract  class VideoFile{
    public Operationplatform opf;
    public void play(){
        opf.playvideo();
    }
}
