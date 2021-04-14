package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

public class AfishaRepositoryTest {
    private AfishaRepository repository = new AfishaRepository();
    private Movie first = new Movie("m1", "https://avatars.mds.yandex.net/get-afishanew/28638/1142a9000bc265840669b3461b2e53f1/s190x280", "Бладшот", "боевик");
    private Movie second = new Movie("m2", "https://avatars.mds.yandex.net/get-afishanew/28638/1142a9000bc265840669b3461b2e53f2/s190x280", "Вперед", "мультфильм");
    private Movie third = new Movie("m3", "https://avatars.mds.yandex.net/get-afishanew/28638/1142a9000bc265840669b3461b2e53f3/s190x280", "Отель 'Белград'", "комедия");
    private Movie fourth = new Movie("m4", "https://avatars.mds.yandex.net/get-afishanew/28638/1142a9000bc265840669b3461b2e53f4/s190x280", "Джентельмены", ",боевик");
    private Movie fifth = new Movie("m5", "https://avatars.mds.yandex.net/get-afishanew/28638/1142a9000bc265840669b3461b2e53f5/s190x280", "Человек-невидимка", "ужасы");
    private Movie sixth = new Movie("m6", "https://avatars.mds.yandex.net/get-afishanew/28638/1142a9000bc265840669b3461b2e53f6/s190x280", "Тролли.Мировой тур", "мультфильм");
    private Movie seventh = new Movie("m7", "https://avatars.mds.yandex.net/get-afishanew/28638/1142a9000bc265840669b3461b2e53f7/s190x280", "Номер один", "комедия");
    private Movie eighth = new Movie("m8", "https://avatars.mds.yandex.net/get-afishanew/28638/1142a9000bc265840669b3461b2e53f8/s190x280", "Мортал комбат", "фантастика");
    private Movie ninth = new Movie("m9", "https://avatars.mds.yandex.net/get-afishanew/28638/1142a9000bc265840669b3461b2e53f9/s190x280", "Годзилла против Конга", "триллер");


    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
        repository.save(eighth);
        repository.save(ninth);
    }

    @Test
    public void shouldFindAll() {
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSave() {
        Movie tenth = new Movie("m10", "https://avatars.mds.yandex.net/get-afishanew/28638/1142a9000bc265840669b3461b2e53f10/s190x280", "Майор Гром: Чумной Доктор", "детектив");
        repository.save(tenth);
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByIdIfExists() {
        String idToFind = "m7";
        Movie actual = repository.findById(idToFind);
        Movie expected = seventh;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindByIdIfNotExists() {
        String idToFind = "m17";
        Movie actual = repository.findById(idToFind);
        Movie expected = null;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdIfExists() {
        String idToRemove = "m1";
        repository.removeById(idToRemove);
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{second, third, fourth, fifth, sixth, seventh, eighth, ninth};
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldNotRemoveByIdIfNotExists() {
        String idToRemove = "m16";
        repository.removeById(idToRemove);
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAll() {
        Movie[] actual = repository.removeAll();
        Movie[] expected = new Movie[0];
        assertArrayEquals(expected, actual);
    }
}