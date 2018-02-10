package com.abhi.schlum.model;

public class Game {

	private Integer id;
	private String title;
	private String url;
	private String platform;
	private Float score;
	private String genre;
	private Boolean editors_choice ;
	private Integer release_year;
	public Integer getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Game [id=" + id + ", title=" + title + ", url=" + url + ", platform=" + platform + ", score=" + score
				+ ", genre=" + genre + ", editors_choice=" + editors_choice + ", release_year=" + release_year + "]";
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public Float getScore() {
		return score;
	}
	public void setScore(Float score) {
		this.score = score;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Boolean getEditors_choice() {
		return editors_choice;
	}
	public void setEditors_choice(Boolean editors_choice) {
		this.editors_choice = editors_choice;
	}
	public Integer getRelease_year() {
		return release_year;
	}
	public void setRelease_year(Integer release_year) {
		this.release_year = release_year;
	}
	
}
