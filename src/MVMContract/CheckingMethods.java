package MVMContract;

import java.util.InputMismatchException;

public class CheckingMethods {

    public static int checkIntTypeForInput(){ // method for check whether is it a valid int

        //sc = new Scanner(System.in);
        try{
            return IO.sc.nextInt();
        }catch(InputMismatchException e){
            return 0;
        }finally {
            IO.sc.nextLine();
        }
    }
    public static int checkIntTypeForVariable(String num){ // method for check whether is it a valid int PARAMETERIZED

        int value;

        try{
            value = Integer.parseInt(num);
        }catch (NumberFormatException nfe){
            System.out.println("Nem számot adtál meg. Kérlek próbáld újra!");
            return 0; // ha nullát ad vissza, nem sikerült a parsolás, meghívásnál while-ban pörgetni!!!
        }finally{
            value = Integer.parseInt(num);
        }
        return value;
    }

    public static int programStartNumCheck(){
        int firstChoice;
        do{
            firstChoice = checkIntTypeForInput();
            if(firstChoice != 0){
                break;
            }
            System.out.println("Kérlek próbáld újra, nem számot adtál meg!");
        }while(firstChoice == 0);

        int inputNum = 0;
        try{
            /*int switchNumber;
            switchNumber = sc.nextInt();*/
            inputNum = firstChoice;
            while(true){
                if(inputNum == 0){
                    System.out.println("Nem számot adtál meg. Kérlek próbáld újra az alábbiak közül!");
                    System.out.println(" ");
                    System.out.println("1 - Bejelentkezés");
                    System.out.println("2 - Regisztráció");
                    inputNum = CheckingMethods.checkIntTypeForInput(); // ha ezt kicommentelném, pörögne végtelenül
                }
                else if(inputNum < 1 || inputNum > 2){
                    System.out.println("A megadott szám nem 1 vagy 2, próbáld újra!");
                    inputNum = CheckingMethods.checkIntTypeForInput();
                }else{
                    break;
                }
            }

        }catch(Exception e){
            System.out.println("Nem számot adtál meg!");
        }
        return inputNum;
    }
}
