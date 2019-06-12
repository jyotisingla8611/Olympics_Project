package com.company;

import java.util.ArrayList;
import java.util.List;

public class NOCRegions {

    public static final int NOC_REGION = 0;
    public static final int REGION = 1;
    public static final int NOTES_PRESENCE = 3;

    public List<NOCRegions> getNocRegions() {
        return nocRegions;
    }

    private List<NOCRegions> nocRegions = new ArrayList<>();

    private String noc;
    private String region;
    private String notes;

    public NOCRegions() {}

    public NOCRegions(String noc, String region, String notes) {
        this.noc = noc;
        this.region = region;
        this.notes = notes;
    }
}


