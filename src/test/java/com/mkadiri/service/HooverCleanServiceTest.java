package test.java.service;

import com.mkadiri.exception.InvalidDirectionException;
import com.mkadiri.model.HooverDetailsInput;
import com.mkadiri.service.HooverCleanService;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.when;

public class HooverCleanServiceTest {

    @Autowired
    private HooverCleanService hooverCleanService;

    public void test_invalidDirection() throws InvalidDirectionException {
        HooverDetailsInput hooverDetailsInput = Mockito.mock(HooverDetailsInput.class);
        this.hooverCleanService.clean(hooverDetailsInput);
    }
}
