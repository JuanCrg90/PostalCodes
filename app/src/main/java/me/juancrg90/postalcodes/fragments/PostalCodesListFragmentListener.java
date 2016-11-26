package me.juancrg90.postalcodes.fragments;

import java.util.List;

import me.juancrg90.postalcodes.entities.PostalCode;

/**
 * Created by JuanCrg90 on 11/26/16.
 */

public interface PostalCodesListFragmentListener {
    void addToList( List<PostalCode> postalCodeList);
    void clearList();
}
