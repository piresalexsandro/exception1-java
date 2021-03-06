package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation3 {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation3(Integer roomNumber, Date checkIn, Date checkOut) {
		if (!checkOut.after(checkIn)){
			throw new DomainException("Error in reservation: Check-out date must be after check-in date");
		}		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime(); // obtem a diferenca entre datas em milisegundos
		return TimeUnit.DAYS.convert(diff,  TimeUnit.MILLISECONDS); // converte milisegundos em dias
	}
	
	public void updateDates(Date checkIn, Date checkOut) throws RuntimeException{
		Date now = new Date(); // data de hoje
		if (checkIn.before(now) || checkOut.before(now)){
			throw new DomainException("Error in reservation: Reservation dates for update must be future dates");
		} 
		if (!checkOut.after(checkIn)){
			throw new DomainException("Error in reservation: Check-out date must be after check-in date");
		}		
		this.checkIn = checkIn;
		this.checkOut = checkOut;	
		//return null; //retorna nulo pq nao deu nenhum erro
	}
	
	@Override
	public  String toString() {
		return "Room: " + roomNumber + " check-in: " + sdf.format(checkIn)
		              + " check-out: " + sdf.format(checkOut) + ", " + duration() + " nights";
	}
}
