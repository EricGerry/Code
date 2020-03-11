import java.util.Arrays;
import java.util.Scanner;

/*
* 找出n个数里最小的k个
* 输入描述:
* 每个测试输入包含空格分割的n+1个整数，最后一个整数为k值,n不超过100。
* 输出描述:
* 输出n个整数里最小的k个数。升序输出
* 示例1
* 输入
* 3 9 6 8 -10 7 -11 19 30 12 23 5
* 输出
* -11 -10 3 6 7
* */

public class FindKMin {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        /*
        * 定义和用法、
        * split() 方法用于把一个字符串分割成字符串数组。
        * 语法
        * stringObject.split(separator,howmany)
        * 参数	描述
        * separator	必需。字符串或正则表达式，从该参数指定的地方分割 stringObject。
        * howmany	可选。该参数可指定返回的数组的最大长度。如果设置了该参数，返回的子串不会多于这个参数指定的数组。如果没有设置该参数，整个字符串都会被分割，不考虑它的长度。
        * 返回值
        * 一个字符串数组。该数组是通过在 separator 指定的边界处将字符串 stringObject 分割成子串创建的。返回的数组中的字串不包括 separator 自身。
        * 但是，如果 separator 是包含子表达式的正则表达式，那么返回的数组中包括与这些子表达式匹配的字串（但不包括与整个正则表达式匹配的文本）。
        * 提示和注释
        * 注释：如果把空字符串 ("") 用作 separator，那么 stringObject 中的每个字符之间都会被分割。
        * 注释：String.split() 执行的操作与 Array.join 执行的操作是相反的。
        * */
        String[] string=in.nextLine().split(" ");
        int[] array=new int[string.length-1];
        for(int i=0;i<string.length-1;i++){
            array[i]=Integer.parseInt(string[i]);
        }
        Arrays.sort(array);
        /*
        * parseInt() 函数可解析一个字符串，并返回一个整数。
        * 语法
        * parseInt(string, radix)
        * 参数	描述
        * string	必需。要被解析的字符串。
        * radix	可选。表示要解析的数字的基数。该值介于 2 ~ 36 之间。
        * 如果省略该参数或其值为 0，则数字将以 10 为基础来解析。如果它以 “0x” 或 “0X” 开头，将以 16 为基数。
        * 如果该参数小于 2 或者大于 36，则 parseInt() 将返回 NaN。
        * 返回值
        * 返回解析后的数字。
        * 说明
        * 当参数 radix 的值为 0，或没有设置该参数时，parseInt() 会根据 string 来判断数字的基数。
        * 举例，如果 string 以 "0x" 开头，parseInt() 会把 string 的其余部分解析为十六进制的整数。如果 string 以 0 开头，那么 ECMAScript v3 允许 parseInt() 的一个实现把其后的字符解析为八进制或十六进制的数字。
        * 如果 string 以 1 ~ 9 的数字开头，parseInt() 将把它解析为十进制的整数。提示和注释
        * 注释：只有字符串中的第一个数字会被返回。
        * 注释：开头和结尾的空格是允许的。
        * 提示：如果字符串的第一个字符不能被转换为数字，那么 parseFloat() 会返回 NaN。
        * 实例
        * 在本例中，我们将使用 parseInt() 来解析不同的字符串：
        * parseInt("10");			//返回 10
        * parseInt("19",10);		//返回 19 (10+9)
        * parseInt("11",2);		//返回 3 (2+1)
        * parseInt("17",8);		//返回 15 (8+7)
        * parseInt("1f",16);		//返回 31 (16+15)
        * parseInt("010");		//未定：返回 10 或 8
        * */
        for(int i=0;i<Integer.parseInt(string[string.length-1]);i++){
            System.out.print(array[i]);
            if(i!=Integer.parseInt(string[string.length-1])-1){
                System.out.print(" ");
            }
        }
    }
}