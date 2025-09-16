public class Customer {
    static int customerIDGen=0;
    int CustomerId;
    int balance;
    Customer(int balance){
        this.CustomerId=++customerIDGen;
        this.balance=balance;
    }
}
