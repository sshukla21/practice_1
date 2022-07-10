package net.providerdetails.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "providers")
public class Providers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String provider_name;
    private String flow_name;
    private LocalDateTime downFrom;
    private LocalDateTime downTo;

    public Providers() {
    }

    public Providers(String provider_name, String flow_name, LocalDateTime downFrom, LocalDateTime downTo) {
        this.provider_name = provider_name;
        this.flow_name = flow_name;
        this.downFrom = downFrom;
        this.downTo =  downTo  ;
        //this.downFrom = downFrom;
        //this.downTo = downTo;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }
    @Column(name = "provider_name", nullable = false)
    public String getProvider_name() {
        return provider_name;
    }

    public void setProvider_name(String provider_name) {
        this.provider_name = provider_name;
    }
    @Column(name = "flow_name", nullable = false)
    public String getFlow_name() {
        return flow_name;
    }

    public void setFlow_name(String flow_name) {
        this.flow_name = flow_name;
    }
    @Column(name = "downfrom")
    public LocalDateTime getDownFrom() {
        return downFrom;
    }

    public void setDownFrom(LocalDateTime downFrom) {
        this.downFrom = downFrom;
    }
    @Column(name = "downto")
    public LocalDateTime getDownTo() {
        return downTo;
    }

    public void setDownTo(LocalDateTime downTo) {
        this.downTo = downTo;
    }

//    @Override
//    public String toString() {
//        return "Provider [name=" + provider_name + ", flow=" + flow_name + ", downfrom=" + downFrom + ", downto=" + downTo
//                + "]";
//    }
}
