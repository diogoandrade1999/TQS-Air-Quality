package andr.springframework.serializers;


public class DataSerializerAir {

    private String status = null;
    private CityQualities data = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CityQualities getData() {
        return data;
    }

    public void setData(CityQualities data) {
        this.data = data;
    }

    public Double getDew(){
        Valor data = getData().getIaqi().getDew();
        if(data != null)
            return data.getV();
        return null;
    }

    public Double getH() {
        Valor data = getData().getIaqi().getH();
        if(data != null)
            return data.getV();
        return null;
    }

    public Double getNo2() {
        Valor data = getData().getIaqi().getNo2();
        if(data != null)
            return data.getV();
        return null;
    }

    public Double getO3() {
        Valor data = getData().getIaqi().getO3();
        if(data != null)
            return data.getV();
        return null;
    }

    public Double getP() {
        Valor data = getData().getIaqi().getP();
        if(data != null)
            return data.getV();
        return null;
    }

    public Double getPm10() {
        Valor data = getData().getIaqi().getPm10();
        if(data != null)
            return data.getV();
        return null;
    }

    public Double getPm25() {
        Valor data = getData().getIaqi().getPm25();
        if(data != null)
            return data.getV();
        return null;
    }

    public Double getSo2() {
        Valor data = getData().getIaqi().getSo2();
        if(data != null)
            return data.getV();
        return null;
    }

    public Double getT() {
        Valor data = getData().getIaqi().getT();
        if(data != null)
            return data.getV();
        return null;
    }

    public Double getW() {
        Valor data = getData().getIaqi().getW();
        if(data != null)
            return data.getV();
        return null;
    }

    public Double getWg() {
        Valor data = getData().getIaqi().getWg();
        if(data != null)
            return data.getV();
        return null;
    }

    @Override
    public String toString() {
        return "{status=" + status + ", data=" + data + '}';
    }
}

class CityQualities {

    private String idx = null;
    private CityAir iaqi = null;

    public String getIdx() {
        return idx;
    }

    public void setIdx(String idx) {
        this.idx = idx;
    }

    public CityAir getIaqi() {
        return iaqi;
    }

    public void setIaqi(CityAir iaqi) {
        this.iaqi = iaqi;
    }

    @Override
    public String toString() {
        return "{idx=" + idx + ", iaqi=" + iaqi + '}';
    }
}

class CityAir {

    private Valor dew = null;
    private Valor h = null;
    private Valor no2 = null;
    private Valor o3 = null;
    private Valor p = null;
    private Valor pm10 = null;
    private Valor pm25 = null;
    private Valor so2 = null;
    private Valor t = null;
    private Valor w = null;
    private Valor wg = null;

    public Valor getDew() {
        return dew;
    }

    public void setDew(Valor dew) {
        this.dew = dew;
    }

    public Valor getH() {
        return h;
    }

    public void setH(Valor h) {
        this.h = h;
    }

    public Valor getP() {
        return p;
    }

    public void setP(Valor p) {
        this.p = p;
    }

    public Valor getPm25() {
        return pm25;
    }

    public void setPm25(Valor pm25) {
        this.pm25 = pm25;
    }

    public Valor getT() {
        return t;
    }

    public void setT(Valor t) {
        this.t = t;
    }

    public Valor getW() {
        return w;
    }

    public void setW(Valor w) {
        this.w = w;
    }

    public Valor getWg() {
        return wg;
    }

    public void setWg(Valor wg) {
        this.wg = wg;
    }

    public Valor getNo2() {
        return no2;
    }

    public void setNo2(Valor no2) {
        this.no2 = no2;
    }

    public Valor getO3() {
        return o3;
    }

    public void setO3(Valor o3) {
        this.o3 = o3;
    }

    public Valor getPm10() {
        return pm10;
    }

    public void setPm10(Valor pm10) {
        this.pm10 = pm10;
    }

    public Valor getSo2() {
        return so2;
    }

    public void setSo2(Valor so2) {
        this.so2 = so2;
    }

    @Override
    public String toString() {
        return "{" +
                "dew=" + dew +
                ", h=" + h +
                ", no2=" + no2 +
                ", o3=" + o3 +
                ", p=" + p +
                ", pm10=" + pm10 +
                ", pm25=" + pm25 +
                ", so2=" + so2 +
                ", t=" + t +
                ", w=" + w +
                ", wg=" + wg +
                '}';
    }
}

class Valor {

    private Double v = null;

    public Double getV() {
        return v;
    }

    public void setV(Double v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return "{v=" + v + '}';
    }
}