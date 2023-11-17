package menu;

public class Minuman extends MenuItem {
    private String jenisMinuman;

    public Minuman(String nama, double harga,  String jenisMinuman) {
        super(nama, harga, jenisMinuman);
        this.jenisMinuman = jenisMinuman;
    }

    public String getJenisMinuman() {
        return jenisMinuman;
    }

    public String getharga() {
        return getharga();
    }

    private void setJenisMinuman(String jenisMinuman) {
        this.jenisMinuman = jenisMinuman;
    }

    @Override
    public void tampilMenu() {
        System.out.println("Minuman : "+getNama()+"\t\tRp. "+getHarga());
    }
}