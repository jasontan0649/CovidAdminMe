public class Main{
    public static void main(String[] args){
        Initializer.Initialize(); //Preload The file.

        while(true) {
            System.out.println("Welcome to COVID-19 Tracking System (Admin)");
            System.out.println("Please choose to SignIn or SignUp");
            System.out.println("1. Sign In");
            System.out.println("2. Sign Up");
            System.out.println("3. Exit Program");

            int choice = InputValid.checkRange(1,3);
            Admin adm = null;
            switch (choice){
                case 1: adm =  Menu.signIn(); break;
                case 2: adm = Menu.signUp(); break;
                case 3: return;
            }

            Menu.AdminInterface();
        }
    }
}

