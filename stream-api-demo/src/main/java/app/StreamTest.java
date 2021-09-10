package app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import model.Person;

public class StreamTest {
    private static List<Person> list;

    static {
        list = new ArrayList<>();
        list.add(new Person("i", 18, "杭州", 999.9));
        list.add(new Person("am", 19, "温州", 777.7));
        list.add(new Person("iron", 21, "杭州", 888.8));
        list.add(new Person("iron", 17, "宁波", 888.8));
    }

    public static void main(String[] args) throws JsonProcessingException {
        System.out.println("===============>stream map demo<================");
        mapDemo();
        System.out.println("===============>stream filter demo<================");
        filterDemo();
    }

    private static void mapDemo() throws JsonProcessingException {
        List<String> personNames = list.stream()
                .map(person ->
                        person.getName() + " comes from " + person.getAddress()
                ).collect(Collectors.toList());
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(personNames));
    }

    private static void filterDemo() throws JsonProcessingException {
        List<Person> personList = list.stream()
                .filter(person -> person.getAge() >= 18)
                .collect(Collectors.toList());
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(personList));
    }
}
