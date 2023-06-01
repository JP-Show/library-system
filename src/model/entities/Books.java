package model.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public final class Books implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String des;
	private String genre;
	private String publisher;
	private LocalDate publication_date;

	private Author author;

	public Books() {
	}

	public Books(Integer id, String name, String des, String genre, String publisher, LocalDate publication_date,
			Author author) {
		this.id = id;
		this.name = name;
		this.des = des;
		this.genre = genre;
		this.publisher = publisher;
		this.publication_date = publication_date;
		this.author = author;
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

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public LocalDate getPublication_date() {
		return publication_date;
	}

	public void setPublication_date(LocalDate publication_date) {
		this.publication_date = publication_date;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
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
		Books other = (Books) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Books [id=" + id + ", name=" + name + ", des=" + des + ", genre=" + genre + ", publisher=" + publisher
				+ ", publication_date=" + publication_date + ", author=" + author + "]";
	}

}
