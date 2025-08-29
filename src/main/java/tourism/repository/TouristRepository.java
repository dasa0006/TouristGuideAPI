package tourism.repository;

import org.springframework.stereotype.Repository;
import tourism.model.TouristAttraction;

import java.util.ArrayList;


@Repository
public class TouristRepository {

    private ArrayList<TouristAttraction> attractions;

    TouristRepository(){
        attractions = new ArrayList<>();

        // Data for fake database (navn, beskrivelse)
        String[][] data = {
                {"Tivoli", "Forlystelsespark i hjertet af København."},
                {"Nyhavn", "Farverig havnepromenade med restauranter og barer."},
                {"Den Lille Havfrue", "Berømt statue inspireret af H.C. Andersen."},
                {"ARoS", "Kunstmuseum i Aarhus med regnbuepanorama."},
                {"Egeskov Slot", "Renæssanceslot på Fyn omgivet af voldgrav."},
                {"Aalborg Zoo", "Dyrepark med mere end 100 forskellige arter."},
                {"Moesgaard Museum", "Museum i Aarhus med arkæologi og kulturhistorie."},
                {"Kronborg Slot", "Renæssanceslot i Helsingør, kendt fra Shakespeares Hamlet."},
                {"Odense Zoo", "Familievenlig zoologisk have på Fyn."},
                {"Hammershus", "Nordeuropas største borgruin på Bornholm."},
                {"Grenen", "Danmarks nordligste punkt, hvor to have mødes."},
                {"Legoland", "Forlystelsespark i Billund bygget af LEGO-klodser."}
        };

        // Loop makes objects and adds to collection
        for (String[] entry : data) {
            TouristAttraction attraction = new TouristAttraction();
            attraction.setName(entry[0]);
            attraction.setDescription(entry[1]);
            attractions.add(attraction);
        }
    }

    public ArrayList<TouristAttraction> getAllAttractions() {
        return attractions;
    }

    public TouristAttraction getOneNamedAttraction(String attractionName) {
        for (TouristAttraction attraction : attractions) {
            if (attraction.getName().equals(attractionName)) {
                return attraction;
            }
        }
        return null;
    }

    public void addOneNamedAttractionToList(TouristAttraction touristAttraction) {
        attractions.add(touristAttraction);
    }

    public void updateOneNamedAttraction(TouristAttraction touristAttraction) {
        for (int i = 0; i < attractions.size(); i++) {
            TouristAttraction attraction = attractions.get(i);
            if (attraction.getName().equals(touristAttraction.getName())) {
                attractions.set(i, touristAttraction); // replace old object with updated one
                break; // stop after first match
            }
        }
    }

    public void deleteOneNamedAttractionFromList(String namedAttractionToRemove) {
        attractions.removeIf(namedAttraction -> namedAttraction.getName().equals(namedAttractionToRemove));
    }
}
