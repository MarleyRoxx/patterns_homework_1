package netology.ru.data;

import com.github.javafaker.Faker;
import lombok.Value;
import org.junit.jupiter.api.MethodOrderer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity(Faker faker) {
        String[] cities = new String[]{
                "Москва", "Санкт-Петербург", "Новосибирск", "Екатеринбург", "Казань",
                "Нижний Новгород", "Челябинск", "Самара", "Омск", "Ростов-на-Дону",
                "Уфа", "Красноярск", "Воронеж", "Пермь", "Волгоград", "Краснодар",
                "Саратов", "Тюмень", "Барнаул", "Ижевск", "Ульяновск", "Иркутск",
                "Владивосток", "Ярославль", "Хабаровск", "Махачкала", "Томск", "Оренбург",
                "Кемерово", "Рязань", "Астрахань", "Пенза", "Липецк", "Калининград"
        };
        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateName(Faker faker) {
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhone(Faker faker) {
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration(){
        }

        public static UserInfo generateUser(String locale) {
            Faker faker = new Faker(new Locale(locale));
            return new UserInfo(
                    generateCity(faker),
                    generateName(faker),
                    generatePhone(faker)
            );
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}