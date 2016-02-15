package java8.streams_2.exercises;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java8.testdata_0.Album;
import java8.testdata_0.Artist;

public class BasicStreamOperations_1 {
    // function that adds up numbers, i.e., int addUp(Stream<Integer> numbers)
    public static int addUp(Stream<Integer> numbers) {
        return numbers.mapToInt(s1->s1.intValue()).sum();
    }

    // function that takes in artists and returns a list of strings with their names and places of origin
    public static List<String> getNamesAndOrigins(List<Artist> artists) {
    	return artists.stream()
                .flatMap(artist -> Stream.of(artist.getName(), artist.getNationality()))
                .collect(toList());
    }

    // function that takes in albums and returns a list of albums with at most three
    // tracks
    public static List<Album> getAlbumsWithAtMostThreeTracks(List<Album> input) {
        return input //
        		.stream() //
        		.filter(a1->a1.getTracks().count()<4) //
        		.collect(Collectors.toList());
    }
}
