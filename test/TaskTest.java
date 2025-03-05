import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


@ExtendWith(MockitoExtension.class)
public class TaskTest {
    @Mock
    private Task task;

    @Mock
    private Memeber member;

    private Date beforeDate = new Date(2025, Calendar.DECEMBER, 30);

    private Date afterDate = new Date(2026, Calendar.JANUARY, 1);

    @BeforeEach
    void setUp() {
        task = new Task("task1", "desc", "Waiting", new Date(2025, Calendar.DECEMBER, 31));
        member = new Member(1, "Jack", new ArrayList<Task>());
    }

    @Test
    public void testAssignTo() {
        task.assignTo(member);

        assertEquals(member.getTasks().get(0), task);
    }

    @Test
    public void testUpdateStatus() {
        Task resultTask = task.updateStatus("Complete");

        assertEquals(task.getStatus(), resultTask.getStatus());
    }

    @Test void testIsOverDue() {
        boolean resultForBefore = task.isOverDue(beforeDate);
        boolean resultForAfter = task.isOverDue(afterDate);

        assertFalse(resultForBefore);
        assertTrue(resultForAfter);
    }
}