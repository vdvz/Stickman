import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class FirstTest {


    private final RequestExecutor executor = new RequestExecutor();
    @Test
    void test(){
        assertEquals(null, executor.executeRequest(null));
    }



}
