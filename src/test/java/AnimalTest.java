import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class AnimalTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();  

  @Test
  public void animal_instantiatesCorrectly_true() {
    Animal testAnimal = new Animal("Rhino", "healthy", "young");
    assertEquals(true, testAnimal instanceof Animal);
  }

  @Test
  public void getName_animalInstantiatesWithName_Rhino() {
      Animal testAnimal = new Animal("Rhino", "healthy", "young");
      assertEquals("Rhino", testAnimal.getName());
  }

  @Test
  public void getHealth_animalInstantiatesWithHealth_healthy() {
      Animal testAnimal = new Animal("Rhino", "healthy", "young");
      assertEquals("healthy", testAnimal.getHealth());
  }

  @Test
  public void getAge_animalInstantiatesWithAge_young(){
    Animal testAnimal = new Animal("Rhino", "healthy", "young");
    assertEquals("young", testAnimal.getAge());
  }
  @Test
  public void equals_returnsTrueIfNameHealthAgeAreSame_true() {
      Animal firstAnimal = new Animal("Rhino", "healthy", "young");
      Animal anotherAnimal = new Animal("Giraffe", "healthy", "young");
      assertTrue(firstAnimal.equals(anotherAnimal));
  }

  @Test
  public void save_insertsObjectIntoDatabase_Animal() {
      Animal testAnimal = new Animal("Rhino", "healthy", "young");
      testAnimal.save();
      assertTrue(Animal.all().get(0).equals(testAnimal));
  }

  @Test

  public void all_returnsAllInstancesOfAnimal_true() {
    Animal firstAnimal = new Animal("Rhino", "healthy", "young");
    Animal secondAnimal = new Animal("Giraffe", "healthy", "young");
    assertEquals(true, Animal.all().get(0).equals(firstAnimal));
    assertEquals(true, Animal.all().get(1).equals(secondAnimal));
  }

  @Test
  public void save_assignsIdToObject() {
    Animal testAnimal = new Animal("Rhino", "healthy", "young");
    testAnimal.save();
    Animal savedAnimal = Animal.all().get(0);
    assertEquals(testAnimal.getId(), savedAnimal.getId());
  }

  @Test
  public void find_returnsAnimalWithSameId_secondAnimal() {
    Animal firstAnimal = new Animal("Rhino", "healthy", "young");
    firstAnimal.save();
    Animal secondAnimal = new Animal("Giraffe", "healthy", "young");
    secondAnimal.save();
    assertEquals(Animal.find(secondAnimal.getId()), secondAnimal);
  }

  @Test
  public void getEndangeredAnimal_retrievesAllEndangeredAnimalFromDatabase_endangeredanimalList() {
      Animal testAnimal = new Animal(("Rhino", "healthy", "young");
      testAnimal.save();
      EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("Tiger", "healthy", "young", 1, testAnimal.getId());
      firstEndangeredAnimal.save();
      EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("Giraffe", "healthy", "young", 1, testAnimal.getId());
      secondEndangeredAnimal.save();
      EndangeredAnimal[] endangeredAnimals = new EndangeredAnimal[] { firstEndangeredAnimal, secondEndangeredAnimal };
      assertTrue(testAnimal.getEndangeredAnimals().containsAll(Arrays.asList(endangeredAnimals)));
  }


}