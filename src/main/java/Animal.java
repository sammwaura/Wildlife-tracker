public class  Animal {
    private String name;
    private String health;
    private String age;

    public Animal(String name, String health, String age) {
        this.name = name;
        this.health = health;
        this.age = age; 
    }

    public String getName(){
        return name;
    }

    public String getHealth() {
        return health;
    }

    public String getAge() {
        return age;
    }

    @Override
    public boolean equals(Object otherAnimal){
        if (!(otherAnimal instanceof Animal)) {
            return  false;
        } else{
            Animal newAnimal = (Animal) otherAnimal;
            return this.getName().equals(newAnimal.getName()) &&
            this.getHealth().equals(newAnimal.getHealth()) && this.getAge().equals(newAnimal.getAge());
        }
        }
    }
