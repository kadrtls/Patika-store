public class Product {
    private PatikaStore store;
    private int id=1,price,stockAmount=0;
    private String name,brandName;
    private int memory,RAM;
    private double screenSize;

    public Product(int id, int price, int stockAmount, String name, String brandName, int memory, int RAM, double screenSize) {
        this.id = id;
        this.price = price;
        this.stockAmount = stockAmount;
        this.name = name;
        this.brandName = brandName;
        this.memory = memory;
        this.RAM = RAM;
        this.screenSize = screenSize;
    }
    public Product(){}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public PatikaStore getStore() {
        return store;
    }

    public void setStore(PatikaStore store) {
        this.store = store;
    }
}
