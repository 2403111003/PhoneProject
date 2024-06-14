package Pp.M.I;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Item {
    private ArrayList<ItemList> itemList = new ArrayList<>();
    private String itemFile = "Item.txt";
    private BufferedReader br;
    public Item() {
    	this.br = new BufferedReader(new InputStreamReader(System.in));
    }
    public ArrayList<ItemList> getItemList() {
        return itemList;
    }
    private void addItemFile()throws IOException{
    	File file = new File(itemFile);
    	if(!file.exists()) {
    		try {
    			file.createNewFile();
    			System.out.println("[ 파일을 생성 하였습니다 ]" + itemFile);
    		}catch(IOException e) {
    			System.out.println("[ 파일을 생성하는데 실패 하였습니다 ]" + itemFile);
    			return;
    		}
    	}
    }
    private void addItemList()throws IOException{
    	FileReader fr;
    	try {
    		fr = new FileReader(itemFile);
    		BufferedReader br = new BufferedReader(fr);
    		String line;
    		while((line = br.readLine()) != null) {	
    			int productId = inputNumber(">> ");
    			String model = inputString(">> ");
    			String manufacturer = inputString(">> ");
    			String operatingSystem = inputString(">> ");
    			int price = inputNumber(">>");
    			itemList.add(new ItemList(productId, model, manufacturer, operatingSystem, price));
    	}
    	}catch (FileNotFoundException |  NumberFormatException e) {
    		
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

}

