package Eric.account;

/**
 * @Author：Eric
 * @Date：2020/4/24 17:33
 */
public class Account {
    public AccountState accountState;
    public String owner;
    public Account(String owner,double init) {
        this.owner = owner;
        this.accountState =new GreenState(init,this);
        System.out.println(owner+"初始金额为"+init);
        System.out.println("===============================");
    }
    public void setAccountState(AccountState accountState){
        this.accountState = accountState;
    }
    public void deposit(double amount){
        System.out.println(this.owner+"存款"+amount);
        accountState.deposit(amount);
        System.out.println("现在账户的状态为"+ accountState.getClass().getName());
        System.out.println("===============================");
    }
    public void withdraw(double amount){
        System.out.println(this.owner+"取款"+amount);
        accountState.withdraw(amount);
        System.out.println("现在账户的状态为"+ accountState.getClass().getName());
        System.out.println("===============================");
    }
}
