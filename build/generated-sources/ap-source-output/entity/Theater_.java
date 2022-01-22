package entity;

import entity.Movie;
import entity.Movieshowing;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-01-14T12:35:23")
@StaticMetamodel(Theater.class)
public class Theater_ { 

    public static volatile SingularAttribute<Theater, String> zipcode;
    public static volatile SingularAttribute<Theater, String> theatername;
    public static volatile SingularAttribute<Theater, String> address;
    public static volatile CollectionAttribute<Theater, Movie> movieCollection;
    public static volatile CollectionAttribute<Theater, Movieshowing> movieshowingCollection;
    public static volatile SingularAttribute<Theater, Integer> theaterid;

}