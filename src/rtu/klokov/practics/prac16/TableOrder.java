package rtu.klokov.practics.prac16;

import java.util.Arrays;
import java.util.HashMap;

public class TableOrder implements Order {
    private int size = 0;
    private MenuItem[] items = new MenuItem[1];
    private Customer customer;
    private int table;

    private void resize(int newSize) {
        if (newSize * 2 <= items.length) {
            MenuItem[] new_items = new MenuItem[newSize];
            for (int i = 0, j = 0; i < size; i++)
                if (items[i] != null)
                    new_items[j++] = items[i];
            items = new_items;
        } else {
            for (int i = 0, j = 0; i < size; i++)
                if (items[i] != null)
                    items[j++] = items[i];
        }
        size = newSize;
    }

    public boolean add(MenuItem item) {
        if (size == items.length) {
            MenuItem[] new_items = new MenuItem[(size == 0) ? 1 : (size * 2)];
            System.arraycopy(items, 0, new_items, 0, size);
            items = new_items;
        }
        items[size++] = item;
        return true;
    }

    public String[] itemsNames() {
        MenuItem[] items = getItems();
        HashMap<String, Integer> orders = new HashMap<>();
        for (MenuItem item : items)
            if (!orders.containsKey(item.getName()))
                orders.put(item.getName(), 0);

        return orders.keySet().toArray(new String[orders.size()]);
    }

    public int itemsQuantity() {
        return size;
    }

    public int itemQuantity(String itemName) {
        int response = 0;
        for (MenuItem item2 : items)
            if (item2.getName().equals(itemName))
                response++;
        return response;
    }

    public int itemQuantity(MenuItem item) {
        int response = 0;
        for (MenuItem item2 : items)
            if (item.equals(item2))
                response++;
        return response;
    }

    public MenuItem[] getItems() {
        return Arrays.copyOf(items, size);
    }

    public boolean remove(String itemName) {
        for (int i = size - 1; i >= 0; i--) {
            if (items[i].getName().equals(itemName)) {
                items[i] = null;
                resize(size - 1);
                return true;
            }
        }
        return false;
    }

    public boolean remove(MenuItem item) {
        for (int i = size - 1; i >= 0; i--) {
            if (items[i].equals(item)) {
                items[i] = null;
                resize(size - 1);
                return true;
            }
        }
        return false;
    }

    public int removeAll(String itemName) {
        int newSize = size;
        for (int i = size - 1; i >= 0; i--) {
            if (items[i] != null && items[i].getName().equals(itemName)) {
                items[i] = null;
                newSize--;
            }
        }
        if (newSize == size)
            return 0;
        int loss = size - newSize;
        resize(newSize);
        return loss;
    }

    public int removeAll(MenuItem item) {
        int newSize = size;
        for (int i = size - 1; i >= 0; i--) {
            if (items[i] != null && items[i].equals(item)) {
                items[i] = null;
                newSize--;
            }
        }
        if (newSize == size)
            return 0;
        int loss = size - newSize;
        resize(newSize);
        return loss;
    }

    public MenuItem[] sortedItemsByCostDesc() {
        int n = size;
        MenuItem[] items = new MenuItem[n];
        System.arraycopy(getItems(), 0, items, 0, n);
        for (int i = 0; i < n; i++) {
            boolean wasSwap = false;
            for (int j = 1; j < n; j++) {
                if (items[j - 1].getCost() < items[j].getCost()) {
                    MenuItem tmp = items[j];
                    items[j] = items[j - 1];
                    items[j - 1] = tmp;
                    wasSwap = true;
                }
            }
            if (!wasSwap)
                break;
        }
        return items;
    }

    public int costTotal() {
        int sum = 0;
        for (MenuItem item : items)
            if (item != null)
                sum += item.getCost();
        return sum;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }
}
