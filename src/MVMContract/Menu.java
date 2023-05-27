package MVMContract;

public class Menu {

    public static boolean openingMenuAndLogout(){
        System.out.println("Üdv a programban, válassz az alábbi lehetőségek közül: ");
        System.out.println("1 - Bejelentkezés");
        System.out.println("2 - Regisztráció");

        int checked = CheckingMethods.programStartNumCheck();
        boolean isSucceed = true;
        do {
            if (checked == 2) {
                MVMContainer.createProfile();
                //return true;
            }
            if (checked == 1) {
                isSucceed = MVMContainer.logIn();
                //return false;
            }

            if (checked == 2 || !isSucceed) {
                return true;
            } else {
                return false;
            }
        } while (true);
    }

    public static void mainMenuList(int choice){
        Customer c = new Customer();


        switch (choice) {
            case 3 ->  MVMContainer.listProfileData();
            /*case 5  -> Contract.createContract();*/
            case 9 -> Menu.openingMenuAndLogout();
            case 10 -> System.exit(0);

        }

    }




}
