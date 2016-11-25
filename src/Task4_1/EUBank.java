package Task4_1;

public class EUBank extends Bank {

    public EUBank(long id, String bankCountry, Currency currency, int numberOfEmployees, double avrSalaryOfEmployee, long rating, long totalCapital) {
        super(id, /*bankCountry,*/ currency, numberOfEmployees, avrSalaryOfEmployee, rating, totalCapital);
        this.setBankCountry(bankCountry);
    }

    @Override
    int getLimitOfWithdrawal() {
        return getCurrency() == Currency.USD ? 2000 : 2200;
    }

    @Override
    int getLimitOfFunding() {
        return getCurrency() == Currency.USD ? 10000 : 20000;
    }

    @Override
    int getMonthlyRate() {
        return getCurrency() == Currency.USD ? 0 : 1;
    }

    @Override
    int getCommission(int summ) {
        if (summ < 1000){
            return getCurrency() == Currency.USD ? 5 : 2;
        } else {
            return getCurrency() == Currency.USD ? 7 : 4;
        }
    }

    @Override
    public void withdrawOfUser(User user, int amount) {

        if(getLimitOfWithdrawal() < amount || amount < 0) {
            System.out.println("Unable to withdraw that amount!");
            return;
        }
        user.setBalance(user.getBalance() - amount);
        this.setTotalCapital(getTotalCapital() + amount);
    }

    @Override
    public void fundUser(User user, int amount) {

        if(getLimitOfFunding() > amount || amount < 0) {
            System.out.println("Unable to fund that amount!");
            return;
        }
        user.setBalance(user.getBalance() + amount - this.getCommission(amount));
        this.setTotalCapital(getTotalCapital() - amount);
    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {
        if (amount < 0){
            System.out.println("Unable to transfer negative amount!");
            return;
        }
        fromUser.setBalance(fromUser.getBalance() - amount + this.getCommission(amount));
        toUser.setBalance(toUser.getBalance() + amount);
    }

    @Override
    public void paySalary(User user) {
        user.setBalance(user.getBalance() + user.getSalary() - this.getCommission(user.getSalary()));
        this.setTotalCapital(getTotalCapital() - user.getSalary() + this.getCommission(user.getSalary()));
    }
}
