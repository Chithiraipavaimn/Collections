import java.util.*;
public class Candidate
{
    Scanner scan=new Scanner(System.in);
    Queue<String> candidate=new LinkedList<>();
    Queue<String> reception=new LinkedList<>();
    Queue<String> mainHall=new LinkedList<>();
    int total,half;

    public void getCandidates()
    {
        System.out.println("Enter total Number of Candidates : ");
        total=scan.nextInt();
        half=((total%2==0)?total/2:(total/2)+1);
        System.out.println("Enter Candidates: ");

        for(int i=0;i<total;i++)
        {
            candidate.add(scan.next());
        }
        System.out.println("Candidates List : "+candidate);
        for(int i=0;i<half;i++)
        {
            String s= candidate.remove();
            mainHall.add(s);
        }
        System.out.println("Main Hall : "+mainHall);
        for(int i=half;i<total;i++)
        {
            String s= candidate.remove();
            reception.add(s);
        }
        System.out.println("Reception : "+reception);
    }

    public void options() {
        int option;
        System.out.println("****** OPTIONS ********");
        System.out.println("\t (1) Call for Interview\n\t (2) Add attendee to Reception");
        char ch;
        do
        {

            System.out.println("Enter your Option : ");
            option = scan.nextInt();
            switch (option)
            {
                case 1:
                    System.out.println("Call next person for interview.....");
                    callFor();
                    break;
                case 2:
                    System.out.println("Add Attendee......");
                    addAttendee();
                    break;
            }
            System.out.println("Do you want to continue...(y/n):");
            ch = scan.next().charAt(0);
        }
        while (ch != 'n');
        if(ch=='n')
        {
            System.exit(0);
        }
    }

    public void addAttendee()
    {
        System.out.println("Enter new Attendee : ");
        reception.add(scan.next());
        System.out.println("New Reception : "+reception);
    }

    public void callFor()
    {
        if(!reception.isEmpty())
        {
            mainHall.remove();
            String g = reception.remove();
            mainHall.add(g);
        }
        else {
            mainHall.remove();
        }
        System.out.println("New Main Hall : " + mainHall);
        System.out.println("New Reception : " + reception);
    }
}