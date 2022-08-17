
class LaunchStringAssignment{
    /*
    * 1.write a program to reverse a String
    * */
    public String reverseStringMethod1(String str){
        String output="";
        //traversing from starting and taking last element and storing in new array
        for(int i=0;i<str.length();i++){
            output=output+str.charAt(str.length()-1-i);
        }
       /* we can also write in this way traversing from backwards and taking last element and storing in new array
        for(int i=str.length()-1;i>=0;i--){
            output=output+str.charAt(i);
        }*/

        return output;
    }
    public String reverseStringMethod2(String str){
        /*we can use XOR operation to reverse a string
          XOR properties are
          1.associative -> X^(Y^Z)=(X^Y)^Z
          2.cummutative -> X^Y =Y ^ X
          3. X ^ X = 0
          4. X ^ 0 = X
          so we can use xor to swap first and last element like below
          suppose x=a, y=b
          x=x^y=a^b
          y=x^y=a^b^b=a^(b^b)=a^0=a
          x=x^y=a^b^a=a^a^b=0^b=b
          thus x becomes b and y becomes a

        * */
        String output="";


        char charArray[]=str.toCharArray();
        int start=0;
        int end=charArray.length-1;
        for(int i=start;i<end;i++){
            charArray[i]^=charArray[end];//  charArray[i]=charArray[i]^charArray[end]
            charArray[end]^=charArray[i];//charArray[i]=charArray[end]^charArray[i]
            charArray[i]^=charArray[end];//charArray[i]=charArray[i]^charArray[end]
            end--;
        }
//        for(int i=0;i<charArray.length;i++){
//           for(int j=i+1;j<charArray.length;j++){
//               charArray[i]=(char)(charArray[i]^charArray[j]);
//               charArray[j]=(char)(charArray[i]^charArray[j]);
//               charArray[i]=(char)(charArray[i]^charArray[j]);
//           }
//        }

        output=String.valueOf(charArray);
        return output;
    }
    /*
     * 2.write a program to reverse a Sentence while preserving the position
     * input:Think Twice
     * output:knihT eciwT
     * */
    public String reverseSentencePreservingPosition(String str){
        String output="";
        String splitArray[]=str.split(" ");
        for(int i=0;i< splitArray.length;i++){
            output=output+reverseStringMethod2(splitArray[i])+" ";
            // output=output+reverseStringMethod1(splitArray[i])+" ";
        }
        return output;
    }
    /*3.Write a program to check if a string is anagram or not.
    eg: string 1=care , string 2 =race
    anagram means a word or phrase or name formed by rearranging the letters of another such as care and race
    ex:rescue and secure
    * */
    public boolean anagramChecker(String str1,String str2){
        int result=0;
        boolean isAnagram=false;
        if(str1==null||str2==null){
            isAnagram=false;
            System.out.println("string should not be null...");
        }
        else if(str1.length()!=str2.length()){
            isAnagram=false;
            System.out.println("both the string should be equal length");
        }
        else{
            // first converting both string into lower case and sorting them into alphabetical order
            String toLowerCaseStr1=sortAlphabeticalOrder(convertToLowerCase(str1));
            String toLowerCaseStr2=sortAlphabeticalOrder(convertToLowerCase(str2));
            // xor property X^X=0
            for(int i=0,j=0;i<toLowerCaseStr1.length();i++,j++){
                result=toLowerCaseStr1.charAt(i)^toLowerCaseStr2.charAt(j);
            }
            if(result==0){
                isAnagram=true;
            }
        }
        return  isAnagram;
    }
    /*
    * 4.write a program to check if a string is panagram or not.
    * panagram means a sentence containing every letter of alphabet.
    * ex: a quick brown fox jumps over the lazy dog.
    * */
    public boolean panagramCheckermethod1(String str){
        boolean isPanagram=false;
        int acount=0,bcount=0,ccount=0,dcount=0,ecount=0,fcount=0,gcount=0,hcount=0,icount=0,jcount=0,kcount=0,lcount=0;
        int mcount=0,ncount=0,ocount=0,pcount=0,qcount=0,rcount=0,scount=0,tcount=0,ucount=0,vcount=0,wcount=0,xcount=0;
        int  ycount=0,zcount=0;
        for(int i=0;i<str.length();i++){
            switch (str.charAt(i)){
                case 'a':
                case 'A':
                    acount++;
                    break;
                case 'b':
                case 'B':
                    bcount++;
                    break;
                case 'c':
                case 'C':
                    ccount++;
                    break;
                case 'd':
                case 'D':
                    dcount++;
                    break;
                case 'e':
                case 'E':
                    ecount++;
                    break;
                case 'f':
                case 'F':
                    fcount++;
                    break;
                case 'g':
                case 'G':
                    gcount++;
                    break;
                case 'h':
                case 'H':
                    hcount++;
                    break;
                case 'i':
                case 'I':
                    icount++;
                    break;
                case 'j':
                case 'J':
                    jcount++;
                    break;
                case 'k':
                case 'K':
                    kcount++;
                    break;
                case 'l':
                case 'L':
                    lcount++;
                    break;
                case 'm':
                case 'M':
                    mcount++;
                    break;
                case 'n':
                case 'N':
                    ncount++;
                    break;
                case 'o':
                case 'O':
                    ocount++;
                    break;
                case 'p':
                case 'P':
                    pcount++;
                    break;
                case 'q':
                case 'Q':
                    qcount++;
                    break;
                case 'r':
                case 'R':
                    rcount++;
                    break;
                case 's':
                case 'S':
                    scount++;
                    break;
                case 't':
                case 'T':
                    tcount++;
                    break;
                case 'u':
                case 'U':
                    ucount++;
                    break;
                case 'v':
                case 'V':
                    vcount++;
                    break;
                case 'w':
                case 'W':
                    wcount++;
                    break;
                case 'x':
                case 'X':
                    xcount++;
                    break;
                case 'y':
                case 'Y':
                    ycount++;
                    break;
                case 'z':
                case 'Z':
                    zcount++;
                    break;
                default:
                    break;
            }}
            if(acount>=1 && bcount>=1 && ccount>=1 && dcount>=1 && ecount>=1 && fcount>=1 && gcount>=1 && hcount >=1 && icount>=1 &&
                    jcount>=1 && kcount>=1 &&lcount>=1 && mcount>=1 && ncount>=1 && ocount>=1 && pcount>=1 && qcount>=1 && rcount>=1 &&
                    scount>=1 && tcount >=1 && ucount>=1 && vcount>=1 && wcount>=1 &&xcount>=1 && ycount>=1 && zcount>=1
            ){
                isPanagram=true;
            }
            else{
                isPanagram =false;
            }

return isPanagram;
    }
    public boolean panagramCheckermethod2(String str) {
        boolean isPanagram = false;
        int alphabetCountsArray[] = new int[26];
        String toLowerCaseString = convertToLowerCase(str);
        for (int i = 0; i < toLowerCaseString.length(); i++) {
            // checking special characters space,periods,exclamation mark etc
            if (toLowerCaseString.charAt(i) == ' ' || toLowerCaseString.charAt(i) == '.' || toLowerCaseString.charAt(i) == '!' || toLowerCaseString.charAt(i) == '?' ||
                    toLowerCaseString.charAt(i) == '@' || toLowerCaseString.charAt(i) == '#' || toLowerCaseString.charAt(i) == '$' || toLowerCaseString.charAt(i) == '\n')
            {
                continue;
            }
            else{
                alphabetCountsArray[(toLowerCaseString.charAt(i)-97)]++;
                }
            }
        for(int i=0;i<alphabetCountsArray.length;i++){
            if(alphabetCountsArray[i]<1){
                isPanagram=false;

            }
            else{
                isPanagram=true;
            }




        }
        return isPanagram;
    }
    /*
    * 5.write a program to print repeatedly occuring characters in the given string.*/
    public void printRepeatedlyOccuringCharacters(String str) {
        int alphabetCountsArray[] = new int[26];
        String toLowerCaseString = convertToLowerCase(str);
        for (int i = 0; i < toLowerCaseString.length(); i++) {
            // checking special characters space,periods,exclamation mark etc
            if (toLowerCaseString.charAt(i) == ' ' || toLowerCaseString.charAt(i) == '.' || toLowerCaseString.charAt(i) == '!' || toLowerCaseString.charAt(i) == '?' ||
                    toLowerCaseString.charAt(i) == '@' || toLowerCaseString.charAt(i) == '#' || toLowerCaseString.charAt(i) == '$' || toLowerCaseString.charAt(i) == '\n') {
                continue;
            } else {
                alphabetCountsArray[(toLowerCaseString.charAt(i) - 97)]++;
            }
        }
        for (int i = 0; i < alphabetCountsArray.length; i++) {
            if (alphabetCountsArray[i] > 1) {
                System.out.println((char)(i+97)+"is repeated " + alphabetCountsArray[i]+" times in "+ str);
            }
        }
    }
    public String convertToLowerCase(String str){
        String output="";
        if(str==null|| str==""){
            System.out.println("entered null/empty valued string");

        }
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)>='A' && str.charAt(i)<='Z'){
                output=output + (char)(str.charAt(i)+32);
            }
            else{
                output=output+str.charAt(i);
            }
        }
        return output;
    }
    /*6.write a program to sort the string alphabetically
    * */
    public String sortAlphabeticalOrder(String str){
        String output="";
        char toLowerCaseStringArray[]=convertToLowerCase(str).toCharArray();
        for(int i=0;i<toLowerCaseStringArray.length;i++){
            for(int j=i+1;j<toLowerCaseStringArray.length;j++){
                if(toLowerCaseStringArray[i]>toLowerCaseStringArray[j]){
                    toLowerCaseStringArray[i]^=toLowerCaseStringArray[j];
                    toLowerCaseStringArray[j]^=toLowerCaseStringArray[i];
                    toLowerCaseStringArray[i]^=toLowerCaseStringArray[j];

                }
            }
        }
        output=String.valueOf(toLowerCaseStringArray);
        return output;
    }
    /*7.write a program to count the number of vowels and consonants of a string value
    * */
    public void countNumberofVowelsAndConsonants(String str){
        int vcount=0,ccount=0;
        String toLowerCaseString=convertToLowerCase(str);
        for(int i=0;i<str.length();i++){
            
             if(toLowerCaseString.charAt(i)=='a'||toLowerCaseString.charAt(i)=='e'||toLowerCaseString.charAt(i)=='i'||
                    toLowerCaseString.charAt(i)=='o'||toLowerCaseString.charAt(i)=='u')
                {   vcount++; // vowels are checked
            }
            else if(toLowerCaseString.charAt(i)>'a' || toLowerCaseString.charAt(i)<='z'){
                ccount++; // consonants are checked
            }
            else{
                continue;//here special characters or numbers 
            }
        }
        System.out.println("In the String "+str+"number of vowels are: "+vcount+" number of consonants are: "+ccount);
    }
    /*8.write a program to count the number of special characters
     * */
    public void countSpecialCharactersinString(String str){
        int scount=0;
        String toLowerCaseString=convertToLowerCase(str);
        for(int i=0;i<toLowerCaseString.length();i++) {
            //checking vowels,consonants and numbers
            if (toLowerCaseString.charAt(i) == 'a' || toLowerCaseString.charAt(i) == 'e' || toLowerCaseString.charAt(i) == 'i' ||
                    toLowerCaseString.charAt(i) == 'o' || toLowerCaseString.charAt(i) == 'u' ||
                    toLowerCaseString.charAt(i) > 'a' && toLowerCaseString.charAt(i) <= 'z'||
                    toLowerCaseString.charAt(i)>=0 && toLowerCaseString.charAt(i)<=9
            ) {
                continue;
            }
            else{//count only special characters which are not numbers,not vowels and not consonants
                scount++;
            }
        }
        System.out.println("In the String "+str+"number of special characters are: "+scount);
    }

}
public class StringsAssignment {
    public static void main(String[] args) {
        LaunchStringAssignment launchStr=new LaunchStringAssignment();
        String str="iNeuron";
        String output="";
        output=launchStr.reverseStringMethod2(str);
        System.out.println("reverse of "+str+" is : "+output);
        System.out.println("------------------------------------------------------------------");
        String sentence="Think Twice";
        String output2="";
        output2=launchStr.reverseSentencePreservingPosition(sentence);
        System.out.println("reverse a Sentence Preserving Position of "+ sentence+ " is: "+output2);
        System.out.println("------------------------------------------------------------------");
        String str2="race";
        String str3="care";
        boolean isAnagram=false;
        isAnagram=launchStr.anagramChecker(str2,str3);
        System.out.println("are "+str2+" and "+str3+" anagrams ?"+isAnagram);
        System.out.println("------------------------------------------------------------------");
        String str4="secure";
        String str5="rescue";
        boolean isAnagram2=false;
        isAnagram2=launchStr.anagramChecker(str4,str5);
        System.out.println("are "+str4+" and "+str5+" anagrams ?"+isAnagram2);
        System.out.println("------------------------------------------------------------------");
        String panagram="a quick brown fox jumps over the lazy dog.";
        boolean isPanagram=false;
        isPanagram=launchStr.panagramCheckermethod2(panagram);
        System.out.println(panagram+ "is panagram?"+isPanagram);
        String panagram2="Pack my box with five dozen liquor jugs.";
        boolean isPanagram2=false;
        isPanagram2=launchStr.panagramCheckermethod2(panagram2);
        System.out.println(panagram2+ "is panagram?"+isPanagram2);
        System.out.println("------------------------------------------------------------------");
        launchStr.printRepeatedlyOccuringCharacters(str);
        System.out.println("------------------------------------------------------------------");
        launchStr.printRepeatedlyOccuringCharacters(panagram);
        System.out.println("------------------------------------------------------------------");
launchStr.countNumberofVowelsAndConsonants(str);
        System.out.println("------------------------------------------------------------------");
        String str6="Hello!@#world.";
        launchStr.countSpecialCharactersinString(str6);
        System.out.println("------------------------------------------------------------------");
    }
}
