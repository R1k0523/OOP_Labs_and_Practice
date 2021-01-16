package rtu.klokov.practics.prac16;


public class InternetOrdersManager implements OrdersManager {
    private QueueNode head = null;
    private QueueNode tail = null;
    private int size = 0;

    private QueueNode getOrderNode(Address address) {
        QueueNode node = head;
        while (node != null) {
            if (node.value.getCustomer().getAddress().equals(address))
                return node;
            node = node.next;
        }
        return null;
    }
    public boolean add(Order order) throws OrderAlreadyAddedException {
        if (head == null)
            head = new QueueNode(null, order);
        else if (tail == null) {
            if (head.value.getCustomer().getAddress().equals(order.getCustomer().getAddress()) && head.value.itemsQuantity() > 0)
                throw new OrderAlreadyAddedException("По адресу " + order.getCustomer().getAddress().toString() + " уже есть заказ");
            tail = new QueueNode(head, order);
            head.prev = tail;
        } else {
            QueueNode orderNode = getOrderNode(order.getCustomer().getAddress());
            if (orderNode != null)
                throw new OrderAlreadyAddedException("По адресу " + order.getCustomer().getAddress().toString() + " уже есть заказ");
            tail = new QueueNode(tail, order);
            tail.prev.next = tail;
        }
        size++;
        return true;
    }

    public Order remove(Address orderAddress) {
        QueueNode orderNode = getOrderNode(orderAddress);
        if (orderNode == null)
            return null;
        if (orderNode.equals(head))
            head = null;
        if (orderNode.next != null)
            (orderNode.next).prev = orderNode.prev;
        if (orderNode.prev != null)
            (orderNode.prev).next = orderNode.next;
        size--;
        return orderNode.value;
    }

    public Order order(Address orderAddress) {
        QueueNode orderNode = getOrderNode(orderAddress);
        if (orderNode == null)
            return null;
        else
            return orderNode.value;
    }

    public int itemsQuantity(String itemName) {
        QueueNode node = head;
        int cnt = 0;
        while (node != null) {
            cnt += node.value.itemQuantity(itemName);
            node = node.next;
        }
        return cnt;
    }

    public int itemsQuantity(MenuItem item) {
        QueueNode node = head;
        int cnt = 0;
        while (node != null) {
            cnt += node.value.itemQuantity(item);
            node = node.next;
        }
        return cnt;
    }

    public Order[] getOrders() {
        QueueNode node = head;
        Order[] orders = new Order[size];
        for (int i = 0; i < size; i++) {
            orders[i] = node.value;
            node = node.next;
        }
        return orders;
    }

    public int ordersCostSummary() {
        QueueNode node = head;
        int cost = 0;
        for (int i = 0; i < size; i++) {
            cost += node.value.costTotal();
            node = node.next;
        }
        return cost;
    }

    public int ordersQuantity() {
        return size;
    }

}
