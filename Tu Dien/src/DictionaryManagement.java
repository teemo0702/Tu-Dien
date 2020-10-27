import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DictionaryManagement {
    Dictionary wordList = new Dictionary();

    public void insertFromFile(Dictionary wordList) throws FileNotFoundException {
        File file = new File("C:\\Users\\PV\\IdeaProjects\\Tu Dien\\src\\dictionary.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] words = s.split(" ",2);
            Word w = new Word(words[0], words[1]);
            wordList.words.add(w);
        }
    }

    /* Dich tu */
    public void dictionaryLookup(Dictionary wordList) {
        System.out.print("Từ bạn muốn dịch là: ");
        Scanner scanner = new Scanner(System.in);
        String word_translate = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < wordList.words.size(); i++) {
            if (word_translate.equalsIgnoreCase(wordList.words.get(i).getWord_target())) {
                System.out.println("Nghĩa của từ" + word_translate + "là : " + wordList.words.get(i).getWord_explain());
                count++;
            }
        }
        if (count == 0) System.out.println("Không có từ này!");
    }

    /* Them tu vung */
    public void dictionaryAdd(Dictionary wordList) {
        System.out.print("\nBạn có muốn thêm từ ? (Y/N)       ");
        Scanner scanner = new Scanner(System.in);
        char choice = scanner.nextLine().charAt(0);
        if (choice == 'Y' || choice == 'y') {
            // Scan in Eng word
            System.out.print("Từ bạn muốn thêm là: ");
            String new_target = scanner.next();
            // Scan in Vie word
            System.out.print("Nghĩa của từ" + new_target + "là : ");
            String new_explain = scanner.next();
            Word w = new Word(new_target, new_explain);
            wordList.words.add(w);
        }
    }

    /* Xoa tu vung */
    public void dictionaryDelete(Dictionary wordList) {
        System.out.print("\nBạn có muốn xóa từ ? (Y/N)      ");
        Scanner scanner = new Scanner(System.in);
        char choice = scanner.nextLine().charAt(0);
        if (choice == 'Y' || choice == 'y') {
            System.out.print("Từ bạn muốn xóa là: ");
            String word_delete = scanner.nextLine();
            int count = 0;
            for (int i = 0; i < wordList.words.size(); i++) {
                if (word_delete.equalsIgnoreCase(wordList.words.get(i).getWord_target())) {
                    count ++;
                    System.out.print("'" + word_delete + "' đã được xóa!");
                    wordList.words.remove(i);
                }
            }
            if (count == 0)
                System.out.println("Không có từ này!");
        }
    }

    /* Sua tu vung */
    public void dictionaryEdit(Dictionary wordList) {
        System.out.print("\nBạn có muốn sửa từ ? (Y/N)      ");
        Scanner scanner = new Scanner(System.in);
        char choice = scanner.nextLine().charAt(0);
        if (choice == 'Y' || choice == 'y') {
            System.out.print("Từ bạn muốn sửa là: ");
            String word_edit = scanner.nextLine();
            int count = 0;
            for (int i = 0; i < wordList.words.size(); i++) {
                if (word_edit.equalsIgnoreCase(wordList.words.get(i).getWord_target())) {
                    count ++;
                    // Insert Eng word
                    System.out.print("Bạn muốn sửa thành: ");
                    String w_target = scanner.nextLine();
                    wordList.words.get(i).setWord_target(w_target);
                    // Insert Vie word
                    System.out.print("Nghĩa của từ " + w_target + " là: ");
                    String w_explain = scanner.nextLine();
                    wordList.words.get(i).setWord_explain(w_explain);
                }
            }
            if (count == 0)
                System.out.println("Không có từ này!");
        }
    }
}
