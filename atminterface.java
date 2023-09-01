import java.util.*;
class BankAccount
{
   String name;
   String username;
   String userpin;
   String accountno;
   float balance=100000f;
   int transactions = 0;
   String transactionHistory = "";

   public void register()
   {
    Scanner sc= new Scanner(System.in);
    System.out.print("Enter your name: ");
    this.name=sc.nextLine();
    System.out.println("Enter your username");
    this.username=sc.nextLine();
    System.out.println("Enter your userpin");
    this.userpin= sc.nextLine();
    System.out.println("Enter your Account Number");
    this.accountno=sc.nextLine();
    System.out.println("Registration completed. You can log in");
    //sc.close();
   }
   public boolean login()
   {
      boolean islogin= false;
      Scanner sc= new Scanner(System.in);
      while (!islogin)
      {
        System.out.println("Enter your username");
        String Username= sc.nextLine();
         System.out.println("Enter your userpin");
        String Userpin= sc.nextLine();

        if ( Username.equals(username) && Userpin.equals(userpin))
        {
            System.out.println("login successful");
            islogin= true;
        }
        else if((!Username.equals(username)) && Userpin.equals(userpin))
        {
            System.out.println("Incorrect username");
            islogin=false;
        }
        else if ( Username.equals(username) && (!Userpin.equals(userpin)))
        {
            System.out.println("Incorrect userpin");
            islogin=false;
        }
        
        
      }
      return islogin;
      //sc.close();

   }
   public void withdraw()
   {
    System.out.print("Enter amount to withdraw");
    Scanner sc=new Scanner(System.in);
    float amount= sc.nextFloat();
    try{
        if(balance>=amount)
        {
            transactions++;
            balance-=amount;
            System.out.println("Withdraw successfully");
            String str= amount + " Rs withdrawn\n";
            transactionHistory= transactionHistory.concat(str);
        }
        else 
        {
            System.out.println("Insufficient balance");
        }
    }
        catch (Exception e)
        {
            System.out.println("The exceptio is:"+ e);
        }
        //sc.close();
            
        
    }
    public void deposit()
    {
        System.out.print("Enter amount to deposit");
        Scanner sc= new Scanner(System.in);
        float amount= sc.nextFloat();
        if(amount<=100000f)
        {
            transactions++;
            balance+=amount;
            System.out.println("Successfully deposited");
            String str= amount + " Rs Deposited\n";
            transactionHistory= transactionHistory.concat(str);

        }
        else 
        System.out.println("Sorry...Limit exceeded");


    }
    public void transfer()
    {
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter receipent's name ");
       String receipent=sc.nextLine();
       System.out.println("Enter amount to transfer ");
       float amount= sc.nextFloat();
       try{
        if(balance>=amount)
        {  if(amount<=50000f)
            {
            transactions++;
            balance-=amount;
            System.out.println("Successfully transferred to " + receipent);
            String str= amount + " Rs transferred to "+ receipent+"\n";
            transactionHistory= transactionHistory.concat(str);

        }
        else{
            System.out.println("Sorry..limit is 50000.00");

        }

       }

    }
    catch(Exception e)
    {
        System.out.println("The exception occured in transfer is "+ e);

    }
}


   public void checkBalance()
   {
    System.out.println("Current Balance is Rs "+ balance);

   }
   public void transhist()
   {
    if (transactions==0)
    System.out.println("Empty");
    else
    {
        System.out.println(transactionHistory);
    }
   }
}

public class atminterface
{
    
    public static int takeIntegerInput(int limit)
    {  Scanner sc=new Scanner(System.in);
        int input=0;
        boolean flag=false;
        while(!flag)
        {
            try{
                input=sc.nextInt();
                flag=true;
                if( flag && input> limit || input < 1)
                {
                    System.out.println("Choose the number between 1 to "+ limit);
                    flag= false;
                }

            }
            catch(Exception e)
            {
                System.out.println("Enter only integer value");
                flag= false;

            }

        };
       // sc.close();
        return input;
    }

    public static void main(String args[])
    {
        System.out.println("WELCOME TO Bank Of Baroda ATM System!");
        System.out.println(" 1.Register yourself \n 2.Exit");
        System.out.println("Enter your choice");
        int choice=takeIntegerInput(2);
        if (choice==1)
        {
            BankAccount b= new BankAccount();
            b.register();
            while(true)
            {
                System.out.println("\n 1.Login \n 2.Exit");
                System.out.println("Enter Your Choice");
                int ch= takeIntegerInput(2);
                if(ch==1)
                {
                    if(b.login())
                    {
                        System.out.println("\n\n***WELCOME BACK** "+ b.name+"*****");
                        boolean isFinished= false;
                        while(!isFinished)
                        {
                            System.out.println("\n 1.Withdraw \n 2.Deposit \n 3.Transfer \n 4.Check Balance \n 5.transactionHistory \n 6.Quit");
                            System.out.println("Enter Your Choice");
                            int c=takeIntegerInput(6);
                            switch (c) {
                                case 1:
                                  b.withdraw();
                                    
                                    break;
                                case 2:
                                b.deposit();
                                break;
                                case 3:
                                b.transfer();
                                break;
                                case 4:
                                b.checkBalance();
                                break;
                                case 5:
                                b.transhist();
                                break;  
                                case 6:
                                isFinished=true;
                                break;  
                            
                                default:
                                    break;
                            }
                        }
                    
                    }
                }
                else
                   System.exit(0);
            
            }
        }
        else
        System.exit(0);




    }

}



