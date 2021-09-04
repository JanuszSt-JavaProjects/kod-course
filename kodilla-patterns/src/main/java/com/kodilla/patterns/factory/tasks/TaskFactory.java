package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public static final String DRIVING = "DRIVING";
    public static final String PAINTING = "PAINTING";
    public static final String SHOPPING = "SHOPPING";

    public final Task createTask(final String taskType) {

        switch (taskType) {
            case DRIVING:
                return new DrivingTask("Fast drive", "Oklahoma City", "Car");
            case PAINTING:
                return new PaintingTask("Every hall paint", "GREY", "hall");
            case SHOPPING:
                return new ShoppingTask("Accessories Buy", "Paints", 50.00);
            default:
//                return null;
                throw new IllegalStateException("Unexpected value: " + taskType);  //<- jak to przetestować ?
        }
    }

}
