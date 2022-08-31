package dev.terry.score;

import dev.terry.entities.Score;
import dev.terry.repos.ScoreRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional // any CRUD operations will not persist outside
public class ScoreRepoTests {

    @Autowired
    ScoreRepo scoreRepo;

    @Test
    void add_score(){
        Score savedScore = this.scoreRepo.save(new Score(0, 1000, "AAA"));
        Assertions.assertNotEquals(0, savedScore.getId());
    }

    @Test
    void all_scores(){
        this.scoreRepo.save(new Score(0, 1000, "AAA"));
        this.scoreRepo.save(new Score(0, 1000, "BBB"));
        this.scoreRepo.save(new Score(0, 1000, "CCC"));

        List<Score> scores = this.scoreRepo.findAll();

        Assertions.assertEquals(5, scores.size());
    }
}
