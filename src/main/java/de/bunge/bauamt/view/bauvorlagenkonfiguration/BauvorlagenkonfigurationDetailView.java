package de.bunge.bauamt.view.bauvorlagenkonfiguration;

import de.bunge.bauamt.entity.Bauvorlagenkonfiguration;

import de.bunge.bauamt.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "bauvorlagenkonfigurations/:id", layout = MainView.class)
@ViewController("Bauvorlagenkonfiguration.detail")
@ViewDescriptor("bauvorlagenkonfiguration-detail-view.xml")
@EditedEntityContainer("bauvorlagenkonfigurationDc")
public class BauvorlagenkonfigurationDetailView extends StandardDetailView<Bauvorlagenkonfiguration> {
}
