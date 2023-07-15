import javax.swing.JOptionPane;

public class Dictionary {
    static WordList wordList = new WordList();
    static WordList deletedWordList = new WordList();

    public static void main(String[] args) {
        int choiceMain = 0;
        String[] optionsMain = {
            "Add a word/meaning",
            "Delete a word",
            "List all words",
            "List all deleted words",
            "Exit"
        };

        while (choiceMain != 4) {
            choiceMain = JOptionPane.showOptionDialog(null, "Choose an option", "Dictionary", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, optionsMain, optionsMain[0]);

            switch (choiceMain) {
                case 0:
                    addWord();
                    break;
                case 1:
                    addDeletedWord();
                    break;
                case 2:
                    listAllWords();
                    break;
                case 3:
                    listAllDeletedWords();
                    break;
                case 4:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }  
    }

    public static void addWord() {
        String name = JOptionPane.showInputDialog("Enter the word").trim();
        String meaning = JOptionPane.showInputDialog("Enter the meaning").trim();

        WordMeaning wordMeaning = new WordMeaning(name, meaning);
        wordList.add(wordMeaning);

        String[] options = {
            "Add another meaning for this word",
            "Main menu"
        };
        
        int choice = JOptionPane.showOptionDialog(null, "Word added successfully. Do you want to add another meaning for this word?", "Add word", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        
        if (choice == 0) {
            addWord();
        }
    }

    public static void addDeletedWord() {
        String name = JOptionPane.showInputDialog("Enter the word").trim();

        WordMeaningNode temp = wordList.head;
        WordMeaningNode prev = null;
        while (temp != null) {
            if (temp.wordMeaning.getName().equals(name)) {
                deletedWordList.add(temp.wordMeaning);

                if (prev == null) {
                    wordList.head = temp.next;
                } else {
                    prev.next = temp.next;
                }
            }
            prev = temp;
            temp = temp.next;
        }

        String[] options = {
            "Delete another word",
            "Main menu"
        };

        int choice = JOptionPane.showOptionDialog(null, "Word deleted successfully. Do you want to delete another word?", "Delete word", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (choice == 0) {
            addDeletedWord();
        }
    }

    public static void listAllWords() {
        WordMeaningNode temp = wordList.head;
        String outputString = "";
        String lastWord = "";
        while (temp != null) {
            if (temp.wordMeaning.getName().equals(lastWord)) {
                outputString += "     - " + temp.wordMeaning.getMeaning() + "\n";
            } else {
                outputString += temp.wordMeaning.getName() + " - " + temp.wordMeaning.getMeaning() + "\n";
            }
            lastWord = temp.wordMeaning.getName();
            temp = temp.next;
        }
        JOptionPane.showMessageDialog(null, outputString, "List of words", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void listAllDeletedWords() {
        WordMeaningNode temp = deletedWordList.head;
        String outputString = "";
        while (temp != null) {
            outputString += temp.wordMeaning.getName() + "\n";
            temp = temp.next;
        }
        JOptionPane.showMessageDialog(null, outputString, "List of deleted words", JOptionPane.INFORMATION_MESSAGE);
    }
}
