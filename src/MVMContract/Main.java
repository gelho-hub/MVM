package MVMContract;
public class Main {
    public static void main(String[] args) {

        boolean opening = Menu.openingMenuAndLogout();
        while(true){
            while (opening){
                opening = Menu.openingMenuAndLogout(); // just an offer to make an other profile or login

            }

            System.out.println(" 1 - Szerződés adatai");
            System.out.println(" 2 - Számlák listázása");
            System.out.println(" 3 - Saját adatok kilistázása");
            System.out.println(" 4 - Adatmódosítás");
            System.out.println(" 5 - Szerződés létrehozása");
            System.out.println(" 6 - Számla létrehozása");
            System.out.println(" 7 - Befizetés");
            System.out.println(" 8 - Hátralévő befizetések");
            System.out.println(" 9 - Kijelentkezés");
            System.out.println("10 - Kilépés");
            int choiceNum = IO.sc.nextInt();
            Menu.mainMenuList(choiceNum);

        }
    }
}