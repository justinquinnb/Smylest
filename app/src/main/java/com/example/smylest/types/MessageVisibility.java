package com.example.smylest.types;

/**
 * Currently non-functional, but intended to restrict who is allowed to view and respond to your
 * request, based on your own, locally stored information.
 */
public enum MessageVisibility {
    /**
     * Allow anyone to view and respond to the request
     */
    GLOBAL,

    /**
     * Allow only members of the user's sex to view and respond the request
     */
    MY_SEX,

    /**
     * Allow only members of user's age group to view and respond the request
     */
    MY_AGE_GROUP,

    /**
     * Allow only users within a certain distance to view and respond to the request
     */
    MY_LOCATION;

    public static String asString(MessageVisibility messageVisibility) {
        switch (messageVisibility) {
            case GLOBAL:
                return "for all";
            case MY_SEX:
                return "by sex";
            case MY_AGE_GROUP:
                return "by age";
            case MY_LOCATION:
                return "by location";
            default:
                return "by unknown";
        }
    }
}
