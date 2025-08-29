package tourism.service;

import org.springframework.stereotype.Service;
import tourism.model.TouristAttraction;
import tourism.repository.TouristRepository;

import java.util.ArrayList;

@Service
public class TouristService {

    private final TouristRepository repository;

    public TouristService(TouristRepository repository) {
        this.repository = repository;
    }

    public ArrayList<TouristAttraction> getAllAttractions() {
        return repository.getAllAttractions();
    }

    public TouristAttraction getOneAttraction(String name) {
        return repository.getOneNamedAttraction(name);
    }

    public void addAttraction(TouristAttraction touristAttraction) {
        repository.addOneNamedAttractionToList(touristAttraction);
    }

    public void updateAttraction(TouristAttraction touristAttraction) {
        repository.updateOneNamedAttraction(touristAttraction);
    }

    public void deleteAttraction(String name) {
        repository.deleteOneNamedAttractionFromList(name);
    }
}
