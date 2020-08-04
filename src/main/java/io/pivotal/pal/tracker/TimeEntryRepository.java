package io.pivotal.pal.tracker;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeEntryRepository {

    TimeEntry create(TimeEntry timeEntry);
    void delete(long id);
    TimeEntry find(long id);
    TimeEntry update(long id, TimeEntry timeEntry);
    List<TimeEntry> list();

}
