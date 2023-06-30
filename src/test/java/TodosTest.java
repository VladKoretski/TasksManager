import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.*;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    // Search testing

    //All tasks meet the query
    @Test
    public void shouldSearchAndFindTasks() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String[] subtasks = {"Позвонить", "Купить", "Заказать доставку"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Договориться о звонке",
                "Позвонить в НетоБанк",
                "Во вторник после обеда"
        );
        String query = "Позвонить";
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search(query);

        Assertions.assertArrayEquals(expected, actual);
    }

    // No one task meets the query
    @Test
    public void shouldSearchAndFindNoTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String[] subtasks = {"Позвонить", "Купить", "Заказать доставку"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Договориться о звонке",
                "Позвонить в НетоБанк",
                "Во вторник после обеда"
        );

        String query = "Посетить";
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search(query);

        Assertions.assertArrayEquals(expected, actual);
    }

    //simpleTask meets the query
    @Test
    public void shouldSearchFindSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String[] subtasks = {"Зайти", "Купить", "Заказать доставку"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Обсудить сроки",
                "CRM в НетоБанк",
                "Во вторник после обеда"
        );

        String query = "Позвонить";
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search(query);

        Assertions.assertArrayEquals(expected, actual);
    }

    //meeting meets the query (topic)
    @Test
    public void shouldSearchFindMeetingTopic() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String[] subtasks = {"Зайти", "Купить", "Заказать доставку"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Обсудить сроки",
                "CRM в НетоБанк",
                "Во вторник после обеда"
        );

        String query = "Обсудить";
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search(query);

        Assertions.assertArrayEquals(expected, actual);
    }

    //meeting meets the query (project)
    @Test
    public void shouldSearchFindMeetingProject() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String[] subtasks = {"Зайти", "Купить", "Заказать доставку"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Обсудить сроки",
                "CRM в НетоБанк",
                "Во вторник после обеда"
        );

        String query = "НетоБанк";
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search(query);

        Assertions.assertArrayEquals(expected, actual);
    }

    //epic meets the query
    @Test
    public void shouldSearchFindEpic() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String[] subtasks = {"Зайти", "Купить", "Заказать доставку"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Обсудить сроки",
                "CRM в НетоБанк",
                "Во вторник после обеда"
        );

        String query = "Купить";
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic};
        Task[] actual = todos.search(query);

        Assertions.assertArrayEquals(expected, actual);
    }

    //Two tasks among others meet the query - simpleTask and epic
    @Test
    public void shouldSearchFindSimpleTaskAndEpic() {

        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String[] subtasks = {"Позвонить", "Купить", "Заказать доставку"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Обсудить сроки",
                "CRM в НетоБанк",
                "Во вторник после обеда"
        );

        String query = "Позвонить";
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search(query);

        Assertions.assertArrayEquals(expected, actual);
    }

    //Two tasks among others meet the query - simpleTask and meeting
    @Test
    public void shouldSearchFindSimpleTaskAndMeeting() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить");
        String[] subtasks = {"Позвонить", "Договориться", "Заказать доставку"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Обсудить сроки",
                "Купить CRM в НетоБанк",
                "Во вторник после обеда"
        );

        String query = "Купить";
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, meeting};
        Task[] actual = todos.search(query);

        Assertions.assertArrayEquals(expected, actual);
    }

    //Two tasks among others meet the query - epic and meeting
    @Test
    public void shouldSearchFindEpicTaskAndMeeting() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String[] subtasks = {"Позвонить", "Купить", "Заказать доставку"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Обсудить сроки",
                "Купить CRM в НетоБанк",
                "Во вторник после обеда"
        );

        String query = "Купить";
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic, meeting};
        Task[] actual = todos.search(query);

        Assertions.assertArrayEquals(expected, actual);
    }
}
