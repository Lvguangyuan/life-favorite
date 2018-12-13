package top.grandma.lifefavorite.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloWorldTest {


    @Test
    public void test01() {
        List<String> stringList = new ArrayList<>();
        stringList.add("Apple");
        stringList.add("Banana");
        stringList.add("Peach");

        Stream.iterate(0, i -> i+1).limit(stringList.size()).forEach(i -> {
            System.out.println(i);
            System.out.println(stringList.get(i));
            System.out.println("----------");
        });
    }

    @Test
    public void test02() {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(8);
        list.add(12);

        int value;
        for (int i = 0; i < list.size(); i++) {
            value = list.get(i);
            if (value < 5) {
                System.out.println("less then 5");
            } else if (value < 10) {
                System.out.println("less then 10");
            } else {
                System.out.println("less then 15");
            }
        }
    }
}
