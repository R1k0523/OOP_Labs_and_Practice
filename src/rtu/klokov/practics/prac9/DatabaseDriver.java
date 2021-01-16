package rtu.klokov.practics.prac9;

import javax.swing.table.DefaultTableModel;

public class DatabaseDriver {

    static DatabaseStudent bd = new DatabaseStudent();


    public void addStudent(String name,String id,String gpa) throws EmptyStringException{
        if(name.equals("")){
            throw new EmptyStringException("ФИО");
        }
        if(id.equals("")){
            throw new EmptyStringException("№ студента");
        }
        if(gpa.equals("")){
            throw new EmptyStringException("Средний балл");
        }
        if(Double.isNaN(Double.parseDouble(gpa)) ||Double.parseDouble(gpa)<0||Double.parseDouble(gpa)>5) {
            throw new NumberFormatException();
        }

        bd.add(new Student(name,Integer.parseInt(id),Double.parseDouble(gpa)));
    }

    public void sort() {
        bd.sort();
    }

    public Student find(String name) throws StudentNotFoundException {
        return bd.find(new Student(name, 0, 0));
    }


    public DefaultTableModel getTable() {
        Object[] columns = {"№ студента","ФИО", "Средний балл"};
        Object[] row = new Object[3];
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        for (int j = 0; j < bd.getSize(); j++) {
            row[0] = bd.get(j).getId();
            row[1] = bd.get(j).getName();
            row[2] = bd.get(j).getGpa();
            model.addRow(row);
        }

        return model;
    }

}
