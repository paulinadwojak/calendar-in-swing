package enums;

public enum View {

    WEEK("WEEK"), MONTH("MONTH");

    private String stringValue;

    View(String stringValue) {
        this.stringValue = stringValue;
    }

    public static View findByName(String stringValue) {
        if (WEEK.stringValue.equals(stringValue)) {
            return View.MONTH;
        } else if (MONTH.stringValue.equals(stringValue)) {
            return View.WEEK;
        }
        return null;
    }


}
