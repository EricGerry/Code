package Eric.account;

/**
 * @Author：Eric
 * @Date：2020/4/24 17:33
 */
public class AccountState {
    public Account status;//状态
    public double balance;//余额
    public void stateCheck(){
    }
    public void deposit(double amount){
        this.balance+=amount;
        System.out.println("现存金额为"+this.balance);
        stateCheck();
    }
    public void withdraw(double amount){
        this.balance-=amount;
        System.out.println("现存金额为"+this.balance);
        stateCheck();
    }
}
class YellowState extends AccountState{  //绿色状态类继承账户状态类
    public YellowState(AccountState state){
        this.status=state.status;
        this.balance=state.balance;
    }
    @Override
    public void stateCheck(){
        if(balance<-1000){
            status.setAccountState(new RedState(this));
        }else if(balance>=0){
            status.setAccountState(new GreenState(this));
        }
    }
}
class RedState extends AccountState{ //红色状态类继承账户状态类
    public RedState(AccountState state){
        this.status=state.status;
        this.balance=state.balance;
    }
    @Override
    public  void stateCheck(){
        if(balance>=0){
            status.setAccountState(new GreenState(this));
        }else if (balance<0&&balance>=-1000){
            status.setAccountState(new YellowState(this));
        }
    }
    @Override
    public void withdraw(double amount){ //红色状态下取钱方法
        System.out.println("账户被冻结,取款失败");
        System.out.println("现存金额为"+this.balance);
    }
}
class GreenState extends AccountState{ //绿色状态类继承账户状态类
    public GreenState(AccountState state){
        this.status=state.status;
        this.balance=state.balance;
    }
    public GreenState(double balance,Account acc){
        this.status=acc;
        this.balance=balance;
    }
    @Override
    public void stateCheck(){
        if (balance<0&&balance>=-1000){
            status.setAccountState(new YellowState(this));
        }else if (balance<-1000){
            status.setAccountState(new RedState(this));
        }
    }
}
