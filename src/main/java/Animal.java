import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;

public class  Animal {
    private String name;
    private String health;
    private String age;
    private int id;

    public Animal(String name, String health, String age, int id) {
        this.name = name;
        this.health = health;
        this.age = age;
        this.id = id;
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

    public int getId() {
        return id;
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

        public void save() {
            try(Connection con = DB.sql2o.open()) {
              String sql = "INSERT INTO animal (name, health, age) VALUES (:name, :health, :age)";
              con.createQuery(sql)
                .addParameter("name", this.name)
                .addParameter("health", this.health)
                .addParameter("age", this.age)
                .executeUpdate()
                .getKey();
            }
          }

          public static List<Animal> all() {
            String sql = "SELECT * FROM animal";
            try(Connection con = DB.sql2o.open()) {
             return con.createQuery(sql).executeAndFetch(Animal.class);
            }
          }

          public static Animal find(int id) {
            try(Connection con = DB.sql2o.open()) {
              String sql = "SELECT * FROM animal where id=:id";
              Animal animal = con.createQuery(sql)
                .addParameter("id", id)
                .executeAndFetchFirst(Animal.class);
              return animal;
            }
          }

          public  List<EndangeredAnimal> gEndangeredAnimals() {
            String sql = "SELECT * FROM endangeredAnimals where animalId=:id";
            try(Connection con = DB.sql2o.open()) {
             return con.createQuery(sql).executeAndFetch(EndangeredAnimal.class);
            }
          }


    }
