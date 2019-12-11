package org.acme.model;

import java.util.List;

public class OpenWeatherResource {

	private Coord coord;
	private List<Weather> weather;
	private String base;
	private Main main;
	private int visibility;
	private Wind wind;
	private Clouds clouds;
	private int dt;
	private Sys sys;
	private int timezone;
	private int id;
	private String name;
	private int cod;

	public OpenWeatherResource() {
	}

	public void setCoord(Coord coord) {
		this.coord = coord;
	}

	public Coord getCoord() {
		return this.coord;
	}

	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

	public List<Weather> getWeather() {
		return this.weather;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getBase() {
		return this.base;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public Main getMain() {
		return this.main;
	}

	public void setVisibility(int visibility) {
		this.visibility = visibility;
	}

	public int getVisibility() {
		return this.visibility;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public Wind getWind() {
		return this.wind;
	}

	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}

	public Clouds getClouds() {
		return this.clouds;
	}

	public void setDt(int dt) {
		this.dt = dt;
	}

	public int getDt() {
		return this.dt;
	}

	public void setSys(Sys sys) {
		this.sys = sys;
	}

	public Sys getSys() {
		return this.sys;
	}

	public void setTimezone(int timezone) {
		this.timezone = timezone;
	}

	public int getTimezone() {
		return this.timezone;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public int getCod() {
		return this.cod;
	}

	public static class Coord {
		private double lon;
		private double lat;

		public Coord() {
		}

		public void setLon(double lon) {
			this.lon = lon;
		}

		public double getLon() {
			return this.lon;
		}

		public void setLat(double lat) {
			this.lat = lat;
		}

		public double getLat() {
			return this.lat;
		}
	}

	public static class Weather {
		private int id;
		private String main;
		private String description;
		private String icon;

		public Weather() {
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getId() {
			return this.id;
		}

		public void setMain(String main) {
			this.main = main;
		}

		public String getMain() {
			return this.main;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getDescription() {
			return this.description;
		}

		public void setIcon(String icon) {
			this.icon = icon;
		}

		public String getIcon() {
			return this.icon;
		}
	}

	public static class Main {
		private Double temp;
		private int pressure;
		private int humidity;
		private double temp_min;
		private double temp_max;
		private int sea_level;
		private int grnd_level;

		public Main() {
		}

		public int getSea_level() {
			return sea_level;
		}

		public void setSea_level(int sea_level) {
			this.sea_level = sea_level;
		}

		public int getGrnd_level() {
			return grnd_level;
		}

		public void setGrnd_level(int grnd_level) {
			this.grnd_level = grnd_level;
		}

		public void setTemp(Double temp) {
			this.temp = temp;
		}

		public Double getTemp() {
			return this.temp;
		}

		public void setPressure(int pressure) {
			this.pressure = pressure;
		}

		public int getPressure() {
			return this.pressure;
		}

		public void setHumidity(int humidity) {
			this.humidity = humidity;
		}

		public int getHumidity() {
			return this.humidity;
		}

		public void setTemp_min(double temp_min) {
			this.temp_min = temp_min;
		}

		public double getTemp_min() {
			return this.temp_min;
		}

		public void setTemp_max(double temp_max) {
			this.temp_max = temp_max;
		}

		public double getTemp_max() {
			return this.temp_max;
		}
	}

	public static class Wind {
		private double speed;
		private int deg;

		public Wind() {
		}

		public void setSpeed(double speed) {
			this.speed = speed;
		}

		public double getSpeed() {
			return this.speed;
		}

		public void setDeg(int deg) {
			this.deg = deg;
		}

		public int getDeg() {
			return this.deg;
		}
	}

	public static class Clouds {
		private int all;

		public Clouds() {
		}

		public Clouds(int all) {
			this.all = all;
		}

		public void setAll(int all) {
			this.all = all;
		}

		public int getAll() {
			return this.all;
		}
	}

	public static class Sys {
		private int type;
		private int id;
		private String country;
		private int sunrise;
		private int sunset;

		public Sys() {
		}

		public void setType(int type) {
			this.type = type;
		}

		public int getType() {
			return this.type;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getId() {
			return this.id;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getCountry() {
			return this.country;
		}

		public void setSunrise(int sunrise) {
			this.sunrise = sunrise;
		}

		public int getSunrise() {
			return this.sunrise;
		}

		public void setSunset(int sunset) {
			this.sunset = sunset;
		}

		public int getSunset() {
			return this.sunset;
		}
	}

}
