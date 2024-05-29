import java.util.Scanner;

public class TitikScavengerHunt {
    private String pertanyaan;
    private String jawaban;
    private String lokasi;
    private String deskripsi;
    private TitikScavengerHunt titikBerikutnya;

    public TitikScavengerHunt(String pertanyaan, String jawaban, String lokasi, String deskripsi) {
        this.pertanyaan = pertanyaan;
        this.jawaban = jawaban;
        this.lokasi = lokasi;
        this.deskripsi = deskripsi;
        this.titikBerikutnya = null;
    }

    // Getter dan setter untuk titikBerikutnya
    public TitikScavengerHunt getTitikBerikutnya() {
        return titikBerikutnya;
    }

    public void setTitikBerikutnya(TitikScavengerHunt titikBerikutnya) {
        this.titikBerikutnya = titikBerikutnya;
    }

    // Metode untuk memeriksa jawaban yang diberikan
    public boolean periksaJawaban(String jawabanPengguna) {
        return jawaban.equalsIgnoreCase(jawabanPengguna);
    }

    // Metode untuk menampilkan informasi titik
    public void tampilkanInformasi() {
        System.out.println("Lokasi: " + lokasi);
        System.out.println("Deskripsi: " + deskripsi);
        System.out.println("Pertanyaan: " + pertanyaan);
    }
}
