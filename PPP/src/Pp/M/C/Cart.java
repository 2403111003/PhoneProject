package Pp.M.C;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Pp.M.C.CartList;

public class Cart {
    ArrayList<CartList> cartList = new ArrayList<>();
    private String cartListFile = "CartList.txt";

    public Cart() throws IOException {
        loadCartListFile();
    }

    private void loadCartListFile() throws IOException {
        FileReader fr;
        try {
            fr = new FileReader(cartListFile);
            BufferedReader br = new BufferedReader(fr);
            String str;
            while ((str = br.readLine()) != null && !str.equals("")) {
                String[] itemInfo = str.split(",");
                int productId = Integer.parseInt(itemInfo[0]);
                String model = itemInfo[1];
                String manufacturer = itemInfo[2];
                String operatingSystem = itemInfo[3];
                int price = Integer.parseInt(itemInfo[4]);
                int quantity = Integer.parseInt(itemInfo[5]);
                cartList.add(new CartList(productId, model, manufacturer, operatingSystem, price, quantity));
            }
            fr.close();
            br.close();

        } catch (FileNotFoundException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveCartListToFile() {
        try {
            FileWriter fw = new FileWriter(cartListFile);
            for (CartList cartItem : cartList) {
                // 각 CartList의 정보를 파일에 저장합니다.
                fw.write(cartItem.getProductId() + "," + cartItem.getModel() + "," + cartItem.getManufacturer() + ","
                        + cartItem.getOperatingSystem() + "," + cartItem.getPrice() + "," + cartItem.getQuantity() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addItem(CartList cartItem) {
        cartList.add(cartItem);
    }

    public void deleteItem(int productId) {
        // 제품 ID에 해당하는 항목을 찾아서 삭제합니다.
        for (int i = 0; i < cartList.size(); i++) {
            if (cartList.get(i).getProductId() == productId) {
                cartList.remove(i);
                break;
            }
        }
    }

    public void updateQuantity(int productId, int newQuantity) {
        // 제품 ID에 해당하는 항목의 수량을 업데이트합니다.
        for (CartList cartItem : cartList) {
            if (cartItem.getProductId() == productId) {
                cartItem.setQuantity(newQuantity);
                break;
            }
        }
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (CartList cartItem : cartList) {
            totalPrice += cartItem.getPrice() * cartItem.getQuantity();
        }
        return totalPrice;
    }

    public void clearCart() {
        cartList.clear();
    }
}
