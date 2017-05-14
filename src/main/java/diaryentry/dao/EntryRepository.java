package diaryentry.dao;

import org.springframework.data.repository.CrudRepository;

import diaryentry.model.Entry;

public interface EntryRepository extends CrudRepository<Entry, Integer> {

}
