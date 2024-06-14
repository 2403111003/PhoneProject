package Pp.V;

import Pp.M.Model;

public class View {
    Model M;

    // 생성자
    public View(Model m) {
        this.M = m;
    }

    // 메인 메뉴
    public void displaymenu() {
        System.out.printf("[ 0. 종료 ]\n" +
                "[ 1. 핸드폰 목록 ]\n" +
                "[ 2. 장바구니 ]\n" + 
                "[ 3. 주문 ]\n" +
                "[ 4. 관리자 모드 ]\n");
    }

    // 핸드폰 메뉴
    public void displayphoneMenu() {
        System.out.printf("[ 0. 뒤로 ]\n" +
                "[ 1. 핸드폰 보기 ]\n" +
                "[ 2. 핸드폰 검색 ]\n" +
                "[ 3. 핸드폰 장바구니에 담기 ]\n" +
                "[ 4. 주문 ]\n");
    }

    // 핸드폰 정보 보기
    public void phoneInfo() {
        M.getItemList();
    }

    // 장바구니 메뉴
    public void displaycartMenu() {
        System.out.printf("=============================================\n\n" +
                "[ 0. 뒤로 ]\n" +
                "[ 1. 장바구니 보기 ]\n" +
                "[ 2. 장바구니 비우기 ]\n" +
                "[ 3. 장바구니 수정 ]\n" +
                "[ 4. 주문 ]\n\n" +
                "=============================================\n");
    }

    // 관리자 메뉴
    public void displayadminMenu() {
        System.out.printf("=============================================\n\n" +
                "[ 0. 관리자 모드 종료 ]\n" +
                "[ 1. 핸드폰 관리 ]\n" +
                "[ 2. 사용자 관리 ]\n" +
                "[ 3. 리뷰 관리 ]\n" +
                "[ 4. 주문 내역 ]\n\n" +
                "=============================================\n");
    }

    // 환영 인사
    public void welcome() {
        System.out.printf("=============================================\n\n" +
                "환영합니다!\n\n" +
                "=============================================\n");
    }

    // 종료
    public void end() {
        System.out.printf("프로그램을 종료합니다.\n");
    }
}
