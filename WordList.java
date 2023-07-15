public class WordList {
    WordMeaningNode head;

    WordList() {
        head = null;
    }

    void add(WordMeaning wordMeaning) {
        WordMeaningNode newNode = new WordMeaningNode(wordMeaning);

        if (head == null) {
            head = newNode;
            return;
        }

        WordMeaningNode temp = head;

        while (temp.next != null) {
            if (newNode.wordMeaning.name.compareToIgnoreCase(temp.next.wordMeaning.name) < 0) {
                newNode.next = temp.next;
                temp.next = newNode;
                return;
            }

            temp = temp.next;
        }
        temp.next = newNode;
    }
}
