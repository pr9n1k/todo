package app.entity;

public enum TaskStatus {
    ACTIVE("ACTIVE"),
    COMPLETED("COMPLETED");

    private final String label;


    TaskStatus(String status) {
        this.label = status;
    }

    public static TaskStatus customValueOf(String status){
        for (TaskStatus taskStatus: TaskStatus.values()){
            if (taskStatus.label.equalsIgnoreCase(status)) {
                return taskStatus;
            }
        }
        throw new IllegalArgumentException("Некорректный статус: " + status);
    }

}
