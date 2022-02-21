public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> w2d = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            char charInWord = word.charAt(i);
            w2d.addLast(charInWord);
        }
        return w2d;
    }

    /* iterative version */
    public boolean isPalindrome(String word) {
        Deque<Character> dq = new LinkedListDeque<>();
        dq = wordToDeque(word);
        String actual = "";
        for (int i = 0; i < word.length(); i++) {
            actual += dq.removeLast();
        }
        if (actual.equals(word)) {
            return true;
        } else {
            return false;
        }
    }

//    /* recursive version */
//    public boolean isPalindrome(String word) {
//        return isPalindromeHelper(word, 0);
//    }
//
//    public boolean isPalindromeHelper(String word, int index) {
//        int reverseIndex = word.length() - index - 1;
//        if (reverseIndex <= index) {
//            return true;
//        } else if (word.charAt(index) == word.charAt(reverseIndex)) {
//            return isPalindromeHelper(word, index + 1);
//        } else {
//            return false;
//        }
//    }



    public boolean isPalindrome(String word, CharacterComparator cc) {
        return isPalindromeHelper(word, cc, 0);
    }

    public boolean isPalindromeHelper(String word, CharacterComparator cc, int index) {
        if (word.length() == 0) {
            return true;
        }
        int reverseIndex = word.length() - index - 1;
        if (reverseIndex <= index) {
            return true;
        } else if (cc.equalChars(word.charAt(index), word.charAt(reverseIndex))) {
            return isPalindromeHelper(word, cc, index + 1);
        } else {
            return false;
        }
    }


}
