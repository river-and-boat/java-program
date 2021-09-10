package app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.MyList;
import model.Person;

public class MockStream {

    public static void main(String[] args) throws JsonProcessingException {
        MyList<Person> personMyList = new MyList<>();
        personMyList.add(new Person("i", 18, "杭州", 999.9));
        personMyList.add(new Person("am", 19, "温州", 777.7));
        personMyList.add(new Person("iron", 21, "杭州", 888.8));
        personMyList.add(new Person("iron", 17, "宁波", 888.8));

        MyList<String> result = personMyList
                .filter(person -> person.getAge() > 19)
                .map(Person::toString);

        prettyPrint(result.getList());
    }

    private static void prettyPrint(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(
                objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj)
        );
    }
}
