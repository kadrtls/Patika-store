import java.util.ArrayList;

public class Brand {

    ArrayList<String> brands=new ArrayList<>();

    public void brandAdd(){
        brands.add("Samsung");
        brands.add("Lenovo");
        brands.add("Apple");
        brands.add("Huawei");
        brands.add("Casper");
        brands.add("Asus");
        brands.add("HP");
        brands.add("Xiaomi");
        brands.add("Monster");
    }

    public void printBrand(){
        brandAdd();
        System.out.println("---Markalar---");
        for (String b:brands){
            System.out.println("-"+b);
        }

    }

}
