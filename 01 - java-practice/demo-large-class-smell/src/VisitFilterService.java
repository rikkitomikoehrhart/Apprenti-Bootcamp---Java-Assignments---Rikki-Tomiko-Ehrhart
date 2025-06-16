public class VisitFilterService {

    public Visit[] getVisitsByProviderId(String providerId, Visit[] visits) {
        Visit[] collector = new Visit[visits.length];
        int nextCollectorIndex = 0;

        for (Visit visit : visits) {
            if (visit.getProvider().getProviderId().equals(providerId)) {
                collector[nextCollectorIndex] = visit;
                nextCollectorIndex++;
            }
        }

        Visit[] results = new Visit[nextCollectorIndex];

        for (int i = 0; i < nextCollectorIndex; i++) {
            results[i] = collector[i];
        }
        return results;
    }

    public Visit[] getVisitsByPatientId(String patientId, Visit[] visits) {
        Visit[] collector = new Visit[visits.length];
        int nextCollectorIndex = 0;

        for (Visit visit : visits) {
            if (visit.getPatient().getPatientId().equals(patientId)) {
                collector[nextCollectorIndex] = visit;
                nextCollectorIndex++;
            }
        }

        Visit[] results = new Visit[nextCollectorIndex];
        for (int i = 0; i < nextCollectorIndex; i++) {
            results[i] = collector[i];
        }
        return results;

    }
}
