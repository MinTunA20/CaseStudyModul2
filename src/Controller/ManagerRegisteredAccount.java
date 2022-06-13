package Controller;

import IO.WriteAndRead;
import Model.AccountRegister;
import validate.ValidateFormRegister;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerRegisteredAccount implements InterfaceAccount {
    ArrayList<AccountRegister> AccountList = new ArrayList<>();
    ValidateFormRegister validateFormRegister = new ValidateFormRegister();
    WriteAndRead<AccountRegister> writeAndReadAccount = new WriteAndRead<>();
    Scanner sc = new Scanner(System.in);

    Menu menu = new Menu();

    public ManagerRegisteredAccount(){
        AccountList=writeAndReadAccount.read("Account.csv");
        if(AccountList.size()==0){
            AccountList.add(new AccountRegister("tuantuantuan","2081996","gin@gmail.com","102006096447"));
        }
    }
    @Override
    public AccountRegister creatRegisteredAccount(){
        String nameRegisteredAccount=validateFormRegister.validateRegisteredName(AccountList);
        String registeredPassword;
        while (true) {
            System.out.println("Nhập mật khẩu đăng ký  :");
            registeredPassword = sc.nextLine();
            if (validateFormRegister.validateRegisteredNPassword(registeredPassword)) {
                break;
            } else {
            }
        }
        while (true){
            System.out.println("Nhập lại mật khẩu:");
            String registeredPasswordAgain = sc.nextLine();
            if(registeredPasswordAgain.equals(registeredPassword)){
                break;
            }
            else {
                System.out.println("nhập lại mật khẩu!");
            }
        }
        String emailRegisteredAccount= validateFormRegister.validateRegisteredEmail(AccountList);
        String telephoneNumberRegisteredAccount= validateFormRegister.validateRegisteredNumberTelephone(AccountList);
        return new AccountRegister(nameRegisteredAccount,registeredPassword,emailRegisteredAccount,telephoneNumberRegisteredAccount);
    }
    @Override
    public void addAccount(){
        AccountList.add(creatRegisteredAccount());
        writeAndReadAccount.write(AccountList,"Account.csv");
    }
    @Override
    public int checkTelephoneAccountExist(String numberTelephone) {
        for (int i = 0; i < AccountList.size(); i++) {
            if (AccountList.get(i).getRegisteredNumber().equals(numberTelephone)) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public boolean verification(){
        int maxRd= 999999;
        int minRd=100000;
        int countVer =0;
        int times=3;
        int verification = (int) (Math.random()*(maxRd - minRd) + minRd);
        System.out.println("Mã xác  nhận :"+verification);
        while (true){
            if(times==3){
                System.out.println("Bạn có "+times +" lần nhập");
            }
            else {
                System.out.println("Bạn còn "+times+" lần nhập");
            }
            System.out.println("Nhập mã xác nhận :");
            int ver = Integer.parseInt(sc.nextLine());
            if(ver==verification){
                return true;
            }
            else {
                if(countVer<3){
                    System.out.println("Mã xác nhận không hợp lệ ! Vui lòng nhập lại !");
                }
                times--;
                countVer++;
            }
            if(countVer==3){
                System.out.println("Mã xác nhận đã hết hiệu lưc !");
                return false;
            }
        }
    }
    @Override
    public void passwordRetrieval()  {
        int vt;
        while (true){
            System.out.println("Nhập số điện thoại: ");
            String numberTelephone = sc.nextLine();
            if(checkTelephoneAccountExist(numberTelephone)>=0){
                vt =checkTelephoneAccountExist(numberTelephone);
                try {
                    Thread.sleep(100);
                }
                catch (InterruptedException ignored){
                }
                if(verification()){
                    System.out.println("Nhập mật khẩu mới:");
                    String newPassword = sc.nextLine();
                    while (true){
                        System.out.println("Nhập lại mật khẩu mới đi!");
                        String newPasswordAgain = sc.nextLine();
                        if(newPasswordAgain.equals(newPassword)){
                            System.out.println("Cập nhật mật khẩu mới thành công!");
                            break;
                        }
                        else {
                            System.out.println("Sai mật khẩu rồi!");
                        }
                    }
                    AccountList.get(vt).setRegisteredPassword(newPassword);
                    writeAndReadAccount.write(AccountList,"Account.csv");
                }
                break;
            }
            else {
                System.out.println("Số điện thoại không có đâu !");
            }
        }
    }
    @Override
    public boolean checkLogIn(String nameAccountLogIn,String passwordAccountLogIn){
        for(int i=0;i<AccountList.size();i++){
            if(AccountList.get(i).getRegisteredName().trim().equals(nameAccountLogIn.trim())
                    && AccountList.get(i).getRegisteredPassword().trim().equals(passwordAccountLogIn.trim())){
                return true;
            }
        }
        return false;
    }
    @Override
    public void menuRegisterAccount(){
        System.out.println("1.Đăng ký !");
        System.out.println("2.Đăng nhập!");
//        System.out.println("3.Lấy lại mật khẩu!");
        try {
            System.out.println("Nhập lựa chọn:");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    addAccount();
                    System.out.println("Đăng ký thành công!");
                    break;
                case 2:
                    for(AccountRegister f:AccountList){
                        System.out.println(f);
                    }
                    while (true){
                        System.out.println("Nhập tên tài khoản :");
                        String nameAccountLogIn = sc.nextLine();
                        System.out.println("Nhập mật khẩu :");
                        String passwordAccountLogIn = sc.nextLine();
                        if (checkLogIn(nameAccountLogIn,passwordAccountLogIn)){
                            System.out.println("Xin chào "+ nameAccountLogIn);
                            MenuAll.admin();
                            break;
                        }
                        else{
                            System.out.println("vui lòng nhập lại !");
                        }
                    }
                    break;
                case 3:
                    passwordRetrieval();
                    break;
            }
            if(choice<0 || choice>3){
                System.out.println("Vui lòng chọn lại !");
            }
        }
        catch (NumberFormatException e){
            System.out.println("Nhập lại nhé!");
        }
    }
}
