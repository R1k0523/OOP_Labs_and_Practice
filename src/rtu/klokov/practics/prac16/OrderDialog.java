package rtu.klokov.practics.prac16;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class OrderDialog {

    private int table;
    private App parent;
    private Order order;
    private boolean manager_type;
    private boolean is_new;
    JFrame frame;
    OrdersManager manager;
    public OrderDialog(Order order, Customer customer, boolean is_new,
                       boolean is_internet_manager, OrdersManager manager, App parent) {
        this.order = order;
        this.parent = parent;
        this.manager = manager;
        this.is_new = is_new;
        this.manager_type = is_internet_manager;
        frame = new JFrame("Заказ");
        frame.add(new MyDialog(order, customer, is_new));
        frame.setSize(400, 500);
        frame.setMinimumSize(new Dimension(400, 500));
        frame.setMaximumSize(new Dimension(400, 500));
        frame.setPreferredSize(new Dimension(400, 500));
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void setTable(int table) {
        this.table = table;
    }
    void accept_info() {
        if (is_new) {
            if (manager_type) {
                try {
                    ((InternetOrdersManager) manager).add(order);
                } catch (OrderAlreadyAddedException e) {
                    e.printStackTrace();
                }
            } else {
                ((TableOrder) order).setTable(table);
                try {
                    ((TableOrdersManager) manager).add(((TableOrder) order), table);
                } catch (OrderAlreadyAddedException e) {
                    e.printStackTrace();
                }
            }
        }
        parent.iOrderItem.setEnabled(false);
        frame.dispose();
        parent.updateTable();

    }


    class MyDialog extends JPanel {
        private int tableNumber = -1;
        private int row = -1;
        private Customer customer;
        private Order order;
        private int[] drinksCnt;
        private Drink[] drinks;

        private JLabel label;
        private JSpinner[] drinksSpinner;
        private JLabel orderInfo;
        private JButton applyBtn;


        MyDialog(Order order, Customer customer, boolean is_new) {
            this.order = order;
            order.setCustomer(customer);
            GridBagLayout layout = new GridBagLayout();
            setLayout(layout);
            GridBagConstraints constraints = new GridBagConstraints();

            constraints.gridy = 0;
            constraints.gridx = 0;

            add(new JLabel(toMultilineStr(" ")), constraints);

            DrinkTypeEnum[] drinksEnum = DrinkTypeEnum.values();
            drinksSpinner = new JSpinner[drinksEnum.length];
            drinksCnt = new int[drinksEnum.length];
            drinks = new Drink[drinksEnum.length];
            for (int i = 0; i < drinksEnum.length; i++) {
                drinksCnt[i] = 0;
                drinks[i] = drinksEnum[i].getValue();
                constraints.gridy++;
                constraints.gridx = 0;
                label = new JLabel(drinks[i].getName());
                label.setToolTipText(toMultilineStr(drinks[i].getDescription() + "\nКрепкость: " +
                        (drinks[i].getAlcoholVol() * 100) + "%\nЦена: " + drinks[i].getCost()));

                if (customer.getAge() > 17 || !drinks[i].isAlcoholicDrink())
                    add(label, constraints);

                constraints.gridx = 1;
                drinksSpinner[i] = new JSpinner(new SpinnerNumberModel(0, 0, 20, 1));
                drinksSpinner[i].setToolTipText(label.getToolTipText());
                int finalI = i;
                drinksSpinner[i].addChangeListener(changeEvent -> {
                    int diff = (int) drinksSpinner[finalI].getValue() - drinksCnt[finalI];
                    while (diff > 0) {
                        order.add(drinks[finalI]);
                        diff--;
                    }
                    while (diff < 0) {
                        order.remove(drinks[finalI]);
                        diff++;
                    }
                    drinksCnt[finalI] = (int) drinksSpinner[finalI].getValue();
                    setOrderInfoText();
                });
                if (customer.getAge() > 17 || !drinks[i].isAlcoholicDrink())
                    add(drinksSpinner[i], constraints);
            }

            constraints.gridy += 1;
            constraints.gridx = 0;
            orderInfo = new JLabel();
            add(orderInfo, constraints);

            constraints.gridx = 1;
            applyBtn = new JButton("Готово");
            applyBtn.addActionListener(actionEvent -> {
                System.out.println(order.itemsQuantity() + "\n");
                if (order.itemsQuantity() == 0) {
                    JOptionPane.showMessageDialog(this, "Напитки не выбраны!");
                    return;
                }

                accept_info();
                setVisible(false);
                setEnabled(false);
            });
            add(applyBtn, constraints);
            constraints.gridy++;
            JButton cancelBtn = new JButton("Назад");
            cancelBtn.addActionListener(actionEvent -> {
                setEnabled(false);
                accept_info();
                setVisible(false);
            });
            add(cancelBtn, constraints);
            if (!is_new) {
                constraints.gridy--;
                constraints.gridx = 2;
                JButton changeBtn = new JButton("Изменить");
                changeBtn.addActionListener(actionEvent -> {
                    setEnabled(true);
                });
                add(changeBtn, constraints);
                constraints.gridy++;
                JButton delBtn = new JButton("Получить/Удалить заказ");
                delBtn.addActionListener(actionEvent -> {
                    if (manager_type) {
                        ((InternetOrdersManager) manager).remove(order.getCustomer().getAddress());
                        accept_info();

                    } else {
                        ((TableOrdersManager) manager).remove(order);
                        accept_info();
                    }
                });
                add(delBtn, constraints);
            }
            if (!is_new) {
                load(order);
            }
            setEnabled(is_new);
        }

        void load(Order order) {
            this.order = order;
            Arrays.fill(drinksCnt, 0);
            for (MenuItem item : order.getItems()) {
                for (int i = 0; i < drinksCnt.length; i++)
                    if (item.getName().equals(drinks[i].getName())) {
                        drinksCnt[i] += 1;
                        break;
                    }
            }
            for (int i = 0; i < drinksCnt.length; i++)
                drinksSpinner[i].setValue(drinksCnt[i]);
            customer = order.getCustomer();
            setOrderInfoText();
        }
        private void setOrderInfoText() {
            if (order == null)
                orderInfo.setText(toMultilineStr("Всего напитков: 0\nИтоговая цена: 0 "));
            else
                orderInfo.setText(toMultilineStr("Всего напитков:" + order.itemsQuantity() + "\nИтоговая цена:" + order.costTotal()));
        }


        @Override
        public void setEnabled(boolean enabled) {
            super.setEnabled(enabled);
            applyBtn.setEnabled(enabled);
            for (JSpinner drink : drinksSpinner)
                drink.setEnabled(enabled);
            setOrderInfoText();
        }

        private String toMultilineStr(String text) {
            return "<html>" + text.replace("\n", "<br>");
        }
    }
}