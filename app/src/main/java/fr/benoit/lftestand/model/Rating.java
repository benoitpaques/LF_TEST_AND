package fr.benoit.lftestand.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by benoit on 06/02/2016.
 */
public class Rating implements Serializable{

    private static final long serialVersionUID = 4787816956323348578L;

    @SerializedName("ambience_rate")
    private String ambienceRate;

    @SerializedName("service_rate")
    private String serviceRate;

    @SerializedName("noice_rate")
    private String noiceRate;

    @SerializedName("global_rate")
    private String globalRate;

    @SerializedName("price_rate")
    private String priceRate;

    @SerializedName("waiting_rate")
    private String waitingRate;

    @SerializedName("food_rate")
    private String foodRate;

    public String getAmbienceRate() {
        return ambienceRate;
    }

    public void setAmbienceRate(String ambienceRate) {
        this.ambienceRate = ambienceRate;
    }

    public String getServiceRate() {
        return serviceRate;
    }

    public void setServiceRate(String serviceRate) {
        this.serviceRate = serviceRate;
    }

    public String getNoiceRate() {
        return noiceRate;
    }

    public void setNoiceRate(String noiceRate) {
        this.noiceRate = noiceRate;
    }

    public String getGlobalRate() {
        return globalRate;
    }

    public void setGlobalRate(String globalRate) {
        this.globalRate = globalRate;
    }

    public String getPriceRate() {
        return priceRate;
    }

    public void setPriceRate(String priceRate) {
        this.priceRate = priceRate;
    }

    public String getWaitingRate() {
        return waitingRate;
    }

    public void setWaitingRate(String waitingRate) {
        this.waitingRate = waitingRate;
    }

    public String getFoodRate() {
        return foodRate;
    }

    public void setFoodRate(String foodRate) {
        this.foodRate = foodRate;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "ambienceRate='" + ambienceRate + '\'' +
                ", serviceRate='" + serviceRate + '\'' +
                ", noiceRate='" + noiceRate + '\'' +
                ", globalRate='" + globalRate + '\'' +
                ", priceRate='" + priceRate + '\'' +
                ", waitingRate='" + waitingRate + '\'' +
                ", foodRate='" + foodRate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rating rating = (Rating) o;

        if (ambienceRate != null ? !ambienceRate.equals(rating.ambienceRate) : rating.ambienceRate != null)
            return false;
        if (serviceRate != null ? !serviceRate.equals(rating.serviceRate) : rating.serviceRate != null)
            return false;
        if (noiceRate != null ? !noiceRate.equals(rating.noiceRate) : rating.noiceRate != null)
            return false;
        if (globalRate != null ? !globalRate.equals(rating.globalRate) : rating.globalRate != null)
            return false;
        if (priceRate != null ? !priceRate.equals(rating.priceRate) : rating.priceRate != null)
            return false;
        if (waitingRate != null ? !waitingRate.equals(rating.waitingRate) : rating.waitingRate != null)
            return false;
        return !(foodRate != null ? !foodRate.equals(rating.foodRate) : rating.foodRate != null);

    }

    @Override
    public int hashCode() {
        int result = ambienceRate != null ? ambienceRate.hashCode() : 0;
        result = 31 * result + (serviceRate != null ? serviceRate.hashCode() : 0);
        result = 31 * result + (noiceRate != null ? noiceRate.hashCode() : 0);
        result = 31 * result + (globalRate != null ? globalRate.hashCode() : 0);
        result = 31 * result + (priceRate != null ? priceRate.hashCode() : 0);
        result = 31 * result + (waitingRate != null ? waitingRate.hashCode() : 0);
        result = 31 * result + (foodRate != null ? foodRate.hashCode() : 0);
        return result;
    }
}
