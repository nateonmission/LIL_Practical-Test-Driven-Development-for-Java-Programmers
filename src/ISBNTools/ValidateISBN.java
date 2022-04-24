package ISBNTools;
import java.io.*;
import java.util.*;
public class ValidateISBN {

    public static final int SHORT_ISBN_LENGTH_10 = 10;
    public static final int LONG_ISBN_LENGTH_13 = 13;
    public static final int LONG_ISBN_MULTIPLIER = 10;
    public static final int SHORT_ISBN_MULTIPLIER = 11;

    public boolean checkISBN(String isbn)  {

        if(isbn.length() != SHORT_ISBN_LENGTH_10 && isbn.length() != LONG_ISBN_LENGTH_13){
            throw new NumberFormatException("ISBN must be 10 or 13 digits.");
        }
        
        int s = 0;
        char[] isbn_intArray = new char[isbn.length()];
        for(int i=0; i< isbn.length(); i++){
            char c = isbn.charAt(i);
            if( !Character.isDigit(c) ) {
                if (i == 9 && c == 'X') {
                    isbn_intArray[i] = 10;
                } else {
                    throw new NumberFormatException("Invalid ISBN");
                }
            }
            isbn_intArray[i] = c;
        }

        if(isbn.length() == SHORT_ISBN_LENGTH_10) {
            return isValidShortISBN( s, isbn_intArray);
        } else {
            return isValidLongISBN(s, isbn_intArray);
        }
    }

    private boolean isValidShortISBN( int s, char[] isbn_intArray) {
        for (int j = 0; j < isbn_intArray.length; j++) {
            s += Character.getNumericValue(isbn_intArray[j]) * (isbn_intArray.length - j);
        }
        return s % SHORT_ISBN_MULTIPLIER == 0;
    }

    private boolean isValidLongISBN(int s, char[] isbn_intArray) {
        for (int j = 1; j <= isbn_intArray.length-1; j++) {
            if( j % 2 == 0 ) {
                s += Character.getNumericValue(isbn_intArray[j-1]) * 3;
            } else {
                s += Character.getNumericValue(isbn_intArray[j-1]) ;
            }
        }
        return (LONG_ISBN_MULTIPLIER - (s % LONG_ISBN_MULTIPLIER)) == Character.getNumericValue(isbn_intArray[12]);
    }

}