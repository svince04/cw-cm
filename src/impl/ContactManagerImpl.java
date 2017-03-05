package impl;

import spec.*;

import java.util.*;

/**
 * Created by svince04 on 17/02/2017 for cw-cm.
 */
public class ContactManagerImpl implements ContactManager {
    private HashMap<Integer, Contact> contactMap = new HashMap<>();
    private HashMap<Integer, Meeting> meetingMap = new HashMap<>();
    private static int contactIdCounter = 1;
    private static int meetingIdCounter = 1;

    public void resetCounter() {
        contactIdCounter = 1;
        meetingIdCounter = 1;
    }

    @Override
    public int addFutureMeeting(Set<Contact> attendees, Calendar date) throws IllegalArgumentException, NullPointerException {
        Calendar currentTime = new GregorianCalendar();
        if (attendees == null || date == null) {
            throw new NullPointerException("Date and/or attendees cannot be null");
        }
        // Checks that future meeting is not in past
        // todo - move these errors into separate methods
        if ((date.compareTo(currentTime) < 0)) {
            throw new IllegalArgumentException("FutureMeeting cannot be in the past.");
        }
        // Checks that all contacts are known/existent
        for (Contact contact : attendees) {
            if (!contactMap.containsValue(contact)) {
                throw new IllegalArgumentException("Invalid Contact entered.");
            }
        }
        int id = meetingIdCounter;
        Meeting newMeeting = new FutureMeetingImpl(id, date, attendees);
        meetingMap.put(id, newMeeting);
        // Iterate meetingCounter in prep for next new Meeting
        meetingIdCounter++;
        return id;
    }

    @Override
    public PastMeeting getPastMeeting(int id) {
        return null;
    }

    @Override
    public FutureMeeting getFutureMeeting(int id) {
        // todo - add error checking in here
        Meeting meeting = meetingMap.get(id);
        FutureMeeting futureMeeting = (FutureMeeting) meeting;
        // todo - is there a way of combing the two lines above?
        return futureMeeting;
    }

    @Override
    public Meeting getMeeting(int id) {
        return null;
    }

    @Override
    public List<Meeting> getFutureMeetingList(Contact contact) {
        return null;
    }

    @Override
    public List<Meeting> getMeetingListOn(Calendar date) {
        return null;
    }

    @Override
    public List<PastMeeting> getPastMeetingListFor(Contact contact) {
        return null;
    }

    @Override
    public int addNewPastMeeting(Set<Contact> contacts, Calendar date, String text) {
        return 0;
    }

    @Override
    public PastMeeting addMeetingNotes(int id, String text) {
        return null;
    }

    @Override
    public int addNewContact(String name, String notes) throws IllegalArgumentException, NullPointerException {
        if (name.equals("") || notes.equals("")) {
            throw new IllegalArgumentException("Name and/or notes cannot be empty");
        } else {
            // Use incrementing id to generate UIDs and assign Contact to corresponding key
            int id = contactIdCounter;
            Contact newContact = new ContactImpl(id, name, notes);
            contactMap.put(id, newContact);
            // Iterate idCounter in prep for next new Contact
            contactIdCounter++;
            return id;
        }
    }

    @Override
    public Set<Contact> getContacts(String name) throws NullPointerException {
        Set<Contact> nameSet = new HashSet<>();
        // return full list if string is empty
        if (name.equals("")) {
            for (Map.Entry<Integer, Contact> entry : contactMap.entrySet()) {
                nameSet.add(entry.getValue());
            }
        } else {
            // otherwise just return matching contacts
            for (Map.Entry<Integer, Contact> entry : contactMap.entrySet()) {
                if (entry.getValue().getName().contains(name)) {
                    nameSet.add(entry.getValue());
                }
            }
        }
        return nameSet;
    }

    @Override
    public Set<Contact> getContacts(int... ids) throws IllegalArgumentException {
        if (ids.length == 0) {
            throw new IllegalArgumentException("No IDs have been entered");
        }
        Set<Contact> idSet = new HashSet<>();
        for (int id : ids) {
            // Check for invalid IDs
            if (!contactMap.containsKey(id)) {
                throw new IllegalArgumentException("Invalid ID entered");
            }
            idSet.add(contactMap.get(id));
        }
        return idSet;
    }

    @Override
    public void flush() {

    }
}
