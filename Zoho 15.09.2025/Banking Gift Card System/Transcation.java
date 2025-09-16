public class Transaction {
    static int TransactionNumGen=0;
    int TransactionNumber;
    int cardNo;
    int Amount;
    Transaction(int cardNo,int Amount){
        this.TransactionNumber=++TransactionNumGen;
        this.cardNo=cardNo;
        this.Amount=Amount;
    }
    
}
