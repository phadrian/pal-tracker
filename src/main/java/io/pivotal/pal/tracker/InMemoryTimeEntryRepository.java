package io.pivotal.pal.tracker;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private long sequence;
    private final Map<Long, TimeEntry> repository;

    public InMemoryTimeEntryRepository() {
        this.sequence = 0;
        this.repository = new HashMap<>();
    }

    private long getNextSequence() {
        return ++sequence;
    }

    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(getNextSequence());
        repository.put(timeEntry.getId(), timeEntry);
        return timeEntry;
    }

    public void delete(long id) {
        repository.remove(id);
    }

    public TimeEntry find(long id) {
        return repository.get(id);
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        if (repository.containsKey(id)) {
            timeEntry.setId(id);
            repository.put(id, timeEntry);
            return timeEntry;
        } else {
            return null;
        }
    }

    public List<TimeEntry> list() {
        return new ArrayList<>(repository.values());
    }
}
