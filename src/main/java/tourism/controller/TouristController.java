package tourism.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tourism.model.TouristAttraction;
import tourism.service.TouristService;

import java.util.ArrayList;

@Controller
@RequestMapping("/attractions")
public class TouristController {

    private final TouristService service;

    public TouristController(TouristService service) {
        this.service = service;
    }

    // GET /attractions
    @GetMapping
    public ResponseEntity<ArrayList<TouristAttraction>> getAllAttractions() {
        return ResponseEntity.ok(service.getAllAttractions());
    }

    // GET /attractions/{name}
    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> getAttractionByName(@PathVariable String name) {
        TouristAttraction touristAttraction = service.getOneAttraction(name);
        if (touristAttraction != null) return ResponseEntity.ok(touristAttraction);
        return ResponseEntity.notFound().build();
    }

    // POST /attractions/add
    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> addAttraction(@RequestBody TouristAttraction touristAttraction) {
        service.addAttraction(touristAttraction);
        return ResponseEntity.ok(touristAttraction);
    }

    // POST /attractions/update
    @PostMapping("/update")
    public ResponseEntity<TouristAttraction> updateAttraction(@RequestBody TouristAttraction touristAttraction) {
        service.updateAttraction(touristAttraction);
        return ResponseEntity.ok(touristAttraction);
    }

    // POST /attractions/delete/{currentName}
    @PostMapping("/delete/{currentName}")
    public ResponseEntity<String> deleteAttraction(@PathVariable String currentName) {
        service.deleteAttraction(currentName);
        return ResponseEntity.ok("Attraction deleted");
    }
}
