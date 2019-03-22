package com.udacity.sandwichclub.utils;


import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class JsonUtils {

    public static List<String> convertJSONArrayToList(JSONArray jsonArray) throws JSONException{
        List<String> list = new ArrayList<>(jsonArray.length());
        for(int i = 0 ; i< jsonArray.length() ; i++){
                list.add(jsonArray.getString(i));
        }
        return list;
    }
    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject obj = new JSONObject(json);
            String mainName = obj.getJSONObject("name").getString("mainName");
            String placeOfOrigin = obj.getString("placeOfOrigin");
            String description = obj.getString("description");
            String image = obj.getString("image");
            JSONArray alsoknown = obj.getJSONObject("name").getJSONArray("alsoKnownAs");
            JSONArray ingredients = obj.getJSONArray("ingredients");


            Sandwich sandwich = new Sandwich(mainName , convertJSONArrayToList(alsoknown) , placeOfOrigin , description , image , convertJSONArrayToList(ingredients));
            return sandwich;

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
