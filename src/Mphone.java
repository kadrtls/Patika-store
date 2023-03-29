import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Mphone extends Product{

    private int battery;
    private String color;
    static Scanner input=new Scanner(System.in);

    public Mphone(int id, int price, int stockAmount, String name, String brandName, int memory, int RAM, double screenSize,int battery,String color) {
        super(id, price, stockAmount, name, brandName, memory, RAM, screenSize);
        this.battery=battery;
        this.color=color;
    }
    public Mphone(){}

    ArrayList<Mphone> mphones=new ArrayList<>();

    public void addPhone(){
        System.out.print("Telefon ismi:");
        input.nextLine();
        this.setName(input.nextLine());
        System.out.print("Fiyatı :");
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
        System.out.print("Batarya :");
        this.setBattery(input.nextInt());
        System.out.print("Renk :");
        input.nextLine();
        this.setColor(input.nextLine());

        mphones.add(new Mphone(getId(),getPrice(),getStockAmount(),getName()
                ,getBrandName(),getMemory(),getRAM(),getScreenSize(),getBattery(),getColor()));
        setId(getId()+1);
        setStockAmount(getStockAmount()+1);
        phoneProccess();
    }

    public  void printPhone(){
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| ID | %-20s | %-10S | %-10S | %-10S | %-10S | %-10S | %-10S | %-10S |\n","Ürün Adı","Fiyat","Marka","Depolama","Ram","Ekran","Pil","Renk");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        for (Mphone m :mphones){
            System.out.format("| %-2d | %-20S | %-10d | %-10s | %-10d | %-10d | %-10s | %-10d | %-10S |",m.getId(),m.getName(),m.getPrice()
                    ,m.getBrandName(),m.getMemory(),m.getRAM(),m.getScreenSize(),m.getBattery(),m.getColor());
            System.out.println();
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        phoneProccess();
    }
    public void phoneProccess(){
        System.out.println("1-Telefonları listele.");
        System.out.println("2-Telefon ekle.");
        System.out.println("3-Telefon sil.");
        System.out.println("4-Telefon filtrele.");
        System.out.println("5-Yönetim paneline dön");
        System.out.print("Yukarıdaki işlemlerden birini seçiniz:");
        int selectPhoneCase=input.nextInt();
        switch (selectPhoneCase){
            case 1:
                printPhone();
                break;
            case 2:
                addPhone();
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
                System.out.println("Geçersiz değer girdiniz.tekrar deneyin:");
                break;
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
                System.out.println("Geçersiz değer girdiniz");
                filteredProduct();
        }
        phoneProccess();
    }
    public void idFilter(){
        System.out.print("id giriniz :");
        input.nextLine();
        int selectedID=input.nextInt();
        for (Mphone m:mphones){
            if (m.getId()==selectedID){
                System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                System.out.printf("| ID | %-20s | %-10S | %-10S | %-10S | %-10S | %-10S | %-10S | %-10S |\n","Ürün Adı","Fiyat","Marka","Depolama","Ekran","Pil","Ram","Renk");
                System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                System.out.format("| %-2d | %-20S | %-10d | %-10s | %-10d | %-10d | %-10s | %-10d | %-10S |",m.getId(),m.getName(),m.getPrice()
                        ,m.getBrandName(),m.getMemory(),m.getRAM(),m.getScreenSize(),m.getBattery(),m.getColor());
                System.out.println();
                System.out.println("-----------------------------------------------------------------------------------------------------------------------");
            }
        }
        phoneProccess();
    }

    public void brandFilter(){
        System.out.print("Marka giriniz:");
        input.nextLine();
        String selectBrand=input.nextLine();
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| ID | %-20s | %-10S | %-10S | %-10S | %-10S | %-10s | %-10S | %-10S |\n","Ürün Adı","Fiyat","Marka","Depolama","Ekran","Pil","Ram","Renk");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        for (Mphone m:mphones){
            if (m.getBrandName().equalsIgnoreCase(selectBrand)){
                System.out.format("| %-2d | %-20S | %-10d | %-10s | %-10d | %-10s | %-10d | %-10d | %-10S |",m.getId(),m.getName(),m.getPrice()
                        ,m.getBrandName(),m.getMemory(),m.getScreenSize(),m.getBattery(),m.getRAM(),m.getColor());
                System.out.println();
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        phoneProccess();
    }
    public void removeProduct(){
        System.out.print("Silmek istediğiniz ürün ID'si :");
        int removeID=input.nextInt();
        if (0<removeID && removeID<=mphones.size()) {
            for (Mphone m : mphones) {
                if (m.getId() == removeID) {
                    mphones.remove(m);
                    System.out.println("Ürün silindi.");
                    break;
                }
            }
        }else{
            System.out.println("Aradığınız id sistemde bulunmamaktadır");
        }
        phoneProccess();
    }
    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
