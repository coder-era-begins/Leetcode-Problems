public class Card {
    static int cardNumberGenerator=0;
    int cardNo;
    int custId;
    int pin;
    String status="Active";
    int cardBalance=0;
    Card(int custId,int pin){
        this.cardNo=++cardNumberGenerator;
        this.custId=custId;
        this.pin=pin;
    }
    void setStatus(String status){
        this.status=status;
    }
}
