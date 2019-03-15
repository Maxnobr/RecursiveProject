public class Main {

    public static void main(String[] args) {

        for(int k = 1;k < 10;k++)
            System.out.println("K:"+k+" = "+kRecur(k));

        System.out.println("'Yo! Banana Boy.' is "+
                (isPalindrome("Yo! Banana Boy.")?"":"not ")
                + "a Palindrome!");
        System.out.println("'No cab, eh, Ted? I sat up. I put aside the bacon' is "+
                (isPalindrome("No cab, eh, Ted? I sat up. I put aside the bacon")?"":"not ")
                + "a Palindrome!");
        System.out.println("'Tulsa night life: filth, gin, a slut.' is "+
                (isPalindrome("Tulsa night life: filth, gin, a slut.")?"":"not ")
                + "a Palindrome!");
        System.out.println("'Definitely not a Palindrome yletinifed' is "+
                (isPalindrome("Definitely not a Palindrome yletinifed")?"":"not ")
                + "a Palindrome!");

        double log = 10;
        System.out.println("log of "+log+"  = "+log_of(log,1));
        System.out.println("actual log = "+Math.log10(log));

        //can't figure out the log stuff!
        for(int x = 0;x < 4;x++)
            for(int y = 0;y < 4;y++)
                System.out.println("sqr("+Math.pow(10,x)+"+"+Math.pow(10,y)+") = " +
                        Math.sqrt(Math.pow(10,x)+Math.pow(10,y)));
    }

    //Write a recursive method that takes an int argument k and returns,
    // as a double, the sum of the first k terms of the series:
    //1 + (1/2) - (1/3) + (1/4) - (1/5) ...
    private static double kRecur(int k){
        if(k == 1) return 1;
        return kRecur(k - 1) + 1.0 / k * (k % 2 == 0 ? 1 : -1);
    }

    //Write a recursive method that takes a String as its argument
    // and returns a boolean indicating whether the String
    // (ignoring white space and punctuation) is a palindrome
    // (is the same forward and backward).
    //For example, "Yo! Banana Boy."
    // , "No cab, eh, Ted? I sat up. I put aside the bacon",
    // and "Tulsa night life: filth, gin, a slut."
    private static boolean isPalindrome(String str){
        String pali = str.replaceAll("[^a-zA-Z]","").toLowerCase();
        System.out.println("pali: '"+str+"' match : "
                +(pali.charAt(0) == pali.charAt(pali.length()-1)));
        if(pali.length() <= 1)
            return true;
        return pali.charAt(0) == pali.charAt(pali.length()-1)
                && isPalindrome(pali.substring(1,pali.length()-1));
    }

    //Napier showed that the logarithm can be computed for the
    //geometric mean of two numbers whose logarithm is known.
    //Here is how it is done.
    //Assume we have two numbers X and Y whose logarithms logX and logY are known.
    //Let K = square_root(X*Y). Then logK = (logX + logY) / 2.
    //
    //For example, 10 and 100 have logs of 1 and 2 respectively.
    //Therefore K = square_root(10 * 100) = 31.623, and logK = 1.5.
    //K*K/y = x
    //
    //log_of() takes a double, X, between 1.0 and 1000 and returns its logarithm
    //as a double (you can stop when you find logY with |Y-X| < .001).
    static double log_of(double x,double end) {
        return (x > end)?(1+log_of(x/10,end))/2:0;
        //return (Math.abs(10 - x*x/10) > end)?(1+log_of(x*x/10,end))/2:0;
        //return (x > 1) ? 1 + log_of(x / 10,end) : 0;
    }

    static double log_of(double x) {
        return (x > 0.001) ? 1 + log_of(x / 10) : 0;
    }

    //logs() prints out numbers and their logarithms in a given range
    //until the difference of the logs is less than a given value.
    static void logs(int start,int end,double lessVal){
        for(int i = start;i < end;i++)
            System.out.println("log of "+i+" = "+log_of(i,lessVal));
    }
}
