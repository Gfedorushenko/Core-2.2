import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10; i++) {//_000_000
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        long count=persons.stream()
                .filter(x -> x.getAge() < 18)
                .count();
        System.out.println("Число несовершеннолетних "+count);

        List<String> сonscripts=persons.stream()
                .filter(x -> x.getAge() >= 18)
                .filter(x -> x.getAge() <= 27)
                .map(x -> x.getFamily())
                .collect(Collectors.toList());
        //System.out.println(сonscripts.get(0));

        List<String> employees=persons.stream()
                .filter(x -> x.getAge() >= 18)
                .filter(x -> x.getAge() < 60 && x.getSex()==Sex.WOMAN || x.getAge() < 65 && x.getSex()==Sex.MAN)
                .map(x -> x.getFamily())
                .collect(Collectors.toList());
        //System.out.println(employees.get(0));

    }
}