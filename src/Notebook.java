import java.util.ArrayList;
import java.util.Scanner;

public class Notebook extends Product{


    public Notebook(int id, int price, int stockAmount, String name, String brandName, int memory, int RAM, double screenSize) {
        super(id, price, stockAmount, name, brandName, memory, RAM, screenSize);
    }
    public Notebook(){}
    static Scanner input=new Scanner(System.in);

    ArrayList<Notebook> notebooks=new ArrayList<>();

    public void addNotebook(){
        System.out.print("Notebook ismi:");
        this.setName(input.next());
        System.out.print("Fiyatı :");
        input.nextLine();
        this.setPrice(input.nextInt());
        System.out.print("Marka :");
        input.nextLine();
        this.setBrandName(input.nextLine());
        System.out.print("Depolama (GB):");
        this.setMemory(input.nextInt());
        System.out.print("Ram (GB):");
        this.setRAM(input.nextInt());
        System.out.print("Ekran boyutu :");
        this.setScreenSize(input.nextDouble());

        notebooks.add(new Notebook(getId(),getPrice(),getStockAmount(),getName()
                ,getBrandName(),getMemory(),getRAM(),getScreenSize()));
        setId(getId()+1);
        setStockAmount(getStockAmount()+1);
        System.out.println("--Ürün başarılı bir şekilde eklendi");
        notebookProccess();
    }

    public void printNotebook(){
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.printf("| ID | %-20s | %-10S | %-10S | %-10S | %-10S | %-10S |\n","Ürün Adı","Fiyat","Marka","Depolama","Ekran","Ram");
        System.out.println("----------------------------------------------------------------------------------------------");
        for (Notebook n:notebooks){
            System.out.println(System.out.format("| %-2d | %-20S | %-10d | %-10s | %-10d | %-10s | %-10d |",n.getId(),n.getName(),n.getPrice()
                    ,n.getBrandName(),n.getMemory(),n.getScreenSize(),n.getRAM()));
        }
        System.out.println("----------------------------------------------------------------------------------------------");
        notebookProccess();
    }
    public void notebookProccess(){
        System.out.println("********************************");
        System.out.println("1-Notebooklerı listele.");
        System.out.println("2-Notebook ekle.");
        System.out.println("3-Notebook sil.");
        System.out.println("4-Notebook filtrele.");
        System.out.println("5-Yönetim paneline dön");
        System.out.print("Yukarıdaki işlemlerden birini seçiniz:");
        int selectNotebookCase=input.nextInt();
        switch (selectNotebookCase){
            case 1:
                printNotebook();
                break;
            case 2:
                addNotebook();
                break;
            case 3:
                removeProduct();
                break;
            case 4:
                filteredProduct();
                break;
            case 5:
                setStore( new PatikaStore() );
                getStore().start();
                break;
            default:
                System.out.println("Geçersiz değer girdiniz,tekrar deneyin;");
        }
    }

    public void filteredProduct(){
        System.out.println("1-ID ye göre filtrele");
        System.out.println("2-Markaya göre filtrele");
        System.out.print("Filtreleme işlemini seçin:");
        int selectFilter=input.nextInt();
        switch (selectFilter){
            case 1:
                idFilter();
                break;
            case 2:
                brandFilter();
                break;
            default:
                System.out.println("geçerssiz değer girdiniz.");
                filteredProduct();
        }
    }

    public void idFilter(){
        System.out.print("id giriniz :");
        input.nextLine();
        int selectedID=input.nextInt();
        for (Notebook n:notebooks){
            if (n.getId()==selectedID){
                System.out.println("----------------------------------------------------------------------------------------------");
                System.out.printf("| ID | %-20s | %-10S | %-10S | %-10S | %-10S | %-10S |\n","Ürün Adı","Fiyat","Marka","Depolama","Ekran","Ram");
                System.out.println("----------------------------------------------------------------------------------------------");
                System.out.println(System.out.format("| %-2d | %-20S | %-10d | %-10s | %-10d | %-10s | %-10d |",n.getId(),n.getName(),n.getPrice()
                        ,n.getBrandName(),n.getMemory(),n.getScreenSize(),n.getRAM()));
                System.out.println();
                System.out.println("----------------------------------------------------------------------------------------------");
            }
        }
        notebookProccess();
    }

    public void brandFilter(){
        System.out.print("Marka giriniz:");
        input.nextLine();
        String selectBrand=input.nextLine();
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.printf("| ID | %-20s | %-10S | %-10S | %-10S | %-10S | %-10S |\n","Ürün Adı","Fiyat","Marka","Depolama","Ekran","Ram");
        System.out.println("----------------------------------------------------------------------------------------------");
        for (Notebook n:notebooks){
            if (n.getBrandName().equalsIgnoreCase(selectBrand)){
                System.out.println(System.out.format("| %-2d | %-20S | %-10d | %-10s | %-10d | %-10s | %-10d |",n.getId(),n.getName(),n.getPrice()
                        ,n.getBrandName(),n.getMemory(),n.getScreenSize(),n.getRAM()));
                System.out.println();
            }
        }
        System.out.println("----------------------------------------------------------------------------------------------");
        notebookProccess();
    }

    public void removeProduct(){
        System.out.print("Silmek istediğiniz ürün ID'si :");
        int removeID=input.nextInt();
        if (0<removeID && removeID<=notebooks.size()) {
            for (Notebook n : notebooks) {
                if (n.getId() == removeID) {
                    notebooks.remove(n);
                    System.out.println("Ürün silindi.");
                    break;
                }
            }
        }else{
                System.out.println("Aradığınız id sistemde bulunmamaktadır");
            }

        notebookProccess();
    }
}
