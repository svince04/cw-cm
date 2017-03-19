package impl;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;
import spec.Contact;
import spec.PastMeeting;

/**
 * Implementation of {@see PastMeeting}.
 * @author svince04
 */
public class PastMeetingImpl extends MeetingImpl implements PastMeeting, Serializable {
  private String notes;

  /**
   * @param id int - the unique id number of the meeting.
   * @param date Calendar object contain past date and time of the meeting.
   * @param attendees Set of Contacts affiliated with the meeting.
   * @param notes String notes about the meeting.
   * @throws IllegalArgumentException when ID is 0 or below.
   * @throws NullPointerException when passed empty Contact Set.
   */
  public PastMeetingImpl(int id, Calendar date, Set<Contact> attendees, String notes) {
    super(id, date, attendees);
    this.notes = notes;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public String getNotes() {
    return notes;
  }
}
