package rtu.klokov.practics.prac1;

class GameEntity {
    private String name, class_type;
    private int health, speed, attack;
    private boolean isEnemy;

    public GameEntity(String name, String class_type, int health, int speed, int attack, boolean isEnemy) {
        this.name = name;
        this.class_type = class_type;
        this.health = health;
        this.speed = speed;
        this.attack = attack;
        this.isEnemy = isEnemy;
    }

    public GameEntity() {

        this.name = "default_name";
        this.class_type = "warrior";
        this.health = 10;
        this.speed = 15;
        this.attack = 20;
        this.isEnemy = true;

    }

    public GameEntity(String name, boolean isEnemy) {

        this.name = name;
        this.class_type = "warrior";
        this.health = 0;
        this.speed = 0;
        this.attack = 0;
        this.isEnemy = isEnemy;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClass_type() {
        return class_type;
    }

    public void setClass_type(String class_type) {
        this.class_type = class_type;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public boolean isEnemy() {
        return isEnemy;
    }

    public void setEnemy(boolean enemy) {
        isEnemy = enemy;
    }

    /* @Override */
    public String toString() {
        return "GameEntity{" +
                "name='" + name + '\'' +
                ", class_type ='" + class_type + '\'' +
                ", health = " + health +
                ", speed =" + speed +
                ", attack = " + attack +
                ", isEnemy = " + isEnemy +
                '}';
    }
}
