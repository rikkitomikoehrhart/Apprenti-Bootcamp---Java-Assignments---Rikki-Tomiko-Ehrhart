public class Result {
    public final boolean success;
    public final String message;

    private Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }




    // Error Handling Functions
    public static Result isCorrectResponse(String response, String[] possibleResponses) {
        for (String possible: possibleResponses) {
            if (response.equals(possible)) {
                return new Result(true, response);
            }
        }

        return new Result(false, response);
    }

    public static Result canRentLocker() {
        if (Main.ls.getNextAvailableLockerIndex() == -1) {
            return new Result(false, "Sorry, we are out of lockers.");
        } else {
            return new Result(true, "There are still lockers left.");
        }
    }

    public static Result isLockerInUse(Locker locker) {
        if (locker != null) {
            return new Result(true, "That locker is in use.");
        } else {
            return new Result(false, "That locker hasn't been rented yet.");
        }
    }
}

