
package myclasses;

import entity.History;
import entity.Model;
import entity.Shop;
import entity.User;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import tools.SaverToBase;
import tools.SaverToFiles;


    public class App {
        private Scanner scanner=new Scanner(System.in);
        private List<Model> models=new ArrayList<>();
        private List<User> users=new ArrayList<>();
        private List<History> histories=new ArrayList<>();
        private List<Shop> shops=new ArrayList<>();
        //private SaverToFiles saverToFiles = new SaverToFiles();
        private SaverToBase saverToFiles = new SaverToBase();

        public App(){
           // models = saverToFiles.loadModels();
           // users= saverToFiles.loadUsers();
           // histories=saverToFiles.loadHistories();
           // shops=saverToFiles.loadShops();
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
                System.out.println("8: Редактировать товар");
                System.out.println("9: Редактировать пользователя");
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
                    case 8:
                        changeModel();
                        break;
                    case 9:
                        changeUser();
                        break;
                    case 10:
                        initiateIncome();
                        break;
                    default:
                        System.out.println("Попробуй еще раз!");
                }
            }while("yes".equals(repeat));
            System.out.println("Пока!");
        }
    private void initiateIncome(){
        Shop shop=new Shop();
        shop.setIncome(0);
        shops.add(shop);
        saverToFiles.saveShops(shops);
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
        model.setPrice(getNumber());
        System.out.print("Введите количество экземпляров: ");
        model.setQuantity(getNumber());

        models.add(model);
        saverToFiles.saveModels(models);
    }
    private void listModel(){
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
            }
            n++;
        }
    if (n<1) {
        System.out.println("Нет обуви в наличии.");
        return;
    }
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
        user.setAmountMoney(getNumber());
        users.add(user);
        saverToFiles.saveUsers(users);
    }
     private void regListUser(){
        System.out.println("----- Список пользователей -----");
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
            }
            n++;
        }
        if (n<1) {
            System.out.println("Нет зарегистрированных пользователей");
            return;
        }
    }
    private void purchaseShoe(){
        System.out.println("----- Покупка обуви -----");
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
            }
            n++;
        }
    if (n<1) {
        System.out.println("Нет обуви в наличии.");
        return;
    }
        System.out.print("Выберите номер обуви: ");
        int numberModel= getNumber();
        System.out.println("----- Список пользователей -----");
        int m=0;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i)!=null) {
                System.out.printf("%d Имя: %s, Фамилия: %s, Номер телефона: %s, Кол-во денег: %d.%n"
                ,i+1
                ,users.get(i).getName()
                ,users.get(i).getSurname()
                ,users.get(i).getTel()
                ,users.get(i).getAmountMoney()
                );
            }
            m++;
        }
        if (m<1) {
        System.out.println("Нет зарегистрированных пользователей");
        return;
        }
        System.out.print("Выберите номер пользователя: ");
        int numberUser= getNumber();
            if (users.get(numberUser-1).getAmountMoney()>=models.get(numberModel-1).getPrice()) {
            History history=new History();
            history.setModel(models.get(numberModel-1));
            history.setUser(users.get(numberUser-1));
            Calendar c=new GregorianCalendar();
            history.setPurchaseModel(c.getTime());
            history.getModel().setQuantity(history.getModel().getQuantity()- 1);
            histories.add(history);
            saverToFiles.saveHistories(histories);
            saverToFiles.saveModels(models);
            System.out.printf("Покупка совершена!%n"
                +"Покупатель: %s %s tel: %s.%n"
                +"Покупка: %s %s %d размера, по цене %d евро.%n"
                +"Дата покупки: %s.%n"
                ,histories.get(numberUser).getUser().getName()
                ,histories.get(numberUser).getUser().getSurname()
                ,histories.get(numberUser).getUser().getTel()
                ,histories.get(numberModel).getModel().getBrand()
                ,histories.get(numberModel).getModel().getName()
                ,histories.get(numberModel).getModel().getSize()
                ,histories.get(numberModel).getModel().getPrice()
                ,histories.get(numberModel).getPurchaseModel()
                );
            users.get(numberUser-1).setAmountMoney(users.get(numberUser-1).getAmountMoney()-models.get(numberModel-1).getPrice());
            saverToFiles.saveUsers(users);
            shops.get(0).setIncome(models.get(numberModel-1).getPrice()+shops.get(0).getIncome());
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
        System.out.println("----- Список пользователей -----");
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
            }
            n++;
        }
        if (n<1) {
        System.out.println("Нет зарегистрированных пользователей");
        return;
        }
        System.out.print("Выберите номер пользователя: ");
        int numberUser=getNumber();
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
               System.out.println("Введено \""+strNumber+"\". Выбирайте номер! ");
           }
       }while(true);
    }
    private void changeModel(){
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
            }
            n++;
        }
    if (n<1) {
        System.out.println("Нет обуви в наличии.");
        return;
    }
        System.out.print("Выберите номер обуви: ");
        int numberModel= getNumber();
        String repeat="yes";
        do{
            System.out.println("0. Выход");
            System.out.println("1. Изменить брэнд обуви");
            System.out.println("2. Изменить название модели");
            System.out.println("3. Изменить размер модели");
            System.out.println("4. Изменить цену модели");
            System.out.println("5. Изменить количество экземпляров");
            System.out.println("Выберите номер параметра, который хотите изменить: ");
            int num=getNumber();
            switch(num){
                case 0:
                    repeat="no";
                    break;
                case 1:
                    System.out.print("Введите новый брэнд обуви: ");
                    String newBrand=scanner.nextLine();
                    models.get(numberModel-1).setBrand(newBrand);
                    saverToFiles.saveModels(models);
                    break;
                case 2:
                    System.out.print("Введите новое название модели: ");
                    String newName=scanner.nextLine();
                    models.get(numberModel-1).setName(newName);
                    saverToFiles.saveModels(models);
                    break;
                case 3:
                    System.out.print("Введите новый размер модели: ");
                    int newSize=getNumber();
                    models.get(numberModel-1).setSize(newSize);
                    saverToFiles.saveModels(models);
                    break;
                case 4:
                    System.out.print("Введите новую цену модели: ");
                    int newPrice=getNumber();
                    models.get(numberModel-1).setPrice(newPrice);
                    saverToFiles.saveModels(models);
                    break;
                case 5:
                    System.out.print("Введите новое количество экземпляров: ");
                    int newQuantity=getNumber();
                    models.get(numberModel-1).setQuantity(newQuantity);
                    saverToFiles.saveModels(models);
                    break;
            }
         }while("yes".equals(repeat));
    }
    private void changeUser(){
         System.out.println("----- Список пользователей -----");
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
            }
            n++;
        }
        if (n<1) {
            System.out.println("Нет зарегистрированных пользователей");
            return;
        }
        System.out.print("Выберите номер пользователя: ");
        int numberUser= getNumber();
        String repeat="yes";
        do{
            System.out.println("0. Выход");
            System.out.println("1. Изменить имя пользователя");
            System.out.println("2. Изменить фамилию пользователя");
            System.out.println("3. Изменить номер пользователя");
            System.out.println("Выберите номер параметра, который хотите изменить: ");
            int num=getNumber();
            switch(num){
                case 0:
                    repeat="no";
                    break;
                case 1:
                    System.out.print("Введите новое имя пользователя: ");
                    String newName=scanner.nextLine();
                    users.get(numberUser-1).setName(newName);
                    saverToFiles.saveUsers(users);
                    break;
                case 2:
                    System.out.print("Введите новую фамилию пользователя: ");
                    String newSurname=scanner.nextLine();
                    users.get(numberUser-1).setSurname(newSurname);
                    saverToFiles.saveUsers(users);
                    break;
                case 3:
                    System.out.print("Введите новый номер пользователя: ");
                    String newTel=scanner.nextLine();
                    users.get(numberUser-1).setTel(newTel);
                    saverToFiles.saveUsers(users);
                    break;
            }
         }while("yes".equals(repeat));
    }
    }
    
    
