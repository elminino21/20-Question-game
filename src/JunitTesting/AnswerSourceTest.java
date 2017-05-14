package JunitTesting;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.necc.net.IA.database.AnswerSource;
import com.necc.net.IA.database.QuestionSource;

public class AnswerSourceTest {

	@Test
	public void test() {
		AnswerSource question = new AnswerSource();
		ResultSet result = question.desisplayQuestions();
		
		try {
			assertEquals(true, result.next());
			
			System.out.println(result.getString("ANSWER") + "   " + result.getInt("guessCorrectly")  );
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
