
import admin.Admin;
import menu.Menu;
import pelanggan.Pelanggan;

import java.util.Scanner;

public class Restoran {
    private Menu menu;
    private Pelanggan pelanggan;
    private Admin admin;

    public Restoran(Menu menuRestoran) {
        this.menu = menuRestoran;
        this.pelanggan = new Pelanggan(menuRestoran);
        this.admin = new Admin(menuRestoran);
    }

    public void mulaiAplikasi() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selamat datang di Restoran kami!");
        System.out.println("Silahkan pilih user:");
        System.out.println("1. Pelanggan");
        System.out.println("2. Admin");

        //handle if input string or other
        while (!scanner.hasNextInt()) {
            System.out.println("Pilihan tidak valid");
            scanner.next();
        }

        int pilihanUser = scanner.nextInt();
        if (pilihanUser == 1) {
            System.out.println("Anda login sebagai Pelanggan");
//            menu.tampilkanSemuaMenu();
            menu.tampilMenu();
            pelanggan.terimaPesanan();
            pelanggan.tampilkanStruk();
        } else if (pilihanUser == 2) {
            System.out.println("Anda login sebagai Admin");
            admin.menuAdmin();
            mulaiAplikasi();
        }
        else {
            System.out.println("Pilihan tidak valid");
            mulaiAplikasi();
        }

        scanner.close();
    }
}