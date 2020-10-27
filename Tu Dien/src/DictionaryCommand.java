import java.io.FileNotFoundException;
import java.util.Scanner;

public class DictionaryCommand {
    DictionaryManagement management = new DictionaryManagement();
    DictionaryCommandline commandline = new DictionaryCommandline();

    public boolean Continue() {
        System.out.print("Bạn có muốn tiếp tục ? (Y/N)   ");
        Scanner scanner = new Scanner(System.in);
        char choice = scanner.next().charAt(0);
        return choice == 'Y' || choice == 'y';
    }

    public void dictionaryAdvanced() throws FileNotFoundException {
        management.insertFromFile(management.wordList);
        while (Continue()) {
            commandline.showAllWords(management.wordList);
            management.dictionaryLookup(management.wordList);
            commandline.dictionarySeacher(management.wordList);
            management.dictionaryAdd(management.wordList);
            management.dictionaryDelete(management.wordList);
            management.dictionaryEdit(management.wordList);
            commandline.showAllWords(management.wordList);
        }
    }
}
