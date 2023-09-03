import java.util.Random;
import java.util.Scanner;

class Main{
    private static final int BATAS_PERCOBAAN = 5;
    public static void main(String args[]){
        int i  = 0;
        Random rand_gen = new Random();
        int hidden = rand_gen.nextInt(4);
        int tebakan = 0;

        Scanner sc = new Scanner(System.in);

        while(i < BATAS_PERCOBAAN){
            //Minta input dari user
            System.out.print("Tebak bilangan bulat yang tersembunyi: ");
            tebakan = sc.nextInt();

            //bandingkan input dengan bilangan yang ditebak
            if(tebakan == hidden)
            {
                System.out.println("Selamat, angka yang anda masukkan benar!");
                break;
            }
            else if(tebakan > hidden)
            {
                System.out.println("angka yang anda masukkan terlalu besar");
            }
            else{
                System.out.println("angka yang anda masukkan terlalu kecil.");
            }
            //pastikan tambahkan nilai i agar loop tidak mengulang selamanya
            i++;

            //berikan message gagal ketika jumlah percobaan mencapai batas
            if(i == BATAS_PERCOBAAN)
            {
                System.out.println("Anda telah mencapai batas percobaan, anda belum beruntung!");
            }
            
            //beritahukan sisa percobaan yang diperbolehkan
            System.out.println("Sisa percobaan: " + (5-i) + "\n");
        }
    }
}