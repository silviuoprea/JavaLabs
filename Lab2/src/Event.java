public class Event {

    String name;
    int participants;
    int starttime;
    int endtime;

    public int getParticipants() {
        return participants;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }

    public int getStarttime() {
        return starttime;
    }

    public void setStarttime(int starttime) {
        this.starttime = starttime;
    }

    public int getEndtime() {
        return endtime;
    }

    public void setEndtime(int endtime) {
        this.endtime = endtime;
    }

    public Event(String name, int participants, int starttime, int endtime) {
        this.name = name;
        this.participants = participants;
        this.starttime = starttime;
        this.endtime = endtime;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", participants=" + participants +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                '}';
    }
}
