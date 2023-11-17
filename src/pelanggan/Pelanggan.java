package pelanggan;

import menu.Menu;
import menu.MenuItem;
import transaction.Pesanan;

import java.util.ArrayList;
import java.util.Scanner;

public class Pelanggan {
    private ArrayList<Pesanan> daftarPesanan;
    private Menu menu;
    Pesanan pesanan = new Pesanan("");

    public Pelanggan(Menu menu) {
        this.daftarPesanan = new ArrayList<>();
        this.menu = menu;
//        this.pesanan = pesanan;
    }

    public void terimaPesanan() {

        double totalHargaPesanan = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Masukkan pesanan Anda, Gunakan format 'Nama Menu = Jumlah' atau ketik 'selesai' untuk selesai :");

        while (true) {
            String pesananInput = scanner.nextLine().trim();

            if (pesananInput.equalsIgnoreCase("selesai")) {
                if (pesanan.isEmpty()) {
                    System.out.println("Anda belum memesan apapun. Gunakan format 'Nama Menu = Jumlah'");
                    continue;
                } else {
                    break; // Keluar dari loop jika pengguna mengetik 'selesai'
                }
            }

            // Memisahkan nama menu dan jumlah dengan menggunakan "=" sebagai pemisah
            String[] pesananSplit = pesananInput.split("=");

            if (pesananSplit.length != 2) {
                System.out.println("Format pesanan tidak valid. Gunakan format 'Nama Menu = Jumlah' atau ketik 'selesai' untuk selesai.");
                continue;
            }

            String namaMenu = pesananSplit[0].trim();
            int jumlah;
            try {
                jumlah = Integer.parseInt(pesananSplit[1].trim());
                if (jumlah < 0) {
                    throw new IllegalArgumentException("Jumlah pesanan tidak dapat negatif.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Jumlah pesanan harus berupa angka. Harap masukkan angka yang valid.");
                continue;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            // Cari menu yang sesuai dengan nama menu yang diinputkan
            MenuItem menuItem = menu.cariMenu(namaMenu);

            if (menuItem != null) {
                // masukkan pesanan ke array class pesanan
                pesanan.tambahItemPesanan(menuItem.getNama(), jumlah, menuItem.getHarga());
            } else {
                System.out.println("Menu '" + namaMenu + "' tidak ditemukan.");
            }

        }

        totalHargaPesanan =  pesanan.hitungTotalHargaPesanan();
//         Apply an offer if the totalHargaPesanan is more than 50,000
        if (totalHargaPesanan >= 50000) {
            System.out.println("Selamat! Anda mendapatkan penawaran khusus by 1 get 1 Minuman. ");

            // Tampilkan menu kategori minuman
            System.out.println("Daftar Menu Minuman:");
            menu.tampilkanMenuMinuman();
            int y = 0;
            System.out.println("Masukkan nama minuman yang ingin Anda tambahkan (maksimal 1 menu) atau ketik 'selesai' untuk selesai :");

            while (y < 1) {
                String minumamInput = scanner.nextLine();
                MenuItem menuItem = menu.cariMenu(minumamInput);

                if (minumamInput.equalsIgnoreCase("selesai")) {
                    break;
                } else if (menuItem != null) {
                    pesanan.tambahItemPesanan(menuItem.getNama(), 1, menuItem.getHarga());
                    pesanan.tambahItemPesanan(menuItem.getNama(), 1, 0);
                    y++;
                } else {
                    System.out.println("Menu '" + minumamInput + "' tidak ditemukan.");
                }

            }
        }
    }

    public void tampilkanStruk() {
        pesanan.tampilkanStruk();
    }
}