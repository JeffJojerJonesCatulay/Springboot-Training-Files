package class3;

import org.springframework.beans.factory.annotation.Autowired;

public class Student {
	private Course course;

	public Course getCourse() {
		return course;
	}

	@Autowired
	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Student [course=" + course + "]";
	}
}
