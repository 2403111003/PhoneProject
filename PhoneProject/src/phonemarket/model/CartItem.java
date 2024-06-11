package phonemarket.model;

public class CartItem {
    Phone phone;
    int phoneId;
    int quantity;

    public CartItem(Phone phone) {
        this.phone = phone;
        this.phoneId = phone.getPhoneId();
        this.quantity = 1;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    @Override
    public String toString() {
        return phone.getPhoneId() + ", " + phone.getModel() + ", " + quantity + "대, " + getPrice() + "원";
    }

    public int getPrice() {
        return quantity * phone.getPrice();
    }
}

