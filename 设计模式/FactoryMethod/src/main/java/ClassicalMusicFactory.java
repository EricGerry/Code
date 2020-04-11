/**
 * @Author：Eric
 * @Date：2020/4/11 22:15
 */
//具体工厂类：古典音乐工厂
public class ClassicalMusicFactory extends MusicFactory {
    @Override
    public Music getMusic() {
        return new ClassicalMusic();
    }
}
