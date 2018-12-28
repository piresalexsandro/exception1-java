package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation2;

public class ProgramException2 { //MUITO RUIM

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date(DD/MM/YYYY): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date(DD/MM/YYYY): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) { // se checkOut nao for maior que checkIn
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}else {
			Reservation2 reservation2 = new Reservation2(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation2);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date(DD/MM/YYYY): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date(DD/MM/YYYY): ");
			checkOut = sdf.parse(sc.next());
			
			String error = reservation2.updateDates(checkIn, checkOut);
			
			if (error != null) {
				System.out.println("Error in reservation: " + error);
			}else {
				System.out.println("Reservation: " + reservation2);
			}
			
		}
	}

}
