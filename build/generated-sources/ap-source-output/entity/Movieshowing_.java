package entity;

import entity.Movie;
import entity.MovieshowingPK;
import entity.Theater;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-01-14T12:35:23")
@StaticMetamodel(Movieshowing.class)
public class Movieshowing_ { 

    public static volatile SingularAttribute<Movieshowing, Movie> movie;
    public static volatile SingularAttribute<Movieshowing, String> showtime;
    public static volatile SingularAttribute<Movieshowing, Theater> theater;
    public static volatile SingularAttribute<Movieshowing, MovieshowingPK> movieshowingPK;

}