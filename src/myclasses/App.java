
package myclasses;

import entity.History;
import entity.Model;
import entity.Shop;
import entity.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import tools.SaverToFiles;


    public class App {
        private Scanner scanner=new Scanner(System.in);
        private List<Model> models=new ArrayList<>();
        private List<User> users=new ArrayList<>();
        private List<History> histories=new ArrayList<>();
        private List<Shop> shops=new ArrayList<>();
        private SaverToFiles saverToFiles = new SaverToFiles();

        public App(){
            models = saverToFiles.loadModels();
            users= saverToFiles.loadUsers();
            histories=saverToFiles.loadHistories();
            shops=saverToFiles.loadShops();
        }
        public void run(){
        String repeat="yes";
            do{
                System.out.println("Выберите номер задачи: ");
                System.out.println("0: Закрыть программу");
                System.out.println("1: Добавить модель");
                System.out.println("2: Список продаваемых моделей");
                System.out.println("3: Добавить пользователя");
                System.out.println("4: Список зарегистрированных пользователей");
                System.out.println("5: Покупка обуви пользователем");
                System.out.println("6: Доход магазина за все время работы");
                System.out.println("7: Добавить денег пользователю");
                int task=getNumber();
                switch (task) {
                    case 0:
                        repeat="no";
                        break;
                    case 1:
                        addModel();
                        break;
                    case 2:
                        listModel();
                        break;
                    case 3:
                        addUser();
                        break;
                    case 4:
                        regListUser();
                        break;
                    case 5:
                        purchaseShoe();
                        break;
                    case 6:
                        incomeShop();
                        break;
                    case 7:
                        addMoneyUser();
                        break;
                    default:
                        System.out.println("Попробуй еще раз!");
                }
            }while("yes".equals(repeat));
            System.out.println("Пока!");
        }
    private void addModel(){
        Model model=new Model();
        System.out.print("Введите брэнд модели обуви: ");
        model.setBrand(scanner.nextLine());
        System.out.print("Введите название обуви: ");
        model.setName(scanner.nextLine());
        System.out.print("Введите размер обуви: ");
        model.setSize(scanner.nextInt());scanner.nextLine();
        System.out.print("Введите цену обуви: ");
        model.setPrice(scanner.nextInt());scanner.nextLine();
        System.out.print("Введите количество экземпляров: ");
        model.setQuantity(scanner.nextInt());scanner.nextLine();
        models.add(model);
        saverToFiles.saveModels(models);
    }
    private Set<Integer> listModel(){
        Set<Integer> setNumbersModels=new HashSet<>();
        System.out.println("----- Список обуви -----");
        int n=0;
        for (int i = 0;i < models.size(); i++) {
            if (models.get(i)!=null
                    && models.get(i).getQuantity()>0) {
                System.out.printf("%d Брэнд: %s, Название: %s, Размер: %d, Цена: %d, В наличии: %d.%n"
                ,i+1
                ,models.get(i).getBrand()
                ,models.get(i).getName()
                ,models.get(i).getSize()
                ,models.get(i).getPrice()
                ,models.get(i).getQuantity()
                );
                setNumbersModels.add(i+1);
            }
            n++;
        }
    if (n<1) {
        System.out.println("Нет обуви в наличии.");
        return setNumbersModels;
    }
        return setNumbersModels;
    }
    private void addUser(){
        User user=new User();
        System.out.print("Введите имя пользователя: ");
        user.setName(scanner.nextLine());
        System.out.print("Введите фамилию пользователя: "); 
        user.setSurname(scanner.nextLine());
        System.out.print("Введите номер телефона пользователя: "); 
        user.setTel(scanner.nextLine());
        System.out.print("Введите количество денег пользователя: "); 
        user.setAmountMoney(scanner.nextInt());scanner.nextLine();
        users.add(user);
        saverToFiles.saveUsers(users);
    }
     private Set<Integer> regListUser(){
        System.out.println("----- Список пользователей -----");
        Set<Integer> setNumbersUsers = new HashSet<>();
        int n=0;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i)!=null) {
                System.out.printf("%d Имя: %s, Фамилия: %s, Номер телефона: %s, Кол-во денег: %d.%n"
                ,i+1
                ,users.get(i).getName()
                ,users.get(i).getSurname()
                ,users.get(i).getTel()
                ,users.get(i).getAmountMoney()
                );
                setNumbersUsers.add(i+1);
            }
            n++;
        }
        if (n<1) {
        System.out.println("Нет зарегистрированных пользователей");
        return setNumbersUsers;
    }
        return setNumbersUsers;
    }
    private void purchaseShoe(){
        Shop shop=new Shop();
        System.out.println("----- Покупка обуви -----");
        Set<Integer> setNumbersModels = listModel();
        if(setNumbersModels.isEmpty()){
            System.out.println("Нет моделей в наличии");
            return;
    }
        System.out.print("Выберите номер обуви: ");
        int numberModel= insertNumber(setNumbersModels);
        Set<Integer> setNumbersUsers= regListUser();
        System.out.print("Выберите номер пользователя: ");
        int numberUser= insertNumber(setNumbersUsers);
            if (users.get(numberUser-1).getAmountMoney()>=models.get(numberModel-1).getPrice()) {
            shop.setCountPurchases(shops.get(0).getCountPurchases()+1);
            History history=new History();
            history.setModel(models.get(numberModel-1));
            history.setUser(users.get(numberUser-1));
            Calendar c=new GregorianCalendar();
            history.setPurchaseModel(c.getTime());
            histories.add(history);
            saverToFiles.saveHistories(histories);
            System.out.printf("Покупка совершена!%n"
                +"Покупатель: %s %s tel: %s.%n"
                +"Покупка: %s %s %d размера, по цене %d евро.%n"
                +"Дата покупки: %s.%n"
                ,histories.get(numberUser-1).getUser().getName()
                ,histories.get(numberUser-1).getUser().getSurname()
                ,histories.get(numberUser-1).getUser().getTel()
                ,histories.get(numberModel-1).getModel().getBrand()
                ,histories.get(numberModel-1).getModel().getName()
                ,histories.get(numberModel-1).getModel().getSize()
                ,histories.get(numberModel-1).getModel().getPrice()
                ,histories.get(numberModel-1).getPurchaseModel()
                );
            users.get(numberUser-1).setAmountMoney(users.get(numberUser-1).getAmountMoney()-models.get(numberModel-1).getPrice());
            saverToFiles.saveUsers(users);
            shops.get(0).setIncome(models.get(numberModel-1).getPrice()+shops.get(0).getIncome());
            shops.add(shop);
            saverToFiles.saveShops(shops);
            }else{
                System.out.println("У пользователя не хватает средств для покупки данных пар обуви!");    
                    }
        
            
        }
        
    
    public void incomeShop(){
        System.out.println("----- Доход компании за все время -----");
        System.out.printf("%d EUR.%n"
        ,shops.get(0).getIncome()
        );
    }
    public void addMoneyUser(){
        Set<Integer> setNumbersUsers= regListUser();
        System.out.print("Выберите номер пользователя: ");
        int numberUser= insertNumber(setNumbersUsers);
        System.out.print("Введите кол-во евро, которые будут перведены пользователю: ");
        int numberMoney=scanner.nextInt();scanner.nextLine();
        users.get(numberUser-1).setAmountMoney(users.get(numberUser-1).getAmountMoney()+numberMoney);
        saverToFiles.saveUsers(users);
    }
    private int getNumber() {
        int number;
        do{
           String strNumber = scanner.nextLine();
           try {
               number = Integer.parseInt(strNumber);
               return number;
           } catch (NumberFormatException e) {
               System.out.println("Введено \""+strNumber+"\". Выбирайте номер ");
           }
       }while(true);
    }

    private int insertNumber(Set<Integer> setNumbers) {
        int number=0;
        do{
           number = getNumber();
           if(setNumbers.contains(number)){
               break;
           }
           System.out.println("Попробуй еще раз: ");
       }while(true);
       return number; 
    }
    }
       
    
