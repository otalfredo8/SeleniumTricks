package com.cybertek.utilities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.util.*;

public class Javautils {

    public static void main(String[] args) {
        String j = "{\n" +
                "    \"glossary\": {\n" +
                "        \"title\": \"example glossary\",\n" +
                "\t\t\"GlossDiv\": {\n" +
                "            \"title\": \"S\",\n" +
                "\t\t\t\"GlossList\": {\n" +
                "                \"GlossEntry\": {\n" +
                "                    \"ID\": \"SGML\",\n" +
                "\t\t\t\t\t\"SortAs\": \"SGML\",\n" +
                "\t\t\t\t\t\"GlossTerm\": \"Standard Generalized Markup Language\",\n" +
                "\t\t\t\t\t\"Acronym\": \"SGML\",\n" +
                "\t\t\t\t\t\"Abbrev\": \"ISO 8879:1986\",\n" +
                "\t\t\t\t\t\"GlossDef\": {\n" +
                "                        \"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",\n" +
                "\t\t\t\t\t\t\"GlossSeeAlso\": [\"GML\", \"XML\"]\n" +
                "                    },\n" +
                "\t\t\t\t\t\"GlossSee\": \"markup\"\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";

        System.out.println(jsonToXml(j));
        System.out.println(xmlToJson(jsonToXml(j)));

        int [] array = {2, 245,44, 6,4,2,6};
        System.out.println(maxValOfArray(array));
        System.out.println(minValOfArray(array));
        System.out.println(isPalindrome("rcecar"));
        String [] strArray = {"car", "dad", "cad", "racecar"};
        List<String> stringArrayList = new ArrayList<String>(Arrays.asList(strArray));
        System.out.println(nonPalindromeRemover(stringArrayList));
        System.out.println(biggestPalindrome("mom and dad in a racecar"));

        printPermutn("abc", "");

        drawDiamond(8);

        System.out.println(toFibonacci(9));

        uniqueLetters("cabc");

        System.out.println(oddOrEven(13));
        int [] toBeSortedArray = {84, 21, 45, 12, 4, 25, 10, 1};
        sortIntArray(toBeSortedArray);

        for (int i:toBeSortedArray){
            System.out.print(i + " ");
        }

        System.out.println(stringReverser("alfredo"));

        System.out.println(stringReverserValidator("alfredo", stringReverser("alfredo")));

        System.out.println(firstRepeatedLetterFinderWithSet("Torres"));
        System.out.println(firstRepeatedLetterFinderWithMap("torres"));

        System.out.println(isValidJSON("{\n" +
                "\"name\":\"John\",\n" +
                "\"age\":30,\n" +
                "\"cars\":[ \"Ford\", \"BMW\", \"Fiat\" ]\n" +
                "}"));

        System.out.println(factorialOfanInt(4));

        System.out.println(numToWordsUntilHundreds(39));

        System.out.println(isMadeOutOfSameLetters("tomas", "motas"));

        System.out.println(duplicatedLettersRemover("alkfjlkjfkjglkgffhskjdhslkdjf"));

        numberOfEachCharInStringCounter("oday is the anniversary of the publication of Robert Frost’s iconic poem “Stopping by Woods on a Snowy Evening,” a fact that spurred the Literary Hub office into a long conversation about their favorite poems, the most iconic poems written in English, and which poems we should all have already read (or at least be reading next). Turns out, despite frequent (false) claims that poetry is dead and/or irrelevant and/or boring, there are plenty of poems that have sunk deep into our collective consciousness as cultural icons. (What makes a poem iconic? For our purposes here, it’s primarily a matter of cultural ubiquity, though unimpeachable excellence helps any case.) So for those of you who were not present for our epic office argument, I have listed some of them here.");


    }
    public static int maxValOfArray(int [] array){
        int max = 0;
        for (int i = 0; i <= array.length-1; i++){
            if (array [i] > max){
                max = array[i];
            }
        }
        return max;
    }

    public static int minValOfArray(int [] array){
        int min = array[0];
        for (int i= 0; i<=array.length-1; i++){
            if (array[i] < min){
                min = array[i];
            }
        }
        return min;
    }

    public static String biggestPalindrome(String str){
        if (str.equalsIgnoreCase("") || str.equalsIgnoreCase(" ")) {
            return "Please enter a String";
        }
        if (str.length() == 1) {
            return str;
        }
        List<String> strArrayList = new ArrayList<String>(Arrays.asList(str.split(" ")));
        List<String> strArrayList_OnlyPal = nonPalindromeRemover(strArrayList);

        String longestPal = strArrayList_OnlyPal.get(0);
        for (int i = 0; i<=strArrayList_OnlyPal.size()-1; i++){
            if (strArrayList_OnlyPal.get(i).length() > longestPal.length())
                longestPal = strArrayList_OnlyPal.get(i);
        }
        return longestPal;
    }


    public static List<String> nonPalindromeRemover(List<String> stringArrayList) {
        List<String> strArrayList = stringArrayList;
        for (int i = 0; i<=strArrayList.size()-1; i++){
            if (!isPalindrome(strArrayList.get(i))) {
                strArrayList.remove(strArrayList.get(i));
            }
        }
        return strArrayList;
    }

    public static boolean isPalindrome(String str){
        boolean isPal = true;
        for (int i = 0; i<=str.length()-1; i++){
            if (str.charAt(i) != str.charAt(str.length()-1-i)){
                isPal = false;
                break;
            }
        }
        return isPal;
    }

    public static int [] sortIntArray(int [] intArray){
        int [] a = intArray;
        int temp = 0;
        for (int i = 0; i < a.length; i++) {   //i=0
            for (int j = i + 1; j < a.length; j++) { //j=1
                if (a[i] > a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }

    public static String stringReverser(String str){
        String reversedStr = "";
        for (int i = str.length() - 1; i >= 0; i--){
            reversedStr += str.charAt(i);
        }
        return reversedStr;
    }

    public static boolean stringReverserValidator(String actualStr, String expectStr){
        boolean isEqual = true;
        if (actualStr.equalsIgnoreCase(stringReverser(expectStr))){
            return isEqual;
        }else {
            return false;
        }
    }

    public static Character firstRepeatedLetterFinderWithMap(String str){

        str = str.replaceAll(" ", "");
        Character repeatChar = null;

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i<= str.length()-1; i++) {
            Character chr = str.charAt(i);
            if (map.containsKey(chr)){
                map.put(chr, map.get(chr)+1);
            }else{
                map.put(chr, 1);
            }
        }
        for (int i = 0; i <str.length(); i++){
            if (map.get(str.charAt(i))>1){
                repeatChar = str.charAt(i);
                break;
            }
        }
        return repeatChar;
    }


    public static char [] stringToCharArrayer(String str){
        char [] strTocharArr = new char[str.length()];
        for (int i = 0; i<=str.length() -1; i++){
            strTocharArr[i] = str.charAt(i);
        }
        return strTocharArr;
    }
    public static char firstRepeatedLetterFinderWithSet(String str){
        char [] array = stringToCharArrayer(str);
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i<=str.length()-1; i++){
            char c  = array[i];
            if (set.contains(c))
                return c;

            else
                set.add(c);
        }
        return '\0';
    }
    //import org.json.*
    public static boolean isValidJSON(String str){
        try{
            new JSONObject(str);
        }catch (JSONException eo){
            try{
                new JSONArray();
            }catch (JSONException ea){
                return false;
            }
        }
        return true;
    }

    public static int factorialOfanInt(int n){
        int fact = 1;

        for (int i=1; i<=n; i++)
            fact=fact*i;

        return fact;
    }

    public static String oddOrEven(int n){
        if (n%2==0)
            return "Even";

        else
            return "Odd";
    }

    public static String numToWordsUntilHundreds(int n){
        final String[] units = { "", "One", "Two", "Three", "Four",
                "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
                "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
                "Eighteen", "Nineteen" };

        final String[] tens = {
                "", 		// 0
                "",		// 1
                "Twenty", 	// 2
                "Thirty", 	// 3
                "Forty", 	// 4
                "Fifty", 	// 5
                "Sixty", 	// 6
                "Seventy",	// 7
                "Eighty", 	// 8
                "Ninety" 	// 9
        };
        if (n < 0) {
            return "Minus " + numToWordsUntilHundreds(-n);
        }

        if (n < 20) {
            return units[n];
        }

        if (n < 100) {
            return tens[n / 10] + ((n % 10 != 0) ? " " : "") + units[n % 10];
        }

        else
            return units[n / 100] + " Hundred" + ((n % 100 != 0) ? " " : "") + numToWordsUntilHundreds(n % 100);
    }

    public static boolean isMadeOutOfSameLetters(String a, String b) {
       if (a == null){
           return b == null;
       }else if (b == null){
           return false;
       }
       char [] arrayA = a.toCharArray();
       char [] arrayB = b.toCharArray();
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        return Arrays.equals(arrayA, arrayB);
    }

    public static String duplicatedLettersRemover(String str){
        char [] chars = str.toCharArray();
        Set<Character> charSet = new HashSet<Character>();
        for (char c:chars) {
            charSet.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : charSet){
            sb.append(character);
        }
        return sb.toString();
    }

    public static void numberOfEachCharInStringCounter(String str){

        String str1 = str.replaceAll(" ", "");
        Map<Character, Integer> characterIntegerMap = new HashMap<Character, Integer>();

        for (char c : str1.toCharArray()){
            if (characterIntegerMap.containsKey(c)){
                characterIntegerMap.put(c, characterIntegerMap.get(c)+1);
            }else{
                characterIntegerMap.put(c, 1);
            }
        }
        System.out.println(characterIntegerMap);
    }

    public static void uniqueLetters(String str){

        String str2 = str;
        for (int i = 0; i<=str.length()-1; i++){
            for (int j = 1; j<=str.length()-1; j++){
                if(str.charAt(i) == str.charAt(j)){
                    str2.replace(str.charAt(i),  ' ');
                }
            }
        }
        System.out.println(str2);
    }


    public static long toFibonacci(long n) {
        if ((n == 0) || (n == 1))
            return n;
        else
            return toFibonacci(n - 1) + toFibonacci(n - 2);
    }

    public static void drawDiamond(int diagonal) {
        int n = diagonal;
        for (int i = n / 2; i >= -n / 2; i--) {
            for (int k = 0; k < i; k++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (n - i * 2) && i >= 0; j++) {
                System.out.print("*");
            }
            for (int k = 1; k <= -i && i < 0; k++) {
                System.out.print(" ");
            }
            for (int j = (n / 2) * 2 + 2 * i; j >= -(n % 2 - 1) && i < 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void printPermutn(String str, String ans) {

        // If string is empty
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            String ros = str.substring(0, i) + str.substring(i + 1);

            printPermutn(ros, ans + ch);
        }
    }
    public static String jsonToXml(String anyJsonString){
        JSONObject jsonObj = new JSONObject(anyJsonString);
        return XML.toString(jsonObj);
    }

    public static JSONObject xmlToJson (String xmlStr){
        JSONObject jsonObj = XML.toJSONObject(xmlStr);
        return jsonObj;
    }
}
