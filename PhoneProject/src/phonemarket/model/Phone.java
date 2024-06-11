package phonemarket.model;

public class Phone {
    private int phoneId;
    private String model;
    private String brand;
    private int price;

    public Phone(int phoneId, String model, String brand, int price) {
        this.phoneId = phoneId;
        this.model = model;
        this.brand = brand;
        this.price = price;
    }

    public int getPhoneId() {
        return phoneId;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return phoneId + ", " + model + ", " + brand + ", " + price + "원";
    }
}

