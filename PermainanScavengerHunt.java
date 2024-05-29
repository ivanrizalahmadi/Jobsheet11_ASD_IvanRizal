import java.util.Scanner;

public class PermainanScavengerHunt {
    private TitikScavengerHunt titikAwal;
    private TitikScavengerHunt titikSaatIni;
    private int titikDitemukan;
    private int skor;
    private int waktuBatasi; // dalam detik

    public PermainanScavengerHunt(int waktuBatasi) {
        titikAwal = null;
        titikSaatIni = null;
        titikDitemukan = 0;
        skor = 0;
        this.waktuBatasi = waktuBatasi;
    }

    // Metode untuk menambahkan titik baru dalam permainan
    public void tambahTitik(String pertanyaan, String jawaban, String lokasi, String deskripsi) {
        TitikScavengerHunt titikBaru = new TitikScavengerHunt(pertanyaan, jawaban, lokasi, deskripsi);
        if (titikAwal == null) {
            titikAwal = titikBaru;
            titikSaatIni = titikAwal;
        } else {
            titikSaatIni.setTitikBerikutnya(titikBaru);
            titikSaatIni = titikBaru;
        }
    }

    // Metode untuk memulai permainan
    public void mulaiPermainan() {
        Scanner scanner = new Scanner(System.in);
        titikSaatIni = titikAwal;
        long waktuMulai = System.currentTimeMillis();

        while (titikSaatIni != null) {
            if (sisaWaktu(waktuMulai) <= 0) {
                System.out.println("Waktu telah habis!");
                break;
            }

            titikSaatIni.tampilkanInformasi();
            System.out.print("Jawaban Anda: ");
            String jawabanPengguna = scanner.nextLine();

            if (titikSaatIni.periksaJawaban(jawabanPengguna)) {
                System.out.println("Jawaban benar! Lanjut ke titik berikutnya.");
                titikSaatIni = titikSaatIni.getTitikBerikutnya();
                titikDitemukan++;
                skor += 10; // Menambah skor setiap jawaban benar
            } else {
                System.out.println("Jawaban salah! Coba lagi.");
            }
        }

        long waktuSelesai = System.currentTimeMillis();
        int durasi = (int) ((waktuSelesai - waktuMulai) / 1000); // Konversi ke detik
        System.out.println("Permainan selesai!");
        System.out.println("Total titik yang ditemukan: " + titikDitemukan);
        System.out.println("Skor Anda: " + skor);
        System.out.println("Durasi permainan: " + durasi + " detik");
    }

    // Metode untuk menghitung sisa waktu
    private int sisaWaktu(long waktuMulai) {
        long waktuSekarang = System.currentTimeMillis();
        int waktuBerlalu = (int) ((waktuSekarang - waktuMulai) / 1000); // Konversi ke detik
        return waktuBatasi - waktuBerlalu;
    }
}
