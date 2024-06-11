package phonemarket;

import phonemarket.controller.PhoneMarketController;

import java.io.IOException;

public class PhoneMarket {
    public static void main(String[] args) {
        try {
            PhoneMarketController controller = new PhoneMarketController();
            controller.run();
        } catch (IOException e) {
            System.err.println("휴대폰 마켓에 접속하는 데 실패했습니다.");
            e.printStackTrace();
        }
    }
}