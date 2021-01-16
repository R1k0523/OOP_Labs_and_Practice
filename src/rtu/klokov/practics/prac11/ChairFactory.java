package rtu.klokov.practics.prac11;

public class ChairFactory implements AbstractChairFactory{

    public VictorianChair createVictorianChair() {
        return new VictorianChair(40);
    }
    public FunctionalChair createFunctionalChair() {
        return new FunctionalChair();
    }
    public MagicChair createMagicChair() {
        return new MagicChair();
    }
}
