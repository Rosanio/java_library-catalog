import org.junit.*;
import java.util.*;
import static org.junit.Assert.*;

public class AuthorTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void all_emptyAtFirst() {
    assertEquals(Author.all().size(), 0);
  }

  @Test
  public void equals_returnsTrueIfDescriptionsAretheSame() {
    Author firstAuthor = new Author("Stephen", "King");
    Author secondAuthor = new Author("Stephen", "King");
    assertTrue(firstAuthor.equals(secondAuthor));
  }

  @Test
  public void save_savesObjectIntoDatabase() {
    Author myAuthor = new Author("Stephen", "King");
    myAuthor.save();
    Author savedAuthor = Author.all().get(0);
    assertTrue(savedAuthor.equals(myAuthor));
  }

  @Test
  public void save_assignsIdToObject() {
    Author myAuthor = new Author("Stephen", "King");
    myAuthor.save();
    Author savedAuthor = Author.all().get(0);
    assertEquals(myAuthor.getId(), savedAuthor.getId());
  }

  @Test
  public void find_findsAuthorInDatabase_true() {
    Author myAuthor = new Author("Stephen", "King");
    myAuthor.save();
    Author savedAuthor = Author.find(myAuthor.getId());
    assertTrue(myAuthor.equals(savedAuthor));
  }

  @Test
  public void update_updatesAuthorNameAndNumber() {
    Author myAuthor = new Author("Stephen", "King");
    myAuthor.save();
    myAuthor.update("Steven", "Bishop");
    Author savedAuthor = Author.find(myAuthor.getId());
    assertEquals(myAuthor, savedAuthor);
  }
  // @Test
  // public void addStudent_addsStudentToAuthor() {
  //   Student myStudent = new Student("John", "12-23-2015", "History");
  //   myStudent.save();
  //
  //   Author myAuthor = new Author("Stephen", "King");
  //   myAuthor.save();
  //
  //   myAuthor.addStudent(myStudent);
  //   Student savedStudent = myAuthor.getStudents().get(0);
  //   assertTrue(myStudent.equals(savedStudent));
  // }

  // @Test
  // public void getStudents_returnsAllStudents_ArrayList() {
  //   Student myStudent = new Student("John", "12-23-2015", "History");
  //   myStudent.save();
  //
  //   Author myAuthor = new Author("Stephen", "King");
  //   myAuthor.save();
  //
  //   myAuthor.addStudent(myStudent);
  //   List savedStudents = myAuthor.getStudents();
  //   assertEquals(savedStudents.size(), 1);
  // }



  // @Test
  // public void delete_deletesAllAuthorsAndListsAssoicationes() {
  //   Student myStudent = new Student("Matt", "2010-08-15", "History");
  //   myStudent.save();
  //
  //   Author myAuthor = new Author("Stephen", "King");
  //   myAuthor.save();
  //
  //   myAuthor.addStudent(myStudent);
  //   myAuthor.delete();
  //   assertEquals(myStudent.getAuthors().size(), 0);
  // }

}
