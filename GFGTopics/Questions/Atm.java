package Questions;

import java.util.*;

public class Atm
{
    public static void
        printCount(
            int amount,
            int thousantNotes,
            int fiveHundredNotes,
            int hundredNotes)
        throws Exception
    {
        if (amount % 100 != 0)
        {
            throw new Exception("Amount entered should be mutiple of 100, 500 or 1000");
        }

        int thNotes = amount / 1000;
        if (thNotes <= thousantNotes)
        {
            amount = amount % 1000;
        }
        else
        {
            thNotes = thousantNotes;
            amount = amount - (thousantNotes * 1000);
        }

        int fiveHunNotes = amount / 500;
        // check for notes present of that type
        if (fiveHunNotes < fiveHundredNotes)
        {
            amount = amount % 500;
        }
        else
        {
            fiveHunNotes = fiveHundredNotes;
            amount = amount - (fiveHundredNotes * 1000);
        }

        int hunNotes = amount / 100;
        if (hunNotes < hundredNotes)
        {
            amount = amount % 100;
        }
        else
        {
            hunNotes = hundredNotes;
            amount = amount - (hundredNotes * 1000);
        }

        int totalNotesReq = hunNotes + thNotes + fiveHunNotes;



        if (totalNotesReq > 40 || amount != 0)
        {
            throw new Exception("Not enough Cash in ATM");
        }


        // adding 100 notes if possible and if no 100 notes are there.
        if (hunNotes == 0 && (thNotes > 0 || fiveHunNotes > 0))
        {
            if (fiveHunNotes > 0)
            {
                // write a function here for this logic to not repeat the check for 1000;
                hunNotes = 5;
                if (hunNotes <= hundredNotes)
                {
                    fiveHunNotes--;
                }
                else
                {
                    hunNotes=0;
                }
            }
            else
            {
                hunNotes = 10;
                if (hunNotes <= hundredNotes)
                {
                    thNotes--;
                }
                else
                {
                    hunNotes=0;
                }
            }
        }

        System.out.println("Notes for 100:" + hunNotes);
        System.out.println("Notes for 500:" + fiveHunNotes);
        System.out.println("Notes for 1000:" + thNotes);
    }

    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();
        int thousantNotes = 3;
        int fiveHundredNotes = 0;
        int hundredNotes = 45;

        printCount(amount, thousantNotes, fiveHundredNotes, hundredNotes);
    }
}