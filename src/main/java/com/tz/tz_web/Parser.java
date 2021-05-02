package com.tz.tz_web;
import com.tz.tz_web.Models.flying;
import com.tz.tz_web.repo.flying_repository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.net.URL;
@Component
public class Parser
{
    @Autowired
    private flying_repository flying_repository;
    private static Document page;
    public static int ind=-1;
    private static String img_name;
//    public static String[][]way_mas1;
    private static Document get_page() throws IOException //Document-для возвращения html-кода
    {
        String url="http://www.vnukovo.ru/flights/online-timetable/#tab-sortie";//Внуково
        Document page=Jsoup.parse(new URL(url),3000);//Сам документ
        return page;
    }
    @Scheduled(fixedDelay =30000)/*Тайминг обновления БД*/
    public void flight_table() throws Exception
    {
        page=get_page();
        Elements main_table=page.select("div[class=ajax-result]");
        Elements table=main_table.select("tbody");
        Element way=table.select("tr").get(0);//Рейс
        Elements data_way=way.select("td");//Данные рейса
//        way_mas1=new String[table.select("tr").size()-2][6];
        int a;
         System.out.println("[db update]");
         flying_repository.deleteAll();
        for(a=0;a<table.select("tr").size()-2;a++)
        {
            way=table.select("tr").get(a);//Рейс
            img_name=way.select("img[class=company-logo]").attr("src");
            data_way=way.select("td");//Данные рейса
            if(data_way.size()==6)
            {
                flying flying=new flying();
                flying.setWay_time(data_way.get(0).text());
                flying.setWay_number(data_way.get(1).text());
                flying.setWay_company(data_way.get(2).text());
                flying.setWay_end(data_way.get(3).text());
                flying.setWay_terminal(data_way.get(4).text());
                flying.setWay_status(data_way.get(5).text());
                if(img_name==""){img_name="not_found_img.jpg";}
                flying.setWay_image(img_name);
                ind++;
                flying_repository.save(flying);
            }
        }
    }
}
