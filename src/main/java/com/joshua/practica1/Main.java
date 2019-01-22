package com.joshua.practica1;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Introduzca la URL válida: ");
        Scanner read = new Scanner(System.in);
        String url = read.next();

        Connection.Response response = Jsoup.connect(url).execute();

        System.out.println("Cantidad de lineas retornado: " + response.body().split("\n").length);

        Document document = Jsoup.connect(url).get();

        System.out.println("Cantidad de parrafos: " + document.getElementsByTag("p").size());

        System.out.println("Cantidad de imagenes dentro de los parrafos: " + document.select("p img").size());
    }
}
