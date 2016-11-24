package Task4_1;

public class ChinaBank extends Bank {

    public ChinaBank(long id, /*String bankCountry,*/ Currency currency, int numberOfEmployees, double avrSalaryOfEmployee, long rating, long totalCapital) {
        super(id, /*bankCountry,*/ currency, numberOfEmployees, avrSalaryOfEmployee, rating, totalCapital);
        this.setBankCountry("China");
    }

    @Override
    int getLimitOfWithdrawal() {
        return getCurrency() == Currency.USD ? 100 : 150;
    }

    @Override
    int getLimitOfFunding() {
        return getCurrency() == Currency.USD ? 10000 : 5000;
    }

    @Override
    int getMonthlyRate() {
        return getCurrency() == Currency.USD ? 1 : 0;
    }

    @Override
    int getCommission(int summ) {
        if (summ < 1000){
            return getCurrency() == Currency.USD ? 3 : 10;
        } else {
            return getCurrency() == Currency.USD ? 5 : 11;
        }
    }

    @Override
    public void withdrawOfUser(User user, int amount) {
        user.setBalance(user.getBalance() - amount);
        this.setTotalCapital(getTotalCapital() + amount);
    }

    @Override
    public void fundUser(User user, int amount) {
        user.setBalance(user.getBalance() + amount - this.getCommission(amount));
        this.setTotalCapital(getTotalCapital() - amount);
    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {
        fromUser.setBalance(fromUser.getBalance() - amount + this.getCommission(amount));
        toUser.setBalance(toUser.getBalance() + amount);
    }

    @Override
    public void paySalary(User user) {
        user.setBalance(user.getBalance() + user.getSalary() - this.getCommission(user.getSalary()));
        this.setTotalCapital(getTotalCapital() - user.getSalary() + this.getCommission(user.getSalary()));
    }
}
