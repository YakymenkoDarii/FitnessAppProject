package fitnessappproject;

import javafx.beans.property.*;

public class ExerciseEntry {
    private final StringProperty exercise = new SimpleStringProperty();
    private final IntegerProperty sets     = new SimpleIntegerProperty();
    private final IntegerProperty reps     = new SimpleIntegerProperty();
    private final DoubleProperty  weight   = new SimpleDoubleProperty();

    public ExerciseEntry(String exercise, int sets, int reps, double weight) {
        this.exercise.set(exercise);
        this.sets.set(sets);
        this.reps.set(reps);
        this.weight.set(weight);
    }


    public StringProperty exerciseProperty() { return exercise; }
    public IntegerProperty setsProperty()    { return sets; }
    public IntegerProperty repsProperty()    { return reps; }
    public DoubleProperty weightProperty()   { return weight; }

    public void setExercise(String v) { exercise.set(v); }
    public void setSets(int v)        { sets.set(v); }
    public void setReps(int v)        { reps.set(v); }
    public void setWeight(double v)   { weight.set(v); }

    public String getExercise() {
        return exercise.get();
    }
}
