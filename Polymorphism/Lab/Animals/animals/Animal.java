package animals;

public abstract class Animal {
    String name;
    String favouriteFood;

    public Animal(String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }

    public String explainSelf(){
        return String.format("I am %s and my favourite food is %s",
                this.name,
                this.favouriteFood);
    };

}
