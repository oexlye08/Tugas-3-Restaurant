package menu;

public abstract class MenuItem {
    private String nama;
    private double harga;
    private String kategori;

    public MenuItem(String nama, double harga, String kategori) {
        this.nama = nama;
        this.harga = harga;
        this.kategori = kategori;
    }

    public MenuItem() {

    }

    public String getNama() {
        return nama;
    }

    private void setNama(String nama) {
        this.nama = nama;
    }

    public double getHarga() {
        return harga;
    }

    void setHarga(double harga) {
        this.harga = harga;
    }

    public String getKategori() {
        return kategori;
    }

    private void setKategori(String kategori) {
        this.kategori = kategori;
    }

    protected abstract void tampilMenu();
}
