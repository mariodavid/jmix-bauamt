package de.bunge.bauamt.view.bauvorlage;

import de.bunge.bauamt.entity.Bauvorlage;

import de.bunge.bauamt.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "bauvorlages/:id", layout = MainView.class)
@ViewController("Bauvorlage.detail")
@ViewDescriptor("bauvorlage-detail-view.xml")
@EditedEntityContainer("bauvorlageDc")
public class BauvorlageDetailView extends StandardDetailView<Bauvorlage> {
}
