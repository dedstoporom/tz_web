package com.tz.tz_web.Models;
import javax.persistence.*;

@Entity
public class flying
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String way_time;//Время рейса
        private String way_number;//Номер рейса
        private String way_company;//Компания
        private String way_end;//Место
        private String way_terminal;//Номер терминала
        private String way_status;//Статус рейса
        private String way_image;

    public String getWay_image()
    {
        return way_image;
    }

    public void setWay_image(String way_image)
    {
        this.way_image = way_image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWay_time() {
        return way_time;
    }

    public void setWay_time(String way_time) { this.way_time = way_time; }

    public String getWay_number() {
        return way_number;
    }

    public void setWay_number(String way_number) {
        this.way_number = way_number;
    }

    public String getWay_company() {
        return way_company;
    }

    public void setWay_company(String way_company) {
        this.way_company = way_company;
    }

    public String getWay_end() {
        return way_end;
    }

    public void setWay_end(String way_end) {
        this.way_end = way_end;
    }

    public String getWay_terminal() {
        return way_terminal;
    }

    public void setWay_terminal(String way_terminal) {
        this.way_terminal = way_terminal;
    }

    public String getWay_status() {
        return way_status;
    }

    public void setWay_status(String way_status) {
        this.way_status = way_status;
    }
}
