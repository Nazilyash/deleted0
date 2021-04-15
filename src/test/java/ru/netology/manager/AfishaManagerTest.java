package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class AfishaManagerTest {
    private Movie first = new Movie("m1", "https://avatars.mds.yandex.net/get-afishanew/28638/1142a9000bc265840669b3461b2e53f1/s190x280", "Бладшот", "боевик");
    private Movie second = new Movie("m2", "https://avatars.mds.yandex.net/get-afishanew/28638/1142a9000bc265840669b3461b2e53f2/s190x280", "Вперед", "мультфильм");
    private Movie third = new Movie("m3", "https://avatars.mds.yandex.net/get-afishanew/28638/1142a9000bc265840669b3461b2e53f3/s190x280", "Отель 'Белград'", "комедия");
    private Movie fourth = new Movie("m4", "https://avatars.mds.yandex.net/get-afishanew/28638/1142a9000bc265840669b3461b2e53f4/s190x280", "Джентельмены", ",боевик");
    private Movie fifth = new Movie("m5", "https://avatars.mds.yandex.net/get-afishanew/28638/1142a9000bc265840669b3461b2e53f5/s190x280", "Человек-невидимка", "ужасы");
    private Movie sixth = new Movie("m6", "https://avatars.mds.yandex.net/get-afishanew/28638/1142a9000bc265840669b3461b2e53f6/s190x280", "Тролли.Мировой тур", "мультфильм");
    private Movie seventh = new Movie("m7", "https://avatars.mds.yandex.net/get-afishanew/28638/1142a9000bc265840669b3461b2e53f7/s190x280", "Номер один", "комедия");
    private Movie eighth = new Movie("m8", "https://avatars.mds.yandex.net/get-afishanew/28638/1142a9000bc265840669b3461b2e53f8/s190x280", "Мортал комбат", "фантастика");
    private Movie ninth = new Movie("m9", "https://avatars.mds.yandex.net/get-afishanew/28638/1142a9000bc265840669b3461b2e53f9/s190x280", "Годзилла против Конга", "триллер");
    private Movie tenth = new Movie("m10", "https://avatars.mds.yandex.net/get-afishanew/28638/1142a9000bc265840669b3461b2e53f10/s190x280", "Майор Гром: Чумной Доктор", "детектив");
    private Movie eleventh = new Movie("m11", "https://avatars.mds.yandex.net/get-afishanew/28638/1142a9000bc265840669b3461b2e53f11/s190x280", "Ночь в музее", "семейный");


    @Test
    public void shouldCheckAdding() {
        AfishaManager manager = new AfishaManager();
        manager.addToFeed(first);
        manager.addToFeed(second);
        manager.addToFeed(third);
        manager.addToFeed(fourth);
        manager.addToFeed(fifth);
        manager.addToFeed(sixth);
        manager.addToFeed(seventh);
        manager.addToFeed(eighth);
        manager.addToFeed(ninth);
        Movie[] actual = manager.getMovies();
        Movie[] expected = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCheckShowFeedForMoviesAmountInFeedIs10AndMoviesAreActually10() {
        AfishaManager manager = new AfishaManager();
        manager.addToFeed(first);
        manager.addToFeed(second);
        manager.addToFeed(third);
        manager.addToFeed(fourth);
        manager.addToFeed(fifth);
        manager.addToFeed(sixth);
        manager.addToFeed(seventh);
        manager.addToFeed(eighth);
        manager.addToFeed(ninth);
        manager.addToFeed(tenth);
        Movie[] actual = manager.showMoviesFeed();
        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCheckShowFeedForMoviesAmountInFeedIs10ButMoviesAreMoreThan10() {
        AfishaManager manager = new AfishaManager();
        manager.addToFeed(first);
        manager.addToFeed(second);
        manager.addToFeed(third);
        manager.addToFeed(fourth);
        manager.addToFeed(fifth);
        manager.addToFeed(sixth);
        manager.addToFeed(seventh);
        manager.addToFeed(eighth);
        manager.addToFeed(ninth);
        manager.addToFeed(tenth);
        manager.addToFeed(eleventh);
        Movie[] actual = manager.showMoviesFeed();
        Movie[] expected = new Movie[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCheckShowFeedForMoviesAmountInFeedIs10ButMoviesAreLess10() {
        AfishaManager manager = new AfishaManager();
        manager.addToFeed(first);
        manager.addToFeed(second);
        manager.addToFeed(third);
        manager.addToFeed(fourth);
        manager.addToFeed(fifth);
        manager.addToFeed(sixth);
        manager.addToFeed(seventh);
        manager.addToFeed(eighth);
        manager.addToFeed(ninth);
        Movie[] actual = manager.showMoviesFeed();
        Movie[] expected = new Movie[]{ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCheckShowFeedForMoviesAmountInFeedNot10AndMoviesAreEqualMoviesAmountInFeed() {
        AfishaManager manager = new AfishaManager(9);
        manager.addToFeed(first);
        manager.addToFeed(second);
        manager.addToFeed(third);
        manager.addToFeed(fourth);
        manager.addToFeed(fifth);
        manager.addToFeed(sixth);
        manager.addToFeed(seventh);
        manager.addToFeed(eighth);
        manager.addToFeed(ninth);
        Movie[] actual = manager.showMoviesFeed();
        Movie[] expected = new Movie[]{ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCheckShowFeedForMoviesAmountInFeedNot10AndMoviesAreMoreThanMoviesAmountInFeed() {
        AfishaManager manager = new AfishaManager(5);
        manager.addToFeed(first);
        manager.addToFeed(second);
        manager.addToFeed(third);
        manager.addToFeed(fourth);
        manager.addToFeed(fifth);
        manager.addToFeed(sixth);
        manager.addToFeed(seventh);
        manager.addToFeed(eighth);
        manager.addToFeed(ninth);
        Movie[] actual = manager.showMoviesFeed();
        Movie[] expected = new Movie[]{ninth, eighth, seventh, sixth, fifth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCheckShowFeedForMoviesAmountInFeedIsNot10AndMoviesAreLessThanMoviesAmountInFeed() {
        int MoviesAmountInFeed = 11;
        AfishaManager manager = new AfishaManager(11);
        manager.addToFeed(first);
        manager.addToFeed(second);
        manager.addToFeed(third);
        manager.addToFeed(fourth);
        manager.addToFeed(fifth);
        manager.addToFeed(sixth);
        manager.addToFeed(seventh);
        manager.addToFeed(eighth);
        manager.addToFeed(ninth);
        manager.addToFeed(tenth);
        Movie[] actual = manager.showMoviesFeed();
        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }
}