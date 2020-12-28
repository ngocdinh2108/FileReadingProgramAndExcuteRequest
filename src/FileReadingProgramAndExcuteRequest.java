import java.io.*;
import java.util.Scanner;

public class FileReadingProgramAndExcuteRequest {
    public static String outPutFileName = "outPut1.txt";

    public static void main(String[] args) {
        printMenu();
        boolean loop = true;
        while (loop) {
            System.out.print("Nhap lua chon: ");
            Scanner input = new Scanner(System.in);
            int select = input.nextInt();
            String url = "./String/inPut1.txt";
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
                    insertString(url);
                    break;
                case 5:
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

    private static void switchString(String url) {
        StringBuffer result = readFile(url);
        String replaceString = result.toString().replaceAll("\\s\\s+", " ").trim();
        String str = "Toi yeu ha noi pho";
        if (replaceString.contains(str)){
            replaceString = replaceString.toString().replace(str, str.toUpperCase());
        }
        if (writeFile(outPutFileName, replaceString)) {
            System.out.println("Xoa khoang trang thua trong file inPut1.txt va doi chuoi \"Toi yeu ha noi pho\" thanh chuoi in hoa thanh cong!");
        } else {
            System.out.println("Xoa khoang trang thua trong file inPut1.txt va doi chuoi \"Toi yeu ha noi pho\" thanh chuoi in hoa that bai!");
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
        System.out.println("3. Xoa ky tu trang thua va doi chuoi \"Toi yeu ha noi pho\" thanh chuoi viet hoa. Ghi lai ket qua vao file outPut1.txt");
        System.out.println("4. Nhap them 1 chuoi \"o con ga cua toi\" vao sau ky tu \"$\". Ghi lai ket qua vao file outPut1.txt");
        System.out.println("5. Thoat khoi chuong trinh.");
    }

    public static StringBuffer readFile(String url) {
        StringBuffer result = new StringBuffer();
        try {
            FileReader fileReader = new FileReader(url);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while (true) {
                line = bufferedReader.readLine();
                if (line == null||line.equals("\\s")) {
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
