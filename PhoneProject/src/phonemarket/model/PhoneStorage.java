package phonemarket.model;

import java.io.*;
import java.util.ArrayList;

public class PhoneStorage {
    ArrayList<Phone> phoneList = new ArrayList<>();
    final int MAX_QUANTITY = 10;
    private String phoneFilename = "phonelist.txt";
    private int lastId;
    private boolean isSaved;

    public PhoneStorage() throws IOException {
        loadPhoneListFromFile();
        generateLastId();
        isSaved = true;
    }

    private void generateLastId() {
        lastId = 0;
        for (Phone phone : phoneList) {
            int id = phone.getPhoneId();
            if (id > lastId) lastId = id;
        }
    }

    private void loadPhoneListFromFile() throws IOException {
        FileReader fr;
        try {
            fr = new FileReader(phoneFilename);
            BufferedReader br = new BufferedReader(fr);
            String idStr;
            while ((idStr = br.readLine()) != null && !idStr.equals("")) {
                int id = Integer.parseInt(idStr);
                String model = br.readLine();
                String brand = br.readLine();
                int price = Integer.parseInt(br.readLine());
                phoneList.add(new Phone(id, model, brand, price));
            }
            fr.close();
            br.close();

        } catch (FileNotFoundException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getNumPhones() {
        return phoneList.size();
    }

    public String getPhoneInfo(int i) {
        return phoneList.get(i).toString();
    }

    public boolean isValidPhone(int phoneId) {
        for (Phone phone : phoneList) {
            if (phone.getPhoneId() == phoneId) return true;
        }
        return false;
    }

    public Phone getPhoneById(int phoneId) {
        for (Phone phone : phoneList) {
            if (phone.getPhoneId() == phoneId)
                return phone;
        }
        return null;
    }

    public int getMaxQuantity() {
        return MAX_QUANTITY;
    }

    public boolean isEmpty() {
        return phoneList.size() == 0;
    }

    public void deleteItem(int phoneId) {
        phoneList.remove(getPhoneById(phoneId));
        isSaved = false;
    }

    public void addPhone(String model, String brand, int price) {
        Phone phone = new Phone(++lastId, model, brand, price);
        phoneList.add(phone);
        isSaved = false;
    }

    public boolean isSaved() {
        return isSaved;
    }

    public void savePhoneList2File() {
        try {
            FileWriter fw = new FileWriter(phoneFilename);
            for (Phone phone : phoneList) {
                fw.write(phone.getPhoneId() + "\n");
                fw.write(phone.getModel() + "\n");
                fw.write(phone.getBrand() + "\n");
                fw.write(phone.getPrice() + "\n");
            }
            fw.close();
            isSaved = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
