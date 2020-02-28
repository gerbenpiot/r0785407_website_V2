package domain.model;

public class Bier {
    private String name;
    private String beschrijving;
    private double percentage;


    public Bier () {
    }

    public Bier(String name) {
        this(name,null,0);
    }
    public Bier(String name,String beschrijving,double percentage){
        setName(name);
        setBeschrijving(beschrijving);
        setPercentage(percentage);
    }
    public Bier(String name,double percentage){
        setName(name);
        this.beschrijving=null;
        setPercentage(percentage);
    }



    @Override
    public boolean equals(Object object) {
        boolean equal = false;
        if (object instanceof Bier) {
            Bier other = (Bier) object;
            equal = this.getName().equals(other.getName());
        }
        return equal;
    }

    @Override
    public String toString() {
        String result = getName() + " (" + getPercentage()
                + " alcoholpercentage, beschrijving " + getBeschrijving() + ")";
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name may not be empty!");
        }
        this.name = name;
    }

    public String getBeschrijving() {
        if(beschrijving==null){
            return "";
        }else{
            return beschrijving;
        }

    }

    public void setBeschrijving(String beschrijving) {

        this.beschrijving = beschrijving;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        if (percentage < 0) {
            throw new IllegalArgumentException("The percentage must be positive!");
        }
        this.percentage = percentage;
    }
}
