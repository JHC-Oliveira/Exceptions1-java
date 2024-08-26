package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        //CREATION OF TRY TO TREAT ANY EXCEPTION THAT MIGHT OCCUR
        try {
            System.out.print("Room number: ");
            int roomNumber = kb.nextInt();
            System.out.print("Check-in date (DD/MM/YYYY): ");
            Date checkIn = sdf.parse(kb.next());
            System.out.print("Check-out date (DD/MM/YYYY): ");
            Date checkOut = sdf.parse(kb.next());

            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (DD/MM/YYYY): ");
            checkIn = sdf.parse(kb.next());
            System.out.print("Check-out date (DD/MM/YYYY): ");
            checkOut = sdf.parse(kb.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        }

        //CATCHES FOR THE TREATMENT OF THE EXCEPTIONS PARSE/DOMAIN OR ANY EXCEPTION
        //BECAUSE OF THE CLASS RUNTIMEEXCEPTION
        catch (ParseException e ){
            System.out.println("Invalid date format");
        }
        catch (DomainException e ){
            System.out.println("Error in reservation: " + e.getMessage());
        }
        catch (RuntimeException e ){
            System.out.println("Unexpected error ");
        }
    }
}