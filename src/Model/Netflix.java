package Model;

import java.util.Date;
import java.util.Set;

public class Netflix {
    private String showId;
    private String type;
    private String title;
    private String director;
    private String cast;
    private Set<String> country;
    private Date dateAdded;
    private String releaseYear;
    private String rating;
    private String duration;
    private Set<String> listedIn;
    private String description;


    public Netflix(final String showId, final String type, final String title, final String director, final String cast, final Set<String> country, final Date dateAdded, final String releaseYear, final String rating, final String duration, final Set<String> listedIn, final String description) {
        this.showId = showId;
        this.type = type;
        this.title = title;
        this.director = director;
        this.cast = cast;
        this.country = country;
        this.dateAdded = dateAdded;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.duration = duration;
        this.listedIn = listedIn;
        this.description = description;
    }


    public String getShowId() {
        return showId;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getCast() {
        return cast;
    }

    public Set<String> getCountry() {
        return country;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public String getRating() {
        return rating;
    }

    public String getDuration() {
        return duration;
    }

    public Set<String> getListedIn() {
        return listedIn;
    }

    public String getDescription() {
        return description;
    }
    @Override
    public String toString() {
        return "Netflix{" +
                "showId='" + showId + '\'' +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", cast='" + cast + '\'' +
                ", country=" + country +
                ", dateAdded=" + dateAdded +
                ", releaseYear='" + releaseYear + '\'' +
                ", rating='" + rating + '\'' +
                ", duration='" + duration + '\'' +
                ", listedIn=" + listedIn +
                ", description='" + description + '\'' +
                '}';
    }

}
