package de.bunge.bauamt.view.antrag;

import de.bunge.bauamt.entity.Anrede;
import de.bunge.bauamt.entity.Bauherr;
import net.datafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class BauherrGenerator {

    public Bauherr fill(Bauherr bauherr) {
        bauherr.setAnrede(randomOf(Anrede.values()));
        bauherr.setEmail(new Faker().internet().emailAddress());
        bauherr.setVorname(new Faker().name().firstName());
        bauherr.setNachname(new Faker().name().lastName());
        bauherr.setStrasse(new Faker().address().streetAddress());
        bauherr.setHausnummer((new Random().nextInt(100) + 1) + "");
        bauherr.setPostleitzahl(new Faker().address().postcode());
        bauherr.setOrt(new Faker().address().city());
        bauherr.setJuristischePerson(new Random().nextBoolean());
        return bauherr;
    }

    public <T> T randomOf(T... values) {
        return values[new Random().nextInt(values.length)];
    }

}
