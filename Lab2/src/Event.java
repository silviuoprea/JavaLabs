public class Event {

    int participants;
    int starttime;
    int endtime;

    public int getParticipants() {
        return participants;
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

    @Override
    public String toString() {
        return "Event{" +
                "participants=" + participants +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                '}';
    }
}
