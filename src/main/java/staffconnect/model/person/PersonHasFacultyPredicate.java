package staffconnect.model.person;

import java.util.function.Predicate;

import staffconnect.commons.util.ToStringBuilder;

/**
 * Tests that a {@code Person}'s {@code Faculty} matches the given faculty to filter for.
 */
public class PersonHasFacultyPredicate implements Predicate<Person> {
    private final Faculty faculty;

    public PersonHasFacultyPredicate(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public boolean test(Person person) {
        if (faculty == null) {
            return true;
        }
        return person.getFaculty().value.getFacultyName().equalsIgnoreCase(faculty.value.getFacultyName());
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof PersonHasFacultyPredicate)) {
            return false;
        }

        PersonHasFacultyPredicate otherPersonHasFacultyPredicate = (PersonHasFacultyPredicate) other;
        return faculty.equals(otherPersonHasFacultyPredicate.faculty);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("faculty", faculty).toString();
    }
}
