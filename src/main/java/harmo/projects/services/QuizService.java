package harmo.projects.services;

import harmo.projects.dao.QuestionDao;
import harmo.projects.dao.QuizDao;
import harmo.projects.models.Question;
import harmo.projects.models.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;


    public ResponseEntity<String> createQuiz(int numQ, String level) {
        List<Question> questionList = questionDao.findByDifficultyLevel(level, numQ);
        Quiz quiz = new Quiz();
        quiz.setLevel(level);
        quiz.setQuestions(questionList);

        quizDao.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
}
