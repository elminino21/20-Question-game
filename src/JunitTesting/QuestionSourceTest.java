package JunitTesting;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.necc.net.IA.database.QuestionSource;

public class QuestionSourceTest {

	@Test
	public void test() {
		
		QuestionSource question = new QuestionSource();
		ResultSet result = question.desisplayQuestions();
		
		try {
			assertEquals(true, result.next());
			
			System.out.println(result.getString("QUESTION") + "   " + result.getInt("randomlyGeneraded")  );
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
