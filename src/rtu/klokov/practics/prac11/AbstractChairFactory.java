package rtu.klokov.practics.prac11;

public interface AbstractChairFactory {
    VictorianChair createVictorianChair();
    FunctionalChair createFunctionalChair();
    MagicChair createMagicChair();
}
