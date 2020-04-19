package File.Op;

/**
 * @Author：Eric
 * @Date：2020/4/19 15:50
 */
//具体调用操作
public class Union {
    ReadSource read;
    Encrypt en;
    Save save;

    public Union() {
        read=new ReadSource();
        en=new Encrypt();
        save=new Save();
    }

    public void operate(){
        read.operate();
        en.operate();
        save.operate();
    }
}
