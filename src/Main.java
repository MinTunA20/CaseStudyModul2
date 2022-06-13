import Controller.ManagerRegisteredAccount;


public class Main {
    public static void main(String[] args) {
        System.out.println("********MENU********");
        ManagerRegisteredAccount managerRegisteredAccount = new ManagerRegisteredAccount();
        while(true){
            managerRegisteredAccount.menuRegisterAccount();
        }
    }
}