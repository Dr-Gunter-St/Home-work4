package Task4_1;

import java.util.Currency;

public class Main {

    public static void main(String[] args) {

        USBank LemonBrothers = new USBank(4321233532143L, Task4_1.Currency.USD, 20000, 7000, 3, 54326452341234L);
        EUBank DVB = new EUBank(432123454332143L, "Germany", Task4_1.Currency.EUR, 15000, 6000, 2, 54324325341234L);
        ChinaBank NBC = new ChinaBank(5743890224341L, Task4_1.Currency.USD, 30000, 30000, 15, 3522542345L);

        User user1 = new User(849320234L, "Jon1", 34214.45, 12, "Goit", 10000);
        User user2 = new User(849320234L, "Jon2", 34214.45, 12, "Goit", 10000);
        User user3 = new User(849320234L, "Jon3", 34214.45, 12, "Goit", 10000);
        User user4 = new User(849320234L, "Jon4", 34214.45, 12, "Goit", 10000);
        User user5 = new User(849320234L, "Jon5", 34214.45, 12, "Goit", 10000);
        //User user6 = new User(849320234L, "Jon6", 34214.45, 12, "Goit", 10000); //not using it

        System.out.println("Withdrawing from user:");
        System.out.println(user1.toString());
        LemonBrothers.withdrawOfUser(user1, 1000);
        System.out.println(user1.toString() + "\n");

        System.out.println("Funding user:");
        System.out.println(user2.toString());
        LemonBrothers.fundUser(user2, 1000);
        System.out.println(user2.toString() + "\n");

        System.out.println("Transferring money:");
        System.out.println(user3.toString());
        System.out.println(user4.toString());
        DVB.transferMoney(user3, user4, 1000);
        System.out.println(user3.toString());
        System.out.println(user4.toString() + "\n");

        System.out.println("Paying salary:");
        System.out.println(user5.toString());
        NBC.paySalary(user5);
        System.out.println(user5.toString() + "\n");

    }
}
