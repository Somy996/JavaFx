package ch.makery.address.model;

import java.time.LocalDate;

import ch.makery.address.util.LocalDateAdapter;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Model class for a Person.
 *
 * @author Marco Jakob
 */
public class Person {

    private final StringProperty city;
    private final StringProperty province;
    private final StringProperty country;
    private final IntegerProperty temperature;
    private final StringProperty weather;
    private final ObjectProperty<LocalDate> date;

    /**
     * Default constructor.
     */
    public Person() {
        this(null, null);
    }

    /**
     * Constructor with some initial data.
     *
     * @param city
     * @param province
     */
    public Person(String city, String province) {
        this.city = new SimpleStringProperty(city);
        this.province = new SimpleStringProperty(province);

        // Some initial dummy data, just for convenient testing.
        this.country = new SimpleStringProperty("中国");
        this.temperature = new SimpleIntegerProperty(26);
        this.weather = new SimpleStringProperty("晴朗");
        this.date = new SimpleObjectProperty<LocalDate>(LocalDate.of(2018, 3, 11));
    }

    public String getFirstName() {
        return city.get();
    }

    public void setFirstName(String firstName) {
        this.city.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return city;
    }

    public String getLastName() {
        return province.get();
    }

    public void setLastName(String lastName) {
        this.province.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return province;
    }

    public String getStreet() {
        return country.get();
    }

    public void setStreet(String street) {
        this.country.set(street);
    }

    public StringProperty streetProperty() {
        return country;
    }

    public int getPostalCode() {
        return temperature.get();
    }

    public void setPostalCode(int postalCode) {
        this.temperature.set(postalCode);
    }

    public IntegerProperty postalCodeProperty() {
        return temperature;
    }

    public String getCity() {
        return weather.get();
    }

    public void setCity(String city) {
        this.weather.set(city);
    }

    public StringProperty cityProperty() {
        return weather;
    }


    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getBirthday() {
        return date.get();
    }
    public void setBirthday(LocalDate birthday) {
        this.date.set(birthday);
    }

    public ObjectProperty<LocalDate> birthdayProperty() {
        return date;
    }
}