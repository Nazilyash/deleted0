package ru.netology.manager;

import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

public class AfishaManager {
    private AfishaRepository repository;
    private int movieCount = 10;

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public void setMovieCount(int movieCount) {
        this.movieCount = movieCount;
    }

    public void addToFeed(Movie movie) {
        repository.save(movie);
    }

    public Movie[] getMoviesFeed() {
        Movie[] movies = repository.findAll();
        if (movieCount > movies.length) {
            movieCount = movies.length;
        }
        Movie[] result = new Movie[movieCount];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
}
