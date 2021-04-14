package ru.netology.manager;

import ru.netology.domain.Movie;

public class AfishaManager {

    private Movie[] movies = new Movie[0];
    private int moviesAmountInFeed = 10;

    public Movie[] getMovies() {
        return movies;
    }

    public void setMoviesAmountInFeed(int moviesAmountInFeed) {
        this.moviesAmountInFeed = moviesAmountInFeed;
    }

    public void addToFeed(Movie movie) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public Movie[] showMoviesFeed() {
        if (moviesAmountInFeed > movies.length) {
            moviesAmountInFeed = movies.length;
        }
        Movie[] result = new Movie[moviesAmountInFeed];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
}
