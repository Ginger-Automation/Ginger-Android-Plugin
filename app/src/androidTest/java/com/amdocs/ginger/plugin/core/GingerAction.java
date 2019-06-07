package com.amdocs.ginger.plugin.core;

public class GingerAction implements IGingerAction
{
    public String ExInfo;

    @Override
    public void AddError(String error) {

    }

    @Override
    public void AddExInfo(String info) {
        ExInfo += info + "\n";
    }
}
