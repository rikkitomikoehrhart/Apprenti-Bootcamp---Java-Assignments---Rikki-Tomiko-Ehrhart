public class Owner {
    private String name;
    private String taxid;
    private Account[] accounts;

    public Owner(String name, String taxid) {
        this.name = name;
        this.taxid = taxid;
    }

    public String getName() {
        return name.substring(0, 1);
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getTaxLast4() {
        if (taxid.length() < 4) {
            return "xxx";
        }

        return "x" + taxid.substring(taxid.length() - 4);
    }
}
