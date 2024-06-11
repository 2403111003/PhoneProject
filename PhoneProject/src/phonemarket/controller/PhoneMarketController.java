package phonemarket.controller;

import phonemarket.model.*;
import phonemarket.view.*;

import java.io.IOException;

public class PhoneMarketController {
    private PhoneStorage phoneStorage;
    private Cart cart;
    private ConsoleView view;
    private Customer customer;
    private Admin admin;

    public PhoneMarketController() throws IOException {
        phoneStorage = new PhoneStorage();
        cart = new Cart();
        view = new ConsoleView();
        customer = new Customer();
        admin = new Admin();
    }

    public void run() {
        view.displayWelcome();
        view.inputCustomerInfo(customer);
        while (true) {
            int option = view.inputMenu();
            switch (option) {
                case 1:
                    view.displayPhoneList(phoneStorage);
                    break;
                case 2:
                    addToCart();
                    break;
                case 3:
                    view.displayCart(cart);
                    break;
                case 4:
                    checkout();
                    break;
                case 0:
                    if (phoneStorage.isSaved()) {
                        System.out.println("종료 중...");
                        return;
                    } else {
                        System.out.println("저장되지 않은 변경 사항이 있습니다. 종료하기 전에 저장하시겠습니까? (예/아니요): ");
                        if (view.confirmPurchase()) {
                            phoneStorage.savePhoneList2File();
                            System.out.println("변경 사항이 저장되었습니다. 종료 중...");
                        } else {
                            System.out.println("변경 사항이 버려졌습니다. 종료 중...");
                        }
                        return;
                    }
            }
        }
    }

    private void addToCart() {
        view.displayPhoneList(phoneStorage);
        int phoneId = view.inputPhoneId();
        if (phoneStorage.isValidPhone(phoneId)) {
            Phone phone = phoneStorage.getPhoneById(phoneId);
            cart.addItem(phone);
            System.out.println(phone.getModel() + "가 장바구니에 추가되었습니다.");
        } else {
            System.out.println("잘못된 휴대폰 ID입니다.");
        }
    }

    private void checkout() {
        if (cart.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다.");
        } else {
            view.displayCart(cart);
            if (view.confirmPurchase()) {
                System.out.println("구매가 완료되었습니다. 쇼핑해 주셔서 감사합니다!");
                cart.resetCart();
            }
        }
    }

    public void adminMenu() {
        while (true) {
            view.displayAdminMenu();
            int option = view.inputMenu();
            switch (option) {
                case 1:
                    addPhone();
                    break;
                case 2:
                    deletePhone();
                    break;
                case 3:
                    phoneStorage.savePhoneList2File();
                    System.out.println("변경 사항이 저장되었습니다.");
                    break;
                case 0:
                    if (phoneStorage.isSaved()) {
                        System.out.println("종료 중...");
                        return;
                    } else {
                        System.out.println("저장되지 않은 변경 사항이 있습니다. 종료하기 전에 저장하시겠습니까? (예/아니요): ");
                        if (view.confirmPurchase()) {
                            phoneStorage.savePhoneList2File();
                            System.out.println("변경 사항이 저장되었습니다. 종료 중...");
                        } else {
                            System.out.println("변경 사항이 버려졌습니다. 종료 중...");
                        }
                        return;
                    }
            }
        }
    }

    private void addPhone() {
        String model = view.inputPhoneModel();
        System.out.println();
        String brand = view.inputPhoneBrand();
        System.out.println();
        int price = view.inputPhonePrice();
        System.out.println();
        phoneStorage.addPhone(model, brand, price);
        System.out.println("휴대폰이 추가되었습니다.");
    }

    private void deletePhone() {
        int phoneId = view.inputPhoneId();
        if (phoneStorage.isValidPhone(phoneId)) {
            phoneStorage.deleteItem(phoneId);
            System.out.println("휴대폰이 삭제되었습니다.");
        } else {
            System.out.println("잘못된 휴대폰 ID입니다.");
        }
    }
}
