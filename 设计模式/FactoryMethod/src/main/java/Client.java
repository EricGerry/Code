/**
 * @Author：Eric
 * @Date：2020/4/11 21:37
 */
//客户端
public class Client {
    public static void main(String[] args) {
        MusicFactory musicFactory = new ClassicalMusicFactory();
        MusicFactory musicFactory1 = new PopMusicFactory();
        Music music = musicFactory.getMusic();
        music.produce();
        Music music1 = musicFactory1.getMusic();
        music1.produce();
    }
}
