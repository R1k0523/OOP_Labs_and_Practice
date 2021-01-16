package rtu.klokov.labs.lab16;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private Customer customer;
    private final InternetOrdersManager internetManager = new InternetOrdersManager();
    private final TableOrdersManager tableManager = new TableOrdersManager();



    private void addOrderInternet() {
        if (customer == null) {
            System.out.println("Сначала создайте пользователя");
            return;
        }
        InternetOrder order = new InternetOrder();
        order.setCustomer(customer);
        fillOrder(order);
        if (order.itemsQuantity() == 0)
            return;
        try {
            internetManager.add(order);
        } catch (OrderAlreadyAddedException e) {
            System.out.println("По этому адресу уже есть заказ!");
            return;
        }
        System.out.println("Заказ принят");
    }

    private void addOrderTable() {
        if (tableManager.freeTableNumber() == -1) {
            System.out.println("Нет свободных столиков");
            return;
        }
        System.out.println("Введите свой возраст");
        int age = getInt(200, false);
        TableOrder order = new TableOrder();
        order.setCustomer((age < 18) ? Customer.NOT_MATURE_UNKNOWN_CUSTOMER : Customer.MATURE_UNKNOWN_CUSTOMER);
        fillOrder(order);
        if (order.itemsQuantity() == 0)
            return;
        System.out.println("За каким столиком вы будете?");
        int[] availableTables = tableManager.freeTableNumbers();
        int j = 0;
        for (int table : availableTables) {
            j++;
            System.out.println("" + j + ") " + table);
        }
        j = getInt(availableTables.length + 1, false);
        try {
            tableManager.add(order, availableTables[j - 1]);
        } catch (OrderAlreadyAddedException e) {
            System.out.println("Столик уже не доступен");
            return;
        }
        System.out.println("Заказ будет приготовлен");
    }

    private void fillOrder(Order order) {
        while (true) {
            System.out.println("Что вы предпочитаете?");
            int j = 0;
            for (DrinkTypeEnum drinkType : DrinkTypeEnum.values()) {
                j++;
                if (order.getCustomer().getAge() >= 18 || !drinkType.getValue().isAlcoholicDrink())
                    System.out.println("" + j + ") " + drinkType.getValue().getName() + " - " + drinkType.getValue().getCost() + " - " + drinkType.getValue().getDescription());
            }
            if (order.itemsQuantity() == 0)
                System.out.println("0) Отмена");
            else
                System.out.println("0) Готово");

            j = getInt(DrinkTypeEnum.values().length + 1, true);
            if (j == 0)
                break;
            Drink drink = DrinkTypeEnum.values()[j - 1].getValue();
            if (drink.isAlcoholicDrink() && order.getCustomer().getAge() < 18)
                System.out.println("Алкоголь только для совершеннолетних!");
            else {
                order.add(drink);
                System.out.println(drink.getName() + " добавлен");
            }
        }
    }

    private void editOrderInternet() {
        Order[] orders = internetManager.getOrders();
        int j = selectOrderInternet(orders);
        if (j == 0)
            return;
        Order order = orders[j - 1];
        while (true) {
            System.out.println("Информация:" +
                    "\nCustomer: " + order.getCustomer().toString() +
                    "\n" + order.itemsQuantity() + " напитков добавлено" +
                    "\nСтоимость" + order.costTotal() +
                    "\nНапитки:");
            for (MenuItem item : order.sortedItemsByCostDesc())
                System.out.println(item.getName() + ' ' + item.getCost() + ' ' + item.getDescription() + '\n');
            System.out.println("1) Добавить еще\n"
                    + "2) Убрать напитки\n"
                    + "3) Отменить заказ\n"
                    + "0) Назад\n"
            );
            j = getInt(4, true);
            switch (j) {
                case 1:
                    fillOrder(order);
                    break;
                case 2:
                    String[] names = order.itemsNames();
                    System.out.println("Что удалить?");
                    for (int i = 1; i <= names.length; i++)
                        System.out.println("" + i + ") " + names[i - 1]);
                    System.out.println("0) Назад");
                    j = getInt(names.length + 1, true);
                    if (j == 0)
                        break;
                    int k = order.removeAll(names[j - 1]);
                    System.out.println(names[j - 1] + " удалено. Количество: " + k);
                    break;
                case 3:
                    internetManager.remove(order.getCustomer().getAddress());
                    System.out.println("Заказ удален");
                    return;
                case 0:
                    return;
            }
        }
    }

    private void editOrderTable() {
        TableOrder[] orders = tableManager.getOrders();
        int j = selectOrderTable(orders);
        if (j == 0)
            return;
        TableOrder order = orders[j - 1];
        while (true) {
            System.out.println("Информация: о заказе " + j + ":\nНомер столика: " +
                    "\n" + order.itemsQuantity() + " напитков добавлено" +
                    "\nСтоимость" + order.costTotal() +
                    "\nНапитки:");
            for (MenuItem item : order.sortedItemsByCostDesc())
                System.out.println(item.getName() + ' ' + item.getCost() + ' ' + item.getDescription() + '\n');
            System.out.println("1) Добавить еще\n"
                    + "2) Убрать напитки\n"
                    + "3) Отменить заказ\n"
                    + "0) Назад\n"
            );
            j = getInt(4, true);
            switch (j) {
                case 0:
                    return;
                case 1:
                    fillOrder(order);
                    break;
                case 2:
                    String[] names = order.itemsNames();
                    System.out.println("Что удалить?");
                    for (int i = 1; i <= names.length; i++)
                        System.out.println("" + i + ") " + names[i - 1]);
                    System.out.println("0) Назад");
                    j = getInt(names.length + 1, true);
                    if (j == 0)
                        break;
                    int k = order.removeAll(names[j - 1]);
                    System.out.println(names[j - 1] + " удалено. Количество: " + k);
                    break;
                case 3:
                    tableManager.remove(order.getTable());
                    System.out.println("Заказ удален");
                    return;
            }
        }
    }

    private void ordersInfoInternet() {
        Order[] orders = internetManager.getOrders();
        while (true) {
            int j = selectOrderInternet(orders);
            if (j == 0)
                return;
            Order order = orders[j - 1];
            System.out.println("Информация:" +
                    "\nCustomer: " + order.getCustomer().toString() +
                    "\n" + order.itemsQuantity() + " напитков добавлено" +
                    "\nСтоимость" + order.costTotal() +
                    "\nНапитки:");
            for (MenuItem item : order.sortedItemsByCostDesc())
                System.out.println(item.getName() + ' ' + item.getCost() + ' ' + item.getDescription() + '\n');
        }
    }

    private void ordersInfoTable() {
        TableOrder[] orders = tableManager.getOrders();
        while (true) {
            int j = selectOrderTable(orders);
            if (j == 0)
                return;
            TableOrder order = orders[j - 1];
            System.out.println("Информация: о заказе " + j +
                    ":\nНомер столика: " +
                    "\n" + order.itemsQuantity() + " напитков добавлено" +
                    "\nСтоимость" + order.costTotal() +
                    "\nНапитки:");
            for (MenuItem item : order.sortedItemsByCostDesc())
                if (item != null)
                    System.out.println(item.getName() + ' ' + item.getCost() + ' ' + item.getDescription() + '\n');
        }
    }

    private void getOrderInternet() {
        Order[] orders = internetManager.getOrders();
        System.out.println("Заказы");

        for (int i = 1; i <= orders.length; i++)
            System.out.println("" + i + ") Заказ для " + orders[i - 1].getCustomer() +
                    "\nСтоимость: " + orders[i - 1].costTotal() + " рублей");
        System.out.println("0) Назад");
        int j = getInt(orders.length + 1, true);
        if (j == 0)
            return;
        Order order = internetManager.remove(orders[j - 1].getCustomer().getAddress());
        if (order == null) {
            System.out.println("Ошибка. Заказ отсутствует");
            return;
        }
        System.out.println("Заказ стоимостью " + order.costTotal() + " рублей доставлен." +
                "\nСостав: ");
        for (MenuItem item : order.getItems())
            System.out.println(item.getName() + ' ' + item.getCost() + ' ' + item.getDescription() + '\n');
    }

    private void getOrderTable() {
        TableOrder[] orders = tableManager.getOrders();
        System.out.println("Заказы");
        for (int i = 1; i <= orders.length; i++)
            System.out.println("" + i + ") Заказ для столика" + orders[i - 1].getTable() +
                    "\nСтоимость: " + orders[i - 1].costTotal() + " рублей");
        System.out.println("0) Назад");
        int j = getInt(orders.length + 1, true);
        if (j == 0)
            return;
        TableOrder order = orders[j - 1];
        tableManager.remove(order.getTable());
        System.out.println("Заказ стоимостью " + order.costTotal() + " рублей доставлен." +
                "\nСостав: ");
        for (MenuItem item : order.getItems())
            System.out.println(item.getName() + ' ' + item.getCost() + ' ' + item.getDescription() + '\n');
    }

    private void addCustomer() {
        System.out.println("Имя");
        String name = getLine(false);

        System.out.println("Фамилия");
        String surName = getLine(false);

        System.out.println("Возраст");
        int age = getInt(200, false);

        System.out.println("Город");
        String city = getLine(false);

        System.out.println("Индекс");
        int zipCode = getInt(1000000, false);

        System.out.println("Улица");
        String street = getLine(false);

        System.out.println("Корпус");
        char buildingLetter = getLine(true).charAt(0);

        System.out.println("Квартира");
        int apartment = getInt(10000, true);

        customer = new Customer(name, surName, age, new Address(city, zipCode, street, buildingLetter, apartment));
    }

    private int selectOrderInternet(Order[] orders) {
        System.out.println(orders.length + " заказов ожидают доставки" +
                "\nПолная стоимость " + internetManager.ordersCostSummary());
        for (int i = 1; i <= orders.length; i++)
            System.out.println("" + i + ") Заказ №" + i +
                    "\nЗаказчик " + orders[i - 1].getCustomer());
        System.out.println("0) Назад");
        return getInt(orders.length + 1, true);
    }

    private int selectOrderTable(TableOrder[] orders) {
        System.out.println(orders.length + " заказов ожидают доставки" +
                "\nПолная стоимость " + tableManager.ordersCostSummary());
        for (int i = 1; i <= orders.length; i++)
            System.out.println("" + i + ") Заказ №" + i +
                    "\nЗаказчик " + orders[i - 1].getTable());
        System.out.println("0) Назад");
        return getInt(orders.length + 1, true);
    }

    private int getInt(int to, boolean canBeZero) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                int res = scanner.nextInt();
                if ((res > 0 && res < to) || (canBeZero && res == 0))
                    return res;
            } catch (InputMismatchException e) {
                scanner.nextLine();
            } catch (Exception e) {
                System.exit(0);
            }
        }
    }

    private String getLine(boolean empty) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                String res = scanner.nextLine();
                if (empty || !res.isEmpty())
                    return res;
            } catch (InputMismatchException e) {
                scanner.nextLine();
            } catch (Exception e) {
                System.exit(0);
            }
        }
    }

    private void customerInterface() {
        while (true) {
            System.out.println("Возможные действия\n"
                    + "1) Добавить интернет заказ\n"
                    + "2) Изменить интернет заказ\n"
                    + "3) Информация об интернет-заказах\n"
                    + "4) Получить интернет заказ\n\n"
                    + "5) Добавить заказ\n"
                    + "6) Изменить заказ\n"
                    + "7) Информация о заказах\n"
                    + "8) Получить заказ\n\n"
                    + "9) Новый пользователь\n"
                    + "0) Выход"
            );
            int response = getInt(10, true);
            switch (response) {
                case 1:
                    addOrderInternet();
                    break;
                case 2:
                    editOrderInternet();
                    break;
                case 3:
                    ordersInfoInternet();
                    break;
                case 4:
                    getOrderInternet();
                    break;


                case 5:
                    addOrderTable();
                    break;
                case 6:
                    editOrderTable();
                    break;
                case 7:
                    ordersInfoTable();
                    break;
                case 8:
                    getOrderTable();
                    break;

                case 9:
                    addCustomer();
                    break;
                case 0:
                    return;
            }
        }
    }


    public static void main(String[] args) {
        new Main().customerInterface();
    }
}
