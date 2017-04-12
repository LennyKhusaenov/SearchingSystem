package org.edu;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {

    private String word;
    private int lineNumber;
    private int startIndex;
    private int endIndex;

    public String getDocName() {
        return docName;
    }

    public String docName;

    public Tokenizer(String word, int lineNumber, int startIndex, int endIndex,
                     String docName) {
        this.word = word;
        this.lineNumber = lineNumber;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.docName = docName;
    }

    public static boolean isWord(char ch) {
        return Character.isLetter(ch);
    }


    public static void tokenize(String inputStr, int lineNum, String filename, List<Tokenizer> str) {

        char[] charArr = inputStr.toCharArray();
        boolean flag = false;
        int stInTemp = 0;
        for (int i = 0; i < charArr.length; i++) {
            String temp = "";
            while (i < charArr.length && isWord(charArr[i])) {
                temp += charArr[i];

                if (flag == false) stInTemp = i;
                flag = true;
                i++;
            }
            if (temp.compareTo("") > 0)
                str.add(new Tokenizer(temp, lineNum, stInTemp, stInTemp + temp.length(), filename));
            flag = false;


        }
    }


    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    @Override
    public String toString() {
        return
                "(word='" + word + '\'' +
                        ", lineNumber=" + lineNumber +
                        ", startIndex=" + startIndex +
                        ", endIndex=" + endIndex +
                        ", filename=" + docName +
                        ")    ";
    }


}
