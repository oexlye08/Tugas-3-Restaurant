import menu.Menu;

public class Main {
    public static void main(String[] args) {
        Menu menuRestoran = new Menu();
        Restoran restoran = new Restoran(menuRestoran);

        // Menjalankan aplikasi
        restoran.mulaiAplikasi();
    }
}

