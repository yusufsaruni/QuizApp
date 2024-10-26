package harmo.projects.dao;

import harmo.projects.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
    List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM question q WHERE q.difficultyLevel=:level ORDER BY RANDOM() LIMIT:numQ", nativeQuery = true)
    List<Question> findByDifficultyLevel(String level, int numQ);
}
