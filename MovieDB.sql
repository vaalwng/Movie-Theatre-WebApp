/* MovieDB Database Tables*/

/*
drop table MovieTimes
drop table TheatresMovies
drop table Theatres
drop table Movies
*/

create table Theatres (
	theatreID int NOT NULL,					
	threatreName varchar(50),
	address varchar(50),
	zipcode char(5),
	primary key (theatreID)
);

create table Movies (
	movieID int NOT NULL,
	movieName varchar(50),
	description varchar(500),
	releaseYear char(4),
	runningTime int,
	primary key (movieID)
);

create table TheatresMovies (
	theatreID int NOT NULL,
	movieID int NOT NULL,
	primary key (theatreID, movieID),
	foreign key (theatreID) references Theatres (theatreID),
	foreign key (movieID) references Movies (movieID)
);

create table MovieTimes (
	theatreID int NOT NULL,
	movieID int NOT NULL,
	showtime char(7) NOT NULL,
	primary key (theatreID, movieID, showtime),
	foreign key (theatreID) references Theatres (theatreID),
	foreign key (movieID) references Movies (movieID)
);

insert into Theatres values (1, 'AMC Stonebriar 24', '2601 Preston Rd, Frisco, TX', '75034');
insert into Theatres values (2, 'Studio Movie Grill', '4800 TX-121, The Colony, TX', '75056');
insert into Theatres values (3, 'IPIC Theatres', '321 Town Pl, Fairview, TX', '75069');
insert into Theatres values (4, 'Highland Park Village Theatre', '32 Highland Park Village, Dallas, TX', '75205');

insert into Movies values (1, 'F9 The Fast Saga', 'Cipher enlists the help of Jakob, Dom's younger brother to take revenge on Dom and his team.', '2021', 143);
insert into Movies values (2, 'The Hitman's Wife's Bodyguard', 'The bodyguard Michael Bryce continues his friendship with assassin Darius Kincaid as they try to save Darius' wife Sonia.', '2021', 100);
insert into Movies values (3, 'A Quiet Place Part II', 'The Abbott family now face the terrors of the outside world as they are forced to venture into the unknown, they realize the creatures that hunt by sound are not the only threats lurking beyond the sand path.', '2020', 97);
insert into Movies values (4, 'Cruella', 'A live-action prequel feature film following a young Cruella de Vil.', '2021', 134);
insert into Movies values (5, 'Black Widow', 'A film about Natasha Romanoff in her quests between the films Civil War and Infinity War.', '2021', 133);
insert into Movies values (6, 'The Boss Baby: Family Business', 'The Templeton brothers have become adults and drifted away from each other, but a new boss baby with a cutting-edge approach is about to bring them together again - and inspire a new family business.', '2021', 107);
insert into Movies values (7, 'Raya and the Last Dragon', 'In a realm known as Kumandra, a re-imagined Earth inhabited by an ancient civilization, a warrior named Raya is determined to find the last dragon.', '2021', 107);
insert into Movies values (8, 'Demon Slayer the Movie: Mugen Train', 'After his family was brutally murdered and his sister turned into a demon, Tanjiro Kamado's journey as a demon slayer began. Tanjiro and his comrades embark on a new mission aboard the Mugen Train, on track to despair.', '2020', 117);
insert into Movies values (9, 'The House Next Door: Meet the Blacks 2', 'When best selling author Carl Black moves his family back to his childhood home, he must team up with oddball neighbors to do battle with a pimp, who may or may not be an actual vampire.', '2021', 97);
insert into Movies values (10, 'The Forever Purge', 'All the rules are broken as a sect of lawless marauders decides that the annual Purge does not stop at daybreak and instead should never end.', '2021', 103);

insert into TheatresMovies values (1, 1);
insert into TheatresMovies values (1, 2);
insert into TheatresMovies values (1, 3);
insert into TheatresMovies values (1, 4);
insert into TheatresMovies values (1, 5);
insert into TheatresMovies values (1, 6);
insert into TheatresMovies values (1, 7);
insert into TheatresMovies values (1, 8);
insert into TheatresMovies values (1, 9);
insert into TheatresMovies values (1, 10);
insert into TheatresMovies values (2, 1);
insert into TheatresMovies values (2, 3);
insert into TheatresMovies values (2, 5);
insert into TheatresMovies values (2, 7);
insert into TheatresMovies values (2, 9);
insert into TheatresMovies values (3, 2);
insert into TheatresMovies values (3, 4);
insert into TheatresMovies values (3, 6);
insert into TheatresMovies values (3, 8);
insert into TheatresMovies values (3, 10);
insert into TheatresMovies values (4, 1);
insert into TheatresMovies values (4, 3);
insert into TheatresMovies values (4, 6);
insert into TheatresMovies values (4, 9);


insert into MovieTimes values (1, 1, );
insert into MovieTimes values (1, 1, );
insert into MovieTimes values (1, 2, );
insert into MovieTimes values (1, 2, );
insert into MovieTimes values (1, 3, );
insert into MovieTimes values (1, 3, );
insert into MovieTimes values (1, 4, );
insert into MovieTimes values (1, 4, );
insert into MovieTimes values (1, 5, );
insert into MovieTimes values (1, 5, );
insert into MovieTimes values (1, 6, );
insert into MovieTimes values (1, 6, );
insert into MovieTimes values (1, 7, );
insert into MovieTimes values (1, 7, );
insert into MovieTimes values (1, 8, );
insert into MovieTimes values (1, 8, );
insert into MovieTimes values (1, 9, );
insert into MovieTimes values (1, 9, );
insert into MovieTimes values (1, 10, );
insert into MovieTimes values (1, 10, );
insert into MovieTimes values (2, 1, );
insert into MovieTimes values (2, 1, );
insert into MovieTimes values (2, 3, );
insert into MovieTimes values (2, 3, );
insert into MovieTimes values (2, 5, );
insert into MovieTimes values (2, 5, );
insert into MovieTimes values (2, 7, );
insert into MovieTimes values (2, 7, );
insert into MovieTimes values (2, 9, );
insert into MovieTimes values (2, 9, );
insert into MovieTimes values (3, 2, );
insert into MovieTimes values (3, 2, );
insert into MovieTimes values (3, 4, );
insert into MovieTimes values (3, 4, );
insert into MovieTimes values (3, 6, );
insert into MovieTimes values (3, 6, );
insert into MovieTimes values (3, 8, );
insert into MovieTimes values (3, 8, );
insert into MovieTimes values (3, 10, );
insert into MovieTimes values (3, 10, );
insert into MovieTimes values (4, 1, );
insert into MovieTimes values (4, 1, );
insert into MovieTimes values (4, 3, );
insert into MovieTimes values (4, 3, );
insert into MovieTimes values (4, 6, );
insert into MovieTimes values (4, 6, );
insert into MovieTimes values (4, 9, );
insert into MovieTimes values (4, 9, );

------------

/*
select bookTitle, authorName, numberOfPages
from Authors, Books, BooksAuthors 
where Books.ISBN = '1-43-024692-8'
    and BooksAuthors.ISBN = '1-43-024692-8'
    and Authors.AUTHORID = BooksAuthors.AUTHORID
*/