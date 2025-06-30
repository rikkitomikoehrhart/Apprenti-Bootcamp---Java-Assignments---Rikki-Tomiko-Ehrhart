package learn.unexplained.ui;

import learn.unexplained.data.DataAccessException;
import learn.unexplained.domain.EncounterResult;
import learn.unexplained.domain.EncounterService;
import learn.unexplained.models.Encounter;

import java.util.List;

public class Controller {

    private final EncounterService service;
    private final View view;

    public Controller(EncounterService service, View view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        view.printHeader("Welcome To Unexplained Encounters.");

        try {
            runMenuLoop();
        } catch (DataAccessException ex) {
            view.printHeader("CRITICAL ERROR:" + ex.getMessage());
        }

        view.printHeader("Goodbye");
    }

    private void runMenuLoop() throws DataAccessException {
        MenuOption option;
        do {
            option = view.displayMenuGetOption();
            switch (option) {
                case DISPLAY_ALL:
                    displayAllEncounters();
                    break;
                case DISPLAY_ENCOUNTERS_BY_TYPE:
                    displayEncountersByType();
                    break;
                case UPDATE_ENCOUNTER:
                    updateEncounter();
                    break;
                case DELETE_ENCOUNTER:
                    deleteEncounter();
                    break;
                case ADD:
                    addEncounter();
                    break;
            }
        } while (option != MenuOption.EXIT);
    }

    private void displayAllEncounters() throws DataAccessException {
        List<Encounter> encounters = service.findAll();
        view.printAllEncounters(encounters);
    }

    private void displayEncountersByType() throws DataAccessException {
        List<Encounter> encounters = service.findByType(view.readType());
        view.printAllEncounters(encounters);
    }

    private void updateEncounter() throws DataAccessException {
        Encounter encounter = service.findById(view.getEncounterId());

        view.printAllEncounters(List.of(new Encounter[]{encounter}));
        encounter = view.updateEncounter(encounter);

        EncounterResult result = service.update(encounter);

        view.printResult(result);
    }

    private void deleteEncounter() throws DataAccessException {
        EncounterResult result = service.deleteById(view.getEncounterId());

        view.printDeleteResult(result);
    }

    private void addEncounter() throws DataAccessException {
        Encounter encounter = view.makeEncounter();
        EncounterResult result = service.add(encounter);
        view.printResult(result);
    }
}
