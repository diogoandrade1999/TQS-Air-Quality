package andr.springframework.domain;

import javax.persistence.*;

@Entity
public class Statistics {

    @Id
    private Integer id;

    private Integer count_requests = 0;
    private Integer hits = 0;
    private Integer misses = 0;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCount_requests() {
        return count_requests;
    }

    public void setCount_requests() {
        this.count_requests = getCount_requests()+1;
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits() {
        this.hits = getHits()+1;
    }

    public Integer getMisses() {
        return misses;
    }

    public void setMisses() {
        this.misses = getMisses()+1;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "id=" + id +
                ", count_requests=" + count_requests +
                ", hits=" + hits +
                ", misses=" + misses +
                '}';
    }
}
