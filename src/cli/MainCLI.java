package cli;

import models.MataKuliah;

import java.util.List;
import java.util.Scanner;

public class MainCLI {
    private final MataKuliah[] matkuls = new MataKuliah[9];

    public MainCLI() {
        matkuls[0] = new MataKuliah("IF402", "Pemrograman Berorientasi Objek", 3);
        matkuls[1] = new MataKuliah("IF100", "Dasar-Dasar Pemrograman", 3);
        matkuls[2] = new MataKuliah("IF534", "Kecerdasan Buatan", 3);
        matkuls[3] = new MataKuliah("CE121", "Aljabar Linear", 3);
        matkuls[4] = new MataKuliah("CE441", "Jaringan Komputer", 3);
        matkuls[5] = new MataKuliah("CE232", "Sistem Digital", 3);
        matkuls[6] = new MataKuliah("UM162", "Pancasila", 2);
        matkuls[7] = new MataKuliah("UM152", "Agama", 2);
        matkuls[8] = new MataKuliah("U<142", "Bahasa Indonesia", 2);
    }

    public void mainMenu(Scanner in) {
        int menu;
        do {
            showMenu();
            System.out.println("Pilihan : ");
            menu = in.nextInt();
            in.nextLine();
            switch(menu) {
                case 1:
                    showData();
                    System.out.println("Press Enter To Continue");
                    in.nextLine();
                    break;
                case 2:
                    filterData("IF");
                    break;
                case 3:
                    filterData("CE");
                    break;
                case 4:
                    filterData("UM");
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Input Tidak Valid");
            }
        } while(menu != 5);
    }

    private void showMenu() {
        System.out.println("------- Daftar Mata Kuliah -------");
        System.out.println("1. Lihat Semua Mata Kuliah");
        System.out.println("2. Lihat Mata Kuliah Kode IF");
        System.out.println("3. Lihat Mata Kuliah Kode CE");
        System.out.println("4. Lihat Mata Kuliah Kode UM");
        System.out.println("5. Exit");
    }

    private void showData() {
        System.out.println("Daftar Mata Kuliah");
        for(MataKuliah matkul : matkuls) {
            System.out.println("-------------------------------------");
            System.out.println("Kode	: "+matkul.getKode());
            System.out.println("Nama    : "+matkul.getNama());
            System.out.println("Jumlah SKS : "+matkul.getSks());
        }
    }

    private void filterData(String kode) {
        for(MataKuliah matkul : matkuls) {
            if(matkul.getKode().contains(kode)) {
                System.out.println("Kode	: "+matkul.getKode());
                System.out.println("Nama    : "+matkul.getNama());
                System.out.println("Jumlah SKS : "+matkul.getSks());
            }
        }
    }
}
