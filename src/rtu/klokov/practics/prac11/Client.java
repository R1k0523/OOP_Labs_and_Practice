package rtu.klokov.practics.prac11;

import java.util.Scanner;

public class Client {
    Chair chair;

    public void setChair(Chair chair) {
        this.chair = chair;
    }

    public void sit() {
        chair.sit();
    }


}
