import java.util.Scanner;

public class PatikaStore {
    Brand brand=new Brand();

    Mphone mphone=new Mphone();
    Notebook notebook=new Notebook();

    Scanner scanner=new Scanner(System.in);
    public void start(){
        System.out.println("PatikaStore yönetim paneline Hoşgeldiniz!");
        System.out.println("1-Notebook işlemleri");
        System.out.println("2-Cep telefonu işlemleri");
        System.out.println("3-Marka listeleme");
        System.out.println("4-ÇIKIŞ YAP!");
        System.out.print("Yukarıdaki işlemlerden birini seçiniz:");
        int selectCase=scanner.nextInt();
        switch (selectCase){
            case 1:
                notebook.notebookProccess();
                break;
            case 2:
                mphone.phoneProccess();
                break;
            case 3:
                brand.printBrand();
                break;
            case 4:
                System.out.println("Sistemden çıkış yapılıyor...");
                break;
            default:
                System.out.println("Geçersiz değer girdiniz,tekrar deneyin.");
                start();
        }


    }
}
