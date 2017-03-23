/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

/**
 *
 * @author ridho
 */
import java.util.Scanner;
public class Converter {
    private String[] huruf;
    public Converter() {
        this.huruf = new String[]{"", "satu", "dua", "tiga", "empat", "lima", "enam", "tujuh", "delapan", "sembilan", "sepuluh", "sebelas"};
    }
    public String ubah(int angka) {
        if (angka < 12) {
            return huruf[angka];
        }
        if (angka >= 12 && angka < 20) {
            return huruf[angka % 10] + " belas";
        }
        if (angka >= 20 && angka < 100) {
            return ubah(angka / 10) + " puluh " + huruf[angka % 10];
        }
        if (angka >= 100 && angka < 200) {
            return "seratus " + ubah(angka % 100);
        }
        if (angka >= 200 && angka < 1000) {
            return ubah(angka / 100) + " ratus " + ubah(angka % 100);
        }
        if (angka == 1000) {
            return "seribu";
        }
        return "";
    }
    public String ubah(String huruf) {
        for (int i = 0; i <= 1000; i++) {
            if (huruf.equalsIgnoreCase(ubah(i))) {
                return Integer.toString(i);
            } 
            else if (huruf.equalsIgnoreCase(ubah(i).replaceAll("s ", "s"))) {
                return Integer.toString(i);
            }
            else if (huruf.equalsIgnoreCase(ubah(i).replaceAll("h ", "h"))) {
               return Integer.toString(i);
            }
            else if (huruf.equalsIgnoreCase("nol")) {
                return Integer.toString(0);
            } 
        }
        return "Maksimal range 1-1000";
    }

public class Main {
    Converter converter = new Converter();
        Scanner masukan = new Scanner(System.in);
        int pilihan = 0;
        do{
            System.out.println("1. Angka ke huruf ");
            System.out.println("2. Huruf ke angka");
            System.out.println("3. Keluar");
            System.out.print("Pilih konversi : ");
            pilihan=masukan.nextInt();
            switch (pilihan){
                case 1 : 
                    System.out.print("Masukan angka : ");
                    int angka = masukan.nextInt();
                    System.out.println("Hasil= "+converter.ubah(angka) );
                    break;
                case 2 :
                    System.out.print("Masukan huruf : ");
                    String huruf = masukan.next();
                    System.out.println("Hasil= "+converter.ubah(huruf) );
                    break;
                case 3 :
                    System.out.println("");
             }
        }while(pilihan!=3);
    }
}
