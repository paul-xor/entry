package diaryentry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import diaryentry.model.Entry;
import diaryentry.service.EntryService;

@RestController
public class deRestController {
	@Autowired
	private EntryService entryService;

	@GetMapping("/hello")
	public String hello(){
		return "Hello from DiaryEntry!";
	}
	
	/*
	@GetMapping("/all-entries")
	public String allEntries(){
		return entryService.findAll().toString();
	}
	
	@GetMapping("/save-entry")
	public String saveEntry(@RequestParam String name, @RequestParam String info){
		Entry entry = new Entry(name,info);
		entryService.save(entry);
		return "Entry succesfully saved!";
	}
	
	@GetMapping("/delete-entry")
	public String saveEntry(@RequestParam int id){
		entryService.delete(id);
		return "Entry succesfully deleted!";
	}
	*/
}
