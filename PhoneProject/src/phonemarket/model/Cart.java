package phonemarket.model;

import java.util.ArrayList;

public class Cart {
    private ArrayList<CartItem> itemList = new ArrayList<>();

    public boolean isEmpty() {
        return itemList.isEmpty();
    }

    public ArrayList<CartItem> getItemList() {
        return itemList;
    }

    public int getNumItems() {
        return itemList.size();
    }

    public String getItemInfo(int index) {
        return itemList.get(index).toString();
    }

    public void addItem(Phone phone) {
        CartItem item = getCartItem(phone);
        if (item == null) {
            itemList.add(new CartItem(phone));
        } else {
            item.addQuantity(1);
        }
    }

    private CartItem getCartItem(Phone phone) {
        for (CartItem item : itemList) {
            if (item.getPhone() == phone) return item;
        }
        return null;
    }

    private CartItem getCartItem(int phoneId) {
        for (CartItem item : itemList) {
            if (item.phoneId == phoneId) return item;
        }
        return null;
    }

    public void resetCart() {
        itemList.clear();
    }

    public boolean isValidItem(int phoneId) {
        for (CartItem item : itemList) {
            if (item.phoneId == phoneId) return true;
        }
        return false;
    }

    public void deleteItem(int phoneId) {
        CartItem item = getCartItem(phoneId);
        itemList.remove(item);
    }

    public void updateQuantity(int phoneId, int quantity) {
        if (quantity == 0)
            deleteItem(phoneId);
        else {
            CartItem item = getCartItem(phoneId);
            item.setQuantity(quantity);
        }
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (CartItem item : itemList) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
}

