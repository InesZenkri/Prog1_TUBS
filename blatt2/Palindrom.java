class Palindrom {
    static boolean ispalindrom(String s){
        int i = 0;
        while (i < s.length()/2 && s.charAt(i) == s.charAt(s.length()-1-i)){
            i++;
        }
        return s.charAt(i) == s.charAt(s.length()-1-i);
    }
    public static void main (String [] args){
        String s = "anasana";
        if (ispalindrom(s)){
            System.out.println(s + " ist ein Palindrom");
        }
        else{
            System.out.println(s + " ist kein Palindrom");
        }
    }
}