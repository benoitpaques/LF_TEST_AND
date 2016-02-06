package fr.benoit.lftestand.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by benoit on 06/02/2016.
 */
public class Restaurant implements Serializable{


    private static final long serialVersionUID = -2863698744749192970L;

    @SerializedName("id_restaurant")
    private long restaurantId;

    private String name;

    @SerializedName("portal_url")
    private String portalUrl;

    @SerializedName("gps_lat")
    private double gpsLat;

    @SerializedName("gps_long")
    private double gpsLong;

    private String address;

    private String city;

    private String zipcode;

    @SerializedName("id_country")
    private int countryId;

    @SerializedName("rate_count")
    private int rateCount;

    @SerializedName("pics_main")
    private HashMap<String, String> picsMain;

    @SerializedName("pics_diaporama")
    private HashMap<String, String>[] picsDiaporama;

    @SerializedName("currency_code")
    private String currencyCode;

    @SerializedName("min_price")
    private int minPrice;

    private String speciality;

    private int saleTypeNormalId;

    @SerializedName("avg_rate")
    private double averageRate;

    private String description;

    @SerializedName("card_price")
    private int cardPrice;

    private Rating ratings;

    public Rating getRatings() {
        return ratings;
    }

    public void setRatings(Rating ratings) {
        this.ratings = ratings;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getAverageRate() {
        return averageRate;
    }

    public void setAverageRate(double averageRate) {
        this.averageRate = averageRate;
    }

    public int getCardPrice() {
        return cardPrice;
    }

    public void setCardPrice(int cardPrice) {
        this.cardPrice = cardPrice;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(double gpsLat) {
        this.gpsLat = gpsLat;
    }

    public double getGpsLong() {
        return gpsLong;
    }

    public void setGpsLong(double gpsLong) {
        this.gpsLong = gpsLong;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, String>[] getPicsDiaporama() {
        return picsDiaporama;
    }

    public void setPicsDiaporama(HashMap<String, String>[] picsDiaporama) {
        this.picsDiaporama = picsDiaporama;
    }

    public HashMap<String, String> getPicsMain() {
        return picsMain;
    }

    public void setPicsMain(HashMap<String, String> picsMain) {
        this.picsMain = picsMain;
    }

    public String getPortalUrl() {
        return portalUrl;
    }

    public void setPortalUrl(String portalUrl) {
        this.portalUrl = portalUrl;
    }

    public int getRateCount() {
        return rateCount;
    }

    public void setRateCount(int rateCount) {
        this.rateCount = rateCount;
    }

    public long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getSaleTypeNormalId() {
        return saleTypeNormalId;
    }

    public void setSaleTypeNormalId(int saleTypeNormalId) {
        this.saleTypeNormalId = saleTypeNormalId;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "Data{" +
                "address='" + address + '\'' +
                ", restaurantId=" + restaurantId +
                ", name='" + name + '\'' +
                ", portalUrl='" + portalUrl + '\'' +
                ", gpsLat=" + gpsLat +
                ", gpsLong=" + gpsLong +
                ", city='" + city + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", countryId=" + countryId +
                ", rateCount=" + rateCount +
                ", picsMain=" + picsMain +
                ", picsDiaporama=" + Arrays.toString(picsDiaporama) +
                ", currencyCode='" + currencyCode + '\'' +
                ", minPrice=" + minPrice +
                ", speciality='" + speciality + '\'' +
                ", saleTypeNormalId=" + saleTypeNormalId +
                ", averageRate=" + averageRate +
                ", description='" + description + '\'' +
                ", cardPrice=" + cardPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Restaurant that = (Restaurant) o;

        if (restaurantId != that.restaurantId) return false;
        if (Double.compare(that.gpsLat, gpsLat) != 0) return false;
        if (Double.compare(that.gpsLong, gpsLong) != 0) return false;
        if (countryId != that.countryId) return false;
        if (rateCount != that.rateCount) return false;
        if (minPrice != that.minPrice) return false;
        if (saleTypeNormalId != that.saleTypeNormalId) return false;
        if (Double.compare(that.averageRate, averageRate) != 0) return false;
        if (cardPrice != that.cardPrice) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (portalUrl != null ? !portalUrl.equals(that.portalUrl) : that.portalUrl != null)
            return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (zipcode != null ? !zipcode.equals(that.zipcode) : that.zipcode != null) return false;
        if (picsMain != null ? !picsMain.equals(that.picsMain) : that.picsMain != null)
            return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(picsDiaporama, that.picsDiaporama)) return false;
        if (currencyCode != null ? !currencyCode.equals(that.currencyCode) : that.currencyCode != null)
            return false;
        if (speciality != null ? !speciality.equals(that.speciality) : that.speciality != null)
            return false;
        return !(description != null ? !description.equals(that.description) : that.description != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (restaurantId ^ (restaurantId >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (portalUrl != null ? portalUrl.hashCode() : 0);
        temp = Double.doubleToLongBits(gpsLat);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(gpsLong);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (zipcode != null ? zipcode.hashCode() : 0);
        result = 31 * result + countryId;
        result = 31 * result + rateCount;
        result = 31 * result + (picsMain != null ? picsMain.hashCode() : 0);
        result = 31 * result + (picsDiaporama != null ? Arrays.hashCode(picsDiaporama) : 0);
        result = 31 * result + (currencyCode != null ? currencyCode.hashCode() : 0);
        result = 31 * result + minPrice;
        result = 31 * result + (speciality != null ? speciality.hashCode() : 0);
        result = 31 * result + saleTypeNormalId;
        temp = Double.doubleToLongBits(averageRate);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + cardPrice;
        return result;
    }
}
