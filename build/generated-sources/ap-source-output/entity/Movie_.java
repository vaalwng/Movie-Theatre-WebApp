package entity;

import entity.Movieshowing;
import entity.Theater;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-01-14T12:35:23")
@StaticMetamodel(Movie.class)
public class Movie_ { 

    public static volatile CollectionAttribute<Movie, Movieshowing> movieshowingCollection;
    public static volatile CollectionAttribute<Movie, Theater> theaterCollection;
    public static volatile SingularAttribute<Movie, String> description;
    public static volatile SingularAttribute<Movie, Integer> movieid;
    public static volatile SingularAttribute<Movie, Integer> runningtime;
    public static volatile SingularAttribute<Movie, String> releaseyear;
    public static volatile SingularAttribute<Movie, String> moviename;

}