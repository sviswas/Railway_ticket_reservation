import java.util.*;
class Train {
    private String tn;
    private int avseats = 50;
    private int count = 1;
    public String[] pn;
    public int[] pa;
    ArrayList<String> h = new ArrayList<String>();

    public void setTn(String tn) 
    {
        this.tn = tn;
    }

    public String getTn() 
    {
        return tn;
    }

    Train(String tn)
    {
        this.tn = tn;
    }

    Scanner sc = new Scanner(System.in);
    
    public int book_tic(int n){
        System.out.println("Enter the number of tickets you want to book:");
        n = sc.nextInt();  
        return n;
    }
    public void bookTicket(Map<String, Train> trainMap) 
    {
        System.out.println("Enter the Train Name:");
        String a = sc.nextLine();
        
        if (!trainMap.containsKey(a))
        {
            trainMap.put(a, new Train(a));
        }
        Train t = trainMap.get(a);
        
        System.out.println("Enter the number of tickets you want to book:");
        int n = sc.nextInt();
    
        while(true)
        {
        if(n>t.avseats){
            System.out.println("Tickets limit out of range. There is only "+t.avseats+" Tickets available in this Reservation.");
            System.out.println("Try to book your tickets in the above limit Range.");
            n=book_tic(n);
        }
        else{
            break;
        }
        }
        String m[] = new String[n];
        int k[] = new int[n];
        sc.nextLine();
        System.out.println("Passenger Details:");
        for (int i = 0; i < n; i++) {
            System.out.println("Passenger " + (i + 1) + " Details");
            System.out.print("Enter your name: ");        
            m[i] = sc.nextLine();
            if (t.h.contains(m[i])) {
                System.out.println("Name is already exists, Please check again and enter name.");
                i = i - 1;
                continue;
            } else 
            {
                System.out.print("Enter your age: ");
                k[i] = sc.nextInt();
                t.h.add(m[i]);
                sc.nextLine();
            }
        }
        
        System.out.println("****************************************************************************************");
        System.out.println("\t\t\tYour ticket Details");   
        System.out.println("****************************************************************************************");
        // System.out.println("\t\tTrain Name:" + a + "\n");
        System.out.println("\t\t\tTrain Name: "+a);  
        System.out.println("****************************************************************************************");
        System.out.println("\t\t\tPassenger Details");
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Passenger Name\t\t Passenger age \t\t Seat Number");
        for (int i = 0; i < n; i++) {
            System.out.println(m[i] + "\t\t\t " + k[i] + "\t\t\t " + t.count);
            t.count++;
        }
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Ticket(s) booked Successfully.");
        t.avseats = t.avseats - n;
        System.out.println("Seats remaining: " + t.avseats);
        System.out.println("****************************************************************************************");
        System.out.println("Thank you for using the Ticket Reservation System.");
        System.out.println("Have a great day.");
    }
}

public class Main_class
{
    public static void main(String[] args)
    {
        String tn = " ";
        Scanner sc=new Scanner(System.in);
        Map<String, Train> trainMap = new HashMap<String, Train>();
        System.out.println("****************************************************************************************");
        System.out.println("                 Welcome! to Railway Ticket Reservation System                                ");
        System.out.println("****************************************************************************************");
        while (true) {
            System.out.println("Please Choose an option");
            System.out.println("1. Book a Ticket\n2. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Train t = new Train(tn);
                    t.bookTicket(trainMap);
                    break;
                case 2:
                    System.out.println("Thank you for using the Ticket Reservation System. Goodbye!");
                    break;
            }
            if (choice == 2)
                break;
        }
    }
}
