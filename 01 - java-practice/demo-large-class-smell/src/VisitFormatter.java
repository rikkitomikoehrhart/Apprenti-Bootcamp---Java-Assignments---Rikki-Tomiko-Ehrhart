import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class VisitFormatter {
    public String formatDateTime(LocalDateTime dt) {
        return dt.format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm"));
    }

    public String formatPatientForListOutput(Visit visit) {
        StringBuilder result = new StringBuilder();
        Patient patient = visit.getPatient();
        Provider provider = visit.getProvider();

        result.append(formatDateTime(visit.getAppointmentTime())).append(" - ");
        result.append(patient.getPatientLastName()).append(", ").append(patient.getPatientFirstName()).append(" ");
        result.append("for ").append(provider.getProviderTitle()).append(" ").append(provider.getProviderLastName()).append(" - ");
        result.append(visit.getVisitCost()). append(": ").append(visit.isCostPaid() ? "PAID" : "DUE");
        return result.toString();
    }
}
