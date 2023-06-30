package ru.netology;

public class Epic extends Task {
    private final String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    public String[] getProject() {
        return subtasks;
    }

    @Override
    public boolean matches(String query) {
        for (int i = 0; i < subtasks.length; i++)
            if (subtasks[i].contains(query)) {
                return true;
            }
        return false;
    }
}
