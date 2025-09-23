package models;

import java.util.ArrayList;
import java.util.Scanner;

class Barang {
    private int id, stock, harga;
    private String nama;

    public Barang(int id, String nama, int stock, int harga) {
        this.id = id;
        this.nama = nama;
        this.stock = stock;
        this.harga = harga;
    }

    public int getId() {
        return id;
    }

    public int getStock() {
        return stock;
    }

    public int getHarga() {
        return harga;
    }

    public String getNama() {
        return nama;
    }

    public void minusStock(int qty) {
        this.stock -= qty;
    }

    public void tampilkanBarang() {
        System.out.println("---------------------------------");
        System.out.println("ID    : " + id);
        System.out.println("Nama  : " + nama);
        System.out.println("Stock : " + stock);
        System.out.println("Harga : " + harga);
    }
}

class Order {
    private int id, jumlah;
    private Barang barang;
    public static int total = 0;

    public Order(int id, Barang barang, int jumlah) {
        this.id = id;
        this.barang = barang;
        this.jumlah = jumlah;
        total += barang.getHarga() * jumlah;
    }

    public int getId() {
        return id;
    }

    public int getJumlah() {
        return jumlah;
    }

    public Barang getBarang() {
        return barang;
    }
}

public class Tugas {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Barang> daftarBarang = new ArrayList<>();
    private static ArrayList<Order> daftarPesanan = new ArrayList<>();
    public static void main(String[] args) {
        daftarBarang.add(new Barang(1, "Pulpen Easy Gel 0.5mm", 120, 2000));
        daftarBarang.add(new Barang(2, "Penggaris 30cm", 30, 5000));
        daftarBarang.add(new Barang(3, "Tipe-x Roller", 30, 7000));
        daftarBarang.add(new Barang(4, "Pensil Mekanik", 50, 5000));
        daftarBarang.add(new Barang(5, "Buku Tulis", 100, 6000));
        boolean running = true;
        while (running) {
            System.out.println("\n------------Menu Toko Multiguna------------");
            System.out.println("1. Pesan Barang");
            System.out.println("2. Lihat Pesanan");
            System.out.println("0. Keluar");
            System.out.print("Pilihan : ");
            int menu = Integer.parseInt(scanner.nextLine());
            switch (menu) {
                case 1:
                    pesanBarang();
                    break;
                case 2:
                    lihatPesanan();
                    break;
                case 0:
                    running = false;
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private static void pesanBarang() {
        System.out.println("\nDaftar Barang Toko Multiguna");
        for (Barang b : daftarBarang) {
            b.tampilkanBarang();
        }

        System.out.println("---------------------------------");
        System.out.print("Ketik 0 untuk batal\nPesan Barang (ID): ");
        int id = Integer.parseInt(scanner.nextLine());
        if (id == 0) return;
        Barang barangDipilih = null;
        for (Barang b : daftarBarang) {
            if (b.getId() == id) {
                barangDipilih = b;
                break;
            }
        }

        if (barangDipilih == null) {
            System.out.println("ID Barang tidak sesuai pilihan.");
            return;
        }

        System.out.print("Masukkan jumlah : ");
        int jumlah = Integer.parseInt(scanner.nextLine());
        if (jumlah <= 0 || jumlah > barangDipilih.getStock()) {
            System.out.println("Jumlah barang tidak sesuai stock.");
            return;
        }

        int totalHarga = barangDipilih.getHarga() * jumlah;
        System.out.println(jumlah + " @ " + barangDipilih.getNama() +
                " dengan total harga " + totalHarga);
        System.out.print("Masukkan jumlah uang : ");
        int uang = Integer.parseInt(scanner.nextLine());
        if (uang < totalHarga) {
            System.out.println("Jumlah uang tidak mencukupi.");
            return;
        }

        barangDipilih.minusStock(jumlah);
        daftarPesanan.add(new Order(daftarPesanan.size() + 1, barangDipilih, jumlah));
        System.out.println("Barang berhasil dipesan.");
    }

    private static void lihatPesanan() {
        System.out.println("\nDaftar Pesanan Toko Multiguna");
        if (daftarPesanan.isEmpty()) {
            System.out.println("Belum ada pesanan.");
        } else {
            for (Order o : daftarPesanan) {
                System.out.println("---------------------------------");
                System.out.println("ID     : " + o.getId());
                System.out.println("Nama   : " + o.getBarang().getNama());
                System.out.println("Jumlah : " + o.getJumlah());
                System.out.println("Total  : " + (o.getBarang().getHarga() * o.getJumlah()));
            }
            System.out.println("---------------------------------");
            System.out.println("Total Semua Pesanan: " + Order.total);
        }
    }
}
