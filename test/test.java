import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

public class test {

    @Test
    public void test() {
        UserOnlyBrokerIdDTO d1 = new UserOnlyBrokerIdDTO(1L, 1L);
        UserOnlyBrokerIdDTO d2 = new UserOnlyBrokerIdDTO(2L, 1L);
        List<UserOnlyBrokerIdDTO> list = Arrays.asList(d1, d2);
        Map<Long, Set<Long>> map = list.stream().collect(Collectors.groupingBy(UserOnlyBrokerIdDTO::getBrokerId, Collectors.mapping(UserOnlyBrokerIdDTO::getUserId, Collectors.toSet())));
        System.out.println(map);

    }
}
