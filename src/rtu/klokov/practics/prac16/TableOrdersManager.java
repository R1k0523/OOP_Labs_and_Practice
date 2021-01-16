package rtu.klokov.practics.prac16;


public class TableOrdersManager implements OrdersManager {
    public static final int TABLES_NUM = 10;
    private TableOrder[] orders = new TableOrder[TABLES_NUM];
    private int ordersCount = 0;

    private void checkTableNumber(int tableNumber) {
        if (tableNumber > TABLES_NUM || tableNumber <= 0)
            throw new IllegalTableNumber("Столика с номером " + tableNumber + " не существует");
    }


    public void add(TableOrder order, int tableNumber) throws OrderAlreadyAddedException {
        checkTableNumber(tableNumber);
        if (orders[tableNumber - 1] != null)
            throw new OrderAlreadyAddedException("На столик с номером " + tableNumber + " уже есть заказ");
        order.setTable(tableNumber);
        ordersCount++;
        orders[tableNumber - 1] = order;
    }

    public void addItem(MenuItem item, int tableNumber) {
        checkTableNumber(tableNumber);
        if (orders[tableNumber - 1] == null)
            throw new IllegalArgumentException("На столик под номером " + tableNumber + " нет заказов!");
        orders[tableNumber - 1].add(item);
    }

    public int freeTableNumber() {
        for (int i = 0; i < TABLES_NUM; i++)
            if (orders[i] == null)
                return i;
        return -1;
    }

    public int[] freeTableNumbers() {
        int[] freeNumbers = new int[TABLES_NUM - ordersCount];
        int j = 0;
        for (int i = 0; i < TABLES_NUM; i++)
            if (orders[i] == null)
                freeNumbers[j++] = i + 1;
        return freeNumbers;
    }

    public TableOrder getOrder(int tableNumber) {
        checkTableNumber(tableNumber);
        return orders[tableNumber - 1];
    }

    public void remove(int tableNumber) {
        checkTableNumber(tableNumber);
        if (orders[tableNumber - 1] != null) {
            ordersCount--;
            orders[tableNumber - 1] = null;
        }
    }

    public int remove(Order order) {
        if (order == null)
            return 0;
        for (int i = 0; i < TABLES_NUM; i++) {
            if (order.equals(orders[i])) {
                orders[i] = null;
                ordersCount--;
                return 1;
            }
        }
        return 0;
    }

    public int removeAll(Order order) {
        if (order == null)
            return 0;
        int removeCnt = 0;
        for (int i = 0; i < TABLES_NUM; i++) {
            if (order.equals(orders[i])) {
                removeCnt++;
                orders[i] = null;
            }
        }
        ordersCount -= removeCnt;
        return removeCnt;
    }

    public int itemsQuantity(String itemName) {
        int cnt = 0;
        for (Order order : orders) {
            if (order != null)
                cnt += order.itemQuantity(itemName);
        }
        return cnt;
    }

    public int itemsQuantity(MenuItem item) {
        int cnt = 0;
        for (Order order : orders) {
            if (order != null)
                cnt += order.itemQuantity(item);
        }
        return cnt;
    }

    public TableOrder[] getOrders() {
        TableOrder[] activeOrders = new TableOrder[ordersCount];
        int j = 0;
        for (int i = 0; i < TABLES_NUM; i++)
            if (orders[i] != null)
                activeOrders[j++] = orders[i];
        return activeOrders;
    }

    public int ordersCostSummary() {
        int cost = 0;
        for (Order order : orders) {
            if (order != null)
                cost += order.costTotal();
        }
        return cost;
    }

    public int ordersQuantity() {
        return ordersCount;
    }
}
