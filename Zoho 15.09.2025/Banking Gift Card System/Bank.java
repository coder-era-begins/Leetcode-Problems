import java.util.ArrayList;
import java.util.LinkedHashMap;

class Bank{
    ArrayList<Customer> CustomerList=new ArrayList<>();
   // ArrayList<Card> CardDetails=new ArrayList<>();
    ArrayList<Transaction> TransactionDetails=new ArrayList<>();
    LinkedHashMap<Integer,ArrayList<Card>> CustomerCardMap=new LinkedHashMap<>();
    void TopUp(int custID,int cardNo,int TopUpAmount){
        boolean canTOPup=false;
        Customer TargetCustomer=null;
        boolean customerFound=false;
        for(Customer currenCustomer:CustomerList){
            if(currenCustomer.CustomerId==custID){
                customerFound=true;
                if(currenCustomer.balance>=TopUpAmount){
                    canTOPup=true;
                    TargetCustomer=currenCustomer;
                }
            }
        }
        if(!customerFound){
            System.out.println("Recheck your customer ID");
            return;
        }
        ArrayList<Card> customerCards=CustomerCardMap.get(custID);
        if(customerCards==null){
            System.out.println("No cards are bought by you");
            return;
        }
        if(canTOPup){
            boolean cardNoFound=false;
            TargetCustomer.balance-=TopUpAmount;
            for(Card currentCard:customerCards){
                if(currentCard.cardNo==cardNo){
                    cardNoFound=true;
                    currentCard.cardBalance+=TopUpAmount;
                }
            }
            if(!cardNoFound){
                System.out.println("Card No is incorrect Recheck it");
                return;
            }

        }
        else{
            System.out.println("Cant Top ur Card Check your balance");
        }
    }
    void CloseCard(int custID,int cardno,int pin){
        boolean customerFound=false;
        for(Customer currenCustomer:CustomerList){
            if(currenCustomer.CustomerId==custID){
               customerFound=true;
            }
        }
        if(!customerFound){
            System.out.println("Recheck your customer id");
            return;
        }
        ArrayList<Card> customerCards=CustomerCardMap.get(custID);
        if(customerCards==null){
            System.out.println("No cards are bought");
            return;
        }
        int amountINcard=0;
        boolean valid=false;

        for(Card currentCard:customerCards){
                if(currentCard.cardNo==cardno){
                    customerFound=true;
                    if(currentCard.pin==pin){
                    amountINcard=currentCard.cardBalance;
                    currentCard.cardBalance=0;
                    currentCard.setStatus("Closed");
                    valid=true;
                    }
                    else{
                        System.out.println("PIN is incorrect");
                        return;
                    }
                }
            }
        if(valid){
        for(Customer currenCustomer:CustomerList){
            if(currenCustomer.CustomerId==custID){
               currenCustomer.balance+=amountINcard;
            }
        }
    }
    }
    void PurchaseItem(int custID,int cardno,int pin,int amount){
        ArrayList<Card> customerCards=CustomerCardMap.get(custID);
        if(customerCards==null){
            System.out.println("cards are not bought");
            return;
        }
        boolean valid=false;
        for(Card currentCard:customerCards){
                if(currentCard.cardNo==cardno&&!currentCard.status.equals("Block")&&!currentCard.status.equals("Closed")){
                    if(currentCard.cardBalance>=amount){
                        currentCard.cardBalance-=amount;
                    }
                    valid=true;
                    if(currentCard.cardBalance<amount){
                        System.out.println("Less Balance in your account");
                        return;
                    }
                }
                
            }
            if(!valid){
                System.out.println("Check whether your car is blocked or closed");
                return;
            }
        TransactionDetails.add(new Transaction( cardno, amount));

    }
    void TransactionSummary(){
        if(Transaction.TransactionNumGen==0){
            System.out.println("No transactions Found");
            return;
        }
        System.out.println("TxnNo    CardNo     Amount ");
        for(Transaction trans:TransactionDetails){
            System.out.println(trans.TransactionNumber+"     " +trans.cardNo+"     "+trans.Amount);
        }
    }
    void BlockUnblock(int custID,int cardno,int pin,String status){
        if(!status.equals("Block")&&!status.equals("Unblock")){
            System.out.println("Enter valid Input");
            return;
        }
        boolean customerFound=false;
        for(Customer currenCustomer:CustomerList){
            if(currenCustomer.CustomerId==custID){
               customerFound=true;
            }
        }
        if(!customerFound){
            System.out.println("Recheck your customer id");
            return;
        }
        ArrayList<Card> customerCards=CustomerCardMap.get(custID);
        if(customerCards==null){
            System.out.println("cards are not bought");
            return;
        }
        boolean cardNoFound=false;
        for(Card currentCard:customerCards){
                if(currentCard.cardNo==cardno){
                    cardNoFound=true;
                    if(status.equals("Unblock")){
                        currentCard.status="Active";
                    }
                    else{
                    currentCard.status=status;
                    }
                }
                
            }
            if(!cardNoFound){
                System.out.println("Enter correct card Number");
            }
            
    }
    void AccountSummary(){
        if(Customer.customerIDGen==0){
            System.out.println("No Account Found");
            return;
        }
        System.out.println("CustomerID                Balance");
        for(Customer currentCustomer:CustomerList){
            System.out.println(currentCustomer.CustomerId+"                "+currentCustomer.balance);
        }
    }
    void CreateGiftCard(int custId,int pin,int amount){
        boolean customerFound=false;
        Customer Target=null;
        for(Customer currenCustomer:CustomerList){
            if(currenCustomer.CustomerId==custId){
                customerFound=true;
                Target=currenCustomer;
            }
        }
        if(!customerFound){
            System.out.println("Check your Customer ID");
            return;
        }
        if(Target.balance>=amount){
            Target.balance-=amount;
        }
        else{
            System.out.println("Less balance in your account");
            return;
        }
        Card card=new Card(custId,pin);
        CustomerCardMap.putIfAbsent(custId,new ArrayList<>());
        CustomerCardMap.get(custId).add(card);
        card.cardBalance+=amount;
    }
    void GiftCardSummary(){
        if(Card.cardNumberGenerator==0){
            System.out.println("No Card Found");
            return;
        }
        System.out.println("CardNo   CustID  PIN  GiftCardBalance  Status");
        for(int custId:CustomerCardMap.keySet()){
            ArrayList<Card> customerCards =CustomerCardMap.get(custId);
            for(Card currentCard:customerCards){
                System.out.println(currentCard.cardNo+"      "+ currentCard.custId+"     "+currentCard.pin+"    "+currentCard.cardBalance+"    "+currentCard.status);
            }
        }
    }
}
