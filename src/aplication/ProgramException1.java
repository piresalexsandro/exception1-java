package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class ProgramException1 { //MUITO RUIM

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date(DD/MM/YYYY): ");
		Date dtCheckIn = sdf.parse(sc.next());
		System.out.print("Check-out date(DD/MM/YYYY): ");
		Date dtCheckOut = sdf.parse(sc.next());
		
		if(!dtCheckOut.after(dtCheckIn)) { // se dtCheckOut nao for maior que dtCheckIn
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}else {
			Reservation reservation = new Reservation(number, dtCheckIn, dtCheckOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date(DD/MM/YYYY): ");
			dtCheckIn = sdf.parse(sc.next());
			System.out.print("Check-out date(DD/MM/YYYY): ");
			dtCheckOut = sdf.parse(sc.next());
			
			Date now = new Date(); // data de hoje
			if(dtCheckIn.before(now) || dtCheckOut.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			}else if(!dtCheckOut.after(dtCheckIn)){
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}else {
				reservation.updateDates(dtCheckIn, dtCheckOut);
				System.out.println("Reservation: " + reservation);
			}
			
		}
	}

}
