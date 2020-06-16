package cyberbionic.webservices;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        Factory factory = new Factory();
        Candy candy = new Candy();
        Structure structure = new Structure(15.0, 20.0, 3.0);
        CandyWrapper wrapper = new CandyWrapper("box", "white");
        candy.setStructures(structure);
        candy.setWrappers(wrapper);
        factory.add(candy);

        try {
            // Создаем файл
            //File file = new File("C:\\2CyberBionic\\WebServices\\WebServices_JAXP\\Lection\\src\\cyberbionic\\webservices\\candy.xml");
            File file = new File("C:\\2CyberBionic\\WebServices\\WebServices_JAXP\\Lection\\src\\cyberbionic\\webservices\\candy1.xml");
            // Вызываем статический метод JAXBContext
            JAXBContext jaxbContext = JAXBContext.newInstance(Factory.class);
            // Возвращает объект класса Marshaller, для того чтобы трансформировать объект
            Marshaller mar = jaxbContext.createMarshaller();

            // Читабельное форматирование
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Записываем в файл, marshal(из памяти, в файл)
            mar.marshal(factory, file);
            mar.marshal(factory, System.out);

            // Считываем из файла
            Unmarshaller unmar = jaxbContext.createUnmarshaller();
            factory = (Factory) unmar.unmarshal(file);
            System.out.println(factory);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
