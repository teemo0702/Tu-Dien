import java.util.Scanner;

public class DictionaryCommandline extends DictionaryManagement{
    public void showAllWords(Dictionary wordList) {
        System.out.println("\nTừ điển Anh-Việt");
        System.out.println("English \t | Vietnamese");
        for (int i = 0; i < wordList.words.size(); i++) {
            System.out.println(wordList.words.get(i).getWord_target() + " \t | " + wordList.words.get(i).getWord_explain());
        }
    }
    public void dictionarySeacher(Dictionary wordList) {
        System.out.print("Từ bạn muốn tìm là ?      ");
        Scanner scanner = new Scanner(System.in);
        String word_search = scanner.next();
        word_search = word_search.toLowerCase();
        int count = 0;
        if (word_search.length() > 1) {
            for (int i = 0; i < wordList.words.size(); i++) {
                if (wordList.words.get(i).getWord_target().startsWith(word_search)) {
                    count++;
                    if (count == 1) System.out.println("Words start with '" + word_search + "' are: ");
                    System.out.println(wordList.words.get(i).getWord_target());
                }
            }
        }
        if (count == 0)
            System.out.println("Không có từ này!");
    }
}