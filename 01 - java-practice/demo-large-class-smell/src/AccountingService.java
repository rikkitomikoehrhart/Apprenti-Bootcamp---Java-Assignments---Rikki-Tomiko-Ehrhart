import java.math.BigDecimal;

public class AccountingService {
    public BigDecimal calculateTotalOutstandingPayments(Visit[] visits) {
        BigDecimal result = new BigDecimal(0);

        for (Visit visit : visits) {
            if (!visit.isCostPaid()) {
                result = result.add(visit.getVisitCost());
            }
        }
        return result;
    }

    public BigDecimal calculateTotalReceived(Visit[] visits) {
        BigDecimal result = new BigDecimal(0);

        for (Visit visit : visits) {
            if (visit.isCostPaid()) {
                result = result.add(visit.getVisitCost());
            }
        }
        return result;
    }
}
