package menu;

public class Diskon extends MenuItem {
    private double diskon;

    public Diskon(String nama, double harga, String kategori) {
        super(nama, harga, kategori);
        this.diskon = 0.0;
    }

    public void setDiskon(double diskon) {
        this.diskon = diskon;
    }

    @Override
    public void tampilMenu() {

//        System.out.println(getNama()+"\t\tRp. "+getHarga());
//        System.out.println("Nama: " + getNama());
//        System.out.println("Harga: " + getHarga());
//        System.out.println("Kategori: " + getKategori());
//        System.out.println("Diskon: " + diskon + "%");

    }

    // Metode untuk menghitung total harga setelah diskon
    public double hitungHargaSetelahDiskon(double totalHarga) {
        if (totalHarga > 100000) {
            return totalHarga - (totalHarga * diskon / 100);
        } else {
            return totalHarga;
        }
    }
}
