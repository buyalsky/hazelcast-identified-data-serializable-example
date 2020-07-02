import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;

import java.util.Map;

public class Demo {

    public static void main(String[] args) {
        HazelcastInstance client = HazelcastClient.newHazelcastClient();
        Map<String, Employee> map = client.getMap("map");

        map.put("Emp1", new Employee("Peter", "Klabnik", 2000, "Hazelcast"));
        map.put("Emp2", new Employee("Kyle", "Alan", 2500, "CastHazel"));
        map.put("Emp3", new Employee("Carol", "Nichols", 3000, "Hazeljet"));

        client.shutdown();
    }
}