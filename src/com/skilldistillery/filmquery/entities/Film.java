package com.skilldistillery.filmquery.entities;

import java.util.ArrayList;

public class Film {
//	values
	private int id, releaseYear, rentalDuration;
	private double rate, length, replacementCost;
	private String title, description, language, rating, specialFeatures;
	private ArrayList<Actor> cast = new ArrayList<>();

//	Constructors
	public Film(int id, int releaseYear, int rentalDuration, double rate, double length, double replacementCost,
			String title, String description, String language, String rating, String specialFeatures) {
		super();
		this.id = id;
		this.releaseYear = releaseYear;
		this.rentalDuration = rentalDuration;
		this.rate = rate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.title = title;
		this.description = description;
		this.language = language;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
	}

	public Film() {
		super();
		this.id = 0;
		this.releaseYear = 0;
		this.rentalDuration = 0;
		this.rate = 0.0;
		this.length = 0.0;
		this.replacementCost = 0.0;
		this.title = null;
		this.description = null;
		this.language = null;
		this.rating = null;
		this.specialFeatures = null;
		this.cast = null;
	}

//	getters & setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public ArrayList<Actor> getCast() {
		return cast;
	}

	public void setCast(ArrayList<Actor> cast) {
		this.cast = cast;
	}

//	# & Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cast == null) ? 0 : cast.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		long temp;
		temp = Double.doubleToLongBits(length);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(rate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + releaseYear;
		result = prime * result + rentalDuration;
		temp = Double.doubleToLongBits(replacementCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((specialFeatures == null) ? 0 : specialFeatures.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (cast == null) {
			if (other.cast != null)
				return false;
		} else if (!cast.equals(other.cast))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (Double.doubleToLongBits(length) != Double.doubleToLongBits(other.length))
			return false;
		if (Double.doubleToLongBits(rate) != Double.doubleToLongBits(other.rate))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (releaseYear != other.releaseYear)
			return false;
		if (rentalDuration != other.rentalDuration)
			return false;
		if (Double.doubleToLongBits(replacementCost) != Double.doubleToLongBits(other.replacementCost))
			return false;
		if (specialFeatures == null) {
			if (other.specialFeatures != null)
				return false;
		} else if (!specialFeatures.equals(other.specialFeatures))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String castList = "";
		for (int i = 0; i < cast.size(); i++) {
			castList+=(this.cast.get(i).getFirstName() + " " + this.cast.get(i).getLastName()+", ");
		}
		return "Film ID " + id + ", title " + title + ", rated " + rating + " was released in " + releaseYear
				+ ". \nIts description reads: " + description + ", language: " + language + "\nStaring: "+castList;

	}

}
