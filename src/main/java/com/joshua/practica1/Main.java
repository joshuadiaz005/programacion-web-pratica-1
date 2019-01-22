package com.joshua.practica1;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        int formularioCant = 1;
        int formularioInput = 1;

        System.out.println("Introduzca la URL válida: ");
        Scanner read = new Scanner(System.in);
        String url = read.next();

        Connection.Response response = Jsoup.connect(url).execute();

        System.out.println("Cantidad de lineas retornado: " + response.body().split("\n").length);

        Document document = Jsoup.connect(url).get();

        System.out.println("Cantidad de parrafos: " + document.getElementsByTag("p").size());

        System.out.println("Cantidad de imagenes dentro de los parrafos: " + document.select("p img").size());

        System.out.println("Cantidad de formularios que contiene el HTML categorizando por el método GET: " + document.select("form[method='GET']").size());

        System.out.println("Cantidad de formularios que contiene el HTML categorizando por el método POST: " + document.select("form[method='POST']").size());

        for(Element formulario : document.getElementsByTag("form")) {
            System.out.println("Form: id = " + formularioCant);

            for(Element input : formulario.getElementsByTag("input")) {
                System.out.println("\tInput: id = " + formularioInput + "tipo: " + input.attr("type"));

                formularioInput++;
            }
            formularioCant++;
        }

        
    }
}
