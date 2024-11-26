package game.monster;

public abstract class Monster {
    private String name;

    public Monster(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
