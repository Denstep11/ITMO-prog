package util;

import data.HumanBeing;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Class for generate time and id
 */
public class ValueGeneration {
    public static void generation(HumanBeing humanBeing){
        ZoneId zoneId = ZoneId.of("Europe/Moscow");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.now(), zoneId);
        zonedDateTime = zonedDateTime.minusWeeks((long) (Math.random() * 100));
        zonedDateTime = zonedDateTime.minusMinutes((long) (Math.random() * 100));
        zonedDateTime = zonedDateTime.minusDays((long) (Math.random() * 100));

        humanBeing.setCreationDate(zonedDateTime);
    }
}
