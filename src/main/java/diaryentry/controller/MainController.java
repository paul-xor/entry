package diaryentry.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import diaryentry.model.Entry;
import diaryentry.service.EntryService;

@Controller
public class MainController {
	
	@Autowired
	private EntryService entryService;
	
	@GetMapping("/")
	public String home(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME");
		return "index";
	}
	
	@GetMapping("/all-entries")
	public String allEntries(HttpServletRequest request){
		request.setAttribute("entries", entryService.findAll());
		request.setAttribute("mode", "MODE_ENTRIES");
		return "index";
	}
	
	/*
	@GetMapping("/all-tasks")
	public String allTasks(HttpServletRequest request){
		request.setAttribute("tasks", taskService.findAll());
		request.setAttribute("mode", "MODE_TASKS");
		return "index";
	}
	*/
	
	@GetMapping("/new-entry")
	public String newEntry(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW");
		return "index";
	}

	@PostMapping("/save-entry")
	public String saveEntry(@ModelAttribute Entry entry, BindingResult bindingResult, HttpServletRequest request){
		entryService.save(entry);
		request.setAttribute("entries", entryService.findAll());
		request.setAttribute("mode", "MODE_ENTRIES");
		return "index";
	}
	
	@GetMapping("/update-entry")
	public String updateEntry(@RequestParam int id, HttpServletRequest request){
		request.setAttribute("entry", entryService.findEntry(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "index";
	}
	
	@GetMapping("/delete-entry")
	public String deleteEntry(@RequestParam int id, HttpServletRequest request){
		entryService.delete(id);
		request.setAttribute("entries", entryService.findAll());
		request.setAttribute("mode", "MODE_ENTRIES");
		return "index";
	}
}
