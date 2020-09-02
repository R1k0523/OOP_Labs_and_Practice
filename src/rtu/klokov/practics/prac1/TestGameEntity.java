package rtu.klokov.practics.prac1;

public class TestGameEntity {

    public static void main(String[] args) {
        GameEntity gameEntity1 = new GameEntity("Hero", false);
        GameEntity gameEntity2 = new GameEntity();
        GameEntity gameEntity3 = new GameEntity("User", "warrior", 20, 13, 7, false);
        System.out.println(gameEntity1);
        System.out.println(gameEntity2);
        System.out.println(gameEntity3.getAttack());
    }

}
