package task_02;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/*
Задание 2
Из задания первого урока.
Сгенерировать класс, соответствующий данному описанию.
Создать приложение для разбора XML-документа и инициализации коллекции объектов информацией из XML-файла.
Для разбора использовать SAX, DOM и StAX парсеры. Для сортировки объектов использовать интерфейс Comparator.
 */

public class MainSAX {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        FlowerHandlerSAX ch = new FlowerHandlerSAX();

        File file = new File("flower.xml");
        parser.parse(file, ch);

        List<Flower> flowers = ch.getFlowers();

        System.out.println("All Flowers: ");

//        for (Flower flower : flowers) {
//            System.out.println(flower.getStem_color() + " " + flower.getLeaf_color() + " " + flower.getAverage_size() + " "
//                    +  flower.getName() + " " +  flower.getSoil() + " " + flower.getOrigin() + " " + flower.getMultiplying());
//        }

        System.out.println(  "_______________compareTo(Flower o)_________________________" );

        Collections.sort(flowers);
        System.out.println(flowers);

    }
}
