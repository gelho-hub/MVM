package MVMContract;

import java.time.LocalDate;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class DateValidator {
    public static boolean isValidDate(String date) {
        String regex = "\\d{4},\\d{2},\\d{2}"; // Regular expression for YYYY-MM-DD format
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(date);

        return matcher.matches();
    }

    public static boolean checkDate(String gotDate){

        boolean isNotValid = true;
        while (isNotValid){
            //gotDate = IO.sc.nextLine();
            if(DateValidator.isValidDate(gotDate)){
                System.out.println("Nem jó a dátumformátum");
            }else{
                isNotValid = false;
            }

        }
        return isNotValid;

    }

    public static LocalDate splitDateElements(String[] dateElements){
        int year;
        int month;
        int day;
        do{
            year = CheckingMethods.checkIntTypeForVariable(dateElements[0]); // checking the correctness for all the year, month, and day parameters
            month = CheckingMethods.checkIntTypeForVariable(dateElements[1]);
            day = CheckingMethods.checkIntTypeForVariable(dateElements[2]);

        }while((year != 0 && month != 0 && day != 0) && (Integer.toString(year).length() == 4 && Integer.toString(month).length() == 2
                && Integer.toString(day).length() == 2));
        System.out.println("Születési dátum helyes✅");

        return LocalDate.of(year, month, day);
    }
}
