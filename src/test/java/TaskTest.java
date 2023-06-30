import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Epic;
import ru.netology.Meeting;
import ru.netology.SimpleTask;

public class TaskTest {

    // Find query for class simpleTask
    @Test
    public void shouldFindQuerySimpleTask() {
        SimpleTask simpleTask = new SimpleTask(10, "Позвонить родителям");
        String query = "Позвонить";

        Boolean expected = true;
        Boolean actual = simpleTask.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindQuerySimpleTask() {
        SimpleTask simpleTask = new SimpleTask(10, "Навестить родителей");
        String query = "Позвонить";

        Boolean expected = false;
        Boolean actual = simpleTask.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    // Find query for class meeting
    @Test
    public void shouldFindQueryMeetingForTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        String query = "приложения";

        Boolean expected = true;
        Boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryMeetingForProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        String query = "Приложение";

        Boolean expected = true;
        Boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryMeetingForTopicAndProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложения НетоБанка",
                "Во вторник после обеда"
        );
        String query = "Приложения";

        Boolean expected = true;
        Boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindQueryMeetingForStart() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        String query = "вторник";

        Boolean expected = false;
        Boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindQueryMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        String query = "запрос";
        Boolean expected = false;
        Boolean actual = meeting.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    //Find query for class Epic
    @Test
    public void shouldFindQueryEpicFirst() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        String query = "Молоко";
        Boolean expected = true;
        Boolean actual = epic.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryEpicSecond() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        String query = "Яйца";
        Boolean expected = true;
        Boolean actual = epic.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryEpicThird() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        String query = "Хлеб";
        Boolean expected = true;
        Boolean actual = epic.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryEpic() {
        String[] subtasks = {"Молоко", "Молоко", "Молоко"};
        Epic epic = new Epic(55, subtasks);
        String query = "Молоко";
        Boolean expected = true;
        Boolean actual = epic.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindQueryEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        String query = "Картошка";
        Boolean expected = false;
        Boolean actual = epic.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    //Getters testing

    @Test
    public void shouldCheckGetterForAllTypesOfTasks() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );


        // getID testing
        //simpleTask
        int expected = 5;
        int actual = simpleTask.getId();
        Assertions.assertEquals(expected, actual);

        //epic
        expected = 55;
        actual = epic.getId();
        Assertions.assertEquals(expected, actual);

        //meeting
        expected = 555;
        actual = meeting.getId();
        Assertions.assertEquals(expected, actual);

        // getTitle for SimpleTask
        String expectedTitle = "Позвонить родителям";
        String actualTitle = simpleTask.getTitle();

        Assertions.assertEquals(expectedTitle, actualTitle);

        // getters for Epic
        String[] expectedSubtasks = {"Молоко", "Яйца", "Хлеб"};
        String[] actualSubtasks = epic.getProject();

        Assertions.assertArrayEquals(expectedSubtasks, actualSubtasks);

        //getters for Meeting
        String expectedTopic = "Выкатка 3й версии приложения";
        String actualTopic = meeting.getTopic();
        Assertions.assertEquals(expectedTopic, actualTopic);

        String expectedProject = "Приложение НетоБанка";
        String actualProject = meeting.getProject();
        Assertions.assertEquals(expectedProject, actualProject);


        String expectedStart = "Во вторник после обеда";
        String actualStart = meeting.getStart();
        Assertions.assertEquals(expectedStart, actualStart);
    }
}
