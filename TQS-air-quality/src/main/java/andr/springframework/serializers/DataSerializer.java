package andr.springframework.serializers;

import java.util.List;

public class DataSerializer {

    private String status = null;
    private List<CityAttributes> data = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<CityAttributes> getData() {
        return data;
    }

    public void setData(List<CityAttributes> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{status=" + status + ", data=" + data + '}';
    }
}

class CityAttributes {

    private String uid = null;
    private Station station = null;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    @Override
    public String toString() {
        return "{uid=" + uid + ", station=" + station + '}';
    }
}

class Station {

    private String name = null;

    public String getName() {
        return name.replace(';', ',');
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{name=" + name  + '}';
    }
}