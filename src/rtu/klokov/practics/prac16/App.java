package rtu.klokov.practics.prac16;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class App extends JFrame {
    private App app = this;
    private Customer customer;
    private final InternetOrdersManager internetManager = new InternetOrdersManager();
    private final TableOrdersManager tableManager = new TableOrdersManager();
    private Address adresses[] = new Address[100];
    private JMenuBar jMenuBar=new JMenuBar();
    private JMenu jMenuAcc=new JMenu("Аккаунт");
    private JMenuItem logItem =new JMenuItem("Войти");
    private JMenuItem exitItem=new JMenuItem("Выйти");
    private JMenu jMenuOrder=new JMenu("Заказ");
    public JMenuItem iOrderItem =new JMenuItem("Новый интернет заказ");
    private JMenuItem orderItem=new JMenuItem("Новый заказ");
    String[] columnNames = {"Тип заказа", "Столик", "Количество напитков", "Стоимость"};
    String[] icolumnNames = {"Тип заказа", "Адрес", "Количество напитков", "Стоимость"};

    private final JTable table;
    private final JTable itable;
    private final DefaultTableModel model;
    private final DefaultTableModel imodel;
    App(){
        setSize(800,660);
        setLocation((1920-1280)/2,(1080-720)/2);

        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        jMenuAcc.add(logItem);
        exitItem.setVisible(false);
        jMenuAcc.add(exitItem);
        jMenuBar.add(jMenuAcc);

        iOrderItem.setEnabled(false);
        jMenuOrder.add(iOrderItem);
        jMenuOrder.add(orderItem);
        jMenuBar.add(jMenuOrder);

        model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        table.setCellSelectionEnabled(false);
        table.setColumnSelectionAllowed(false);
        table.setRowSelectionAllowed(true);
        table.setDragEnabled(false);
        table.setEnabled(false);

        imodel = new DefaultTableModel();
        imodel.setColumnIdentifiers(icolumnNames);
        itable = new JTable(imodel);
        JScrollPane iscrollPane = new JScrollPane(itable);
        itable.setFillsViewportHeight(true);
        itable.setCellSelectionEnabled(false);
        itable.setColumnSelectionAllowed(false);
        itable.setRowSelectionAllowed(true);
        itable.setDragEnabled(false);
        itable.setEnabled(false);


        constraints.weighty=1;
        constraints.weightx=1;
        constraints.gridx=0;
        constraints.gridy=1;
        iscrollPane.setMinimumSize(new Dimension(1000, 300));
        iscrollPane.setMaximumSize(new Dimension(1000, 300));
        iscrollPane.setPreferredSize(new Dimension(1000, 300));
        scrollPane.setMinimumSize(new Dimension(1000, 300));
        scrollPane.setMaximumSize(new Dimension(1000, 300));
        scrollPane.setPreferredSize(new Dimension(1000, 300));
        add(scrollPane, constraints);
        constraints.gridy++;
        add(iscrollPane, constraints);

        constraints.fill=GridBagConstraints.HORIZONTAL;
        constraints.anchor=GridBagConstraints.NORTHWEST;
        constraints.weighty=1;
        constraints.weightx=1;
        constraints.gridx=0;
        constraints.gridy=0;

        logButton();
        exitButton();
        orderButton();
        iOrderButton();
        add(jMenuBar,constraints);
        setVisible(true);
    }

    private void logButton() {
        logItem.addActionListener(e -> {
            LogInDialog dial = new LogInDialog();
            customer = dial.getCustomer();
            logItem.setVisible(false);
            exitItem.setVisible(true);
            iOrderItem.setEnabled(true);
        });
    }
    private void exitButton() {
        exitItem.addActionListener(e -> {
            logItem.setVisible(true);
            exitItem.setVisible(false);
            iOrderItem.setEnabled(false);
        });
    }
    private void orderButton() {
        orderItem.addActionListener(e -> {
            int age = 0, table = 0;
            OrderDialog dial;
            String freeTables = "";
            for (int i : tableManager.freeTableNumbers()) {
                freeTables += i + " ";
            }
            while (true) {
                String s = JOptionPane.showInputDialog(
                        this,
                        "Выбирайте столик:\nСвободные столики: " + freeTables);
                try {
                    table = Integer.parseInt(s);
                    boolean flag = false;
                    for (int element : tableManager.freeTableNumbers()) {
                        if (element == table) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag)
                        break;
                } catch (Exception ex) {}
            }
            while (true) {
                String s = JOptionPane.showInputDialog(
                        this,
                        "Ваш возраст");
                try {
                    age = Integer.parseInt(s);
                    break;
                } catch (Exception ex) {}
            }

            if (age > 17) {
                TableOrder order = new TableOrder();
                dial = new OrderDialog(order,
                        Customer.MATURE_UNKNOWN_CUSTOMER, true, false, tableManager, this);
            }
            else {
                TableOrder order = new TableOrder();
                dial = new OrderDialog(order,
                        Customer.NOT_MATURE_UNKNOWN_CUSTOMER, true, false, tableManager, this);
            }
            dial.setTable(table);
        });

    }
    private void iOrderButton() {
        iOrderItem.addActionListener(e -> {
            InternetOrder order = new InternetOrder();
            new OrderDialog(order, customer, true, true, internetManager, this);
        });
    }


    public void updateTable() {
        Object[] row = new Object[4];
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        DefaultTableModel imodel = new DefaultTableModel();
        imodel.setColumnIdentifiers(icolumnNames);
        for (TableOrder i : tableManager.getOrders()) {
            row[0] = "Заказ в баре";
            row[1] = i.getTable();
            row[2] = i.getItems().length;
            row[3] = i.costTotal();
            model.addRow(row);
        }
        int k = 0;
        for (Order i : internetManager.getOrders()) {
            adresses = new Address[100];
            row[0] = "Заказ в баре";
            row[1] = i.getCustomer().getAddress().toString();
            row[2] = i.getItems().length;
            row[3] = i.costTotal();
            adresses[k] = i.getCustomer().getAddress();
            imodel.addRow(row);
            k++;
        }
        table.setModel(model);
        table.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                int table_num =Integer.parseInt(table.getValueAt(row, 1).toString());
                TableOrder order = tableManager.getOrder(table_num);
                new OrderDialog(order, order.getCustomer(), false, false, tableManager, app);
            }
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });
        itable.setModel(imodel);
        itable.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {
                int row = itable.rowAtPoint(e.getPoint());
                Order order = internetManager.order(adresses[row]);
                new OrderDialog(order, order.getCustomer(), false, true, internetManager, app);
            }
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });
    }

}
