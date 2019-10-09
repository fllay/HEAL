package com.example.heal;

public class TabDetails {
    private String tabName;
    private diceasesHistActivity.PlaceholderFragment fragment;

    public TabDetails(String tabName, diceasesHistActivity.PlaceholderFragment fragment) {
        this.tabName = tabName;
        this.fragment = fragment;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    public diceasesHistActivity.PlaceholderFragment getFragment() {
        return fragment;
    }

    public void setFragment(diceasesHistActivity.PlaceholderFragment fragment) {
        this.fragment = fragment;
    }

}