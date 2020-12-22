import java.io.*;
import java.util.Scanner;

public class Main {
    public static String outPutFileName = "outPut1.txt";

    public static void main(String[] args) {
        printMenu();
        boolean loop = true;
        while (loop) {
            System.out.print("Nhap lua chon: ");
            Scanner input = new Scanner(System.in);
            int select = input.nextInt();
            String url = "/home/dinhngocdinh/Downloads/String/inPut1.txt";
            switch (select) {
                case 1:
                    printUpperCase(url);
                    break;
                case 2:
                    countCharacters(url);
                    break;
                case 3:
                    switchString(url);
                    break;
                case 4:
                    deleteExtraSpace(url);
                    break;
                case 5:
                    insertString(url);
                    break;
                case 6:
                    loop = false;
                    System.out.println("Ket thuc chuong trinh!");
                    break;
                default:
                    System.out.println("Khong co lua chon phu hop! Xin nhap lai!");
                    break;
            }
        }
    }

    private static void insertString(String url) {
        StringBuffer result = readFile(url);
        int index = result.indexOf("$");
        StringBuffer replaceString = result.insert(index + 1, "o con ga cua toi");
        if (writeFile(outPutFileName, replaceString.toString())) {
            System.out.println("Them chuoi \"o con ga cua toi\" dang sau ky tu \"$\" trong file thanh cong!");
        } else {
            System.out.println("Xhem chuoi \"o con ga cua toi\" dang sau ky tu \"$\" trong file that bai!");
        }
    }

    private static void deleteExtraSpace(String url) {
        StringBuffer result = readFile(url);
        String replaceString = result.toString().replaceAll("\\s\\s+", " ").trim();
        if (writeFile(outPutFileName, replaceString)) {
            System.out.println("Xoa ky tu trang thua thanh cong!");
        } else {
            System.out.println("Xoa ky tu trang thua that bai!");
        }
    }

    private static void switchString(String url) {
        StringBuffer result = readFile(url);
        int index = result.indexOf("Toi "); // lay ra chi so cua chuoi "Toi ..." trong chuoi result
        int index2 = result.indexOf("De im ngu"); //lay ra chi so cua chuoi "De im ng u..." trong chuoi result (Trc tu ha noi pho)
        String subStr = result.substring(index, index2);
        String replaceString = result.toString().replace(subStr, subStr.toUpperCase()); // Thay the chuoi trong result
        if (writeFile(outPutFileName, replaceString)) {
            System.out.println("Doi chuoi \"Toi yeu ha noi pho\" thanh chuoi in hoa thanh cong!");
        } else {
            System.out.println("Doi chuoi \"Toi yeu ha noi pho\" thanh chuoi in hoa that bai!");
        }
    }

    private static void countCharacters(String url) {
        StringBuffer result = readFile(url);
        System.out.println("So luong ki tu trong File: " + readFile(url).length() + " ky tu.");
        int countOfLowercaseCharacters = 0;
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) >= 'a' && result.charAt(i) <= 'z') {
                countOfLowercaseCharacters++;
            }
        }
        System.out.println("So luong ki tu thuong: " + countOfLowercaseCharacters + " ky tu.");
    }

    private static void printUpperCase(String url) {
        StringBuffer result = readFile(url);
        System.out.print("Cac ky tu in hoa trong file la: ");
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) >= 'A' && result.charAt(i) <= 'Z') {
                System.out.print(result.charAt(i) + " ");
            }
        }
        System.out.println("\n");

    }

    public static void printMenu() {
        System.out.println("Cho file inputBai1.txt. Chon yeu cau can thuc hien");
        System.out.println("1. In ra cac ky tu hoa.");
        System.out.println("2. Dem so luong ky tu va so ky tu thuong.");
        System.out.println("3. Doi chuoi \"Toi yeu ha noi pho\" thanh chuoi viet hoa. Ghi lai ket qua vao file outPut1.txt");
        System.out.println("4. Xoa ky tu trang thua. Ghi lai ket qua vao file outPut1.txt");
        System.out.println("5. Nhap them 1 chuoi \"o con ga cua toi\" vao sau ky tu \"$\". Ghi lai ket qua vao file outPut1.txt");
        System.out.println("6. Thoat khoi chuong trinh.");
    }

    public static StringBuffer readFile(String url) {
        StringBuffer result = new StringBuffer();
        try {
            FileReader fileReader = new FileReader(url);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }

                result.append(line);
                result.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean writeFile(String outPutFileName, String content) {
        try {
            FileWriter fileWriter = new FileWriter(outPutFileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(content);
            bufferedWriter.close();
            fileWriter.close();
            System.out.print("Ghi vao file outPut1.txt thanh cong! ");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ghi that bai!");
        }
        return false;
    }
}
