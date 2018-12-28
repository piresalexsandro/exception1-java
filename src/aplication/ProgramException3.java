package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation3;
import model.exceptions.DomainException;

public class ProgramException3 { //MUITO RUIM

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date(DD/MM/YYYY): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date(DD/MM/YYYY): ");
			Date checkOut = sdf.parse(sc.next());
			
			Reservation3 reservation3 = new Reservation3(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation3);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date(DD/MM/YYYY): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date(DD/MM/YYYY): ");
			checkOut = sdf.parse(sc.next());
			
			reservation3.updateDates(checkIn, checkOut);
			
			System.out.println("Reservation: " + reservation3);
		}	
		// tratamento de excessoes o catch capturar, captura o tipo de erro
		catch(ParseException e) {
			System.out.println("Invalid date format");
		}
		catch(DomainException e) {
			System.out.println(e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}
	}

}
