import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Bank SBI=new Bank();
        while(true){
            System.out.println("Enter your choice user");
            System.out.println("1.Account Summary 2.Create Gift Card 3.Create Customer 4.TopUp 5.Close Card 6.GiftCardSummary 7.PurchaseItem 8.Transaction summary 9.Block/Unblock");
            int choice=sc.nextInt();
            switch (choice) {
                case 1:
                    SBI.AccountSummary();
                    break;
                case 2:
                    try{
                    System.out.println("Enter your Custd No:");
                    int custId=sc.nextInt();
                    System.out.println("Enter your PIN:(PIN should be four digits)");
                    int pin=sc.nextInt();
                    int digits=0;
                    int temp=pin;
                    while(temp!=0){
                        temp=temp/10;
                        digits++;
                    }
                    if(digits!=4){
                        System.out.println("Enter valid pin");
                        break;
                    }
                    System.out.println("Enter the initial Amount");
                    int amount=sc.nextInt();
                    SBI.CreateGiftCard(custId,pin,amount);
                    SBI.GiftCardSummary();
                    break;
                    }
                    catch(Exception e){
                        System.out.println("Enter the valid Input");
                        sc.nextLine();
                        break;
                    }
                case 3:
                    try{
                    System.out.println("Enter the balance");
                    int balance=sc.nextInt();
                    SBI.CustomerList.add(new Customer(balance));
                    break;
                    }
                    catch(Exception e){
                        System.out.println("Enter the valid input");
                        break;
                    }
                case 4:
                    try{
                    System.out.println("Enter your Customer ID");
                    int custID=sc.nextInt();
                    System.out.println("Enter your Card No");
                    int cardNO=sc.nextInt();
                    System.out.println("Enter the topup Amount");
                    int topUP=sc.nextInt();
                    if(topUP<0){
                        System.out.println("Enter positive topup amount");
                        break;
                    }
                    SBI.TopUp(custID,cardNO,topUP);
                    break;
                    }
                    catch(Exception e){
                        System.out.println("Enter the valid input");
                        sc.nextLine();
                        break;
                    }
                case 5:
                    try{
                    System.out.println("Enter your Customer Id");
                    int custid=sc.nextInt();
                    System.out.println("Enter your CardNo");
                    int cardNo=sc.nextInt();
                    System.out.println("Enter your PIN");
                    int PIN=sc.nextInt();
                    int digits=0;
                    int temp=PIN;
                    while(temp!=0){
                        temp=temp/10;
                        digits++;
                    }
                    if(digits!=4){
                        System.out.println("Enter valid pin");
                        break;
                    }
                    SBI.CloseCard(custid, cardNo, PIN);
                    break;
                    }
                    catch(Exception e){
                        System.out.println("Enter the valid input");
                        sc.nextLine();
                        break;
                    }
                case 6:
                    SBI.GiftCardSummary();
                    break;
                case 7:
                    try{
                    System.out.println("Enter your Customer Id");
                    int custid=sc.nextInt();
                    System.out.println("Enter your CardNo");
                    int cardNo=sc.nextInt();
                    System.out.println("Amount");
                    int  amount=sc.nextInt();
                    System.out.println("Enter the pin");
                    int pin=sc.nextInt();
                    int digits=0;
                    int temp=pin ;
                    while(temp!=0){
                        temp=temp/10;
                        digits++;
                    }
                    if(digits!=4){
                        System.out.println("Enter valid pin");
                        break;
                    }
                    SBI.PurchaseItem(custid, cardNo, pin, amount);
                    break;
                    }
                    catch(Exception e){
                        System.out.println("Enter the valid input");
                        sc.nextLine();
                        break;
                    }
                case 8:
                    SBI.TransactionSummary();
                    break;
                case 9:
                try{
                    System.out.println("Enter your Customer Id");
                    int custid=sc.nextInt();
                    System.out.println("Enter your CardNo");
                    int cardNo=sc.nextInt();
                    System.out.println("Enter your PIN");
                    int PIN=sc.nextInt();
                    int digits=0;
                    int temp=PIN;
                    while(temp!=0){
                        temp=temp/10;
                        digits++;
                    }
                    if(digits!=4){
                        System.out.println("Enter valid pin");
                        break;
                    }
                    System.out.println("Enter 1.Block 2.Unblock");
                    int choice2=sc.nextInt();
                    if(choice2==1){
                    SBI.BlockUnblock(custid,cardNo,PIN,"Block");
                    }
                    else if(choice2==2){
                    SBI.BlockUnblock(custid,cardNo,PIN,"Unblock"); 
                    }
                    else{
                        System.out.println("Enter valid Input");
                    }
                    break;
                }
                catch(Exception e){
                    System.out.println("Enter the valid Input");
                    sc.nextLine();
                    break;
                }
                default:
                    break;
            }
        }

    }
}
