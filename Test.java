import javax.swing.JOptionPane;

public class Test {
    static WordList wordList = new WordList();

    public static void main(String[] args) {

        //test alphabetical ordering
        wordList.add(new WordMeaning("a", "a"));
        wordList.add(new WordMeaning("e", "e"));
        wordList.add(new WordMeaning("b", "b"));
        wordList.add(new WordMeaning("b", "b2"));
        wordList.add(new WordMeaning("b", "b3"));
        wordList.add(new WordMeaning("d", "d"));
        wordList.add(new WordMeaning("c", "c"));
        wordList.add(new WordMeaning("c", "c2"));
        wordList.add(new WordMeaning("f", "f"));

        listAllWords();

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
}
