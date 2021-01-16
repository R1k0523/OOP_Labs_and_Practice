package rtu.klokov.labs.lab16;

import java.util.HashMap;

public class InternetOrder implements Order {
    private int size = 0;
    private ListNode head = null;
    private ListNode tail = null;
    private Customer customer;

    public InternetOrder() {}

    public InternetOrder(MenuItem[] items) {
        for (MenuItem item : items)
            add(item);
    }


    public boolean add(MenuItem item) {
        ListNode node = new ListNode(null, item);
        if (head == null)
            head = node;
        else if (tail == null) {
            tail = node;
            head.next = tail;
        } else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
            tail = node;
        }
        size++;
        return true;
    }

    public String[] itemsNames() {
        MenuItem[] items = getItems();
        HashMap<String, Boolean> orders = new HashMap<>();
        for (MenuItem item : items)
            if (!orders.containsKey(item.getName()))
                orders.put(item.getName(), true);

        return orders.keySet().toArray(new String[orders.size()]);
    }

    public int itemsQuantity() {
        return size;
    }

    public int itemQuantity(String itemName) {
        if (tail == null) {
            if (head.value != null && head.value.getName().equals(itemName)) {
                return 1;
            }
            return 0;
        }
        ListNode currNode = tail;
        int cnt = 0;
        while (currNode != null) {
            if (currNode.value.getName().equals(itemName)) {
                cnt++;
            }
            currNode = currNode.next;
        }
        return cnt;
    }

    public int itemQuantity(MenuItem item) {
        if (tail == null) {
            if (head.value != null && head.value.equals(item))
                return 1;
            return 0;
        }
        ListNode currNode = tail;
        int cnt = 0;
        while (currNode != null) {
            if (currNode.value.equals(item))
                cnt++;
            currNode = currNode.next;
        }
        return cnt;
    }

    public MenuItem[] getItems() {
        if (tail == null) {
            if (head.value != null)
                return new MenuItem[]{head.value};
            return new MenuItem[]{};
        }
        MenuItem[] items = new MenuItem[size];
        ListNode currNode = head;
        for (int i = 0; i < size; i++) {
            items[i] = currNode.value;
            currNode = currNode.next;
        }
        return items;
    }

    public boolean remove(String itemName) {
        if (tail == null) {
            if (head.value != null && head.value.getName().equals(itemName)) {
                head.value = null;
                size--;
                return true;
            }
            return false;
        }
        ListNode currNode = head;
        ListNode prevNode = head;
        while (currNode != null) {
            if (currNode.value.getName().equals(itemName)) {
                if (currNode.equals(head)) {
                    head = currNode.next;
                }
                prevNode.next = currNode.next;
                size--;
                return true;
            }
            prevNode = currNode;
            currNode = currNode.next;
        }
        return false;
    }

    public boolean remove(MenuItem item) {
        if (tail == null) {
            if (head.value != null && head.value.equals(item)) {
                head.value = null;
                size--;
                return true;
            }
            return false;
        }
        ListNode currNode = head;
        ListNode prevNode = head;
        while (currNode != null) {
            if (currNode.value.equals(item)) {
                if (currNode.equals(head)) {
                    head = currNode.next;
                }
                prevNode.next = currNode.next;
                size--;
                return true;
            }
            prevNode = currNode;
            currNode = currNode.next;
        }
        return false;
    }

    public int removeAll(String itemName) {
        if (tail == null) {
            if (head.value != null && head.value.getName().equals(itemName)) {
                head.value = null;
                size--;
                return 1;
            }
            return 0;
        }
        ListNode currNode = head;
        ListNode prevNode = head;
        int count = 0;
        while (currNode != null) {
            if (currNode.value.getName().equals(itemName)) {
                if (currNode.equals(head)) {
                    head = currNode.next;
                }
                prevNode.next = currNode.next;
                size--;
                count++;
            }
            if (currNode.next == null) {
                tail = prevNode;
            }
            prevNode = currNode;
            currNode = currNode.next;
        }
        return count;
    }

    public int removeAll(MenuItem item) {
        if (tail == null) {
            if (head.value != null && head.value.equals(item)) {
                head.value = null;
                size--;
                return 1;
            }
            return 0;
        }
        ListNode currNode = head;
        ListNode prevNode = head;
        int cnt = 0;
        while (currNode != null) {
            if (currNode.value.equals(item)) {
                if (currNode.equals(head)) {
                    head = currNode.next;
                }
                prevNode.next = currNode.next;
                size--;
                cnt++;
            }
            if (currNode.next == null) {
                tail = prevNode;
            }
            prevNode = currNode;
            currNode = currNode.next;
        }
        return cnt;
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
        if (tail == null) {
            if (head.value != null)
                return head.value.getCost();
            return 0;
        }
        ListNode currNode = head;
        int sum = 0;
        while (currNode != null) {
            sum += currNode.value.getCost();
            currNode = currNode.next;
        }
        return sum;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
