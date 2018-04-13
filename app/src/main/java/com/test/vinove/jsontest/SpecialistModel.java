package com.test.vinove.jsontest;

/**
 * Created by vinove on 28/3/18.
 */

class SpecialistModel {
    private String id, name, name_ar, is_active;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_ar() {
        return name_ar;
    }

    public void setName_ar(String name_ar) {
        this.name_ar = name_ar;
    }

    public String getIs_active() {
        return is_active;
    }

    public void setIs_active(String is_active) {
        this.is_active = is_active;
    }

    public SpecialistModel(String id, String name, String name_ar, String is_active) {
        this.id = id;
        this.name = name;

        this.name_ar = name_ar;
        this.is_active = is_active;
    }
}
