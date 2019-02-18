package com.skilldistillery.filmquery.database;

import java.nio.file.attribute.AclEntry.Builder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {

//	DB URL
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";

	@Override
	public Film findFilmById(int filmId) {

		try {
			String user = "student";
			String pass = "student";
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String maxfilmID = "SELECT id FROM film ORDER BY id DESC LIMIT 1";
			String sqltxt = "select id, release_year, rental_duration, rental_rate, length, replacement_cost, title, description, language_id, rating, special_features from film where id = ?";

			PreparedStatement ps2 = conn.prepareStatement(maxfilmID);
			ResultSet rs2 = ps2.executeQuery();
			while (rs2.next()) {
				int maxID = rs2.getInt(1);

				if (filmId > maxID || filmId <= 0) {
					return null;
				} else {
					PreparedStatement ps = conn.prepareStatement(sqltxt);
					ps.setInt(1, filmId);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						Film f = new Film();
						f.setId(rs.getInt(1));
						f.setReleaseYear(rs.getInt(2));
						f.setRentalDuration(rs.getInt(3));
						f.setRate(rs.getInt(4));
						f.setLength(rs.getDouble(5));
						f.setReplacementCost(rs.getDouble(6));
						f.setTitle(rs.getString(7));
						f.setDescription(rs.getString(8));
						f.setRating(rs.getString(10));
						f.setSpecialFeatures(rs.getString(11));
						return f;

					}
					rs.close();
					ps.close();
					conn.close();
				}
			}
		} catch (SQLException e) {
			System.out.println("Failed to retrieve movie from DB.");
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public Actor findActorById(int actorId) {
		try {
			String user = "student";
			String pass = "student";
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String maxActorID = "select id from actor order by id desc limit 1;";
			String sqltxt = "select id, first_name, last_name from actor where id = ?;";
			PreparedStatement ps2 = conn.prepareStatement(maxActorID);
			ResultSet rs2 = ps2.executeQuery();
			while (rs2.next()) {
				int maxID = rs2.getInt(1);
				if (actorId > maxID) {
					return null;
				} else {
					PreparedStatement ps = conn.prepareStatement(sqltxt);
					ps.setInt(1, actorId);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						Actor a = new Actor();
						a.setId(rs.getInt(1));
						a.setFirstName(rs.getString(2));
						a.setLastName(rs.getString(3));
						return a;
					}
					rs.close();
					ps.close();
					conn.close();
				}
			}
		} catch (SQLException e) {
			System.out.println("Failed to retrieve actor from DB.");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		// TODO Auto-generated method stub
		return null;
	}

}
