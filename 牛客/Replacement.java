/**
 * @Author：Eric
 * @Date：2020/4/16 10:43
 */

/*空格替换

请编写一个方法，将字符串中的空格全部替换为“%20”。假定该字符串有足够的空间存放新增的字符，并且知道字符串的真实长度(小于等于1000)，同时保证字符串由大小写的英文字母组成。

给定一个string iniString 为原始的串，以及串的长度 int len, 返回替换后的string。

测试样例：
"Mr John Smith”,13
返回："Mr%20John%20Smith"
”Hello  World”,12
返回：”Hello%20%20World”*/

public class Replacement {
    public String replaceSpace(String iniString, int length) {
        if (iniString == null || length <= 0){
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++){
            char c = iniString.charAt(i);
            if (c == ' '){
                stringBuffer.append("%20");
            }else {
                stringBuffer.append(c);
            }
        }
        return stringBuffer.toString();
    }
}
