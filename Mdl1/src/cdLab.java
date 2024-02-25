import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class cdLab {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		try {
			System.out.print("Nama: ");
			String nama = scan.nextLine();
			System.out.print("Jenis Kelamin (L/P): ");
			char jenis = scan.next().charAt(0);
			String jenisKelamin = "";
			if(jenis == 'L' || jenis == 'l') {
				jenisKelamin = "Laki-laki";
			}else if(jenis == 'P' || jenis == 'p'){
				jenisKelamin = "Perempuan";
			}
			System.out.print("Tanggal Lahir (yyyy-mm-dd): ");
			String lahir = scan.next();
			LocalDate tglLahir = LocalDate.parse(lahir, DateTimeFormatter.ISO_DATE);
			LocalDate now = LocalDate.now();
			int umur = now.getYear() - tglLahir.getYear();
			int bulan = now.getMonthValue() - tglLahir.getMonthValue();
			if (bulan < 0) {
				bulan += 12;
				umur--;
			}
			
			System.out.println("Nama : " + nama);
			System.out.println("Jenis kelamin: "+ jenisKelamin);
			System.out.println("Umur Anda: " + umur + " tahun " + bulan + " bulan");
		}
		catch(InputMismatchException | DateTimeParseException e) {
			System.out.println(e.getMessage());
		}
        scan.close(); 

	}

}
