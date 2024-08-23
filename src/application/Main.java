package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Scanner kb = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.print("Room number: ");
        int roomNumber = kb.nextInt();
        System.out.print("Check-in date (DD/MM/YYYY): ");
        Date checkIn = sdf.parse(kb.next());
        System.out.print("Check-out date (DD/MM/YYYY): ");
        Date checkOut = sdf.parse(kb.next());

        //CHECKING IF CHECK-OUT IS NOT BEFORE CHECK-IN
        if (!checkOut.after(checkIn)){
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        }
        else {
            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (DD/MM/YYYY): ");
            checkIn = sdf.parse(kb.next());
            System.out.print("Check-out date (DD/MM/YYYY): ");
            checkOut = sdf.parse(kb.next());

            //CREATING A STRING TO KEEP THE ERROR MESSAGE IN CASE IT HAPPENS, IF NOT IT'S NULL
            String error = reservation.updateDates(checkIn, checkOut);
            if (error != null){
                System.out.println("Error in reservation: " + error);
            }
            else {
                System.out.println("Reservation: " + reservation);
            }
        }
    }
}