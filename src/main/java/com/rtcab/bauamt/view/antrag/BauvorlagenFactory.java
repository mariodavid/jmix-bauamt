package com.rtcab.bauamt.view.antrag;

import com.rtcab.bauamt.entity.Antrag;
import com.rtcab.bauamt.entity.Antragsart;
import com.rtcab.bauamt.entity.Bauvorlage;
import com.rtcab.bauamt.entity.Bauvorlagenkonfiguration;
import io.jmix.core.DataManager;
import io.jmix.flowui.model.DataContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BauvorlagenFactory {

    private final DataManager dataManager;

    public BauvorlagenFactory(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public List<Bauvorlage> create(DataContext dataContext, Antragsart antragsart, Antrag antrag) {
        return dataManager.load(Bauvorlagenkonfiguration.class)
                .all()
                .list()
                .stream()
                .filter(bauvorlagenkonfiguration -> bauvorlagenkonfiguration.getAntragsart().equals(antragsart))
                .map(bauvorlagenkonfiguration -> {
                    Bauvorlage bauvorlage = dataContext.create(Bauvorlage.class);
                    bauvorlage.setTyp(bauvorlagenkonfiguration.getBauvorlagentyp());
                    bauvorlage.setPflicht(bauvorlagenkonfiguration.getPflicht());
                    bauvorlage.setAntrag(antrag);
                    return bauvorlage;
                }).toList();
    }
}
