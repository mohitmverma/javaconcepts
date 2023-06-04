package collections;

import java.util.Objects;

public class StudentMarks implements Comparable<StudentMarks> {
    private int physics;
    private int maths;

    @Override
    public int compareTo(StudentMarks o) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentMarks that = (StudentMarks) o;
        return physics == that.physics && maths == that.maths;
    }

    @Override
    public int hashCode() {
        return Objects.hash(physics, maths);
    }
}
