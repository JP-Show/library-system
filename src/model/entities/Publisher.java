package model.entities;

import java.util.Objects;

public class Publisher {
	private Integer id;
	private String name;
	
	public Publisher() {
		
	}

	public Publisher(Integer id, String name) {
		this.id = id;
		this.name = name;
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
		Publisher other = (Publisher) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Publisher{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
