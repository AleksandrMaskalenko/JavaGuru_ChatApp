package lv.javaguru.Commands;

import lv.javaguru.Domain.Talks;

import java.util.List;


public interface TalksDAO {
    void  createTalks();
    List<Talks> getTalks();
}
