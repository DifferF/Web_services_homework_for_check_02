package task_04;

/*
Задание 4+
Создать xml-документ candies.xml,
с корневым элементом , который будет в себе содержать несколько ,
c характеристиками конфеты.
Используя StAX-парсер получить коллекцию Candy из xml-файла.
 */

import task_04.entity.Candies;

import javax.xml.stream.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, XMLStreamException {
        creationС();
        parsingС();
    }

    static void creationС() throws XMLStreamException, IOException {
        Candies candie_01 = new Candies("01", "20", "9", "36", "Орешки в шоколаде", "Торговая марка_1");
        Candies candie_02 = new Candies("02", "15", "8", "38", "Орешки в шоколаде_2", "Торговая марка_2");
        Candies candie_03 = new Candies("03", "19", "8", "30", "Орешки в шоколаде_3", "Торговая марка_3");

        Candies[] arrayCandy = {candie_01, candie_02, candie_03};

        // Создаем фабрику для последующего создания исходящего потока
        XMLOutputFactory factory = XMLOutputFactory.newFactory();
        XMLStreamWriter writer = factory.createXMLStreamWriter(new FileWriter("candies.xml"));
        writer.writeStartDocument();
        writer.writeStartElement("candies");

        for (int i = 0; i < arrayCandy.length; i++) {
            writer.writeStartElement("candie");
            writer.writeAttribute("art", arrayCandy[i].getArt());
            writer.writeAttribute("weight", arrayCandy[i].getWeight());
            writer.writeAttribute("shelf_life", arrayCandy[i].getShelf_life());
            writer.writeAttribute("price", arrayCandy[i].getPrice());
            writer.writeStartElement("title");
            writer.writeCharacters(arrayCandy[i].getTitle());
            writer.writeEndElement();
            writer.writeStartElement("trademark>");
            writer.writeCharacters(arrayCandy[i].getTrademark());
            writer.writeEndElement();
            writer.writeEndElement();
        }
        writer.writeEndElement();
        writer.writeEndDocument();
        writer.flush();
        writer.close();
    }

    static void parsingС() throws FileNotFoundException, XMLStreamException {
        // Создаем фабрику
        XMLInputFactory factory = XMLInputFactory.newFactory();
        // Класс для чтения символов
        Reader reader = new FileReader("candies.xml");

        // Для обеспечения прямого доступа к чтению файла с помощью итератора
        XMLStreamReader xmlStreamReader = factory.createXMLStreamReader(reader);
        // Если есть следующий элемент, то мы его берем и анализируем
        while (xmlStreamReader.hasNext()) {
            switch (xmlStreamReader.next()) {
                // Если это стартовый элемент, то получаем его имя
                case XMLStreamReader.START_ELEMENT:
                    String elem = xmlStreamReader.getName().toString();
                    System.out.println("Element on this step: " + elem);

                    // Анализируем полученный элемент. В зависимости от него осуществляем набор действий.
                    switch (elem) {
                        case "candie":
                            for (int i = 0; i < xmlStreamReader.getAttributeCount(); i++) {
                                String attributeName = xmlStreamReader.getAttributeLocalName(i);
                                String attributeValue = xmlStreamReader.getAttributeValue(i);

                                System.out.println(attributeName + " " + attributeValue);
                            }
                            break;
                        case "title":
                            System.out.println("Title: " + xmlStreamReader.getElementText());
                            break;
                        case "trademark":
                            System.out.println("trademark: " + xmlStreamReader.getElementText() + "\n");
                            break;
                    }

                    System.out.println("Start element was: " + xmlStreamReader.getName());
                    break;

                case XMLStreamReader.END_ELEMENT:
                    System.out.println("End element: " + xmlStreamReader.getName());
                    break;
            }
        }
    }
}
