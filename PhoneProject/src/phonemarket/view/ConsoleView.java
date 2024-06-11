package phonemarket.view;

import phonemarket.model.*;

import java.util.Scanner;

public class ConsoleView {
    Scanner scanner = new Scanner(System.in);

    public void displayWelcome() {
        System.out.printf("++++++++++++++++++++++++++++++++++\n+              +                 +\n" +
        		"+  Welcome to the Phone Market!  +\n+              +                 +\n" +
        		"++++++++++++++++++++++++++++++++++\n\n");
    }

    public void inputCustomerInfo(Customer customer) {
        System.out.println("++++++++++++++++++++++++++++++++++");
    	System.out.print(">> 이름을 입력하세요 : ");
        customer.setName(scanner.nextLine());
        System.out.print(">> 전화번호를 입력하세요 : ");
        customer.setPhone(scanner.nextLine());
        System.out.print(">> 주소를 입력하세요 : ");
        customer.setAddress(scanner.nextLine());
        System.out.print(">> 이메일을 입력하세요: ");
        customer.setEmail(scanner.nextLine());
        System.out.println("++++++++++++++++++++++++++++++++++");
    }

    public int inputMenu() {
        System.out.printf("++++++++++++++++++++++++++++++++++\n\n" +
        		"[메뉴 목록]\n" + 
        		"[ 1. 휴대폰 목록 ]\n" +
        		"[ 2. 장바구니에 추가 ]\n" +
        		"[ 3. 장바구니 보기 ]\n" +
        		"[ 4. 주문 ]\n" + 
        		"[ 0. 종료 ]\n" +
        		"\n++++++++++++++++++++++++++++++++++" +
        		">> 번호를 입력 하세요 : ");
        return Integer.parseInt(scanner.nextLine());
    }

    public int inputPhoneId() {
        System.out.print("ID를 입력 하세요: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void displayPhoneList(PhoneStorage phoneStorage) {
        System.out.printf("++++++++++++++++++++++++++++++++++\n\n"+
        		"[ 휴대폰 목록 ]\n");
        for (int i = 0; i < phoneStorage.getNumPhones(); i++) {
            System.out.println(phoneStorage.getPhoneInfo(i));
        }
        System.out.printf("\n\n++++++++++++++++++++++++++++++++++\n");
    }

    public void displayCart(Cart cart) {
        System.out.printf("++++++++++++++++++++++++++++++++++\n\n"+"[장바구니]");
        for (int i = 0; i < cart.getNumItems(); i++) {
            System.out.println(cart.getItemInfo(i));
        }
        System.out.println(">> 총 가격은 " + cart.getTotalPrice() + "원 입니다. <<");
        System.out.printf("\n\n++++++++++++++++++++++++++++++++++\n");
    }

    public boolean confirmPurchase() {
    	System.out.printf("++++++++++++++++++++++++++++++++++\n");
        System.out.print("주문 하시겠습니까? (네/아니요) : ");
        String input = scanner.nextLine();
        return input.equalsIgnoreCase("네");
    }

    public void displayAdminMenu() {
    	System.out.printf("++++++++++++++++++++++++++++++++++\n\n" +
    			"[관리자 메뉴]\n" +
    			"[ 1. 휴대폰 추가 ]\n");
        System.out.println("[ 2. 휴대폰 삭제 ]\n");
        System.out.println("[ 3. 저장 ]\n");
        System.out.println("[ 0. 종료 ]");
        System.out.printf("\n\n++++++++++++++++++++++++++++++++++\n");
        System.out.print(">> 번호를 입력 하세요 : ");
    }

    public String inputAdminUsername() {
    	System.out.printf("++++++++++++++++++++++++++++++++++\n" +
    			">> 관리자 이름을 입력하세요 : ");
        return scanner.nextLine();
    }

    public String inputAdminPassword() {
    	System.out.printf("++++++++++++++++++++++++++++++++++\n" +
    			">> 관리자 비밀번호를 입력 하세요 : ");
        return scanner.nextLine();
    }

    public String inputPhoneModel() {
        System.out.print(">> 휴대폰의 모델명을 입력하세요 : ");
        return scanner.nextLine();
    }

    public String inputPhoneBrand() {
        System.out.print(">> 휴대폰의 브랜드를 입력하세요 : ");
        return scanner.nextLine();
    }

    public int inputPhonePrice() {
        System.out.print(">> 휴대폰의 가격을입력 하세요 : ");
        return Integer.parseInt(scanner.nextLine());
    }
}
