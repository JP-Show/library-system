package model.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Author implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private LocalDate born;
	private LocalDate died;

	private List<Books> list = new ArrayList<>();

	public Author() {

	}

	public Author(Integer id, String name, LocalDate born, LocalDate died, List<Books> list) {
		this.id = id;
		this.name = name;
		this.born = born;
		this.died = died;
		this.list = list;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBorn() {
		return born;
	}

	public void setBorn(LocalDate born) {
		this.born = born;
	}

	public LocalDate getDied() {
		return died;
	}

	public void setDied(LocalDate died) {
		this.died = died;
	}

	public List<Books> getList() {
		return list;
	}

	public void addList(Books book) {
		list.add(book);
	}

	public void removeList(Books book) {
		list.remove(book);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		return Objects.equals(id, other.id);
	}

}
