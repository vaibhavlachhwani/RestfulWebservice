package com.vaibhav.restfulwebservice.versioning;

public class PersonV2 {

    private Name name;

    public PersonV2(Name name) {
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PersonV2{");
        sb.append("name=").append(name);
        sb.append('}');
        return sb.toString();
    }
}
