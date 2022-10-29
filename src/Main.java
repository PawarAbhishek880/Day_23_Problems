import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface Operations {
    public String convertFirstCharacter(String name);
}

interface CheckEmail{
    public String isValid(String email);
}

interface passValidate{
    public void isValid(String password);
}

interface contactValid{
    public void isValid(String cont);
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter you first name :- ");
        String first = sc.nextLine();

        System.out.println("Enter you last name :- ");
        String last = sc.nextLine();

        Operations op1 = (name) -> {
            String firstLetStr = name.substring(0, 1);
            // Get remaining letter using substring
            String remLetStr = name.substring(1);

            // convert the first letter of String to uppercase
            firstLetStr = firstLetStr.toUpperCase();

            // concantenate the first letter and remaining string
            String firstLetterCapitalizedName = firstLetStr + remLetStr;

            return firstLetterCapitalizedName;
        };



        System.out.println("------------------------------------------------");

        System.out.println(op1.convertFirstCharacter(first));
        System.out.println(op1.convertFirstCharacter(last));

        System.out.println("------------------------------------------------");


        System.out.println("Enter you email :- ");
        String email1 = sc.nextLine();

        CheckEmail chk1 = (email) -> {
            Pattern pattern = Pattern.compile("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
            Matcher matcher = pattern.matcher(email);

            String val = matcher.matches() ? "valid" : "invalid";

            return val;
        };

        System.out.println(chk1.isValid(email1));

        System.out.println("------------------------------------------------");

        passValidate pass1 = (password) -> {
            Pattern pattern = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})");
            Matcher matcher = pattern.matcher(password);
            if(matcher.matches()){
                System.out.println("Password "+ password +" is valid");
            }else{
                System.out.println("Password "+ password +" is invalid");
            }
        };

        pass1.isValid("Prabhu@99");

        System.out.println("------------------------------------------------");

        contactValid contact = (cont) -> {
            Pattern pattern = Pattern.compile("^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$");
            Matcher matcher = pattern.matcher(cont);
            if(matcher.matches()){
                System.out.println("Contact "+ cont +" is valid");
            }else{
                System.out.println("Contact "+ cont +" is invalid");
            }
        };

        contact.isValid("+91 8766553648");
    }
}
