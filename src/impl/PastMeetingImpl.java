package impl;

import spec.Contact;
import spec.PastMeeting;

import java.util.Calendar;
import java.util.Set;

/**
 * Created by essvee on 17/02/2017.
 */
public class PastMeetingImpl extends MeetingImpl implements PastMeeting {
    @Override
    public int getId() {
        return 0;
    }

    @Override
    public Calendar getDate() {
        return null;
    }

    @Override
    public Set<Contact> getContacts() {
        return null;
    }

    @Override
    public String getNotes() {
        return null;
    }
}
