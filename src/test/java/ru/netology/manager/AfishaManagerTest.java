package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AfishaManagerTest {
    @Mock
    private AfishaRepository repository;
    @InjectMocks
    private AfishaManager manager=new AfishaManager(repository);
    private Movie first = new Movie("m1", "https://avatars.mds.yandex.net/get-afishanew/28638/1142a9000bc265840669b3461b2e53f1/s190x280", "Бладшот", "боевик");
    private Movie second = new Movie("m2", "https://avatars.mds.yandex.net/get-afishanew/28638/1142a9000bc265840669b3461b2e53f2/s190x280", "Вперед", "мультфильм");
    private Movie third = new Movie("m3", "https://avatars.mds.yandex.net/get-afishanew/28638/1142a9000bc265840669b3461b2e53f3/s190x280", "Отель 'Белград'", "комедия");
    private Movie fourth = new Movie("m4", "https://avatars.mds.yandex.net/get-afishanew/28638/1142a9000bc265840669b3461b2e53f4/s190x280", "Джентельмены", ",боевик");
    private Movie fifth = new Movie("m5", "https://avatars.mds.yandex.net/get-afishanew/28638/1142a9000bc265840669b3461b2e53f5/s190x280", "Человек-невидимка", "ужасы");
    private Movie sixth = new Movie("m6", "https://avatars.mds.yandex.net/get-afishanew/28638/1142a9000bc265840669b3461b2e53f6/s190x280", "Тролли.Мировой тур", "мультфильм");
    private Movie seventh = new Movie("m7", "https://avatars.mds.yandex.net/get-afishanew/28638/1142a9000bc265840669b3461b2e53f7/s190x280", "Номер один", "комедия");
    private Movie eighth = new Movie("m8", "https://avatars.mds.yandex.net/get-afishanew/28638/1142a9000bc265840669b3461b2e53f8/s190x280", "Мортал комбат", "фантастика");
    private Movie ninth = new Movie("m9", "https://avatars.mds.yandex.net/get-afishanew/28638/1142a9000bc265840669b3461b2e53f9/s190x280", "Годзилла против Конга", "триллер");
    private Movie tenth = new Movie("m10", "https://avatars.mds.yandex.net/get-afishanew/28638/1142a9000bc265840669b3461b2e53f9/s190x280", "Майор Гром: Чумной Доктор", "детектив");
    private Movie eleventh = new Movie("m11", "https://avatars.mds.yandex.net/get-afishanew/28638/1142a9000bc265840669b3461b2e53f11/s190x280", "Ночь в музее", "семейный");


    @Test
    public void shouldCheckAdding() {
        doNothing().when(repository).save(first);
        manager.addToFeed(first);
        verify(repository).save(first);
    }

    @Test
    public void shouldCheckShowFeedForMoviesAmountInFeedIs10AndMoviesAreActually10() {
        Movie[] returned = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        doReturn(returned).when(repository).findAll();
        Movie[] actual = manager.getMoviesFeed();
        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    public void shouldCheckShowFeedForMoviesAmountInFeedIs10ButMoviesAreMoreThan10() {
        Movie[] returned = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
        doReturn(returned).when(repository).findAll();
        Movie[] actual = manager.getMoviesFeed();
        Movie[] expected = new Movie[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    public void shouldCheckShowFeedForMoviesAmountInFeedIs10ButMoviesAreLess10() {
        Movie[] returned = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth};
        doReturn(returned).when(repository).findAll();
        Movie[] actual = manager.getMoviesFeed();
        Movie[] expected = new Movie[]{ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }
}