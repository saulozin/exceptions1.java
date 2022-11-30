package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class ExExcecoes3 {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room Number: ");
		int number = sc.nextInt();
		System.out.print("Check In date (DD/MM/YYYY): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check Out date (DD/MM/YYYY): ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check Out date must be after Check In date");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println(reservation.toString());
			System.out.println();
			System.out.println("Enter data to update the reservations:");
			System.out.print("Check In date (DD/MM/YYYY): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check Out date (DD/MM/YYYY): ");
			checkOut = sdf.parse(sc.next());

			String error = reservation.updateDates(checkIn, checkOut);
			if (error != null) {
				System.out.println(error);
			} else {
				System.out.println(reservation.toString());
			}

		}

		sc.close();

	}

}
