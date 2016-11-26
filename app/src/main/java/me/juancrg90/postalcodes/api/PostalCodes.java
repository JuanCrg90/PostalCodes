package me.juancrg90.postalcodes.api;

import java.util.List;

import me.juancrg90.postalcodes.entities.PostalCode;

/**
 * Created by JuanCrg90 on 11/26/16.
 */
public class PostalCodes {

    private List<PostalCode> postalCodes;

    public List<PostalCode> getPostalCodes() {
        return postalCodes;
    }

    public void setPostalCodes(List<PostalCode> postalCodes) {
        this.postalCodes = postalCodes;
    }
}
