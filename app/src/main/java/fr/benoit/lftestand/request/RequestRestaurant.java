package fr.benoit.lftestand.request;

import com.google.gson.annotations.SerializedName;

import fr.benoit.lftestand.model.Restaurant;

/**
 * Created by benoit on 06/02/2016.
 */
public class RequestRestaurant {

    private int result;

    @SerializedName("result_code")
    private String resultCode;

    @SerializedName("result_detail")
    private String resultDetail;

    @SerializedName("result_msg")
    private String resultMessage;

    @SerializedName("result_cached")
    private String resultCached;

    @SerializedName("data")
    private Restaurant restaurant;

    public Restaurant getData() {
        return restaurant;
    }

    public void setData(Restaurant data) {
        this.restaurant = data;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getResultCached() {
        return resultCached;
    }

    public void setResultCached(String resultCached) {
        this.resultCached = resultCached;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultDetail() {
        return resultDetail;
    }

    public void setResultDetail(String resultDetail) {
        this.resultDetail = resultDetail;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    @Override
    public String toString() {
        return "RequestRestaurant{" +
                "restaurant=" + restaurant +
                ", result=" + result +
                ", resultCode='" + resultCode + '\'' +
                ", resultDetail='" + resultDetail + '\'' +
                ", resultMessage='" + resultMessage + '\'' +
                ", resultCached='" + resultCached + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RequestRestaurant that = (RequestRestaurant) o;

        if (result != that.result) return false;
        if (resultCode != null ? !resultCode.equals(that.resultCode) : that.resultCode != null)
            return false;
        if (resultDetail != null ? !resultDetail.equals(that.resultDetail) : that.resultDetail != null)
            return false;
        if (resultMessage != null ? !resultMessage.equals(that.resultMessage) : that.resultMessage != null)
            return false;
        if (resultCached != null ? !resultCached.equals(that.resultCached) : that.resultCached != null)
            return false;
        return !(restaurant != null ? !restaurant.equals(that.restaurant) : that.restaurant != null);

    }

    @Override
    public int hashCode() {
        int result1 = result;
        result1 = 31 * result1 + (resultCode != null ? resultCode.hashCode() : 0);
        result1 = 31 * result1 + (resultDetail != null ? resultDetail.hashCode() : 0);
        result1 = 31 * result1 + (resultMessage != null ? resultMessage.hashCode() : 0);
        result1 = 31 * result1 + (resultCached != null ? resultCached.hashCode() : 0);
        result1 = 31 * result1 + (restaurant != null ? restaurant.hashCode() : 0);
        return result1;
    }
}
