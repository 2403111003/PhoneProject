package Pp.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Pp.M.Model;
import Pp.V.View;

public class Controller {
    View V;
    Model M;
    private BufferedReader br;

    public Controller(View v, Model m) {
        this.V = v;
        this.M = m;
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public void Start() throws IOException {
        V.welcome();
        Menu();
    }

    private void Menu() throws IOException {
        while (true) {
            V.displaymenu();
            int choice = inputNumber(">> 숫자를 입력 하세요.");
            switch (choice) {
                case 0:
                    V.end();
                    return;
                case 1:
                    V.displayphoneMenu();
                    phoneMenu();
                    break;
                case 2:
                    V.displaycartMenu();
                    cartMenu();
                    break;
                case 3:
                    order();
                    break;
                case 4:
                    V.displayadminMenu();
                    adminMenu();
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 입력하세요.");
            }
        }
    }

    private void phoneMenu() throws IOException {
        int choice = inputNumber(">> 숫자를 입력 하세요.");
        switch (choice) {
            case 0:
                Menu();
                break;
            case 1:
                V.phoneInfo();
                break;
            case 2:
                search();
                break;
            case 3:
                addCart();
                break;
            case 4:
                order();
                break;
            default:
                System.out.println("잘못된 선택입니다. 다시 입력하세요.");
        }
    }
    private void search()throws IOException{
    	int	search = inputNumber(">> 모델명/상품 번호를 입력 하세요.");
	}

	private void addCart() {
    	
	}

	private void cartMenu() throws IOException {
        int choice = inputNumber(">> 숫자를 입력 하세요.");
        switch (choice) {
            case 0:
                Menu();
                break;
            case 1:
                // Implement view cart functionality
                break;
            case 2:
                // Implement empty cart functionality
                break;
            case 3:
                // Implement modify cart functionality
                break;
            case 4:
                order();
                break;
            default:
                System.out.println("잘못된 선택입니다. 다시 입력하세요.");
        }
    }

    private void adminMenu() throws IOException {
        int choice = inputNumber(">> 숫자를 입력 하세요.");
        switch (choice) {
            case 0:
                Menu();
                break;
            case 1:
                // Implement phone management functionality
                break;
            case 2:
                // Implement user management functionality
                break;
            case 3:
                // Implement review management functionality
                break;
            case 4:
                // Implement order history functionality
                break;
            default:
                System.out.println("잘못된 선택입니다. 다시 입력하세요.");
        }
    }

    public int inputNumber(String message) throws IOException {
        System.out.printf(message + "\n>> ");
        int number;
        try {
            number = Integer.parseInt(br.readLine());
        } catch (NumberFormatException | IOException e) {
            System.out.printf(">> 잘못 입력 하셨습니다. 다시 입력하세요.\n");
            return inputNumber(message);
        }
        return number;
    }

    public String inputString(String message) throws IOException {
        System.out.printf(message + "\n>> ");
        String str;
        try {
            str = br.readLine();
        } catch (IOException e) {
            System.out.printf(">> 잘못 입력 하셨습니다. 다시 입력하세요.\n");
            return inputString(message);
        }
        return str;
    }

    public void order() throws IOException {
        String response = inputString(">> 주문 하시겠습니까?");
        switch (response) {
            case "d":
            case "dd":
            case "dP":
            case "sp":
            case "yes":
            case "네":
            case "예":
            case "ㅇㅇ":
            case "ㅇ":
                System.out.printf(">> 주문 완료 했습니다.\n");
                break;
            default:
                System.out.printf(">> 잘못된 입력입니다. 다시 시도해주세요.\n");
                order();
        }
    }
}
