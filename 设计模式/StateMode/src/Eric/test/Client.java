package Eric.test;

import Eric.account.Account;

/**
 * @Author：Eric
 * @Date：2020/4/24 17:43
 */
//客户端测试
public class Client {
    public static void main(String[] args) {
        Account account=new Account("TianXin",1000000);
        account.deposit(1000);
        account.withdraw(1001000);
        account.deposit(1000);
        account.withdraw(2000);
        account.withdraw(100);
    }
}
