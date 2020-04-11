/**
 * @Author：Eric
 * @Date：2020/4/11 22:17
 */
//具体工厂类：流行音乐工厂
public class PopMusicFactory extends MusicFactory {
    @Override
    public Music getMusic() {
        return new PopMusic();
    }
}
