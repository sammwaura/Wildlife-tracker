import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class EndangeredAnimal{
    private String name;
    private String health;
    private String age;
    private int animalId;
    private int id;
    private int healthylevel;
    private int illlevel;
    private int okaylevel;

    public EndangeredAnimal(String name, String health, String age, int animalId, int id) 
     {
        this.name = name;
        this.health = health;
        this.age = age;
        this.animalId = animalId;
        this.id = id;
        healthylevel = MAX_HEALTHY_LEVEL / 4;
        illlevel = MAX_ILL_LEVEL / 4 ;
        okaylevel = MAX_OKAY_LEVEL /4;

    }

    public String getName() {
        return name;
    }

    public String getHealth() {
        return health;
    }

    public String getAge(){
        return age;
    }

    public int getanimalId(){
        return animalId;
    }

    public int getId(){
        return id;
    }

    public int getHealthyLevel(){
        return healthylevel;
    }
    
    public int getIllLevel(){
        return illlevel;
    }

    public int getOkayLevel(){
        return okaylevel;
    }

    public static final int MAX_HEALTHY_LEVEL = 5;
    public static final int MAX_ILL_LEVEL = 5;
    public static final int MAX_OKAY_LEVEL = 5;
    public static final int MIN_ALL_LEVELS = 0;

    public boolean isAlive() {
        if (healthylevel <= MIN_ALL_LEVELS ||
        illlevel <= MIN_ALL_LEVELS ||
        okaylevel <= MIN_ALL_LEVELS) {
            return false;
        }
        return true;
        }

        public void depleteLevels(){
            healthylevel--;
            illlevel--;
            okaylevel--;
        }

    @Override
    public boolean equals(Object otherEndangeredAnimal){
      if (!(otherEndangeredAnimal instanceof EndangeredAnimal)) {
        return false;
      } else {
        EndangeredAnimal newEndangeredAnimal = (EndangeredAnimal) otherEndangeredAnimal;
        return this.getName().equals(newEndangeredAnimal.getName()) &&  this.getHealth().equals (newEndangeredAnimal.getHealth()) &&  this.getAge().equals(newEndangeredAnimal.getAge()) &&
               this.getanimalId() == newEndangeredAnimal.getanimalId();
      }
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO endangeredanimal (name, health, age, animalid) VALUES (:name, :health, :age, animalId)";
            this.id = (int) con.createQuery(sql, true)
            .addParameter("name", this.name)
            .addParameter("health", this.health)
            .addParameter("age", this.age)
            .addParameter("animalid", this.animalId)
            .executeUpdate()
            .getKey();
        }
    }

    public static List<EndangeredAnimal> all() {
        String sql = "SELECT * FROM Endangered";
        try(Connection con = DB.sql2o.open()) {
          return con.createQuery(sql).executeAndFetch(EndangeredAnimal.class);
        }
      }

      public static EndangeredAnimal find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM endangered where id=:id";
            EndangeredAnimal endangeredAnimal = con.createQuery(sql)
            .addParameter("id", id)
            .executeAndFetchFirst(EndangeredAnimal.class);
          return endangeredAnimal;
        }
      }



}