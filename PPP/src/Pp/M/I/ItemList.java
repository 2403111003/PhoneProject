package Pp.M.I;

public class ItemList {
    protected int productId;
    protected String model;
    protected String manufacturer;
    protected String operatingSystem;
    protected int price;

    public ItemList(int productId, String model, String manufacturer, String operatingSystem, int price) {
        this.productId = productId;
        this.model = model;
        this.manufacturer = manufacturer;
        this.operatingSystem = operatingSystem;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public int getPrice() {
        return price;
    }
    @Override
    public String toString() {
        return productId + ", " + model + ", " + manufacturer + ", " + operatingSystem + ", " + price + "원";
    }
}