import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class EndangeredAnimal {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void endangeredanimal_instantiatesCorrectly_true() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Tiger", "healthy", "young",1 );
    assertEquals(true, testEndangeredAnimal instanceof EndangeredAnimal);
  }

  @Test
  public void endangeredanimal_instantiatesWithName_String() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Tiger", "healthy", "young", 1 );
    assertEquals("Tiger", testEndangeredAnimal.getName());
  }

  @Test
  public void endangeredanimal_instantiatesWithHealth_String() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Tiger", "healthy", "young", 1 );
    assertEquals("healthy", testEndangeredAnimal.getHealth());
  }

  @Test
  public void endangeredanimal_instantiatesWithAge_String() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Tiger", "healthy", "young", 1 );
    assertEquals("age", testEndangeredAnimal.getAge());
  }

  @Test
  public void endangeredanimal_instantiatesWithanimalId_int() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Tiger", "healthy", "young", 1 );
    assertEquals(1, testEndangeredAnimal.getAnimalId());
  }

  @Test
  public void equals_returnsTrueIfNameHealthAgeAndAnimalIdAreSame_true() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Tiger", "healthy", "young", 1 );
    EndangeredAnimal anotherEndangeredAnimal = new EndangeredAnimal("Tiger", "healthy", "age", 1); 
    assertTrue(testEndangeredAnimal.equals(anotherEndangeredAnimal));
  }

    @Test
    public void save_returnsTrueIfDescriptionAretheSame(){
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Tiger", "healthy", "young", 1);
        testEndangeredAnimal.save();
        assertTrue(EndangeredAnimal.all().get(0).equals(testEndangeredAnimal));
    }

    @Test
    public void save_assignsIdToEndangeredAnimal(){
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Tiger", "healthy", "young", 1);
        testEndangeredAnimal.save();
        EndangeredAnimal savedEndangeredAnimal = EndangeredAnimal.all().get(0);
        assertEquals(savedEndangeredAnimal.getId(),testEndangeredAnimal.getId());
    }

    @Test
    public void all_returnsAllInstancesOfEndangeredAnimal_true(){
        EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("Tiger", "healthy", "young", 1);
        firstEndangeredAnimal.save();
        EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("Giraffe", "healthy", "young", 1);
        secondEndangeredAnimal.save();
        assertTrue(EndangeredAnimal.all().get(0).equals(firstEndangeredAnimal));
        assertTrue(EndangeredAnimal.all().get(1).equals(secondEndangeredAnimal));   
    }

    @Test
    public void find_returnsEndangeredAnimalWithSameId_secondEndangeredAnimal(){
        EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("Tiger", "healthy", "young", 1);
        firstEndangeredAnimal.save();
        EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("Giraffe", "healthy", "young", 1);
        secondEndangeredAnimal.save();
        assertTrue(EndangeredAnimal.find(secondEndangeredAnimal.getId()),secondEndangeredAnimal);
    }

    @Test
    public void save_saveAnimalIdIntoDB_true(){
        Animal testAnimal = new Animal("Rhino", "healthy", "young");
        testAnimal.save();
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Tiger", "healthy", "young", 1, testAnimal.getId());
        testEndangeredAnimal.save();
        EndangeredAnimal savedEndangeredAnimal =  EndangeredAnimal.find(testEndangeredAnimal.getId());
        assertTrue(EndangeredAnimal(savedEndangeredAnimal.getAnimalId(),testPerson.getId());
    }

    @Test 
    public void endangeredanimal_instantiatesWithhalffullhealthylevel(){
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Rhino", "healthy", "young",1);
        assertEquals(testEndangeredAnimal.gethealthylevel(), (EndangeredAnimal.MAX_HEALTHY_LEVEL / 4));
    }


    @Test 
    public void endangeredanimal_instantiatesWithHalfFullIlllevel(){
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Rhino", "healthy", "young",1);
        assertEquals(testEndangeredAnimal.getilllevel(), (EndangeredAnimal.MAX_ILL_LEVEL / 4));
    }


    @Test 
    public void endangeredanimal_instantiatesWithHalfFullOkaylevel(){
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Rhino", "healthy", "young",1);
        assertEquals(testEndangeredAnimal.getokaylevel(), (EndangeredAnimal.MAX_OKAY_LEVEL / 4));
    }


    @Test 
    public void isAlive_confirmsEndangeredAnimalISAlivelIfAllLevelsAboveMinimum_true(){
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Rhino", "healthy", "young",1);
        assertEquals(testEndangeredAnimal.isAlive(), true);
    }

    @Test 
    public void depleteLevels_reducesAllLevels(){
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Rhino", "healthy", "young",1);
        testEndangeredAnimal.depleteLevels();
        assertEquals(testEndangeredAnimal.gethealthylevel(), (EndangeredAnimal.MAX_HEALTHY_LEVEL / 4) -1);
        assertEquals(testEndangeredAnimal.getilllevel(), (EndangeredAnimal.MAX_ILL_LEVEL / 4) -1);
        assertEquals(testEndangeredAnimal.getokaylevel(), (EndangeredAnimal.MAX_OKAY_LEVEL / 4) -1);
    }

    @Test 
    public void isAlive_recognizesEndangeredAnimalIsDeadWhenLevelsReachMinimum_false(){
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Rhino", "healthy", "young",1);
    for(int i = EndangeredAnimal.MIN_ALL_LEVELS; i <= EndangeredAnimal.MAX_HEALTHY_LEVEL; i++){
        testEndangeredAnimal.depleteLevels();
    }
        assertEquals(testEndangeredAnimal.isAlive(), false);
    }

    @Test
    public void endangeredanimal_healthyLevelCannotGoBeyondMaxValue(){
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Rhino", "healthy", "young",1);
        for(int i = EndangeredAnimal.MIN_ALL_LEVELS; i <= (EndangeredAnimal.MAX_HEALTHY_LEVEL + 2); i++) {
            testEndangeredAnimal.health();
        }  
        assertTrue(testEndangeredAnimal.gethealthylevel() <= EndangeredAnimal.MAX_HEALTHY_LEVEL);
    }

}
