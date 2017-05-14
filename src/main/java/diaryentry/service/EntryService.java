package diaryentry.service;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import diaryentry.dao.EntryRepository;
import diaryentry.model.Entry;

@Service
@Transactional
public class EntryService {
	
	private final EntryRepository entryRepository;

	public EntryService(EntryRepository entryRepository) {
		this.entryRepository = entryRepository;
	}
	
	public List<Entry> findAll(){
		List<Entry> entries = new ArrayList<>();
		for(Entry entry : entryRepository.findAll()){
			entries.add(entry);
		}		
		return entries;
	}
	
	public Entry findEntry(int id){
		return entryRepository.findOne(id);
	}
	
	public void save(Entry entry){
		entryRepository.save(entry);
	}
	
	public void delete(int id){
		entryRepository.delete(id);
	}
	
	
}
